//package guiFahrraeder;
/*package gui;
   
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import business.Fahrrad;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

public class FahrraederAnwendersystem {
	  
    //---Anfang Attribute der grafischen Oberflaeche---
    private Pane pane     					= new  Pane();
    private Label lblEingabe    	 		= new Label("Eingabe");
    private Label lblAnzeige   	 	    	= new Label("Anzeige");
    private Label lblName 					= new Label("Name:");
    private Label lblRahmennummer   		= new Label("Rahmennummer:");
    private Label lblFahrradtyp  	 		= new Label("Fahrradtyp:");
    private Label lblDHK   			= new Label("Damen/Herren/Kinder?:");
    private Label lblVorhandeneGroe�en  		= new Label("Vorhandene Groe�en:");
    private TextField txtName 	 			= new TextField();
    private TextField txtRahmennummer		= new TextField();
    private TextField txtFahrradtyp		= new TextField();
    private TextField txtDHK			= new TextField();
    private TextField txtVorhandeneGroe�en	= new TextField();
    private TextArea txtAnzeige  			= new TextArea();
    private Button btnEingabe 		 		= new Button("Eingabe");
    private Button btnAnzeige 		 		= new Button("Anzeige");
    private MenuBar mnbrMenuLeiste  		= new MenuBar();
    private Menu mnDatei             		= new Menu("Datei");
    private MenuItem mnItmCsvImport 		= new MenuItem("csv-Import");
    private MenuItem mnItmTxtImport 		= new MenuItem("txt-Import");
    private MenuItem mnItmCsvExport 		= new MenuItem("csv-Export");    
    //-------Ende Attribute der grafischen Oberflaeche-------
    
    // speichert temporaer ein Objekt vom Typ Buergeramt
    private Fahrrad fahrrad;
    
    public FahrraederAnwendersystem(Stage primaryStage){
    	Scene scene = new Scene(this.pane, 700, 340);
    	primaryStage.setScene(scene);
    	primaryStage.setTitle("Verwaltung von Fahrraedern fuer ein Fahrradgeschaeft");
    	primaryStage.show();
    	this.initKomponenten();
		this.initListener();
    }
    
    private void initKomponenten(){
       	// Labels
    	lblEingabe.setLayoutX(20);
    	lblEingabe.setLayoutY(40);
    	Font font = new Font("Arial", 24); 
    	lblEingabe.setFont(font);
    	lblEingabe.setStyle("-fx-font-weight: bold;"); 
    	lblAnzeige.setLayoutX(400);
    	lblAnzeige.setLayoutY(40);
      	lblAnzeige.setFont(font);
       	lblAnzeige.setStyle("-fx-font-weight: bold;"); 
       	lblName.setLayoutX(20);
    	lblName.setLayoutY(90);
    	lblRahmennummer.setLayoutX(20);
    	lblRahmennummer.setLayoutY(130);
    	lblFahrradtyp.setLayoutX(20);
    	lblFahrradtyp.setLayoutY(170);
    	lblDHK.setLayoutX(20);
    	lblDHK.setLayoutY(210);
    	lblVorhandeneGroe�en.setLayoutX(20);
    	lblVorhandeneGroe�en.setLayoutY(250);    	
       	pane.getChildren().addAll(lblEingabe, lblAnzeige, 
       		lblName, lblRahmennummer, lblFahrradtyp,
       		lblDHK, lblVorhandeneGroe�en);
    
    	// Textfelder
     	txtName.setLayoutX(170);
    	txtName.setLayoutY(90);
    	txtName.setPrefWidth(200);
    	txtRahmennummer.setLayoutX(170);
    	txtRahmennummer.setLayoutY(130);
    	txtRahmennummer.setPrefWidth(200);
    	txtFahrradtyp.setLayoutX(170);
    	txtFahrradtyp.setLayoutY(170);
    	txtFahrradtyp.setPrefWidth(200);
      	txtDHK.setLayoutX(170);
    	txtDHK.setLayoutY(210);
    	txtDHK.setPrefWidth(200);
    	txtVorhandeneGroe�en.setLayoutX(170);
    	txtVorhandeneGroe�en.setLayoutY(250);
    	txtVorhandeneGroe�en.setPrefWidth(200);
      	pane.getChildren().addAll( 
     		txtName, txtRahmennummer, txtFahrradtyp,
     		txtDHK, txtVorhandeneGroe�en);
     	
        // Textbereich	
        txtAnzeige.setEditable(false);
     	txtAnzeige.setLayoutX(400);
    	txtAnzeige.setLayoutY(90);
     	txtAnzeige.setPrefWidth(270);
    	txtAnzeige.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeige); 
       	
        // Buttons
        btnEingabe.setLayoutX(20);
        btnEingabe.setLayoutY(290);
        btnAnzeige.setLayoutX(400);
        btnAnzeige.setLayoutY(290);
        pane.getChildren().addAll(btnEingabe, btnAnzeige); 
        
 		// Menue
  	    this.mnbrMenuLeiste.getMenus().add(mnDatei);
  	    this.mnDatei.getItems().add(mnItmCsvImport);
  	    this.mnDatei.getItems().add(mnItmTxtImport);
  	    this.mnDatei.getItems().add(new SeparatorMenuItem());
  	    this.mnDatei.getItems().add(mnItmCsvExport);
 	    pane.getChildren().add(mnbrMenuLeiste);
   }
   
   private void initListener() {
	    btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
        	    nehmeFahrradAuf();
            }
	    });
	    btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	        public void handle(ActionEvent e) {
	            zeigeFahrraederAn();
	        } 
   	    });
	    mnItmCsvImport.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	        public void handle(ActionEvent e) {
	       	 	leseAusDatei("csv");
	    	}
	    });
	    mnItmTxtImport.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent e) {
		     	leseAusDatei("txt");
		    }
    	});
	    mnItmCsvExport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				schreibeFahrraederInCsvDatei();
			}	
	    });
    }
    
    private void nehmeFahrradAuf(){
    	try{
    		this.fahrrad = new Fahrrad(
    			txtName.getText(), 
   	            Float.parseFloat(txtRahmennummer.getText()),
   	            txtFahrradtyp.getText(),
    		    txtDHK.getText(),
    		    txtVorhandeneGroe�en.getText().split(";"));
    		zeigeInformationsfensterAn("Das Fahrrad wurde aufgenommen!");
       	}
       	catch(Exception exc){
       		zeigeFehlermeldungsfensterAn(exc.getMessage());
     	}
    }
   
    private void zeigeFahrraederAn(){
    	if(this.fahrrad != null){
    		txtAnzeige.setText(
    			this.fahrrad.gibFahrradZurueck(' '));
    	}
    	else{
    		zeigeInformationsfensterAn("Bisher wurde kein Fahrrad aufgenommen!");
    	}
    }    
		  
    private void leseAusDatei(String typ){
    	try {
      		if("csv".equals(typ)){
      			BufferedReader ein = new BufferedReader(new FileReader("Fahrraeder.csv"));
      			String[] zeile = ein.readLine().split(";");
      			this.fahrrad = new Fahrrad(zeile[0], 
      				Float.parseFloat(zeile[1]), 
      				zeile[2], 
      				zeile[3], zeile[4].split("_"));
      				ein.close();
      	  			zeigeInformationsfensterAn(
      	  	   			"Die Fahrraeder wurden gelesen!");
      		}
       		else{
	   			zeigeInformationsfensterAn(
	   				"Noch nicht implementiert!");
	   		}
		}
		catch(IOException exc){
			zeigeFehlermeldungsfensterAn(
				"IOException beim Lesen!");
		}
		catch(Exception exc){
			zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Lesen!");
		}
	}
		
	private void schreibeFahrraederInCsvDatei() {
		try {
			BufferedWriter aus 
				= new BufferedWriter(new FileWriter("FahrraederAusgabe.csv", true));
			aus.write(fahrrad.gibFahrradZurueck(';'));
			aus.close();
   			zeigeInformationsfensterAn(
	   			"Die Fahrraeder wurden gespeichert!");
		}	
		catch(IOException exc){
			zeigeFehlermeldungsfensterAn(
				"IOException beim Speichern!");
		}
		catch(Exception exc){
			zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Speichern!");
		}
	}

    private void zeigeInformationsfensterAn(String meldung){
    	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
    		"Information", meldung).zeigeMeldungsfensterAn();
    }	
    
    void zeigeFehlermeldungsfensterAn(String meldung){
       	new MeldungsfensterAnzeiger(AlertType.ERROR,
        	"Fehler", meldung).zeigeMeldungsfensterAn();
    }

}*/
