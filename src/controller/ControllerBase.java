package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import model.Minibus;
import model.Route;
import model.Trip;

public class ControllerBase implements Serializable {
	private static Map<String, Minibus> minibuses = new HashMap<>();
	private static Map<String, Route> routes = new HashMap<>();
	private static Map<String, Trip> trips = new TreeMap<>();

	private static File minibusesFile = new File("minibuses");
	private static File routesFile = new File("routes");
	private static File tripsFile = new File("trips");
	private FileInputStream fisMinibusesFile;
	private FileInputStream fisRoutesFile;
	private FileInputStream fisTripsFile;

	private ControllerBase() {
		try {
			if (!minibusesFile.isFile() && !routesFile.isFile()
					&& !tripsFile.isFile()) {
				saveBase();// автоматически создать базу при её отсутствии
			}

			fisMinibusesFile = new FileInputStream(minibusesFile);
			fisRoutesFile = new FileInputStream(routesFile);
			fisTripsFile = new FileInputStream(tripsFile);
			ObjectInputStream oisMinibus = new ObjectInputStream(
					fisMinibusesFile);
			ObjectInputStream oisRoutes = new ObjectInputStream(fisRoutesFile);
			ObjectInputStream oisTrips = new ObjectInputStream(fisTripsFile);
			Map<String, Minibus> readObjectMinibus = (Map<String, Minibus>) oisMinibus
					.readObject();
			Map<String, Route> readObjectRoute = (Map<String, Route>) oisRoutes
					.readObject();
			Map<String, Trip> readObjectTrip = (Map<String, Trip>) oisTrips
					.readObject();

			minibuses = readObjectMinibus;
			routes = readObjectRoute;
			trips = readObjectTrip;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {

		}
	}

	public static void saveBase() {

		try {

			minibusesFile.createNewFile();
			routesFile.createNewFile();
			tripsFile.createNewFile();
			FileOutputStream fosMinibuses = new FileOutputStream(minibusesFile);
			FileOutputStream fosRoutes = new FileOutputStream(routesFile);
			FileOutputStream fosTrips = new FileOutputStream(tripsFile);
			ObjectOutputStream oosMinibuses = new ObjectOutputStream(
					fosMinibuses);
			ObjectOutputStream oosRoutes = new ObjectOutputStream(fosRoutes);
			ObjectOutputStream oosTrips = new ObjectOutputStream(fosTrips);
			oosMinibuses.writeObject(minibuses);
			oosRoutes.writeObject(routes);
			oosTrips.writeObject(trips);
			oosMinibuses.close();
			oosRoutes.close();
			oosTrips.close();
			fosMinibuses.close();
			fosRoutes.close();
			fosTrips.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static Map<String, Minibus> getMinibuses() {
		return minibuses;
	}

	public static void setMinibuses(Map<String, Minibus> minibuses) {
		ControllerBase.minibuses = minibuses;
	}

	public static Map<String, Route> getRoutes() {
		return routes;
	}

	public static void setRoutes(Map<String, Route> routes) {
		ControllerBase.routes = routes;
	}

	public static Map<String, Trip> getTrips() {
		return trips;
	}

	public static void setTrips(Trip trip) {
		ControllerBase.getTrips().put(
				trip.getFullNameOfTheRoute()
						+ trip.getDateOfTravel().getDate().toString()
						+ trip.getTimeOfRoute()
						+ trip.getMinibus().getCarNumber(), trip);
	}

}
