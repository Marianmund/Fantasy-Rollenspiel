
import Helden.Waffen.Held;
import Kampf.HeldenUndMonsterService;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;



public class Main {
    public static Scanner input = new Scanner(System.in);

    public static boolean gameIsActive;

    public static void main(String[] args) {
        // Spiel starten mit "Loading Screen" (falls man das so nennen kann...)
        startScreen();

        do {
            
            Spiel();

            gameIsActive = erneutSpielen();

        } while (gameIsActive == true);

        input.close();
    }

    public static void startScreen() {
        System.out.println("\n\nWillkommen zum Fantasy-Rollenspiel!\n\n");
        Sleep(1);
        System.out.println("In diesem Spiel kannst du einen Helden auswählen und gegen Monster kämpfen!");
        Sleep(1);
        System.out.println("Drücke die Eingabetaste, um fortzufahren...");
        input.nextLine(); // Wait for user to press Enter
        System.out.println("Viel Spaß beim Spielen!\n\n");
        Sleep(1);
        System.out.println("\n\n\n");
        Sleep(1);
    }


    // gesamtes Spiel findet hier statt
    public static void Spiel(){
        // Heldenauswahl
        var service = new HeldenUndMonsterService();

        Held Held = service.selectHeld();

        Sleep(1);

        System.out.println("Gewaehlter Held: " + Held.getName());
    }


    // Möchte Spieler erneut spielen? (y/n) - returns true or false
    public static boolean erneutSpielen() {
    while (true) {
        System.out.print("\nMöchtest du erneut spielen? (y/n): ");

        String answer = input.nextLine().trim().toLowerCase();

        switch (answer) {
            case "y" -> {
                Sleep(1);
                System.out.println("\n\n\n\n");
                Sleep(1);
                System.out.println("Neues Spiel wird gestartet...\n\n");
                Sleep(3);
                return true;
            }
            case "n" -> {
                Sleep(1);
                System.out.println("\n\n\n\n");
                Sleep(1);
                System.out.println("Vielen Dank fürs Spielen!\n\n");
                Sleep(1);
                System.out.println("Das Spiel wird beendet...\n\n");
                Sleep(1);
                System.out.println("Auf Wiedersehen!\n\n");
                Sleep(1);
                System.exit(0);
                return false;
            }
            default -> System.out.println(
                "Ungültige Eingabe. Bitte gib 'y' oder 'n' ein.\n"
            );
        }
    }
}




    // Sleeps the program for a specified number of seconds
    public static void Sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}