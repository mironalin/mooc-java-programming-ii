package application;

import java.util.Random;

public class TemperatureSensor implements Sensor {
    private boolean sensorState;

    public TemperatureSensor() {
        this.sensorState = false;
    }

    public boolean isOn() {
        if (this.sensorState == true) {
            return true;
        }

        return false;
    }

    public void setOn() {
        this.sensorState = true;
    }

    public void setOff() {
        this.sensorState = false;
    }

    public int read() {
        if (sensorState == false) {
            throw new IllegalStateException("The sensor is off.");
        }
        return new Random().nextInt(61) - 30;
    }
}
