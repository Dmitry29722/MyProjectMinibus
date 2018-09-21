package controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import model.Passenger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ControllerForSaveAndReadObservableList {
	public ObservableList<Passenger> dataTable=FXCollections.observableArrayList();

	public  ObservableList<Passenger> getDataTable() {
		return dataTable;
	}

	public  void setDataTable(ArrayList<Passenger> dataTable2) {
		this.dataTable = FXCollections.observableArrayList(dataTable2);
	}

	public  void setDataTable(ObservableList<Passenger> dataTable) {
		this.dataTable = dataTable;
	}
	
	public static void write(ObservableList<Passenger> personObservalble) {
		try {
			FileOutputStream fos = new FileOutputStream("Objectsavefile.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(new ArrayList<Passenger>(personObservalble));
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/* public static ObservableList<Passenger> read(Path file) {
	      
		 try {
	            InputStream in = Files.newInputStream(file);
	            ObjectInputStream ois = new ObjectInputStream(in);
	            List<Passenger> list = (List<Passenger>) ois.readObject() ;

	            return FXCollections.observableList(list);
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return FXCollections.emptyObservableList();
	    }*/
}
