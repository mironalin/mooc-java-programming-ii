package FlightControl.logic;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import FlightControl.domain.Airplane;
import FlightControl.domain.Flight;
import FlightControl.domain.Place;

public class FlightControl {
    private Map<String, Airplane> airplanes;
    private Map<String, Flight> flights;
    private Map<String, Place> places;

    public FlightControl() {
        this.airplanes = new HashMap<>();
        this.flights = new HashMap<>();
        this.places = new HashMap<>();
    }

    public void addAirplane(String ID, int capacity) {
        Airplane airplane = new Airplane(ID, capacity);
        this.airplanes.put(ID, airplane);
    }

    public void addFlight(Airplane airplane, String departureID, String targetID) {
        this.places.putIfAbsent(departureID, new Place(departureID));
        this.places.putIfAbsent(targetID, new Place(targetID));

        Flight flight = new Flight(airplane, this.places.get(departureID), this.places.get(targetID));
        this.flights.put(flight.toString(), flight);
    }

    public Collection<Airplane> getAirplanes() {
        return this.airplanes.values();
    }

    public Collection<Flight> getFlights() {
        return this.flights.values();
    }

    public Airplane getAirplane(String ID) {
        return this.airplanes.get(ID);
    }
}
