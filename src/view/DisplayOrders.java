package view;

import java.io.Serializable;

import model.DateOfTravel;
import model.Trip;
import controller.ControllerErrors;
import model.Passenger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import controller.ControllerAddElementsInBase;
import controller.ControllerBase;
import controller.ControllerMenager;

public class DisplayOrders implements Serializable{

	private ControllerMenager controller = new ControllerAddElementsInBase();
	private Scene scene;
	private Button back;
	private Button serchTrip;
	private Label labelAddRoute;
	private ChoiceBox<String> choiceRoute;
	private Label labelAddTime;
	private ChoiceBox<String> choiceTime;
	private TableView<Passenger> table;
	private Label labelAddDate;
	private DatePicker dateOfTrip;
	private TableColumn nameColumn;
	private TableColumn surnameColumn;
	private TableColumn telephoneNumberColumn;
	private Passenger passenger;
	private TextField fieldName;
	private TextField fieldSurname;
	private TextField fieldTelephone;
	private Button addPassenger;
	private ObservableList<Passenger> dataTable;
	//private List<Passenger> dataTable=  new ArrayList<Passenger>();
	private Button save;
	private Label labelAddMinibus;
	private ChoiceBox<String> choiceMinibus;
	private Button buttonDelete;

	public DisplayOrders() {
		
		// вернуться в главное меню
		back = new Button("вернуться в меню");
		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				try {
					MainDisplay.mainDisplay.setScene(new MainDisplay()
							.getMainScene());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		// Выбор маршрутки
		labelAddMinibus = new Label("Chuse minibus");
		choiceMinibus = new ChoiceBox<>();
		choiceMinibus.getItems().addAll(
				controller.getAllKeysInCollection(ControllerBase.getMinibuses()));

		// Время
		labelAddTime = new Label("Time");
		choiceTime = new ChoiceBox<>();
		// Выбора маршрута
		labelAddRoute = new Label("Route");
		choiceRoute = new ChoiceBox<>();
		choiceRoute.getItems().addAll(
				controller.getAllKeysInCollection(ControllerBase.getRoutes()));
		choiceRoute.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				choiceTime.getItems().clear();
				choiceTime.getItems().addAll(
						ControllerBase.getRoutes().get(choiceRoute.getValue())
								.getTimeList());
			}
		});
		// РАБОТА С ТАБЛИЦЕЙ
		dataTable = FXCollections.observableArrayList();
		nameColumn = new TableColumn<>("Name");
		nameColumn.setPrefWidth(100);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));

		surnameColumn = new TableColumn<>("Surname");
		surnameColumn
				.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		surnameColumn.setPrefWidth(150);

		telephoneNumberColumn = new TableColumn<>("Telephone");
		telephoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>(
				"telephoneNumber"));
		telephoneNumberColumn.setPrefWidth(200);

		table = new TableView<>();
		table.getColumns().addAll(nameColumn, surnameColumn,
				telephoneNumberColumn);
		table.setPrefWidth(450);
		table.setPrefHeight(250);

		// ДАТА
		labelAddDate = new Label("Date");
		dateOfTrip = new DatePicker();

		// ADD Passenger
		fieldName = new TextField();
		fieldSurname = new TextField();
		fieldTelephone = new TextField();
		addPassenger = new Button("Add passenger");
		addPassenger.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				if (ControllerErrors.testForNull(fieldName.getText(),
						fieldSurname.getText(), fieldTelephone.getText())) {
					if (dataTable
							.size() < ControllerBase.getMinibuses()
							.get(choiceMinibus.getValue()).getNumberOfSeats()) {
						passenger = new Passenger(fieldName.getText(),
								fieldSurname.getText(), fieldTelephone
										.getText());
						dataTable.add(passenger);
						table.setItems(dataTable);
						fieldName.clear();
						fieldSurname.clear();
						fieldTelephone.clear();
					} else {
						ControllerErrors
								.getYourErrorMessage("Maximum number of seats"
										+ ControllerBase.getMinibuses()
												.get(choiceMinibus.getValue())
												.getNumberOfSeats());
					}
				};
			}
		});
		//Delete Passenger
		buttonDelete= new Button("Delete");
		buttonDelete.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				ObservableList<Passenger> passengerSelected, allPassengers;
				allPassengers=table.getItems();
				passengerSelected=table.getSelectionModel().getSelectedItems();
				for(int i=0;i<allPassengers.size();i++){
					if(allPassengers.get(i)==passengerSelected.get(0)){
						allPassengers.remove(i);
					}
				}
				table.setItems(allPassengers);
			}
		});
		// Поиск поездок
		serchTrip = new Button("Serch trip");
		serchTrip.setOnAction(new EventHandler<ActionEvent>() {
				
			@Override
			public void handle(ActionEvent arg0) {
				dataTable=(ObservableList<Passenger>) ControllerBase
						.getTrips()
						.get(choiceRoute.getValue()
								+ dateOfTrip.getValue().toString()
								+ choiceTime.getValue()
								+ choiceMinibus.getValue()).getPassengers();
				table.setItems(dataTable);
			}
		});
		// SAVE
		save = new Button("Save");
		save.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				DateOfTravel dateOfTravel = new DateOfTravel();
				dateOfTravel.setDate(dateOfTrip.getValue());
				Trip trip = new Trip(dateOfTravel, choiceRoute.getValue(),
						ControllerBase.getMinibuses().get(choiceMinibus.getValue()),
						dataTable, choiceTime.getValue());
				ControllerBase.setTrips(trip);
				//dataTable =(List<T>) ControllerForSaveAndReadObservableList.getDataTable().stream().collect(Collectors.toList());
				//ControllerBase.saveBase();
				
			}
		});

		// Кидаем всё на панель
		GridPane layout = new GridPane();
		layout.add(labelAddRoute, 0, 1);
		layout.add(labelAddDate, 1, 1);
		layout.add(choiceRoute, 0, 2);
		layout.add(labelAddTime, 2, 1);
		layout.add(choiceTime, 2, 2);
		layout.add(labelAddMinibus, 5, 1);
		layout.add(choiceMinibus, 5, 2);
		layout.add(dateOfTrip, 1, 2);
		layout.add(table, 0, 4, 3, 2);
		layout.add(fieldName, 0, 6);
		layout.add(fieldSurname, 1, 6);
		layout.add(fieldTelephone, 2, 6);
		layout.add(addPassenger, 5, 6);
		layout.add(buttonDelete, 6, 6);
		layout.add(serchTrip, 0, 7);
		layout.add(save, 5, 7);
		layout.add(back, 1, 7);

		scene = new Scene(layout, 600, 400);

	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

}
