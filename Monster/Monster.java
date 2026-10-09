src package Monster

public class Monster {
    private String name;
    private int leben;
    private int schaden;

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

    public int getSchaden() {
        return schaden;
    }

    public void keineLeben() {
        if (leben <= 0) {
            System.out.println(name + " ist tot!");
        }
    }
