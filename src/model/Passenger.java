package model;

import java.io.Serializable;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Passenger implements Serializable {
	private String firstName;
	private String lastName;
	private String telephoneNumber;

	public Passenger(String fName, String lName, String telephone) {
		this.firstName = fName;
		this.lastName = lName;
		this.telephoneNumber = telephone;
	}

	public StringProperty firstNameProperty() {
		return new SimpleStringProperty(firstName);
	}

	public StringProperty lastNameProperty() {
		return new SimpleStringProperty(lastName);
	}

	public StringProperty telephoneNumberProperty() {
		return new SimpleStringProperty(telephoneNumber);
	}
}
