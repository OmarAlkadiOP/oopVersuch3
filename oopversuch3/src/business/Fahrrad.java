package business;

public class Fahrrad {
	

    private String name;

    private float rahmennummer;
    private String dhk;

    private float fahrradtyp;

    private String[] vorhandeneGroessen ;

    public Fahrrad(String name, float rahmennummer, String dhk,float fahrradtyp, String[] vorhandeneGroessen ){
   		this.name = name;
  	    this.rahmennummer = rahmennummer;
   	    this.dhk = dhk;
   	    this.fahrradtyp = fahrradtyp;
   	    this.vorhandeneGroessen  = vorhandeneGroessen ;
    }
  
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public float getRahmennummer() {
		return rahmennummer;
	}


	public void setRahmennummer(float rahmennummer) {
		this.rahmennummer = rahmennummer;
	}


	public String getDhk() {
		return dhk;
	}


	public void setDhk(String dhk) {
		this.dhk = dhk;
	}


	public float getFahrradtyp() {
		return fahrradtyp;
	}


	public void setFahrradtyp(float fahrradtyp) {
		this.fahrradtyp = fahrradtyp;
	}


	public String[] getVorhandeneGroessen() {
		return vorhandeneGroessen;
	}


	public void setVorhandeneGroessen(String[] vorhandeneGroessen) {
		this.vorhandeneGroessen = vorhandeneGroessen;
	}


	public String getVorhandeneGroessenAlsString(char trenner) {
		String ergebnis = "";
		int i = 0;
		for(i = 0; i < this.getVorhandeneGroessen ().length - 1; i++) {
			ergebnis = ergebnis + this.getVorhandeneGroessen ()[i] + trenner; 
		}
		return ergebnis	+ this.getVorhandeneGroessen ()[i];
	}
	
	public String gibFahrradZurueck(char trenner){
  		return this.getName() + trenner 
  			+ this.getRahmennummer() + trenner
  		    + this.getDhk() + trenner
  		    + this.getFahrradtyp() + trenner
  		    + this.getVorhandeneGroessenAlsString(trenner);
  	}

	
}

