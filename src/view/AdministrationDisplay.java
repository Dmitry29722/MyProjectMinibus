package view;

import model.Minibus;
import model.Route;
import controller.ControllerAddElementsInBase;
import controller.ControllerErrors;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import controller.ControllerMenager;

public class AdministrationDisplay {

	private ControllerMenager controller = new ControllerAddElementsInBase();
	private Scene scene;
	private Button back;
	private Button addCar;
	private TextField textFieldBrandOfCar;
	private Label labelAddBrandOfCar;
	private TextField textFieldCarNumber;
	private Label labelAddCarNumber;
	private TextField textFieldNumberOfSeats;
	private Label labelAddNumberOfSeats;
	private Button addRoute;
	private Label labelAddDeparturePoint;
	private TextField textFieldDeparturePoint;
	private Label labelAddPlaceOfArrival;
	private TextField textFieldPlaceOfArrival;
	private Label labelAddPrice;
	private TextField textFieldPrice;
	private Label labelAddTime;
	private TextField textFieldTime1;
	private TextField textFieldTime2;
	private TextField textFieldTime3;
	private TextField textFieldTime4;
	private TextField textFieldTime5;

	public AdministrationDisplay() {

		back = new Button("вернуться в меню");
		back.setOnAction(new EventHandler<ActionEvent>() {
			// вернуться в главное меню
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
		// Для добавления машины
		labelAddBrandOfCar = new Label("Brand of car");
		textFieldBrandOfCar = new TextField();
		labelAddCarNumber = new Label("Car number");
		textFieldCarNumber = new TextField();
		labelAddNumberOfSeats = new Label("Number of seats");
		textFieldNumberOfSeats = new TextField();
		addCar = new Button("add car");
		addCar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				if (ControllerErrors.testForNull(textFieldBrandOfCar.getText(),
						textFieldCarNumber.getText(),
						textFieldNumberOfSeats.getText())) {
					Minibus minibus = new Minibus();
					minibus.setBrandOfCar(textFieldBrandOfCar.getText());
					minibus.setCarNumber(textFieldCarNumber.getText());
					minibus.setNumberOfSeats(Integer
							.parseInt(textFieldNumberOfSeats.getText()));
					controller.addMinibus(minibus);
					textFieldBrandOfCar.clear();
					textFieldCarNumber.clear();
					textFieldNumberOfSeats.clear();
				}
			}
		});
		// Для добавления маршрута
		labelAddDeparturePoint = new Label("Add departure point");
		textFieldDeparturePoint = new TextField();
		labelAddPlaceOfArrival = new Label("Add place of arrival");
		textFieldPlaceOfArrival = new TextField();
		labelAddPrice = new Label("Set price");
		textFieldPrice = new TextField();
		labelAddTime = new Label("Time");
		textFieldTime1 = new TextField();
		textFieldTime2 = new TextField(); 
		textFieldTime3 = new TextField(); 
		textFieldTime4 = new TextField(); 
		textFieldTime5 = new TextField(); 
		addRoute = new Button("Add route");
		addRoute.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				if (ControllerErrors.testForNull(textFieldDeparturePoint.getText(),
						textFieldPlaceOfArrival.getText(),
						textFieldPrice.getText(),textFieldTime1.getText(),textFieldTime2.getText(),textFieldTime3.getText()
						,textFieldTime4.getText(),textFieldTime5.getText())) {
					Route route = new Route();
					route.setDeparturePoint(textFieldDeparturePoint.getText());
					route.setPlaceOfArrival(textFieldPlaceOfArrival.getText());
					route.setPrice(Double.parseDouble(textFieldPrice.getText()));
					route.setTimeList(
							textFieldTime1.getText(),
							textFieldTime2.getText(),
							textFieldTime3.getText(),
							textFieldTime4.getText(),
							textFieldTime5.getText());
					controller.addRoute(route);
					textFieldDeparturePoint.clear();
					textFieldPlaceOfArrival.clear();
					textFieldPrice.clear();
					textFieldTime1.clear();
					textFieldTime2.clear();
					textFieldTime3.clear();
					textFieldTime4.clear();
					textFieldTime5.clear();
				}
			}
		});

		// Кидаем всё на панель
		GridPane layout = new GridPane();
		layout.add(labelAddBrandOfCar, 0, 1);
		layout.add(textFieldBrandOfCar, 1, 1);
		layout.add(labelAddCarNumber, 0, 2);
		layout.add(textFieldCarNumber, 1, 2);
		layout.add(labelAddNumberOfSeats, 0, 3);
		layout.add(textFieldNumberOfSeats, 1, 3);
		layout.add(addCar, 0, 4);
		layout.add(labelAddDeparturePoint, 0, 5);
		layout.add(textFieldDeparturePoint, 1, 5);
		layout.add(labelAddPlaceOfArrival, 0, 6);
		layout.add(textFieldPlaceOfArrival, 1, 6);
		layout.add(labelAddPrice, 0, 7);
		layout.add(textFieldPrice, 1, 7);
		layout.add(labelAddTime, 0, 8);
		layout.add(textFieldTime1, 1, 8);
		layout.add(textFieldTime2, 1, 9);
		layout.add(textFieldTime3, 1, 10);
		layout.add(textFieldTime4, 1, 11);
		layout.add(textFieldTime5, 1, 12);
		layout.add(addRoute, 0, 13);
		layout.add(back, 0, 14);

		scene = new Scene(layout, 500, 500);

	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

}
