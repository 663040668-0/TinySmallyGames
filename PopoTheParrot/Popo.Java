
// Import necessary packages
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Parrot {
    //Public attributes
    public int hunger = 0;
    public String name;
    public int age;
    public String color;

    //Private attributes or fields
    private Random rand = new Random();

    //Private constants
    final private int MIN_AGE = 1; //years old
    final private int MAX_AGE = 5; //years old

    //Constructor
    public Parrot(String newName){
        //Name the parrot
        name = newName;

        //Random the age
        age = rand.nextInt(MAX_AGE - MIN_AGE + 1);

        //Random color
        List<String> colorsList = new ArrayList<String>();
        try {
            colorsList = Files.readAllLines(Paths.get("info\\colors.txt"));
        } catch (IOException e) {
            System.err.println(e);
        }
        // Add the list to the empty string array
        String[] colorsArray = colorsList.toArray(new String[0]);
        // Random index in the array
        color = colorsArray[rand.nextInt(colorsArray.length)];
    }
}

public class Popo {
    public static void main(String[] args) throws FileNotFoundException {
        // Initial input receiver
        Scanner sc = new Scanner(System.in);

        // Start the game
        System.out.println("You've bought a new parrot.");
        System.out.print("Let give it a name: ");
        String name = sc.nextLine();
        Parrot newParrot = new Parrot(name);
        System.out.println(newParrot.color);

        sc.close();
    }
}