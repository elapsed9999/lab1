import java.awt.*;

public abstract class Car implements Movable {

    public int nrDoors;
    public double enginePower;
    public Color color;
    public String modelName;

    public Car(int nrDoors, double enginePower, String modelName, Color color) {

        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.color = color;

    }

    public int getNrDoors() {

        return nrDoors;
    }
    public double getenginePower() {

        return enginePower;
    }
    public String getModelName() {

        return modelName;
    }
    public Color getColor() {

        return color
    }
}
