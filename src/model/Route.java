package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Route implements Serializable{
	private String departurePoint;
	private String placeOfArrival;
	private double price;
	private List<String> timeList = new ArrayList<>();

	public String getDeparturePoint() {
		return departurePoint;
	}

	public void setDeparturePoint(String departurePoint) {
		this.departurePoint = departurePoint;
	}

	public String getPlaceOfArrival() {
		return placeOfArrival;
	}

	public void setPlaceOfArrival(String placeOfArrival) {
		this.placeOfArrival = placeOfArrival;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<String> getTimeList() {
		return timeList;
	}

	public void setTimeList(String... times) {
		this.timeList = Arrays.asList(times);
	}
}
