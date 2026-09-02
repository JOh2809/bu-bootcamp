import java.io.*;
import java.util.ArrayList;

public class GradeAnalyzer {

    // Keeps track of invalid non-number lines
    public static int invalidLinesSkipped = 0;

    public static void main(String[] args) {

        // Step 1: Read scores from file
        ArrayList<Integer> scores = readScores("scores.txt");

        // Handle empty file or file containing no valid scores
        if (scores.isEmpty()) {
            System.out.println("No valid scores were found.");
            return;
        }

        // Step 2: Calculate average
        double average = calculateAverage(scores);

        // Step 3: Find highest and lowest scores
        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;

        for (int score : scores) {
            if (score > highest) {
                highest = score;
            }

            if (score < lowest) {
                lowest = score;
            }
        }

        // Step 4: Write and print report
        writeReport(scores, average, highest, lowest, "report.txt");
    }


    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {

        ArrayList<Integer> scores = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new FileReader(filename))) {

            String line;

            while ((line = reader.readLine()) != null) {

                // Remove extra whitespace
                line = line.trim();

                // Skip blank lines
                if (line.isEmpty()) {
                    continue;
                }

                try {
                    int score = Integer.parseInt(line);
                    scores.add(score);

                } catch (NumberFormatException e) {
                    System.out.println(
                            "Warning: Invalid score skipped: " + line
                    );

                    invalidLinesSkipped++;
                }
            }

        } catch (IOException e) {
            System.out.println(
                    "Error reading file: " + e.getMessage()
            );
        }

        return scores;
    }


    // Returns the average of a list of scores,
    // or 0.0 if the list is empty
    public static double calculateAverage(
            ArrayList<Integer> scores) {

        if (scores.isEmpty()) {
            return 0.0;
        }

        double total = 0.0;

        for (int score : scores) {
            total += score;
        }

        return total / scores.size();
    }


    // Writes and prints the report
    public static void writeReport(
            ArrayList<Integer> scores,
            double avg,
            int high,
            int low,
            String outputFile) {

        // Grade band counters
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        int countF = 0;

        // Count grade bands
        for (int score : scores) {

            if (score >= 90) {
                countA++;
            } else if (score >= 80) {
                countB++;
            } else if (score >= 70) {
                countC++;
            } else if (score >= 60) {
                countD++;
            } else {
                countF++;
            }
        }

        // Create formatted report
        String report = String.format(
                "=== Grade Analysis Report ===%n" +
                "Total scores processed: %d%n" +
                "Invalid lines skipped:  %d%n" +
                "%n" +
                "Average score:   %.2f%n" +
                "Highest score:   %d%n" +
                "Lowest score:    %d%n" +
                "%n" +
                "Grade distribution:%n" +
                "  A (90-100):    %d%n" +
                "  B (80-89):     %d%n" +
                "  C (70-79):     %d%n" +
                "  D (60-69):     %d%n" +
                "  F (below 60):  %d%n",
                scores.size(),
                invalidLinesSkipped,
                avg,
                high,
                low,
                countA,
                countB,
                countC,
                countD,
                countF
        );

        // Print report to terminal
         System.out.println(report);

        // Write report to file
        try (BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter(outputFile))) {

            writer.write(report);

        } catch (IOException e) {
            System.out.println(
                    "Error writing report: " + e.getMessage()
            );
        }
    }
}