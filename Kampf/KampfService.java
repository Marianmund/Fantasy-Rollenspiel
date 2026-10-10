package Held.Kampf;

import Helden.Waffen.Held;
import Monster.Monster;

// verschiedene Würfel für versch. Kampfmechaniken


public class KampfService {
    public static void startKampf(Held held, Monster monster) {
        System.out.println("Der Kampf beginnt zwischen " + held.getName() + " und " + monster.getName() + "!");
        // Hier können Sie die Kampfmechanik implementieren
    }
}