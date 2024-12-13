package Droids;

import Droids.Droid;

public class DroidBerserk extends Droid {
    private int damageAmplify;
    private boolean Info = false;
    private int Amplify;

    public DroidBerserk(String name, int health, int damage, int damageAmplify) {
        super(name, health, damage);
        this.damageAmplify = damageAmplify;
    }

    public void attack(Droid enemy){

        if (getHealth() > 0 && getHealth() <= 30) {
            Amplify = damageAmplify;
            if (!Info) {
                System.out.println("\t" + this.name + " лютує, кількість його шкоди зросла у " + this.damageAmplify + " рази!");
                Info = true;
            }
        } else {
            Amplify = 1;
        }


        System.out.println(this.name + " атакує " + enemy.name + " і завдає " + this.damage + " шкоди.");
        enemy.takeDamage(this.damage * Amplify);
    }

    @Override
    public String toString() {
        return super.toString() + ", Збільшення шкоди у: " + damageAmplify + " рази";
    }
}
