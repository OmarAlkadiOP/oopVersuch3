package gui.guiFahrraederundZubehoer;

import java.io.IOException;

import business.FahrradModel;
import javafx.stage.Stage;

public class FahrraederUndZubehoerControl {
	
	public FahrraederUndZubehoerView fahrradView;
	public FahrradModel fahrradModel;

	public FahrraederUndZubehoerControl(Stage primaryStage) {
		this.fahrradModel = FahrradModel.getFahrradModel();
		this.fahrradView = new FahrraederUndZubehoerView(this, primaryStage, fahrradModel);
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
			//this.fahrradView.zeigeInformationsfensterAn("Das Fahrrad wurden gespeichert!");
		} catch (IOException exc) {
			this.fahrradView.zeigeFehlermeldungsfensterAn("IOException beim Speichern!");
		} catch (Exception exc) {
			this.fahrradView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!");
		}
	}


//	private FahrraederUndZubehoerView fahrraederUndZubehoerView;
//	private FahrradModel fahrraederModel;
//
//	public FahrraederUndZubehoerControl(Stage primaryStage) {
//
//		this.fahrraederModel = FahrradModel.getFahrradModel();
//		this.fahrraederUndZubehoerView = new FahrraederUndZubehoerView(this, primaryStage, fahrraederModel);
//		
//	}
}
