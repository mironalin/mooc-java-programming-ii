package application;

public class StandardSensor implements Sensor {
    private int sensorValue;

    public StandardSensor(int sensorValue) {
        this.sensorValue = sensorValue;
    }

    public boolean isOn() {
        return true;
    }

    public void setOn() {
    }

    public void setOff() {
    }

    public int read() {
        return this.sensorValue;
    }
}
