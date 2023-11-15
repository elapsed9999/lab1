import java.awt.*;

public class Scania extends Car{    

    private double currentDegree = 0;

    public Scania(){
        super(2,400,"Scania",Color.BLACK,0,0,0);

    }

    public double getCurrentDegree(){
        return currentDegree;
    }

    public void incrementDegree(double amount) {
        if(currentSpeed == 0) 
            currentDegree = Math.min(getCurrentDegree() + amount, 70);
    }

    public void decrementDegree(double amount) {
        if(currentSpeed == 0)
            currentDegree = Math.max(getCurrentDegree() - amount, 0);
    }

    public boolean rampdown(){
        if(currentDegree > 0)
            return true;
        return false;
    } 

    public double speedFactor(){
       if(rampdown())
            return 0;
        return 1;
    }

}