package Helden.Waffen;

public class Wartebank {
	private Waffe[] waffen = new Waffe[0];
	private int anzahl;

	public void waffeHinzufuegen(Waffe waffe) {
		if (waffe == null) {
			throw new IllegalArgumentException("Waffe darf nicht null sein.");
		}

		if (anzahl == waffen.length) {
			Waffe[] groessereWaffen = new Waffe[Math.max(1, waffen.length * 2)];
			System.arraycopy(waffen, 0, groessereWaffen, 0, anzahl);
			waffen = groessereWaffen;
		}

		waffen[anzahl] = waffe;
		anzahl++;
	}

	public Waffe[] getWaffen() {
		Waffe[] gespeicherteWaffen = new Waffe[anzahl];
		System.arraycopy(waffen, 0, gespeicherteWaffen, 0, anzahl);
		return gespeicherteWaffen;
	}

	public Waffe waffeEntnehmen() {
		if (anzahl == 0) {
			return null;
	}

		Waffe entnommeneWaffe = waffen[0];
		anzahl--;
		System.arraycopy(waffen, 1, waffen, 0, anzahl);
		waffen[anzahl] = null;
		return entnommeneWaffe;
	}
}