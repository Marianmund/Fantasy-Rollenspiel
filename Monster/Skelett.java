package Monster;

public class Skelett extends Monster {
    public Skelett(String name, int leben) {
        super(name, leben, 12);
    }

    public Skelett(String name, int leben, int schaden) {
        super(name, leben, schaden);
    }

    @Override
    public String getArt() {
        return "Skelett";
    }
}
