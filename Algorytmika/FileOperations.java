import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class FileOperations {

    public static void writeRandomNumbersToFile(String fileName, int numbersCount, int bound) throws FileNotFoundException {
        System.out.println("Writing Random Numbers To File: " + fileName);

        PrintWriter writer = new PrintWriter(fileName);

        Random random = new Random();

        for (int i = 0; i < numbersCount; i++)
        {
            var randomNumber = random.nextInt(bound);
            writer.println(randomNumber);
        }

        writer.close();
    }

    public static void writeFileFromTerminal(String fileName) throws FileNotFoundException {
        System.out.println("Writing To File: " + fileName);
        System.out.println("Type in 'save' to Save");

        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(fileName);

        while (true)
        {
            if(scanner.hasNextInt()) {
                var value = scanner.nextInt();
                writer.println(value);
            }
            else
            {
                var value = scanner.next();
                if(value.equals("save"))
                {
                    writer.close();
                    return;
                }
            }
        }
    }

    public static void cleanFile(String fileName) throws FileNotFoundException {
        System.out.println("Cleaning File: " + fileName);
        try (PrintWriter writer = new PrintWriter(fileName)) {

            writer.write("");
        }
    }

    public static void writeFile(ArrayList<String> values, String fileName) throws FileNotFoundException {
        System.out.println("Writing To File: " + fileName);
        try (PrintWriter writer = new PrintWriter(fileName)) {

            for (var line : values)
            {
                System.out.println(line);
                writer.println(line);
            }
        }
    }

    public static ArrayList<Integer> readFileInt(String fileName) throws FileNotFoundException {
        System.out.println("Reading From File: " + fileName);

        File file = new File(fileName);
        ArrayList<Integer> valuesFromFile = new ArrayList<>();

        Scanner reader = new Scanner(file);

        while(reader.hasNextInt())
        {
            var value = reader.nextInt();
            valuesFromFile.add(value);
        }

        reader.close();

        return valuesFromFile;
    }

    public static ArrayList<String> readFileString(String fileName) throws FileNotFoundException {
        System.out.println("Reading From File: " + fileName);

        File file = new File(fileName);
        ArrayList<String> valuesFromFile = new ArrayList<>();

        Scanner reader = new Scanner(file);

        while(reader.hasNext())
        {
            var value = reader.next();
            valuesFromFile.add(value);
        }

        reader.close();

        return valuesFromFile;
    }
}
