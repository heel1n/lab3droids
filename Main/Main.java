package Main;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import Battles.Battle;
import Battles.TeamBattle;
import Droids.Droid;
import Droids.DroidBerserk;
import Droids.DroidHealer;
import Droids.DroidPoisoner;
import Droids.DroidBomber;
import Files.Recorder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    static final String YELLOW = "\u001B[33m";
    static final String BLUE = "\u001B[34m";
    static final String PURPLE = "\u001B[35m";
    static final String CYAN = "\u001B[36m";
    static final String BOLD = "\u001B[1m";
    static final String UNDERLINE = "\u001B[4m";

    static List<Droid> droidList = new ArrayList<>();
    static String resultBattle = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(CYAN + "\nМеню:" + RESET);
            System.out.println("1. " + BOLD + "Створити дроїда" + RESET);
            System.out.println("2. Показати список дроїдів");
            System.out.println("3. Бій 1 на 1");
            System.out.println("4. Командний бій");
            System.out.println("5. Зберегти результати битви у файл");
            System.out.println("6. Зчитати бій з файлу у консоль");
            System.out.println("7. Вийти");
            System.out.print(YELLOW + "Ваш вибір: " + RESET);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createDroid(scanner);
                    break;
                case 2:
                    showDroidList();
                    break;
                case 3:
                    resultBattle = oneOnOneBattle(scanner);
                    break;
                case 4:
                    resultBattle = teamBattle(scanner);
                    break;
                case 5:
                    saveBattleResults(scanner);
                    break;
                case 6:
                    replayBattleFromFile(scanner);
                    break;
                case 7:
                    System.out.println(GREEN + "Вихід..." + RESET);
                    System.exit(0);
                default:
                    System.out.println(RED + "Невірний вибір." + RESET);
            }
        }
    }

    private static void createDroid(Scanner scanner) {
        System.out.println(PURPLE + "\nВиберіть дроїда з наступних варіантів:" + RESET);
        System.out.println("1. Poisoner");
        System.out.println("2. Healer");
        System.out.println("3. Berserk");
        System.out.println("4. Bomber");

        System.out.print(YELLOW + "Ваш вибір: " + RESET);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                droidList.add(new DroidPoisoner("Poisoner", 80, 4, 8));
                break;
            case 2:
                droidList.add(new DroidHealer("Healer", 100, 6, 4));
                break;
            case 3:
                droidList.add(new DroidBerserk("Berserk", 60, 12, 2));
                break;
            case 4:
                droidList.add(new DroidBomber("Bomber", 90, 6, 20));
                break;
            default:
                System.out.println(RED + "Невірний вибір типу." + RESET);
        }
    }

    private static void showDroidList() {
        if (droidList.isEmpty()) {
            System.out.println(RED + "Немає створених дроїдів." + RESET);
        } else {
            System.out.println();
            for (int i = 0; i < droidList.size(); i++) {
                System.out.println(GREEN + (i + 1) + ". " + droidList.get(i) + RESET);
            }
        }
    }

    private static String oneOnOneBattle(Scanner scanner) {
        showDroidList();
        if (droidList.size() < 2) {
            System.out.println(RED + "Недостатньо дроїдів для бою." + RESET);
            return "";
        }

        System.out.print(BLUE + "Виберіть дроїда 1: " + RESET);
        int droid1Index = scanner.nextInt() - 1;
        System.out.print(BLUE + "Виберіть дроїда 2: " + RESET);
        int droid2Index = scanner.nextInt() - 1;

        String result = Battle.oneOnOneFight(droidList.get(droid1Index), droidList.get(droid2Index));
        System.out.println(YELLOW + result + RESET);
        return result;
    }

    private static String teamBattle(Scanner scanner) {
        showDroidList();
        if (droidList.size() < 4) {
            System.out.println(RED + "Недостатньо дроїдів для командного бою." + RESET);
            return "";
        }

        List<Droid> team1 = new ArrayList<>();
        List<Droid> team2 = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            System.out.print(BLUE + "Виберіть дроїда для команди 1: " + RESET);
            team1.add(droidList.get(scanner.nextInt() - 1));
        }

        for (int i = 0; i < 2; i++) {
            System.out.print(BLUE + "Виберіть дроїда для команди 2: " + RESET);
            team2.add(droidList.get(scanner.nextInt() - 1));
        }

        String result = TeamBattle.teamFight(team1, team2);
        System.out.println(YELLOW + result + RESET);
        return result;
    }

    private static void saveBattleResults(Scanner scanner) {
        System.out.print(PURPLE + "\nВведіть ім'я файлу для збереження результатів бою: " + RESET);
        scanner.nextLine();
        String filename = scanner.nextLine();

        if (!resultBattle.isEmpty()) {
            Recorder.Recorder(filename, resultBattle);
        } else {
            System.out.println(RED + "Немає результатів для збереження." + RESET);
        }
    }

    private static void replayBattleFromFile(Scanner scanner) {
        System.out.print(PURPLE + "\nВведіть ім'я файлу для відтворення бою: " + RESET);
        scanner.nextLine();
        String filename = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("\n" + GREEN + "Результат бою з файлу:" + RESET);
            while ((line = reader.readLine()) != null) {
                System.out.println(YELLOW + line + RESET);
            }
        } catch (IOException e) {
            System.out.println(RED + "Не вдалося прочитати файл: " + filename + RESET);
        }
    }
}
