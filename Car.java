import java.awt.*;

/*
Abstract class är en "basklass" som byggs på. Den innehåller bl.a. gemensam, duplicerad kod från Saab95 och Volvo240. 
Implements implementerar Movable och dess metoder. 
*/

public abstract class Car implements Movable {

/*
Deklarering av variabler och sätts till private där tillåtet. Ökar säkerheten.
*/

    private int nrDoors;
    public double enginePower;
    private Color color;
    private String modelName;
    public double currentSpeed = 0;
    public double xpos;
    public double ypos;
    private double direction; 

/*
Start på konstruktorn, med kodens parametrar...
*/
    
    public Car(int nrDoors, double enginePower, String modelName, Color color, double xpos, double ypos, double direction) {

/*
Initialiserar de 7 parametrar som getts i konstruktorn, "this" sätter värden till instansvariablerna (attributen).  
*/

        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.color = color;
        this.xpos = xpos;
        this.ypos = ypos;
        this.direction = direction;
        
    }

    
    /* ändrar x-/y-värde beroende på currentspeed och direction (direction = r=0 mod 2pi ger riktning åt öst)*/
    public void move(){
        xpos += Math.cos(direction)*currentSpeed;
        ypos += Math.sin(direction)*currentSpeed;
    }
    
    /* Ändrar direction med 90 grader (det vill säga rotation med pi/2 där höger subtraherar och vänster adderar) */
    public void turnRight(){
        direction -= Math.PI/2;
    }

    public void turnLeft(){
        direction += Math.PI/2;
    }

    abstract double speedFactor();

    public void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    public void gas(double amount){
        if(amount >= 0 && amount <= 1) {
            incrementSpeed(amount);
            move();
        }
    }

	/*
 	EXEMPEL: 

	Metod "brake" och parameter "double amount". Lokal variabel "amount". 
	Om if-satsen stämmer kallas metoden "decrementSpeed()" med "amount" som argument. 
	Därefter kallas metoden "move()"

  	vvvvvvvvvvv
	*/

    public void brake(double amount){
        if(amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
            move();
        }
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {

        return enginePower;
    }
    public String getModelName() {

        return modelName;
    }
    public Color getColor() {

        return color;
    }

    public void setColor(Color clr){
	    color = clr;
    }

    public void startEngine(){
	    currentSpeed = 0.1;
    }

    public void stopEngine(){
	    currentSpeed = 0;
    }
    public double getCurrentSpeed(){
        return currentSpeed;
    }

}
