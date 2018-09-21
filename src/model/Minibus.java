package model;

import java.io.Serializable;

public class Minibus implements Serializable{
	private String brandOfCar;
	private String carNumber;
	private int numberOfSeats;

	public String getBrandOfCar() {
		return brandOfCar;
	}

	public void setBrandOfCar(String brandOfCar) {
		this.brandOfCar = brandOfCar;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

}
