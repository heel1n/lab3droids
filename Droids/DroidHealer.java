package Droids;

import Droids.Droid;

public class DroidHealer extends Droid {
    private int healAmount;

    public DroidHealer(String name, int health, int damage, int healAmount) {
        super(name, health, damage);
        this.healAmount = healAmount;
    }

    public void attack(Droid enemy){
        if (getHealth() < 100 || getHealth() > 0){
            setHealth(getHealth() + this.healAmount);
            System.out.println("\t" + this.name + " виліковує себе на " + this.healAmount + " здоров'я.");
        }

        System.out.println(this.name + " атакує " + enemy.name + " і завдає " + this.damage + " шкоди.");
        enemy.takeDamage(this.damage);
    }

    @Override
    public String toString() {
        return super.toString() + ", Кількість зцілення: " + healAmount;
    }
}
