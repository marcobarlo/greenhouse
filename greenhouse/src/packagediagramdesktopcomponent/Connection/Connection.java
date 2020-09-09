package packagediagramdesktopcomponent.Connection;

import java.nio.ByteBuffer;
import java.util.concurrent.Semaphore;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MqttDefaultFilePersistence;

import packagediagramdesktopcomponent.Configurazione;
import packagediagramdesktopcomponent.Business_Logic.ControllerFacade;


public class Connection implements Runnable{

	private static Connection instance = null;
	private MqttClient client;
	private static Semaphore available = new Semaphore(0, true);
	private static Thread t;
	private Connection(){}
	
	public void run()
	{
		try {available.acquire();} 
		catch (InterruptedException e) 
		{throw new RuntimeException();}
		
        System.out.println("Setting callbacks ...");
	    MqttCallback callback = new MqttCallback() {
	        
	        @Override
	        public void messageArrived(String topic, MqttMessage message) throws Exception {
	            if(topic.equals("GH/Dati")) 
	            {
	            	//comunica al controller l'aggiornamento dell'ambiente attuale
	            	byte[] payload = message.getPayload();
	            	ByteBuffer b = ByteBuffer.wrap(payload);
	            	int id = b.getInt();
	            	float temperatura = b.getFloat();
	            	float umidita = b.getFloat();
	            	float irradianza = b.getFloat();
	            	ControllerFacade.modificaAmbienteAttuale(id,temperatura,umidita,irradianza);
	            }  
	        }
	        
	        @Override
	        public void deliveryComplete(IMqttDeliveryToken token) {
	        }
	        
	        @Override
	        public void connectionLost(Throwable cause) {
				System.out.println(cause.getMessage());
	            cause.printStackTrace();
	        }
	    };
	    
	    
	    try {
			client.subscribe("gh/Dati");
		} catch (MqttException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		client.setCallback(callback);
		available.release();
		boolean exit=false;
		while(!exit)
		{
			try {Thread.sleep(100);}
			catch (InterruptedException ex) 
			{
				  try {client.disconnect();} 
				  catch (MqttException me) 
				  {
		                System.out.println("reason "+me.getReasonCode());
		                System.out.println("msg "+me.getMessage());
		                System.out.println("loc "+me.getLocalizedMessage());
		                System.out.println("cause "+me.getCause());
		                System.out.println("excep "+me);
		                me.printStackTrace();
				  }
				  exit=true;
		          System.out.println("Shutting down mqtt client ...");
			}
		}
	}
	
	public void startup()
	{
		//setup mqtt client
        String broker = "tcp://localhost:1883";
		String clientId = "Mainframe";
        MqttDefaultFilePersistence dataStore = new MqttDefaultFilePersistence(System.getProperty("java.io.tmpdir") + "/" + clientId);
        try {
            client = new MqttClient(broker, clientId, dataStore);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker: "+broker + " ...");
            client.connect(connOpts);
            System.out.println("Connected!");
       
        } catch(MqttException me) 
        {
            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);
            me.printStackTrace();
        }
		available.release();
	}

	public boolean sendSetUp(Configurazione c) 
	{
        String topic= "GH/SetUp";
        int qos= 1;
        //System.out.println("Publishing message: "+id+" - "+mac+ " ...");
        ByteBuffer buf = ByteBuffer.allocate(4+12+4+24);
        buf=buf.put(c.getMac().getBytes()).putInt(c.getId()).putInt(c.getSezione()).putFloat(c.getTempTarget()).putFloat(c.getUmiTarget()).putFloat(
        		c.getIrrTarget()).putFloat(c.getsogliaTemp()).putFloat(c.getsogliaUmi()).putFloat(c.getsogliaIrr());
        MqttMessage message = new MqttMessage();
        message.setQos(qos);
        message.setPayload(buf.array());
        try {client.publish(topic, message);} 
        catch (MqttPersistenceException e) 
        {return false;} 
        catch (MqttException e) 
        {return false;}
        System.out.println("Message published!");
		return true;
	}
	
	public boolean richiediParametriAmbientali(int id, int sez) 
	{
        String topic= "GH/"+sez+"/cmd/STROBS";
        int qos= 1;
        //System.out.println("Publishing message: "+id);
        byte[] bytes = ByteBuffer.allocate(4).putInt(id).array();
        MqttMessage message = new MqttMessage(bytes);
        message.setQos(qos);
        message.setPayload(bytes);
        try {client.publish(topic, message);} 
        catch (MqttPersistenceException e) 
        {return false;} 
        catch (MqttException e) 
        {return false;}
        System.out.println("Message published");
		return true;
	}
	
	public boolean modificaAmbiente(int id, float temperatura, float umidita, float irradianza, int sez)
	{
        String topic= "GH/"+sez+"/cmd/Mod";
        int qos= 1;
        //System.out.println("Publishing message: "+id + " "+temperatura+" "+ umidita+" "+irradianza);
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
        System.out.println("Message published");
		return true;
	}
	
	public boolean sendStop(int id, int sez)
	{
        String topic= "GH/"+sez+"/cmd/STPOBS";
        int qos= 1;
        //System.out.println("Publishing message: "+id + " "+temperatura+" "+ umidita+" "+irradianza);
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
        System.out.println("Message published");
		return true;
	}
	
	
	public static Connection getInstance() 
	{
		if (instance == null)
		{
			instance = new Connection();
			Runnable r= instance;
			t= new Thread(r);
			t.start();
		}
		return instance;
	}
	public Thread getThread()
	{
		return t;
	}
}