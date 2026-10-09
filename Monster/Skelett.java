src package Monster

public class Skellett extends Monster {
    private int schaden;

    public Skellett(String name, int leben, int schaden) {
        super(name, leben, schaden);
        this.schaden = schaden;
    }

    public int getSchaden() {
        return schaden;
    }
}