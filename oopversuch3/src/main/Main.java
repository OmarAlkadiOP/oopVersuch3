package main;


import gui.guiFahrraeder.FahrradControl;
import gui.guiFahrraederundZubehoer.FahrraederUndZubehoerControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		
		new FahrradControl(primaryStage);
	
		Stage fensterFahrraederUndZubehoer = new Stage();
		new FahrraederUndZubehoerControl(fensterFahrraederUndZubehoer);
		
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
