package Monster;

public class Schueler extends Monster {
    private static final String[] MÖGLICHE_NAMEN = {
        "Lasse Hartmann", "Till Bastian", "Marian Mund", 
        "Katharina Schmidt", "Fynn Kontenak", "Ghina Awad",
        "Ben Schütze", "Fabrolant Dahlmanns",
        "Leonie Hildermann", "Jadon Mania", "Ahmed Cubukcu",
        "Felix Weiße", "Margarita Bürgel", "Annanis Bangaboom",
        "Jan Hansen", "Yulie Swidzinski"
    };

    public static String[] getMöglicheNamen() {
        return MÖGLICHE_NAMEN.clone();
    }

    public Schueler(String name, int leben) {
        super(name, leben, 8);
    }

    public Schueler(String name, int leben, int schaden) {
        super(name, leben + 40, schaden - 2);
    }

    @Override
    public String getArt() {
        return "Schüler";
    }
}

