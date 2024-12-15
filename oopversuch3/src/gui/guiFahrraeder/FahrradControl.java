package gui.guiFahrraeder;

import java.io.IOException;

import business.Fahrrad;
import business.FahrradModel;
import javafx.stage.Stage;

public class FahrradControl {
	private FahrradView fahrradView;
	private FahrradModel fahrradModel;
	
	public FahrradControl(Stage primaryStage) {
		this.fahrradModel = FahrradModel.getFahrradModel();
		this.fahrradView = new FahrradView(this, primaryStage, fahrradModel);
	}
	public void nehmeFahrradAuf(){
    	try{
    		this.fahrradModel.setFahrrad(new Fahrrad(
    			fahrradView.getTxtName().getText(), 
   	            Float.parseFloat(fahrradView.getTxtRahmennummer().getText()),
   	            fahrradView.getTxtDhk().getText(),
   	            Float.parseFloat(fahrradView.getTxtFahrradtyp().getText()),
   	         	fahrradView.getTxtVorhandeneGroessen().getText().split(";")));
    			//fahrradView.zeigeInformationsfensterAn("Das Fahrrad wurde aufgenommen!");
    		this.fahrradModel.notifyObservers();
       	}
       	catch(Exception exc){
       		fahrradView.zeigeFehlermeldungsfensterAn(exc.getMessage());
     	}
    }

	public void leseAusDatei(String typ) {
		try {
			this.fahrradModel.leseAusDatei(typ);
			//this.fahrradView.zeigeInformationsfensterAn("Fahrrad wurde aufgenommen");
		} catch (IOException exc) {
			this.fahrradView.zeigeFehlermeldungsfensterAn("IOException beim Lesen!");
		} catch (Exception exc) {
			this.fahrradView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Lesen!" + exc.getMessage());
		}
	}

	public void schreibeFahrradInCsvDatei() {
		try {
			this.fahrradModel.schreibeFahrradInCsvDatei();
			this.fahrradView.zeigeInformationsfensterAn("Das Fahrrad wurden gespeichert!");
		} catch (IOException exc) {
			this.fahrradView.zeigeFehlermeldungsfensterAn("IOException beim Speichern!");
		} catch (Exception exc) {
			this.fahrradView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!");
		}
	}
    
	
	
	
}
