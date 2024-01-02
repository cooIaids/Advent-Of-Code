package Day_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day2 {

    private final ArrayList<String> lines2 = new ArrayList<>();


    public void readInputFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("Day_2/input_2.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] divided = line.split("\n");
                Collections.addAll(lines2, divided);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    /**
     * Calculates the sum of the game IDs that have the correct amount cubes.
     * @return sum of the game IDs
     */
    public int partOne() {
        int correctAmountOfBlueCubes = 0;
        int correctAmountOfRedCubes = 0;
        int correctAmountOfGreenCubes = 0;
        int correctAmountOfAllCubes = 0;
        int sumOfID = 0;
        for (String s : lines2) {
            Pattern patternBlueCubes = Pattern.compile("([0-9]+\\s(blue))+");
            Matcher matcherBlueCubes = patternBlueCubes.matcher(s);
            Pattern patternRedCubes = Pattern.compile("([0-9]+\\s(red))+");
            Matcher matcherRedCubes = patternRedCubes.matcher(s);
            Pattern patternGreenCubes = Pattern.compile("([0-9]+\\s(green))+");
            Matcher matcherGreenCubes = patternGreenCubes.matcher(s);
            ArrayList<String> listOfBlueCubes = new ArrayList<>();
            ArrayList<String> listOfRedCubes = new ArrayList<>();
            ArrayList<String> listOfGreenCubes = new ArrayList<>();
            while (matcherBlueCubes.find()) {
                listOfBlueCubes.add(matcherBlueCubes.group());
            }
            while (matcherRedCubes.find()) {
                listOfRedCubes.add(matcherRedCubes.group());
            }
            while (matcherGreenCubes.find()) {
                listOfGreenCubes.add(matcherGreenCubes.group());
            }

            for (int j = 0; j < listOfBlueCubes.size(); j++) {
                if (listOfBlueCubes.get(j).matches("([1-9]|1[0-4])\\s(blue)")) {
                    correctAmountOfBlueCubes++;
                }
                if (correctAmountOfBlueCubes == listOfBlueCubes.size()) {
                    correctAmountOfAllCubes++;
                }

            }
            for (int k = 0; k < listOfRedCubes.size(); k++) {
                if (listOfRedCubes.get(k).matches("([1-9]|1[0-2])\\s(red)")) {
                    correctAmountOfRedCubes++;

                }
                if (correctAmountOfRedCubes == listOfRedCubes.size()) {
                    correctAmountOfAllCubes++;
                }

            }
            for (int m = 0; m < listOfGreenCubes.size(); m++) {
                if (listOfGreenCubes.get(m).matches("([1-9]|1[0-3])\\s(green)")) {
                    correctAmountOfGreenCubes++;
                }
                if (correctAmountOfGreenCubes == listOfGreenCubes.size()) {
                    correctAmountOfAllCubes++;
                }

            }

            if (correctAmountOfAllCubes == 3) {
                Pattern patternGameID = Pattern.compile("(Game\\s[0-9]+)");
                Matcher matcherGameID = patternGameID.matcher(s);
                matcherGameID.find();
                String gameID = matcherGameID.group();
                Pattern patternGameIDNumber = Pattern.compile("([0-9]+)");
                Matcher matcherGameIDNumber = patternGameIDNumber.matcher(gameID);
                matcherGameIDNumber.find();
                String gameIDNumber = matcherGameIDNumber.group();
                int ID = Integer.parseInt(gameIDNumber);
                sumOfID += ID;

            }


        }

        return sumOfID;
    }

    /**
     * Calculates the sum of the power of the sets of cubes with the fewest number of cubes possible.
     * @return sum of the power
     */

    public int partTwo() {
        int maxBlue = Integer.MIN_VALUE;
        int maxRed = Integer.MIN_VALUE;
        int maxGreen = Integer.MIN_VALUE;
        int powerOfMax;
        int sumOfPowers = 0;
        for (String s : lines2) {
            Pattern patternBlueCubes = Pattern.compile("([0-9]+\\s(blue))+");
            Matcher matcherBlueCubes = patternBlueCubes.matcher(s);
            Pattern patternRedCubes = Pattern.compile("([0-9]+\\s(red))+");
            Matcher matcherRedCubes = patternRedCubes.matcher(s);
            Pattern patternGreenCubes = Pattern.compile("([0-9]+\\s(green))+");
            Matcher matcherGreenCubes = patternGreenCubes.matcher(s);
            ArrayList<String> listOfBlueCubes = new ArrayList<>();
            ArrayList<String> listOfRedCubes = new ArrayList<>();
            ArrayList<String> listOfGreenCubes = new ArrayList<>();
            while (matcherBlueCubes.find()) {
                listOfBlueCubes.add(matcherBlueCubes.group());
            }
            while (matcherRedCubes.find()) {
                listOfRedCubes.add(matcherRedCubes.group());
            }
            while (matcherGreenCubes.find()) {
                listOfGreenCubes.add(matcherGreenCubes.group());
            }

            for (String listOfBlueCube : listOfBlueCubes) {
                Pattern patternBlueCubesNumber = Pattern.compile("[0-9]+");
                Matcher matcherBlueCubesNumber = patternBlueCubesNumber.matcher(listOfBlueCube);
                matcherBlueCubesNumber.find();
                String numberOfBlueCubes = matcherBlueCubesNumber.group();
                int parsedNumberOfBlueCubes = Integer.parseInt(numberOfBlueCubes);
                if (maxBlue < parsedNumberOfBlueCubes) {
                    maxBlue = parsedNumberOfBlueCubes;
                }
            }
            for (String listOfRedCube : listOfRedCubes) {
                Pattern patternRedCubesNumber = Pattern.compile("[0-9]+");
                Matcher matcherRedCubesNumber = patternRedCubesNumber.matcher(listOfRedCube);
                matcherRedCubesNumber.find();
                String numberOfRedCubes = matcherRedCubesNumber.group();
                int parsedNumberOfRedCubes = Integer.parseInt(numberOfRedCubes);
                if (maxRed < parsedNumberOfRedCubes) {
                    maxRed = parsedNumberOfRedCubes;
                }
            }
            for (String listOfGreenCube : listOfGreenCubes) {
                Pattern patternGreenCubesNumber = Pattern.compile("[0-9]+");
                Matcher matcherGreenCubesNumber = patternGreenCubesNumber.matcher(listOfGreenCube);
                matcherGreenCubesNumber.find();
                String numberOfGreenCubes = matcherGreenCubesNumber.group();
                int parsedNumberOfGreenCubes = Integer.parseInt(numberOfGreenCubes);
                if (maxGreen < parsedNumberOfGreenCubes) {
                    maxGreen = parsedNumberOfGreenCubes;
                }
            }
            powerOfMax = maxBlue * maxRed * maxGreen;
            sumOfPowers += powerOfMax;
        }
        return sumOfPowers;
    }

}
