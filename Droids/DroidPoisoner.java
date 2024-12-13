package Droids;

import Droids.Droid;

public class DroidPoisoner extends Droid {
    private int poisonDamage;

    public DroidPoisoner(String name, int health, int damage, int poisonDamage) {
        super(name, health, damage);
        this.poisonDamage = poisonDamage;
    }

    public void attack(Droid enemy){
        System.out.println(this.name + " атакує " + enemy.name + " і завдає " + this.damage + " шкоди.");
        System.out.println("\tТакож завдає " + poisonDamage + " шкоди від отрути.");
        enemy.takeDamage(this.damage + this.poisonDamage);
    }

    @Override
    public String toString() {
        return super.toString() + ", Шкода від отрути: " + poisonDamage;
    }
}
