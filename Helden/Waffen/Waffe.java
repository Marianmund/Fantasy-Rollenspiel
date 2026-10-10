package Helden.Waffen;

public abstract class Waffe {
	private final String name;
	private final int magie;

	public Waffe(String name, int magie, String seltenheit) {
		this.name = name;
		this.magie = magie;
	}

	public String getName() {
		return name;
	}

	public int getMagie() {
		return magie;
	}

	public abstract int getSchaden();

	public int bonusBerechnen() {
		if (this.magie != 0) {
			int gesamtschaden = this.magie * getSchaden();
			return gesamtschaden;
		} else {
			System.out.println("Die Waffe " + this.name + " hat keinen Magiebonus.");
			return getSchaden();
		}
	}
}
