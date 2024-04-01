package FlightControl.ui;

import java.util.Scanner;

import FlightControl.domain.Airplane;
import FlightControl.domain.Flight;
import FlightControl.logic.FlightControl;

public class TextUI {
    private Scanner scanner;
    private FlightControl flightControl;

    public TextUI(FlightControl flightControl, Scanner scanner) {
        this.flightControl = flightControl;
        this.scanner = scanner;
    }

    public void start() {
        startAssetControl();
        System.out.println();
        startFlightControl();
        System.out.println();
    }

    private void startAssetControl() {
        System.out.println("Airport Asset Control");
        System.out.println("--------------------\n");

        while (true) {
            System.out.println("Choose an action:");
            System.out.println("[1] Add an airplane");
            System.out.println("[2] Add a flight");
            System.out.println("[x] Exit Airport Asset Control");
            System.out.print("> ");

            String input = scanner.nextLine();

            if (input.equals("1")) {
                addAirplane();
            }

            if (input.equals("2")) {
                addFlight();
            }

            if (input.equals("x")) {
                break;
            }
        }
    }

    private void addAirplane() {
        System.out.print("Give the airplane id: ");
        String airplaneID = scanner.nextLine();

        System.out.print("Give the airplane capacity: ");
        int airplaneCapacity = Integer.valueOf(scanner.nextLine());

        this.flightControl.addAirplane(airplaneID, airplaneCapacity);
    }

    private void addFlight() {
        System.out.print("Give the airplane id: ");
        Airplane airplane = askForAirplane();

        System.out.print("Give the departure airport id: ");
        String departureID = scanner.nextLine();

        System.out.print("Give the target airport id: ");
        String targetID = scanner.nextLine();

        this.flightControl.addFlight(airplane, departureID, targetID);

    }

    private Airplane askForAirplane() {
        Airplane airplane = null;

        while (airplane == null) {
            String id = scanner.nextLine();
            airplane = flightControl.getAirplane(id);

            if (airplane == null) {
                System.out.println("No airplane with the id " + id + ".");
            }
        }

        return airplane;
    }

    private void startFlightControl() {
        System.out.println("Flight Control");
        System.out.println("------------\n");

        while (true) {
            System.out.println("Choose an action:");
            System.out.println("[1] Print airplanes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print airplane details");
            System.out.println("[x] Quit");
            System.out.print("> ");

            String input = scanner.nextLine();

            if (input.equals("1")) {
                printAirplanes();
            }

            if (input.equals("2")) {
                printFlights();
            }

            if (input.equals("3")) {
                printAirplaneDetails();
            }

            if (input.equals("x")) {
                break;
            }
        }
    }

    private void printAirplanes() {
        for (Airplane plane : flightControl.getAirplanes()) {
            System.out.println(plane);
        }
    }

    private void printFlights() {
        for (Flight flight : flightControl.getFlights()) {
            System.out.println(flight);
        }
    }

    private void printAirplaneDetails() {
        System.out.print("Give the airplane id: ");
        Airplane plane = askForAirplane();
        System.out.println(plane);
        System.out.println();
    }

}
