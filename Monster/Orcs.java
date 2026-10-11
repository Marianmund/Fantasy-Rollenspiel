package Monster;

public class Orcs extends Monster {
    private static final String[] MÖGLICHE_NAMEN = {
        "Gorruk", "Morgul", "Brakk", "Zughar", "Darg", "Kharok", "Vrak", "Rugnar",
        "Snagor", "Torgath", "Gromm", "Nark", "Hruk", "Drazh", "Rukta", "Borgul",
        "Tharok", "Krag", "Murk", "Gralsh"
    };

    public static String[] getMöglicheNamen() {
        return MÖGLICHE_NAMEN.clone();
    }

    public Orcs(String name, int leben) {
        super(name, leben, 18);
    }

    public Orcs(String name, int leben, int schaden) {
        super(name, leben - 20, schaden - 1);
    }



    @Override
    public String getArt() {
        return "Orc";
    }
}
