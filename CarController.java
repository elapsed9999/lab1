import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {

    // member fields:

    protected boolean isStopped = false;

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();
    ArrayList<Scania> scania = new ArrayList<>();


    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95());
        Scania scania = new Scania();
        cc.cars.add(scania);
        cc.scania.add(scania);






        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc, cc.cars);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */


    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(!isStopped) {
                for (Car car : cars) {
                    car.move();
                    int x = (int) Math.round(car.getCurrentXpos());  //Kan kanske ta bort round
                    int y = (int) Math.round(car.getCurrentYpos());
                    frame.drawPanel.moveit(x, y);
                    // repaint() calls the paintComponent method of the panel
                    frame.drawPanel.repaint();
                }
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars
                ) {
            car.gas(gas);
        }
    }
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars
        ) {
            car.brake(brake);
        }
    }
    void incBed(int amount) {
        for (Scania scania: scania
        ) {
            scania.incrementDegree(amount);
        }
    }
    void decBed(int amount) {
        for (Scania scania: scania
        ) {
            scania.decrementDegree(amount);
        }
    }
    void turnLeft() {
        for (Car car : cars
        ) {
            car.turnLeft();
        }
    }
    void turnRight() {
        for (Car car : cars
        ) {
            car.turnRight();
        }
    }

    public ArrayList list() {
        ArrayList<Car> cary = new ArrayList<>();
        for (Car car : cars){
            cary.add(car);
        }
        return cary;
    }


}
