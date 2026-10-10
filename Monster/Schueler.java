package Monster;

public class Schueler extends Monster {
    public Schueler(String name, int leben) {
        super(name, leben, 8);
    }

    public Schueler(String name, int leben, int schaden) {
        super(name, leben, schaden);
    }

    @Override
    public String getArt() {
        return "Schüler";
    }
}

