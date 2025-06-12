package main;

import gui.HomeScreen;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Startup extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		HomeScreen root = new HomeScreen();
		Scene scene = new Scene(root);
		
	
		primaryStage.setScene(scene);
		primaryStage.setTitle("Blonde Friction");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
