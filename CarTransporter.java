import java.awt.*;
import java.util.ArrayList;

public class CarTransporter extends Car{

    protected final ArrayList <Car> carin = new ArrayList<>();
    
    private double closeness; 
    private boolean rampdown = false;

    public CarTransporter(){
        super(2,300,"CarTransporter",Color.GREEN,0,0,0);

    }

    public void rampdownToggle() {
        if(getCurrentSpeed() == 0)
            rampdown = !(rampdown);
    }

    public boolean rampdown() {
        return rampdown;
    }


    public double speedFactor(){
        if(rampdown())
             return 0;
         return 1;
    }

    public void transGas(double amount){
        gas(amount);
        int carinsize =carin.size()-1;
        if (carinsize >= 0)
            for (int i = 0;i <= carinsize ; i++) {
                carin.get(i).xpos = xpos;
                carin.get(i).ypos = ypos;
            }
    }

    

    public void pickup(Car carpick) {
        if (rampdown())
            closeness = Math.sqrt(Math.pow((getCurrentXpos()+carpick.getCurrentXpos()), 2))+Math.pow((getCurrentYpos()+carpick.getCurrentYpos()), 2);
            if(closeness <= 15)
                if(!carpick.isDocked && !(carpick instanceof CarTransporter))
                    carin.add(carpick);
                    carpick.isDocked = true;
    }

    public void unload(Car carpick) {
        if(rampdown()) 
            if(carin.get(carin.size()-1)==carpick){
                carin.remove(carin.size()-1);
                carpick.isDocked=false;}
    }

