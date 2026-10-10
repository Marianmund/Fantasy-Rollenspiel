package Monster;

public class Lehrer extends Monster {
    public Lehrer(String name, int leben) {
        super(name, leben, 20);
    }

    public Lehrer(String name, int leben, int schaden) {
        super(name, leben, schaden);
    }

    @Override
    public String getArt() {
        return "Lehrer";
    }
}

