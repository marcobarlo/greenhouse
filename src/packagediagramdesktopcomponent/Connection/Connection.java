package packagediagramdesktopcomponent.Connection;

import java.nio.ByteBuffer;
import java.util.concurrent.Semaphore;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MqttDefaultFilePersistence;


public class Connection implements Runnable{

	private static Connection instance = null;
	private MqttClient client;
	private static Semaphore available = new Semaphore(0, true);
	private static Thread t;
	private Connection() 
	{
	}
	
	public void run()
	{
		try {available.acquire();} 
		catch (InterruptedException e) 
		{throw new RuntimeException();}
		
        System.out.println("Setting callbacks ...");
	    MqttCallback callback = new MqttCallback() {
	        
	        @Override
	        public void messageArrived(String topic, MqttMessage message) throws Exception {
	            MqttMessage received=message;
	            System.out.println(received);
	        }
	        
	        @Override
	        public void deliveryComplete(IMqttDeliveryToken token) {
	        }
	        
	        @Override
	        public void connectionLost(Throwable cause) {
	            cause.printStackTrace();
	        }
	    };
		client.setCallback(callback);
		available.release();
		boolean exit=false;
		while(!exit)
		{
			try {Thread.sleep(1);}
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
        String broker 	= "tcp://mqtt.eclipse.org:1883";
        String clientId = "Mainframe";
        //MemoryPersistence persistence = new MemoryPersistence();
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

	public boolean sendStartup(int id, String mac) 
	{
        String topic= "gh/setup";
        int qos= 1;
        System.out.println("Publishing message: "+id+" - "+mac+ " ...");
        ByteBuffer b = ByteBuffer.allocate(4+12);
        b=b.putInt(id).put(mac.getBytes());
        MqttMessage message = new MqttMessage();
        message.setQos(qos);
        try {client.publish(topic, message);} 
        catch (MqttPersistenceException e) 
        {return false;} 
        catch (MqttException e) 
        {return false;}
        System.out.println("Message published!");
		return true;
	}
	
	public boolean richiediParametriAmbientali(int id) 
	{
        String topic= "gh/sezione/cmd/richiedi";
        int qos= 1;
        System.out.println("Publishing message: "+id);
        byte[] bytes = ByteBuffer.allocate(4).putInt(id).array();
        MqttMessage message = new MqttMessage(bytes);
        message.setQos(qos);
        try {client.publish(topic, message);} 
        catch (MqttPersistenceException e) 
        {return false;} 
        catch (MqttException e) 
        {return false;}
        System.out.println("Message published");
		return true;
	}
	
	public boolean modificaAmbiente(int id, float temperatura, float umidita, float irradianza)
	{
        String topic= "gh/sezione/cmd/modifica";
        int qos= 1;
        System.out.println("Publishing message: "+id + " "+temperatura+" "+ umidita+" "+irradianza);
        ByteBuffer b = ByteBuffer.allocate(4+4+4+4);
        b=b.putInt(id).putFloat(temperatura).putFloat(umidita).putFloat(irradianza);
        MqttMessage message = new MqttMessage(b.array());
        message.setQos(qos);
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