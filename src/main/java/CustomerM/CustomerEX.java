package CustomerM;

import ChefM.ChefDisplay;
import database.OrderConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import CustomerM.CustomerEX;
import database.OrderConnection;
import java.io.*;
import java.sql.Connection;
import java.util.Observable;


public class CustomerEX extends Application {

	@Override
	public void start(Stage stage) throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(CustomerDisplay.class.getResource("CustomerScene.fxml"));
		Scene scene = new Scene(fxmlLoader.load());
		stage.setScene(scene);
		stage.show();


	}

	public static void main(String[] args) {
		launch();

		ChefDisplay watched = new ChefDisplay();

		CustomerDisplay watcher = new CustomerDisplay();

		watched.addObserver(watcher);

		watched.findStatus();

		if (watched.hasChanged())
			watcher.changeLabel(watched.findStatus());
		else
			System.out.println("Value not changed");
	}
	public void update(Observable obj, Object arg) {
		System.out.println("Update called");
	}

}
/*public static boolean CheckId() {
	if (asuID instanceof String) { //checking if ID is a string or not for now
			return true;
	} 
	else {
			return false;
	}
}*/