package Kampf;

import Helden.Waffen.Held;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

// verschiedene Würfel für versch. Kampfmechaniken


public class KampfService {
    private final Scanner input;

    public KampfService(Scanner input) {
        this.input = input;
    }

    public int  SchadenMachen(Held held) throws InterruptedException {
        Wuerfel d20 = new Wuerfel(20, input);

        System.out.printf("%s greift an!%n", held.getName());

        Sleep(1);

        int weaponBonus = 0;
        for (var weapon : held.getInventar()) {
            if (weapon != null) {
                weaponBonus += weapon.getSchaden();
            }
        }

        int damage = (int) Math.ceil((d20.wuerfeln() * held.getSchaden()) / 5.0 + weaponBonus);
        
        Sleep(1);

        return damage;
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