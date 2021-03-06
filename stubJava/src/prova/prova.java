package prova;
import java.nio.ByteBuffer;
import java.util.concurrent.Semaphore;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
//import org.eclipse.paho.client.mqttv3.SimpleMQTTCallback;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.eclipse.paho.client.mqttv3.persist.MqttDefaultFilePersistence;


public class prova {
	private static MqttClient client;
    public static void main(String[] args) {

    	 String broker = "tcp://localhost:1883";
 	     String clientId = "prova";
         //MemoryPersistence persistence = new MemoryPersistence();
         MqttDefaultFilePersistence dataStore = new MqttDefaultFilePersistence(System.getProperty("java.io.tmpdir") + "/" + clientId);
         System.out.println(System.getProperty("java.io.tmpdir"));
     //    SimpleMQTTCallback callback = new SimpleMQTTCallback();
         try {
             client = new MqttClient(broker, clientId, dataStore);
             MqttConnectOptions connOpts = new MqttConnectOptions();
             connOpts.setCleanSession(true);
             MqttCallback callback = new MqttCallback() {
     	        
     	        @Override
     	        public void messageArrived(String topic, MqttMessage message) throws Exception {
	            	/*byte[] payload = message.getPayload();
	            	ByteBuffer b = ByteBuffer.wrap(payload);
	            	int id = b.getInt();
	            	byte[] dst=new byte[12];
	            	b=b.get(dst, 0, 12);
	            	String mac = new String(dst);
	            	int sezione = b.getInt();*/
	            	//System.out.println(id+" "+mac+ " "+ sezione);
     	        	if(topic.equals("GH/1/cmd/Mod"))
     	        	{
     	        			byte[] payload = message.getPayload();
     	        			ByteBuffer b = ByteBuffer.wrap(payload);
     	        			int id = b.getInt();
     	        	        int qos= 1;
     	        	        byte[] bytes = ByteBuffer.allocate(4).putInt(id).array();
     	        	        MqttMessage message2 = new MqttMessage(bytes);
     	        	        message2.setQos(qos);
     	        	        message2.setPayload(bytes);
     	        	        try {client.publish("GH/Ack", message2);} 
     	        	        catch (MqttPersistenceException e) 
     	        	        {} 
     	        	        catch (MqttException e) 
     	        	        {}
     	        	}
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
             //System.out.println("Connecting to broker: "+broker + " ...");
             client.connect(connOpts);
             //System.out.println("Connected!");
        
         } catch(MqttException me) 
         {
             System.out.println("reason "+me.getReasonCode());
             System.out.println("msg "+me.getMessage());
             System.out.println("loc "+me.getLocalizedMessage());
             System.out.println("cause "+me.getCause());
             System.out.println("excep "+me);
             me.printStackTrace();
         }
		try {
			client.subscribe("GH/SetUp");
			client.subscribe("GH/1/cmd/Mod");
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*for(int i=0 ; i< 15 ; i++)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
        float i = (float) 0.5;
        float j = (float) 2.98;
        float k = (float) 5.62;
		for(int m=0; m<50;m++)
		{

			//lolAllarme(m);
			try {Thread.sleep(5000);}
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
		          System.out.println("Shutting down mqtt client ...");
			}
			System.out.println("Mando il messaggio dati!");
			lol(i,j,k);
			i++;
			j++;
			k++;
		}
		try {
			client.disconnect();
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	public static boolean lol(float i, float j, float k) 
	{
        String topic= "GH/Dati";
        int qos= 1;
        //System.out.println("Publishing message: "+id+" - "+mac+ " ...");
        ByteBuffer buf = ByteBuffer.allocate(16);

        buf=buf.putInt(1).putFloat(i).putFloat(j).putFloat(k);
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
	public static void lolAllarme(int i)
	{       
		String topic= "GH/Errore";
	    int qos= 1;
	    ByteBuffer buf = ByteBuffer.allocate(8);
	    buf=buf.putInt(1).putInt(i);
	    MqttMessage message = new MqttMessage();
	    message.setQos(qos);
	    message.setPayload(buf.array());
	    try {client.publish(topic, message);} 
	    catch (MqttPersistenceException e) 
	    {} 
	    catch (MqttException e) 
	    {}

	}
}
