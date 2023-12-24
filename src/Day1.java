import java.io.*;

public class Day1 {

    public static void main(String[] args) throws IOException {
        File file = new File("day1.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String currentLine;
        int sum = 0;
        while ((currentLine = br.readLine()) != null) {
            int firstInt = -1;
            int lastInt = 0;
            int lowestIndex = -1;
            int higestIndex = -1;
            for (int i = 0; i < currentLine.length(); i++) {
                if (Character.isDigit(currentLine.charAt(i))) {
                    int parseInt = Integer.parseInt(String.valueOf(currentLine.charAt(i)));
                    if (firstInt == -1) {
                        firstInt = parseInt;
                        lowestIndex = i;
                    }
                    lastInt = parseInt;
                    higestIndex = i;
                }
            }
            String[] wordNumbers = new String[]{"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
            for (int i = 0; i < wordNumbers.length; i++) {
                if ((currentLine.indexOf(wordNumbers[i]) < lowestIndex || lowestIndex == -1) && currentLine.contains(wordNumbers[i])) {
                    lowestIndex = currentLine.indexOf(wordNumbers[i]);
                    firstInt = i + 1;
                }
                if (currentLine.lastIndexOf(wordNumbers[i]) > higestIndex && currentLine.contains(wordNumbers[i])) {
                    higestIndex = currentLine.lastIndexOf(wordNumbers[i]);
                    lastInt = i + 1;
                }
            }
            System.out.println(firstInt + " " + lastInt);
            System.out.println(currentLine);
            int total = firstInt * 10 + lastInt;
            sum += total;
        }
        System.out.println(sum);
    }


}
