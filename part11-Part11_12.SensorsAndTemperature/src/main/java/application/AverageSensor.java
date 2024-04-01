package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AverageSensor implements Sensor {
    private List<Sensor> sensors;
    private List<Integer> readings;

    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();
    }

    public void addSensor(Sensor toAdd) {
        this.sensors.add(toAdd);
    }

    public boolean isOn() {
        for (Sensor sensor : sensors) {
            if (sensor.isOn() == false) {
                return false;
            }
        }

        return true;
    }

    public void setOn() {
        for (Sensor sensor : sensors) {
            sensor.setOn();
        }
    }

    public void setOff() {
        for (Sensor sensor : sensors) {
            sensor.setOff();
        }
    }

    public int read() {
        if (this.sensors.size() == 0 || this.isOn() == false) {
            throw new IllegalStateException("The average sensor is either off or it has no sensors added to it.");
        }

        int average = (int) this.sensors.stream().mapToInt(sensor -> sensor.read()).average().getAsDouble();
        this.readings.add(average);

        return average;
    }

    public List<Integer> readings() {
        return this.readings;
    }
}
