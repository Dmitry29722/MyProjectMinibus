package model;

import java.io.Serializable;
import java.time.LocalDate;

public class DateOfTravel implements Serializable{
	private LocalDate date;

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
}
