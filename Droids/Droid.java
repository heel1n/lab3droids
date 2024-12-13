package Droids;

public abstract class Droid {
    protected String name;
    protected int health;
    protected int damage;

    public Droid(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public abstract void attack(Droid enemy);

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public int setHealth(int health) {
        return this.health = health;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
    }

    public int setDamage(int damage) {
        return this.damage = damage;
    }

    public int getDamage() {
        return this.damage;
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    @Override
    public String toString() {
        return "Дроїд: " + this.name + ", Здоров'я: " + this.health + ", Шкода: " + this.damage;
    }
}
