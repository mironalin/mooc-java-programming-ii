package FlightControl.domain;

public class Flight {
    private Airplane plane;
    private Place departurePlace;
    private Place targetPlace;

    public Flight(Airplane plane, Place departurePlace, Place targetPlace) {
        this.plane = plane;
        this.departurePlace = departurePlace;
        this.targetPlace = targetPlace;
    }

    public Airplane getAirplane() {
        return this.plane;
    }

    public Place getDeparturePlace() {
        return this.departurePlace;
    }

    public Place getTargetPlace() {
        return this.targetPlace;
    }

    public String toString() {
        return this.plane.toString() + " (" + this.departurePlace + "-" + this.targetPlace + ")";
    }
}
