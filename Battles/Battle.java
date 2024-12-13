package Battles;

import Droids.Droid;

public class Battle {
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    static final String YELLOW = "\u001B[33m";
    static final String BLUE = "\u001B[34m";
    static final String PURPLE = "\u001B[35m";
    static final String CYAN = "\u001B[36m";
    static final String BOLD = "\u001B[1m";

    public static String oneOnOneFight(Droid droid1, Droid droid2) {
        System.out.println(CYAN + "\nБій між " + BOLD + droid1.getName() + RESET + CYAN + " та " + BOLD + droid2.getName() + RESET + CYAN + " починається!" + RESET);

        int Round = 1;
        String result;
        while (droid1.isAlive() && droid2.isAlive()) {
            System.out.println(YELLOW + "\n___(" + droid1.getName() + ")___(" + droid1.getHealth() + " здоров'я)___Раунд №" + Round
                    + "___(" + droid2.getName() + ")___(" + droid2.getHealth() + " здоров'я)___\n" + RESET);

            // Атака першого дроїда
            System.out.println(BLUE + droid1.getName() + " атакує " + droid2.getName() + "!" + RESET);
            droid1.attack(droid2);
            if (!droid2.isAlive()) {
                System.out.println(RED + "\n\t" + droid2.getName() + " загинув." + RESET);
                break;
            }

            System.out.println();
            // Атака другого дроїда
            System.out.println(BLUE + droid2.getName() + " атакує " + droid1.getName() + "!" + RESET);
            droid2.attack(droid1);
            if (!droid1.isAlive()) {
                System.out.println(RED + "\n\t" + droid1.getName() + " загинув." + RESET);
                break;
            }
            Round++;
        }
        return formatResult(droid1, droid2, Round);
    }

    private static String formatResult(Droid droid1, Droid droid2, int Round) {
        Droid winner = droid1.isAlive() ? droid1 : droid2;
        Droid loser = droid1.isAlive() ? droid2 : droid1;

        // Результат бою
        return GREEN + "\nГра між " + droid1.getName() + " і " +
                droid2.getName() + " закінчилася на " + Round + " раунді!\nПереміг - " +
                winner.getName() + " (" + winner.getHealth() + " здоров'я залишилось!" + RESET;
    }
}
