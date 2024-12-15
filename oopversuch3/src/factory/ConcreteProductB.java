package factory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteProductB extends Product {

	private BufferedReader br;

	public ConcreteProductB() throws IOException {
		super();
		this.br = new BufferedReader(new FileReader("FahrradAusgabe.txt"));

	}

	@Override
	public String[] leseAusDatei() throws IOException {
		// TODO Auto-generated method stub
		
		String [] ergebnisZeile = new String [5];
		String zeile = br.readLine();
		
		int i = 0;
		
		while(i < ergebnisZeile.length) {
			ergebnisZeile[i] = zeile;
			zeile = br.readLine();
			i++;
		}
		return ergebnisZeile;
	}

	@Override
	public void schliesseDatei() throws IOException {
		// TODO Auto-generated method stub
		br.close();
	}

}
