package controller;

import java.io.Serializable;

import javafx.scene.control.Alert;

public class ControllerErrors {

	public static boolean testForNull(String... values) {
		for (String value : values) {
			if (value.length() == 0) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText(null);
				alert.setContentText("Fill in all the fields!");
				alert.showAndWait();
				return false;
			}
		}
		return true;
	}
	
	public static void getYourErrorMessage(String message) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}
	
	public static boolean testForMaximumNumberOfSeats(){
		
		return false;
	}
}
