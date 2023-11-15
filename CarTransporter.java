import java.awt.*;
import java.util.ArrayList;

public class CarTransporter extends Car{

    public CarTransporter(){
        super(2,300,"CarTransporter",Color.GREEN,0,0,0);

    }

    public void pickup(carTran,carpick){
        if (carTran.whatAmI == carTransporter && carpick.whatAmI == car)
            if (carTran.currentSpeed = 0)
                if(carTran.rampdown)
                    closeness=((carTran.xpos+carpick.xpos)^2+(carTran.ypos+carpick.ypos)^2)^0.5;
                    if(closeness <= 15) 
                        carTran.carin.add(carpick);
    }

    public void unload(carTran,carpick){
        if(carTran.carin__==int lastIndexOf(carpick))
        
        if(carpick=all)

        if(carpick=int)

    }

    public static void main(String[] args) {
        ArrayList<String> cars = new ArrayList<String>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");
        System.out.println(cars);
      }
          

    
    
 
    public double speedFactor(){
        if(currentDegree > 0)
                return 0;
            return 1;
        }

    }