package main;

import view.MainDisplay;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {

		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		MainDisplay display = new MainDisplay();
		display.start(primaryStage);

	}

}
