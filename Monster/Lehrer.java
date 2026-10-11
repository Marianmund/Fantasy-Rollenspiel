package Monster;

public class Lehrer extends Monster {
    private static final String[] MÖGLICHE_NAMEN = {
        "Lilian Antwerpen", "Thomas Cleef", "Thomas Müller", 
        "Lena Hans", "Stephen Rosing", "Lisa Brauweiler", 
        "Ileana Frings", "Eva Beckers", "Gregory Kugelmaier"
    };

    public static String[] getMöglicheNamen() {
        return MÖGLICHE_NAMEN.clone();
    }


    public Lehrer(String name, int leben) {
        super(name, leben, 20);
    }

    public Lehrer(String name, int leben, int schaden) {
        super(name, leben - 8, schaden - 3);
    }

    @Override
    public String getArt() {
        return "Lehrer";
    }
}

