
import Helden.Waffen.Held;
import Kampf.HeldenUndMonsterService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        var service = new HeldenUndMonsterService();

        Held Held = service.selectHeld();

        Sleep(1);

        System.out.println("Gewählter Held: " + Held.getName());
    }


    public static void Sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}