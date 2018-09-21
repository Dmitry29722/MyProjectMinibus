package model;

import java.io.Serializable;
import java.util.List;
import javafx.collections.ObservableList;

public class Trip implements Serializable{
	private DateOfTravel dateOfTravel;
	private String fullNameOfTheRoute;
	private String timeOfRoute;
	private Minibus minibus;
	private ObservableList<Passenger> passengers;

	public DateOfTravel getDateOfTravel() {
		return dateOfTravel;
	}

	public String getFullNameOfTheRoute() {
		return fullNameOfTheRoute;
	}

	public Minibus getMinibus() {
		return minibus;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void addPassenger(Passenger passenger) {
		this.passengers.add(passenger);
	}

	public Trip(DateOfTravel dateOfTravel, String route, Minibus minibus,
			ObservableList<Passenger> dataTable, String timeOfRoute) {
		this.dateOfTravel = dateOfTravel;
		this.fullNameOfTheRoute = route;
		this.minibus = minibus;
		this.timeOfRoute = timeOfRoute;
		this.passengers = dataTable;
	}

	public String getTimeOfRoute() {
		return timeOfRoute;
	}

	public void setTimeOfRoute(String timeOfRoute) {
		this.timeOfRoute = timeOfRoute;
	}

}
