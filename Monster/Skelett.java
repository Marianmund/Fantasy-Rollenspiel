package Monster;

public class Skelett extends Monster {
    private static final String[] MÖGLICHE_NAMEN = {
        "Knochenkrieger", "Rippenriese", "Mordknochen", "Friedhofsfehde",
        "Knochentanz", "Schattenbein", "Gräbergroll", "Eisenskelett",
        "Totenwächter", "Magergrim", "Dornknochen", "Knochenwolf",
        "Leichenwandler", "Rauchenknochen", "Kalte Rippe", "Schnappknochen",
        "Todesrippe", "Knochenlord", "Mumienklinge", "Nachtgrab"
    };

    public static String[] getMöglicheNamen() {
        return MÖGLICHE_NAMEN.clone();
    }

    public Skelett(String name, int leben) {
        super(name, leben, 12);
    }

    public Skelett(String name, int leben, int schaden) {
        super(name, leben - 40, schaden + 6);
    }

    @Override
    public String getArt() {
        return "Skelett";
    }
}
