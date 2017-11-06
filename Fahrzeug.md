/**
 * @author <Nemanja Filipovic>
 * Matrikelnummer:01348905
 */

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;


public abstract class Fahrzeug implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String marke;
	private String modell;
	private Jahr baujahr;
	private double grundpreis;
	
	public Fahrzeug(long id, String marke, String modell, Jahr baujahr, double grundpreis) {
		if(baujahr.istJuenger(Jahr.heuer())) throw new IllegalArgumentException("Error: Baujahr ungueltig.");
		if(grundpreis < 0) throw new IllegalArgumentException("Error: Grunpreis ungueltig.");
		this.id = id;
		this.marke = marke;
		this.modell = modell;
		this.baujahr = baujahr;
		this.grundpreis = grundpreis;
	}
	
	public String getMarke() {
		return marke;
	}

	public void setMarke(String marke) {
		this.marke = marke;
	}

	public String getModell() {
		return modell;
	}

	public void setModell(String modell) {
		this.modell = modell;
	}

	public Jahr getBaujahr() {
		return baujahr;
	}

	public void setBaujahr(Jahr baujahr) {
		this.baujahr = baujahr;
	}

	public double getGrundpreis() {
		return grundpreis;
	}

	public void setGrundpreis(double grundpreis) {
		this.grundpreis = grundpreis;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public int getAlter() {
		return Jahr.heuer().unterschied(this.baujahr);
	}
	
	public abstract double getRabatt();
	
	public String getPreis() {
		DecimalFormat df = Fahrzeug.getDecimalFormat();
		double temp = getGrundpreis() - getRabatt();
		return df.format(temp);
	}

	public static DecimalFormat getDecimalFormat() {
		DecimalFormatSymbols dfs = DecimalFormatSymbols.getInstance();
		dfs.setDecimalSeparator('.');
		return new DecimalFormat("0.00", dfs);
	}

	@Override
	public String toString() {
		DecimalFormat df = Fahrzeug.getDecimalFormat();
		return "Id:           " + id + "\nMarke:        " + marke + "\nModell:       " + modell + "\nBaujahr:      " + baujahr
				+ "\nGrundpreis:   " + df.format(grundpreis);
	}		
}
