import java.awt.*;
import java.util.ArrayList;

public class CarTransporter <T extends Car> extends Car{

    private final ArrayList <T> currentCars;
    private final Class<T> carX;
    private double closeness; 

    public CarTransporter(){
        super(2,300,"CarTransporter",Color.GREEN,0,0,0);

    }

    public boolean rampdown() {
        if(getCurrentSpeed() > 0)
            return false;
        
        return true;
    }

    
    ArrayList<Object> carin = new ArrayList<>();
    

    public void pickup(T carpick) {
        if (rampdown())
            closeness = ((getCurrentXpos()+carpick.xpos)^2+(getCurrentYpos()+carpick.ypos)^2)^0.5;
            if(closeness <= 15)
                carin.add(carpick);
                currentCars.add(carpick);
            System.out.println(closeness);
    }

    public void unload(T carpick) {
        if(rampdown()) 
            if(carin.get(carin.size()-1)==carpick)
                carin.remove(carin.size()-1);
                carpick.isDocked=false;
    }

}
