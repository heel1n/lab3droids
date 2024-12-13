package Battles;

import Droids.Droid;

import java.util.List;

public class TeamBattle {
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    static final String YELLOW = "\u001B[33m";
    static final String BLUE = "\u001B[34m";
    static final String PURPLE = "\u001B[35m";

    public static String teamFight(List<Droid> team1, List<Droid> team2) {
        System.out.println(BLUE + "\nКомандний бій починається!" + RESET);

        StringBuilder results = new StringBuilder();
        Droid team1Winner = null;
        Droid team2Winner = null;

        // Перший бій між першим дроїдом команди 1 і першим дроїдом команди 2
        String result1 = Battle.oneOnOneFight(team1.get(0), team2.get(0));
        results.append(result1);

        if (team1.get(0).isAlive()) {
            team1Winner = team1.get(0);
        } else {
            team2Winner = team2.get(0);
        }

        // Другий бій між другим дроїдом команди 1 і другим дроїдом команди 2
        String result2 = Battle.oneOnOneFight(team1.get(1), team2.get(1));
        results.append(result2);

        if (team1.get(1).isAlive()) {
            team1Winner = team1Winner != null ? team1Winner : team1.get(1);
        } else {
            team2Winner = team2Winner != null ? team2Winner : team2.get(1);
        }

        // Перевірка, чи залишилися дроїди в обох командах
        if (team1Winner != null && team2Winner != null) {
            results.append(PURPLE + "\n\nОбидві команди мають переможців! Починається третій бій!" + RESET);

            String finalResult = Battle.oneOnOneFight(team1Winner, team2Winner);
            results.append(finalResult);
        } else if (team1Winner != null) {
            results.append(GREEN + "\n\nКоманда 1 перемогла!" + RESET);
        } else {
            results.append(RED + "\n\nКоманда 2 перемогла!" + RESET);
        }

        return results.toString();
    }
}
