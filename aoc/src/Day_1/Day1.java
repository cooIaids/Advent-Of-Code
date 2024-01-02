package Day_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day1 {

    private final ArrayList<String> lines = new ArrayList<>();


    public void readInputFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("input_1.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] divided = line.split("\n");
                Collections.addAll(lines, divided);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Finds the first digit and the last digit in a line, combines them and then sums them up.
     * @return sum of the combined digits
     */


    public int partOne() {
        int sumPartOne = 0;
        for (String word : lines) {
            Pattern patternFirst = Pattern.compile("\\d");
            Matcher matcherFirst = patternFirst.matcher(word);
            matcherFirst.find();
            Pattern patternLast = Pattern.compile("(\\d)(?!.*\\d)");
            Matcher matcherLast = patternLast.matcher(word);
            matcherLast.find();
            String firstOccurrence = matcherFirst.group();
            String lastOccurrence = matcherLast.group();
            String firstAndLast = firstOccurrence + "" + lastOccurrence;
            int numberPartOne = Integer.parseInt(firstAndLast);
            sumPartOne += numberPartOne;
        }
        return sumPartOne;

    }
    /**
     * Replaces the digits spelled out with letters with numerical digits,
     * finds the first digit and the last digit in a line,
     * combines them and then sums them up.
     * @return sum of the combined digits
     */

    public int partTwo(){
        int sumPartTwo = 0;
        for (String word : lines) {
            String replacedWord = word.replace("one", "one1one").
                    replace("two", "two2two").
                    replace("three", "three3three").
                    replace("four", "four4four").
                    replace("five", "five5five").
                    replace("six", "six6six").
                    replace("seven", "seven7seven").
                    replace("eight", "eight8eight").
                    replace("nine", "nine9nine");
            Pattern patternFirst = Pattern.compile("\\d");
            Matcher matcherFirst = patternFirst.matcher(replacedWord);
            matcherFirst.find();
            Pattern patternLast = Pattern.compile("(\\d)(?!.*\\d)");
            Matcher matcherLast = patternLast.matcher(replacedWord);
            matcherLast.find();
            String firstOccurrence = matcherFirst.group();
            String lastOccurrence = matcherLast.group();
            String firstAndLast = firstOccurrence + "" + lastOccurrence;
            int numberPartTwo = Integer.parseInt(firstAndLast);
            sumPartTwo += numberPartTwo;
        }
        return sumPartTwo;
    }
}
