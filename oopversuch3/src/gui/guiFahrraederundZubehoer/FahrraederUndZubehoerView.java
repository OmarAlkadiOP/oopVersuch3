package gui.guiFahrraederundZubehoer;

import business.FahrradModel;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;
import ownUtil.Observer;

public class FahrraederUndZubehoerView implements Observer {

	private FahrraederUndZubehoerControl fahrraederUndZubehoerControl;
	private FahrradModel fahrraederModel;

	// ---Anfang Attribute der grafischen Oberflaeche---
	private Pane pane = new Pane();
	private Label lblAnzeigeFahrraeder = new Label("Anzeige Fahrräder");
	private TextArea txtAnzeigeFahrraeder = new TextArea();
	private Button btnAnzeigeFahrraeder = new Button("Anzeige");
	// -------Ende Attribute der grafischen Oberflaeche-------

	public FahrraederUndZubehoerView(FahrraederUndZubehoerControl fahrraederUndZubehoerControl, Stage primaryStage,
			FahrradModel fahrraederModel) {

		Scene scene = new Scene(this.pane, 560, 340);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Anzeige von FahrraederUndZubehoer");
		primaryStage.show();
		this.fahrraederUndZubehoerControl = fahrraederUndZubehoerControl;
		this.fahrraederModel = fahrraederModel;
		this.initKomponenten();
		this.initListener();
		this.fahrraederModel.addObserver(this);

	}

	private void initKomponenten() {
		// Label
		Font font = new Font("Arial", 20);
		lblAnzeigeFahrraeder.setLayoutX(310);
		lblAnzeigeFahrraeder.setLayoutY(40);
		lblAnzeigeFahrraeder.setFont(font);
		lblAnzeigeFahrraeder.setStyle("-fx-font-weight: bold;");
		pane.getChildren().add(lblAnzeigeFahrraeder);

		// Textbereich
		txtAnzeigeFahrraeder.setEditable(false);
		txtAnzeigeFahrraeder.setLayoutX(310);
		txtAnzeigeFahrraeder.setLayoutY(90);
		txtAnzeigeFahrraeder.setPrefWidth(220);
		txtAnzeigeFahrraeder.setPrefHeight(185);
		pane.getChildren().add(txtAnzeigeFahrraeder);

		// Button
		btnAnzeigeFahrraeder.setLayoutX(310);
		btnAnzeigeFahrraeder.setLayoutY(290);
		pane.getChildren().add(btnAnzeigeFahrraeder);

	}

	private void initListener() {
		btnAnzeigeFahrraeder.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				// zeigeFahrraederAn();
				update();
			}
		});
	}

//	private void zeigeFahrraederAn() {
//		if (fahrraederModel.getFahrrad() != null) {
//			txtAnzeigeFahrraeder.setText(fahrraederModel.getFahrrad().gibFahrradZurueck(' '));
//
//		} else {
//			zeigeInformationsfensterAn("Bisher wurde kein Fahrrad aufgenommen!");
//
//		}
//	}

	public void zeigeInformationsfensterAn(String meldung) {
		new MeldungsfensterAnzeiger(AlertType.INFORMATION, "Information", meldung).zeigeMeldungsfensterAn();
	}

	public void zeigeFehlermeldungsfensterAn(String meldung) {
		new MeldungsfensterAnzeiger(AlertType.ERROR, "Fehler", meldung).zeigeMeldungsfensterAn();
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if (this.fahrraederModel.getFahrrad() != null) {
			txtAnzeigeFahrraeder.setText(this.fahrraederModel.getFahrrad().gibFahrradZurueck(' '));
		} else {
			zeigeInformationsfensterAn("Bisher wurde kein Fahrrad aufgenommen!");
		}

	}

}
