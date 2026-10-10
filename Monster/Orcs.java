package Monster;

public class Orcs extends Monster {
    public Orcs(String name, int leben) {
        super(name, leben, 18);
    }

    public Orcs(String name, int leben, int schaden) {
        super(name, leben, schaden);
    }

    @Override
    public String getArt() {
        return "Orc";
    }
}
