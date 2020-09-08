void setup() 
{
    Serial.begin(9600 );     // communication with the host computer
    Serial3.begin(9600);
    while (!Serial)   { ; }
     while (!Serial3)   { ; }

    // Start the software serial for communication with the ESP8266
 
    Serial.println("");
    Serial.println("Remember to to set Both NL & CR in the serial monitor.");
    Serial.println("Ready");
    Serial.println("");    
}
 
void loop() 
{
    // listen for communication from the ESP8266 and then write it to the serial monitor
    if ( Serial3.available() )   {  Serial.write( Serial3.read() );  }
 
    // listen for user input and send it to the ESP8266
    if ( Serial.available() )       {Serial3.write( Serial.read());  }
}
