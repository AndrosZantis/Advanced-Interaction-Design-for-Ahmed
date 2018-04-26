import grovepi.GrovePi;
import grovepi.sensors.*;
import grovepi.Pin;
import grovepi.PinMode;
import java.util.*;


public class Test {

    public static void main(String[] args) {
        
        GrovePi grovePi = new GrovePi();
        Led red = grovePi.getDeviceFactory().createLed(Pin.DIGITAL_PIN_2);
        Led blue = grovePi.getDeviceFactory().createLed(Pin.DIGITAL_PIN_3);
        Led green = grovePi.getDeviceFactory().createLed(Pin.DIGITAL_PIN_4);
        UltrasonicRangerSensor rangeSensor = grovePi.getDeviceFactory().createUltraSonicSensor(Pin.DIGITAL_PIN_7);
        ButtonSensor button = grovePi.getDeviceFactory().createButtonSensor(Pin.DIGITAL_PIN_8);
        boolean isStart = false;
  
        while (true){
            if (rangeSensor.getDistance() < 25){
                isStart = true;
            }
            if (isStart == true){
                red.setState(true);
                try{
                    Thread.sleep(500);
                }catch(InterruptedException e){;}
                red.setState(false);
                blue.setState(true);
                 try{
                    Thread.sleep(500);
                }catch(InterruptedException e){;}
                blue.setState(false);
                green.setState(true);
                 try{
                    Thread.sleep(500);
                }catch(InterruptedException e){;}
                green.setState(false);
                isStart = false;
            }
            else {
                while(button.isPressed() == true){
                   red.setState(true);
                   try{
                    Thread.sleep(10000);
                }catch(InterruptedException e){;}
                    red.setState(false);
                }
                
            }
        }
    }
    
}
