import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.io.FileWriter; // Import the FileWriter class
import java.io.IOException; // Import the IOException class to handle errors
import java.text.DecimalFormat; // Import the DecimalFormat class
import java.text.NumberFormat; // Import the NumberFormat class
import java.util.Scanner; // Import the Scanner class to read text files

/*
 * Food Analyzer:
 * This program is used to analyze food nutrition information.
 * It reads food data from a text file.
 * and show main nutrients quantity, total calories, total time takes to digest.
 * New food can be added to the text file.
 * 
 * Author: Fire Of Ender
 */

public class Analyzer {
    static String appVersion = "1.0.0";

    // Variables
    static Scanner sc = new Scanner(System.in); // Scanner for user input
    static File foodDataFile; // File object for food infomation
    static Scanner foodDataScanner; // Scanner for food information text file
    static String foodFileName = "foodData.txt"; // File name

    // Constants
    static final double PROT_KCAL = 5.65;
    static final double CARB_KCAL = 4.1;
    static final double FATS_KCAL = 9.45;
    static final double PROT_MIN_RATE = 0.1; // hour/gram
    static final double PROT_MAX_RATE = 0.3; // hour/gram
    static final double CARB_MIN_RATE = 0.05; // hour/gram
    static final double CARB_MAX_RATE = 0.1; // hour/gram
    static final double FATS_MIN_RATE = 0.01; // hour/gram
    static final double FATS_MAX_RATE = 0.07; // hour/gram

    // Get data from user for unknown food
    static double getData(String nutrient) {
                        while (true) {
                            System.out.print(nutrient + " (g): ");
                            try {
                                return Double.parseDouble(sc.nextLine());
                            } catch (NumberFormatException e) {
                                System.err.println("Error: Invalid input. Please enter a number.");
                            }
                        }
                    }

    public static void main(String[] args) {
        while (true) {
            try {
                foodDataFile = new File("FoodAnalyzer\\" + foodFileName); // Link file to object
                foodDataScanner = new Scanner(foodDataFile); // Link scanner to file

                // Get food input
                System.out.println("-----Food Analyzer V." + appVersion + "-----");
                System.out.print("Food to be analyzed: ");
                String foodName = sc.nextLine().trim(); // Get food name
                if (foodName.trim().equalsIgnoreCase("/exit") || foodName.trim().equalsIgnoreCase("/q")) {
                    System.out.println("Exiting...");
                    break;
                }

                // Initial food information
                double prot = 0;
                double carb = 0;
                double fats = 0;
                boolean found = false;

                while (foodDataScanner.hasNextLine()) {
                    String line = foodDataScanner.nextLine();
                    if (!line.startsWith("#") && !line.isBlank()) { // Ignore comments
                        String[] dataLine = line.split(":");
                        String dataName = dataLine[0].trim();
                        if (dataName.equalsIgnoreCase(foodName)) {
                            found = true; // Found food
                            String[] foodCalories = dataLine[1].trim().split(" ");
                            foodName = dataName;
                            prot = Double.parseDouble(foodCalories[0]); // Grams
                            carb = Double.parseDouble(foodCalories[1]); // Grams
                            fats = Double.parseDouble(foodCalories[2]); // Grams
                        }
                    }
                }

                if (!found) {

                    // Recieve food information if not found
                    System.err.println("System: Food not found.");
                    System.out.println("Please manually enter food information.");
                    foodName = foodName.substring(0, 1).toUpperCase() + foodName.substring(1);
                    prot = getData("Protein");
                    carb = getData("Carbohydrates");
                    fats = getData("Fats");

                    // Add food to foodData.txt
                    try (FileWriter foodFileWriter = new FileWriter("FoodAnalyzer\\" + foodFileName, true)) { // Use try with resources
                        foodFileWriter.write("\n" + foodName + " : " + prot + " " + carb + " " + fats);
                        foodFileWriter.close();
                        System.out.println("System: Added new food to data file.");
                    } catch (IOException e) {
                        System.err.println("Error: Unable to add new food data to file.");
                    }
                }

                // Display food information
                System.out.println("-----NUTRITIONAL INFORMATION------");
                System.out.println("Food: " + foodName);
                System.out.println("\tProtein: " + prot + " g");
                System.out.println("\tCarbohydrates: " + carb + " g");
                System.out.println("\tFats: " + fats + " g");

                // Display number in 2 decimal places
                NumberFormat numFormat = new DecimalFormat("#.##");

                System.out.println("Total Calories: " + numFormat.format(prot * PROT_KCAL + carb * CARB_KCAL + fats * FATS_KCAL) + " kcal");
                System.out.println("\tFrom protein: " + numFormat.format(prot * PROT_KCAL) + " kcal");
                System.out.println("\tFrom carbohydrates: " + numFormat.format(carb * CARB_KCAL) + " kcal");
                System.out.println("\tFrom fats: " + numFormat.format(fats * FATS_KCAL) + " kcal");

                System.out.println("Total time to digest: " + numFormat.format(prot * PROT_MIN_RATE + carb * CARB_MIN_RATE + fats * FATS_MIN_RATE) + " to " + numFormat.format(prot * PROT_MAX_RATE + carb * CARB_MAX_RATE + fats * FATS_MAX_RATE) + " hours");
                System.out.println("\tFrom protein: " + numFormat.format(prot * PROT_MIN_RATE) + " to " + numFormat.format(prot * PROT_MAX_RATE) + " hours");
                System.out.println("\tFrom carbohydrates: " + numFormat.format(carb * CARB_MIN_RATE) + " to " + numFormat.format(carb * CARB_MAX_RATE) + " hours");
                System.out.println("\tFrom fats: " + numFormat.format(fats * FATS_MIN_RATE) + " to " + numFormat.format(fats * FATS_MAX_RATE) + " hours");
                System.out.println(""); // Blank line
            } catch (FileNotFoundException e) {
                System.err.println("Error: Data file not found.");
            }
        }

        sc.close();
        foodDataScanner.close();
    }
}
