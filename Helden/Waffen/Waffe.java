src package Helden.Waffen;

public abstract class Waffe {
	private String name;
	private int magie;
    private String seltenheit;

	public Waffe(String name, int magie, String seltenheit) {
		this.name = name;
		this.magie = magie;
		this.seltenheit = seltenheit;
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
		return 0;
	}
}
