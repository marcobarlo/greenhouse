package packagediagramdesktopcomponent.Connection;

import java.nio.ByteBuffer;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MqttDefaultFilePersistence;

import packagediagramdesktopcomponent.Configurazione;
import packagediagramdesktopcomponent.Alarms.Allarme;
import packagediagramdesktopcomponent.Business_Logic.ControllerFacade;


public class Connection{

	private static Connection instance = null;
	private MqttClient client;
	private Connection(){}
	
	public void startup()
	{
		//setup mqtt client
        String broker = "tcp://localhost:1883";
		String clientId = "Mainframe";
        MqttDefaultFilePersistence dataStore = new MqttDefaultFilePersistence(System.getProperty("java.io.tmpdir") + "/" + clientId);
        try {
            client = new MqttClient(broker, clientId, dataStore);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setAutomaticReconnect(true);
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker: "+broker + " ...");
            client.connect(connOpts);
            System.out.println("Connected!");
    	    MqttCallback callback = new MqttCallback() {
    	        
    	        @Override
    	        public void messageArrived(String topic, MqttMessage message) throws Exception 
    	        {
    	            if(topic.equals("GH/Dati")) 
    	            	callback_data(message);
    	            else if(topic.equals("GH/Errore"))
    	            	callback_error(message);
    	        }
    	    
    	        @Override
    	        public void deliveryComplete(IMqttDeliveryToken token) {}
    	        
    	        @Override
    	        public void connectionLost(Throwable cause) {
    				System.out.println(cause.getMessage());
    	            cause.printStackTrace();
    	            System.exit(1);
    	        }
    	    };
    	    
    		client.setCallback(callback);
    		client.subscribe("GH/Dati");
    		client.subscribe("GH/Errore");
    		
        } catch(MqttException me) 
        {
            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);
            me.printStackTrace();
            System.exit(1);
        }
	}

	public boolean sendSetUp(Configurazione c) 
	{
        String topic= "GH/SetUp";
        int qos= 1;
        ByteBuffer buf = ByteBuffer.allocate(4+12+4+24);
        String mac= c.getMac();
        buf=buf.put(hexStringToByteArray(mac)).putInt(c.getId()).putInt(c.getSezione()).putFloat(c.getTempTarget()).putFloat(c.getUmiTarget()).putFloat(
        		c.getIrrTarget()).putFloat(c.getsogliaTemp()).putFloat(c.getsogliaUmi()).putFloat(c.getsogliaIrr());
        MqttMessage message = new MqttMessage();
        message.setQos(qos);
        message.setPayload(buf.array());
        try {client.publish(topic, message);} 
        catch (MqttPersistenceException e) 
        {return false;} 
        catch (MqttException e) 
        {return false;}
        //System.out.println("Message published!");
		return true;
	}
	
	public boolean richiediParametriAmbientali(int id, int sez) 
	{
        String topic= "GH/"+sez+"/cmd/STROBS";
        int qos= 1;
        byte[] bytes = ByteBuffer.allocate(4).putInt(id).array();
        MqttMessage message = new MqttMessage(bytes);
        message.setQos(qos);
        message.setPayload(bytes);
       // CountDownLatch processingFinishedLatch = new CountDownLatch(10);
       // processingFinishedLatch.
        try {client.publish(topic, message);} 
        catch (MqttPersistenceException e) 
        {return false;} 
        catch (MqttException e) 
        {return false;}
        //System.out.println("Message published");
		return true;
	}
	
	public boolean modificaAmbiente(int id, float temperatura, float umidita, float irradianza, int sez)
	{
        String topic= "GH/"+sez+"/cmd/Mod";
        int qos= 1;
        ByteBuffer buf = ByteBuffer.allocate(4+4+4+4);
        buf=buf.putInt(id).putFloat(temperatura).putFloat(umidita).putFloat(irradianza);
        MqttMessage message = new MqttMessage(buf.array());
        message.setQos(qos);
        message.setPayload(buf.array());
        try {client.publish(topic, message);} 
        catch (MqttPersistenceException e) 
        {return false;} 
        catch (MqttException e) 
        {return false;}
        //System.out.println("Message published");
		return true;
	}
	
	public boolean sendStop(int id, int sez)
	{
        String topic= "GH/"+sez+"/cmd/STPOBS";
        int qos= 1;
        ByteBuffer buf = ByteBuffer.allocate(4);
        buf=buf.putInt(id);
        MqttMessage message = new MqttMessage(buf.array());
        message.setQos(qos);
        message.setPayload(buf.array());
        try {client.publish(topic, message);} 
        catch (MqttPersistenceException e) 
        {return false;} 
        catch (MqttException e) 
        {return false;}
        //System.out.println("Message published");
		return true;
	}
	
	
	public static Connection getInstance() 
	{
		if (instance == null)
			instance = new Connection();
		return instance;
	}
	public void shutdown()
	{
		try {
			client.disconnect();
		} catch (MqttException me) {
            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);
            me.printStackTrace();
            System.exit(1);
		}
	}
	private void callback_error(MqttMessage message) {
		byte[] payload = message.getPayload();
		ByteBuffer b = ByteBuffer.wrap(payload);
		int id = b.getInt();
		int code =b.getInt();
		Allarme all= Allarme.buildAllarme(code);
		String err=all.getErrore();
		ControllerFacade.sendAllarme(id, err);
	}

	private void callback_data(MqttMessage message) {
		//comunica al controller l'aggiornamento dell'ambiente attuale
		byte[] payload = message.getPayload();
		ByteBuffer b = ByteBuffer.wrap(payload);
		int id = b.getInt();
		float temperatura = b.getFloat();
		float umidita = b.getFloat();
		float irradianza = b.getFloat();
		ControllerFacade.modificaAmbienteAttuale(id,temperatura,umidita,irradianza);
	}
	
	private static byte[] hexStringToByteArray(String s) 
	{
		int len = s.length();
		byte[] data = new byte[len / 2];
		for (int i = 0; i < len; i += 2) 
		{
			data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i+1), 16));
		}
		return data;
	}

}