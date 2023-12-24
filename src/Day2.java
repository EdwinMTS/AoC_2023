import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.text.AbstractWriter;

public class Day2 {
    /*
    > 177
     */

    public static void main(String[] args) throws IOException {
        part2();
    }
    public static void part1() throws IOException {
        File file = new File("C:\\Users\\Edwin\\OneDrive\\Documenten\\AoC\\src\\day2.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String currentLine;
        int result = 0;
        while ((currentLine = br.readLine()) != null) {
            String[] game = currentLine.split(": ");
            String[] sets = game[1].split("; ");
            ArrayList<String> reveals = new ArrayList<>();
            for (String set : sets) {
                String[] grabs = set.split(", ");
                reveals.addAll(Arrays.asList(grabs));
            }
            int[] count = {0, 0, 0};
            boolean possible = true;
            for (String reveal : reveals) {
                String[] split = reveal.split(" ");
                switch (split[1]) {
                    case "red":
                        if (Integer.parseInt(split[0]) > 12) {
                            possible = false;
                        }
                        break;
                    case "blue":
                        if (Integer.parseInt(split[0]) > 14) {
                            possible = false;
                        }
                        break;
                    case "green":
                        if (Integer.parseInt(split[0]) > 13) {
                            possible = false;
                        }
                        break;
                }
            }
            if (possible) {
                result += Integer.parseInt(game[0].split(" ")[1]);
            }
        }
        System.out.println(result);
    }

    public static void part2() throws IOException {
        File file = new File("C:\\Users\\Edwin\\OneDrive\\Documenten\\AoC\\src\\day2.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String currentLine;
        int result = 0;
        while ((currentLine = br.readLine()) != null) {
            String[] game = currentLine.split(": ");

            String[] sets = game[1].split("; ");
            ArrayList<String> reveals = new ArrayList<>();
            for (String set : sets) {
                String[] grabs = set.split(", ");
                reveals.addAll(Arrays.asList(grabs));
            }

            int[] count = {0, 0, 0};
            for (String reveal : reveals) {
                String[] split = reveal.split(" ");
                switch (split[1]) {
                    case "red":
                        if (Integer.parseInt(split[0]) > count[0]) {
                            count[0] = Integer.parseInt(split[0]);
                        }
                        break;
                    case "blue":
                        if (Integer.parseInt(split[0]) > count[1]) {
                            count[1] = Integer.parseInt(split[0]);
                        }
                        break;
                    case "green":
                        if (Integer.parseInt(split[0]) > count[2]) {
                            count[2] = Integer.parseInt(split[0]);
                        }
                        break;
                }
            }
            result += count[0] * count[1] * count[2];
        }
        System.out.println(result);
    }
}

