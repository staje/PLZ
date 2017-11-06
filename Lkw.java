/**
 * @author <Nemanja Filipovic>
 * Matrikelnummer:01348905
 */

public class Lkw extends Fahrzeug {

	private static final long serialVersionUID = 1L;
	
	

	public Lkw(long id, String marke, String modell, Jahr baujahr, double grundpreis) {
		super(id, marke, modell, baujahr, grundpreis);
	}



	public double getRabatt() {
		double rabatt = getAlter()* 0.05 * getGrundpreis();
		if (rabatt <= 0) {
			return 0.0;
		}
		else if ((rabatt / getGrundpreis()) >= 0.2) {
			return 0.2 * getGrundpreis();
		}
		else {
			return rabatt;
		}
	}
	
	public String toString() {
		return "Typ:          LKW\n" + super.toString() + "\nPreis:        " + getPreis()  + "\n";
	}
	
}
