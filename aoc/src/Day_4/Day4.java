package Day_4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Day4 {

    private final ArrayList<String> linesCards = new ArrayList<>();


    public void readInputFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("input_4.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] divided = line.split("\n");
                Collections.addAll(linesCards, divided);

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Calculates the sum of the points that the cards are worth.
     * @return sum of the points
     */
    public int partOne(){
        int sumOfPoints = 0;
        for (String linesCard : linesCards) {
            String[] dividedCard = String.valueOf(linesCard).split(":|\\|");
            String replacedWinningNumbers = dividedCard[1].trim().replaceAll("\\s+", " ");
            ArrayList<Integer> winningNumbers = new ArrayList<>();
            String[] dividedWinningNumbers = replacedWinningNumbers.split("\\s");
            for (String dividedWinningNumber : dividedWinningNumbers) {
                winningNumbers.add(Integer.parseInt(dividedWinningNumber));
            }
            String replacedNumbers = dividedCard[2].trim().replaceAll("\\s+", " ");
            ArrayList<Integer> numbers = new ArrayList<>();
            String[] dividedNumbers = replacedNumbers.split("\\s");
            for (String dividedNumber : dividedNumbers) {
                numbers.add(Integer.parseInt(dividedNumber));
            }
            numbers.retainAll(winningNumbers);
            int points = (int) Math.pow(2, numbers.size() - 1);
            sumOfPoints += points;
        }
        return sumOfPoints;
    }

    /**
     * Calculates the sum of the cards.
     * @return sum of the cards
     */

    public int partTwo(){
        int sumOfCards = 0;
        int[] scores = new int[2000000];
        int[] copies = new int[2000000];
        int games = 0;
        for (String linesCard : linesCards) {
            String[] dividedCard = String.valueOf(linesCard).split(":|\\|");
            String replacedWinningNumbers = dividedCard[1].trim().replaceAll("\\s+", " ");
            ArrayList<Integer> winningNumbers = new ArrayList<>();
            String[] dividedWinningNumbers = replacedWinningNumbers.split("\\s");
            for (String dividedWinningNumber : dividedWinningNumbers) {
                winningNumbers.add(Integer.parseInt(dividedWinningNumber));
            }
            String replacedNumbers = dividedCard[2].trim().replaceAll("\\s+", " ");
            ArrayList<Integer> numbers = new ArrayList<>();
            String[] dividedNumbers = replacedNumbers.split("\\s");
            for (String dividedNumber : dividedNumbers) {
                numbers.add(Integer.parseInt(dividedNumber));
            }
            numbers.retainAll(winningNumbers);


            scores[games] = numbers.size();
            copies[games] = 1;
            games++;

        }


        for(int i = 0; i < games; i++){
            for(int j = i + 1; j <= i + scores[i]; j++){
                copies[j] += copies[i];
            }
            sumOfCards +=copies[i];
        }
        return sumOfCards;
    }



}
