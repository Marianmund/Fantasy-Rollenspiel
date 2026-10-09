package Helden.Waffen;

public class Held {
	private String name;
	private int gesundheit;
	private int schaden;
	private Waffe[] inventar = new Waffe[3];
	private int anzahlWaffen;

	public Held(int gesundheit, int schaden) {
		this.gesundheit = gesundheit;
		this.schaden = schaden;
	}

	public Held(int gesundheit, int schaden, String name) {
		this.gesundheit = gesundheit;
		this.schaden = schaden;
		this.name = name;
	}

	public int getGesundheit() {
		return gesundheit;
	}

	public int getSchaden() {
		return schaden;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean waffeAufnehmen(Wartebank wartebank) {
		if (wartebank == null) {
			throw new IllegalArgumentException("Wartebank darf nicht null sein.");
		}
		if (anzahlWaffen == inventar.length) {
			return false;
		}

		Waffe waffe = wartebank.waffeEntnehmen();
		if (waffe == null) {
			return false;
		}

		inventar[anzahlWaffen] = waffe;
		anzahlWaffen++;
		return true;
	}

	public Waffe[] getInventar() {
		Waffe[] kopie = new Waffe[inventar.length];
		System.arraycopy(inventar, 0, kopie, 0, inventar.length);
		return kopie;
	}

	
	public void erleideSchaden(int schaden) {
		if (schaden < 0) {
			throw new IllegalArgumentException("Schaden darf nicht negativ sein.");
		}
		gesundheit = Math.max(0, gesundheit - schaden);
	}

	
}
