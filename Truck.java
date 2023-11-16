import java.awt.*;

public abstract class Truck extends Car{

    
    

    public double speedFactor(){
        if(rampdown())
             return 0;
         return 1;



}

