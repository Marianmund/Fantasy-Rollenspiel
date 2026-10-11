package Monster;

public class Monster {
    private final String name;
    private int leben;
    private final int schaden;

    public Monster(String name, int leben, int schaden) {
        this.name = name;
        this.leben = leben;
        this.schaden = schaden;
    }

    public String getName() {
        return name;
    }

    public int getLeben() {
        return leben;
    }

    public void setLeben(int leben){
        this.leben = leben;
    }

    public int getSchaden() {
        return schaden;
    }

    public String getArt() {
        return "Monster";
    }

    public void keineLeben() {
        if (leben <= 0) {
            System.out.println(name + " ist tot!");
        }
    }
}
