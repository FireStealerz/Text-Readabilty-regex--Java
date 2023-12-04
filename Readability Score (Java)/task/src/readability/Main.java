package readability;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File(args[0]);
        FileProcessing fileProcessing = new FileProcessing();
        try (Scanner scanner = new Scanner(file)){
            String fileAsString = new String(Files.readAllBytes(Paths.get(args[0])));
            System.out.println("The text is: \n" + fileAsString + "\n");
            fileProcessing.fileProccessing(fileAsString);
        } catch (FileNotFoundException e) {
            System.out.println("File not Provided!");
        } catch (IOException e) {
            System.out.println("Runtime Exception!");
            throw new RuntimeException(e);
        }

        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        System.out.println(fileProcessing);
        System.out.printf("Automated Readability Index: %.02f (about %s-year-olds).\n", fileProcessing.getScore() ,
                fileProcessing.getAgeRange());
        System.out.printf("Flesch-Kincaid readabilty tests: %.02f (about %s-year-olds).\n",
                fileProcessing.getFKscore(), fileProcessing.getFKageRange());
        System.out.printf("Simple Measure of Gobbledygook: %.02f (about %s-year-olds).\n",
                fileProcessing.getSMOGscore(), fileProcessing.getSMOGageRange());
        System.out.printf("Coleman-Liau index: %.02f (about %s-year-olds).\n",
                fileProcessing.getCOLEscore(), fileProcessing.getCOLEageRange());
        double average = (Double.parseDouble(fileProcessing.getAgeRange()) +
                Double.parseDouble(fileProcessing.getFKageRange()) +
                Double.parseDouble(fileProcessing.getSMOGageRange()) +
                Double.parseDouble(fileProcessing.getCOLEageRange())) / 4;
        System.out.printf("This text should be understood in average by %.02f-year-olds.", average);
    }
}



