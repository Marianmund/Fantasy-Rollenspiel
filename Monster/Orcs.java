src package Monster

public class Orcs extends Monster {
    private int schaden;

    public Orcs(String name, int leben, int schaden) {
        super(name, leben, schaden);
        this.schaden = schaden;
    }

    public int getSchaden() {
        return schaden;
    }

    
}