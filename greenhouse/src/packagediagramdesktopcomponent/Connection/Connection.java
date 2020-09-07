package packagediagramdesktopcomponent.Connection;

import packagediagramdesktopcomponent.model.Serra;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class Connection implements Runnable{

	private static Connection instance = null;
	private MqttClient client;
	
	private Connection() 
	{
	}
	
	public void run()
	{
		
		while(true);
	}
	
	public void startup()
	{
		//setup mqtt client
        String broker 	= "tcp://mqtt.eclipse.org:1883";
        String clientId = "Mainframe";
        MemoryPersistence persistence = new MemoryPersistence();

        try {
            client = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker: "+broker);
            client.connect(connOpts);
            System.out.println("Connected");
       
        } catch(MqttException me) 
        {
            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);
            me.printStackTrace();
        }
	}

	public boolean sendStartup(int id, String mac) 
	{
        String topic= "gh/setup";
        int qos= 1;
        
        System.out.println("Publishing message: "+id+" "+mac);
        MqttMessage message = new MqttMessage(content.getBytes());
        message.setQos(qos);
        client.publish(topic, message);
        System.out.println("Message published");
		return true;
	}
	
	public boolean richiediParametriAmbientali(int id) 
	{
        String topic= "gh/sezione/cmd/richiedi";
        int qos= 1;
        System.out.println("Publishing message: "+id);
        MqttMessage message = new MqttMessage(id.toString().getBytes());
        message.setQos(qos);
        client.publish(topic, message);
        System.out.println("Message published");
		return true;
	}
	
	public boolean modificaAmbiente(int id, float temperatura, float umidita, float irradianza)
	{
        String topic= "gh/sezione/cmd/modifica";
        int qos= 1;
        System.out.println("Publishing message: "+content);
        MqttMessage message = new MqttMessage(content.getBytes());
        message.setQos(qos);
        client.publish(topic, message);
        System.out.println("Message published");
		return true;
	}
	
	public static Connection getInstance() 
	{
		if (instance == null)
		{
			instance = new Connection();
			Runnable r= instance;
			Thread t= new Thread(r);
			t.start();
		}
		return instance;
	}
}