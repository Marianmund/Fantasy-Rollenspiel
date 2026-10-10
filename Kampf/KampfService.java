package Kampf;

import Helden.Waffen.Held;
import java.util.concurrent.TimeUnit;

// verschiedene Würfel für versch. Kampfmechaniken


public class KampfService {
    public static int  SchadenMachen(Held held) throws InterruptedException {
        Wuerfel d20 = new Wuerfel(20);
        
        System.out.printf("%d greift an!" + held.getName());

        Sleep(1);

        int damage = (int) Math.ceil((d20.wuerfeln() * held.getSchaden()) / 5.0 + held.getInventar()[1].getSchaden());
        
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