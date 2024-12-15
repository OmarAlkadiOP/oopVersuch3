package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import factory.ConcreteCreatorAB;
import factory.Creator;
import factory.Product;
import ownUtil.Observable;
import ownUtil.Observer;


public class FahrradModel implements Observable {
	
	private static Fahrrad fahrrad;
	
	private static FahrradModel fahrradmodel;
	
	private Vector<Observer> observers = new Vector<Observer>();
	
	private FahrradModel() {
		
	}
	
	 public Fahrrad getFahrrad() {
		return fahrrad;
	}
	public static void setFahrrad(Fahrrad fahrrad) {
		FahrradModel.fahrrad = fahrrad;
	}
	
	public Vector<Observer> getObservers() {
		return observers;
	}

	public void setObservers(Vector<Observer> observers) {
		this.observers = observers;
		notifyObservers();
	}
	
	public static FahrradModel getFahrradModel() {
		if(fahrradmodel == null) {
			return fahrradmodel = new FahrradModel();
		}
		return fahrradmodel;
	}
	
	public void schreibeFahrradInCsvDatei() throws IOException{
		    BufferedWriter aus = new BufferedWriter(new FileWriter("FahrradAusgabe.csv", false));
		   	aus.write(fahrrad.gibFahrradZurueck(';'));
		    aus.close();
		    notifyObservers();
	 	}
	
	public void leseAusDatei(String typ) throws IOException {
		
		
		Creator creator=new ConcreteCreatorAB();
		Product reader=creator.factoryMethod(typ);
		
		String [] zeile= reader.leseAusDatei();
		
		reader.schliesseDatei();
			
		this.fahrrad=new Fahrrad(zeile[0], 
				Float.parseFloat(zeile[1]), 
				zeile[2], 
				Float.parseFloat(zeile[3]), 
				zeile[4].split("_"));
		
		notifyObservers();
		
//		if ("csv".equals(typ)) {
//			BufferedReader ein = new BufferedReader(new FileReader("FahrradAusgabe.csv"));
//			String[] zeile = ein.readLine().split(";");
//			this.fahrrad = new Fahrrad(zeile[0], Float.parseFloat(zeile[1]), zeile[2], Float.parseFloat(zeile[3]), zeile[4].split(";"));
//			ein.close();
//		}
	}
	@Override
	public void addObserver(Observer obs) {
		// TODO Auto-generated method stub
		this.observers.addElement(obs);
	}
	@Override
	public void removeObserver(Observer obs) {
		// TODO Auto-generated method stub
		this.observers.removeElement(obs);
	}
	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for (Observer observer : observers) {
			observer.update();
		}
	}


}
