import java.util.Scanner;

class Cat {
    // Declare variables
    private String thisName;
    private boolean knownName;
    private final boolean isBold; // Initialize final variables and assign the value later is available
    private final String gender;
    private final float friendliness;

    // Declare constants
    private final float BOLD_CHANCE = 40F; // Percentage
    private final float MALE_CHANCE = 55F; // Percentage

    // Initialize the cat
    public Cat(String name) {
        thisName = name;
        isBold = ((float)(Math.random()*(100)) <= BOLD_CHANCE); // Percent to be bold
        gender = ((float)(Math.random()*(100)) <= MALE_CHANCE) ? "Male" : "Female"; // Percent to be male else female
        friendliness = (float)(Math.random()*(100));
    }

    // Cat is called
    public void call() {
        if (knownName)
            System.out.println("//" + thisName + " is running to you.");
        else
            System.out.println("//The cat ignored your call.");
    }

    // Cat get pet
    public void pet() {
        if ((float)(Math.random()*(100)) <= friendliness)
            System.out.println(isBold ? "MEOW!" : "meow~");
        else
            System.out.println(isBold ? "GRRR!" : "mff.");
    }

    // Nametag get read
    public void readNametag() {
        System.out.println((gender.equalsIgnoreCase("male") ? "His" : "Her") + " name is " + thisName + ".");
        knownName = true;
    }

    // Cat get rename request
    public void rename() {
        if (knownName) {
            System.out.print("New name?\n> ");
            String newName = PetMe.sc.nextLine();
            thisName = newName;
            System.out.println("//The cat is renamed.");
        } else
            System.out.println("You don't even know " + (gender.equalsIgnoreCase("male") ? "his" : "her") + " name. How dare you to rename?!");
    }
}

public class PetMe {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Wow! You've got a new cat! Give it a name. \n> ");
        
        Cat newCat = new Cat(sc.nextLine());
        System.out.println("Now, Let's play! \n('help' for commands list)");

        // Command input loops
        while (true) {
            System.out.print("> ");
            String command = sc.nextLine().replace(" ", "").toLowerCase();
            switch (command) {
                case "help" -> { // List out available commands
                    System.out.println("Commands : help, call, pet, readName, rename, sell, exit .");
                }
                case "call" -> { // Call the cat to you
                    newCat.call();
                }
                case "pet" -> { // Pet the cat
                    newCat.pet();
                }
                case "readname" -> { // Read cat's name from its nametag
                    newCat.readNametag();
                }
                case "rename" -> { // Rename the cat
                    newCat.rename();
                }
                case "sell" -> { // Sell the cat and get new one
                    System.out.println("So rude! Whatever, here's your new cat. Name it.");
                    System.out.print("> ");
                    newCat = new Cat(sc.nextLine());
                    System.out.println("Now, Let's play! \n('help' for commands list)");
                }
                case "exit" -> { // Exit the program
                    System.out.println("Ow~");
                    sc.close();
                    return;
                }
                default -> { // Unknown command
                    System.out.println("?");
                }
            }
        }
    }
}