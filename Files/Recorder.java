package Files;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Recorder {

    public static void Recorder(String filename, String result) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(result);
            System.out.println("Бій успішно записано у файл: " + filename);
        } catch (IOException e) {
            System.out.println("Не вдалося записати бій до файлу: " + filename);
        }
    }
}