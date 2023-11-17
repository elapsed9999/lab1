import java.awt.*;
import java.util.ArrayList;

public class Garage <T extends Car> {

    private int maxCars;
    private ArrayList <T> currentCars;
    private Class<T> brandOfCar;

    
    public void maxGarageLimit(int maxCars) {

        this.maxCars = maxCars;

    }

    public Garage() {

        this.currentCars = new ArrayList<>();
    }

    public void leaveCar(T theCar) {

        if(brandOfCar.isInstance(theCar) && currentCars.size() < maxCars) {
            
            currentCars.add(theCar);
            theCar.isDocked=true;
        } 
    }
    
    public void pickUpCar(T theCar) {

        if(currentCars.size() > 0)
            currentCars.remove(currentCars.indexOf(theCar));
            theCar.isDocked=false;
            
    }

}
