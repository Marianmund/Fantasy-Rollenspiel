
package Helden.Waffen;

public class Kanone extends Waffe {
    private int schaden;

    public Kanone(String name, int magie, String seltenheit, int schaden) {
        super(name, magie, seltenheit);
        this.schaden = schaden;
    }

    public int getSchaden() {
        return schaden;
    }
    @Override

    public int bonusBerechnen() {
        if (this.getMagie() != 0) {
            int gesamtschaden = this.getMagie() * getSchaden();
            return gesamtschaden;
        } else {
            System.out.println("Die Waffe " + this.getName() + " hat keinen Magiebonus.");
            return getSchaden();
        }
    }
}