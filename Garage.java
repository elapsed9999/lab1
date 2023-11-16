import java.awt.*;
import java.util.ArrayList;

public class Garage <T extends Car> {

    private final int maxCars;
    private final ArrayList <T> currentCars;
    private final Class<T> brandOfCar;


    public Garage(int maxCars, Class<T> brandOfCar) {

        this.brandOfCar = brandOfCar;
        this.maxCars = maxCars;
        this.currentCars = new ArrayList<>();
        
    }

    public void isItTheRightBrand(T theCar) {

        if(brandOfCar.isInstance(theCar) && currentCars.size() < maxCars) {
            
            currentCars.add(theCar);
        } 
        }
    

    public void pickUpCar(T yourNumber) {

        if(currentCars.size() > 0)
            currentCars.remove(yourNumber);
    }

}