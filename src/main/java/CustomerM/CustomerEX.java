package CustomerM;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import CustomerM.CustomerEX;

import java.io.*;

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