package Droids;

public class DroidBomber extends Droid {
    private int bombDamage;
    private int round;
    private int cooldown;

    public DroidBomber(String name, int health, int damage, int bombDamage) {
        super(name, health, damage);
        this.bombDamage = bombDamage;
        this.round = 0;
        this.cooldown = 3;
    }

    public void attack(Droid enemy){
        if (round == 0) {
            System.out.println("\tРакета наносить " + bombDamage + " шкоди!");
            enemy.takeDamage(this.bombDamage);
            round = cooldown;
        } else {
            round--;
            System.out.println("\tРакета перезаряджаєтья ще " + (round + 1) + " раундів!");
        }

        System.out.println(this.name + " атакує " + enemy.name + " і завдає " + this.damage + " шкоди.");

        enemy.takeDamage(this.damage);
    }

    @Override
    public String toString() {
        return super.toString() + ", Шкода від ракети: " + bombDamage;
    }
}
