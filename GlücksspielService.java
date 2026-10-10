import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class GlücksspielService {
    int geldEin = 0;
    int Siege = 0;

    public GlücksspielService() {
        this.geldEin = printGlücksspielInfo();
    }

    public GlücksspielService(int geldEin){
        this.geldEin = geldEin;
    }

    public int getGeldEin(){
        return geldEin;
    }

    public int calculateGeldAus(int Siege){
        return (geldEin * 2 * Siege);
    }

    public int  printGlücksspielInfo(){
        Scanner input = new Scanner(System.in);
        int in = 0;

        System.out.println("####################\n");
        Sleep(1);
        System.out.println("Hinweise zum verantwortungsvollen Umgang mit Spielangeboten:");
        System.out.println("Wer merkt, dass ein Spiel plötzlich mehr nach Abenteuer klingt als nach Spaß, sollte kurz innehalten und realisieren: Das Leben ist kein Casino mit Bonuslevel.");
        System.out.println("Hilfe und Beratung: https://www.bundeszentrale-rueckfallvorsorge.de/");
        System.out.println("Wenn das Spiel plötzlich mehr Interesse am Geld als am Abenteuer zeigt, ist das ein klares Zeichen: Pause machen und Hilfe holen.\n");
        Sleep(1);
        System.out.println("Zahle Geld ein und gewinne für jeden Sieg doppelt!");
        Sleep(1);
        System.out.println("Wenn du jedoch verlierst ist es aus mit dem Geld! \n");
        Sleep(1);


        while (in <= 0) {
            System.out.print("\r\033[KWie viel möchtest du einzahlen? ");
            System.out.flush();
            try {
                in = Integer.parseInt(input.nextLine().trim());
                if (in <= 0) {
                    System.out.print("Der Betrag muss größer als 0 sein!");
                    Sleep(1);
                }
            } catch (NumberFormatException e) {
                System.out.print("Eingabe muss eine ganze Zahl sein!");
                Sleep(1);
            }
        }
        System.out.println("\n####################\n\n\n");

        return in;
    }
    

    /*
* add. Methods
*/

    // Pause für eine bestimmte Anzahl von Sekunden
    public static void Sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
