import java.util.Random;
import java.util.Scanner;

class Parrot {
    //Public attributes
    public String name;
    public int age;

    //Private attributes
    private String greetingPreference;
    private Random rand = new Random();

    //Constructor
    public Parrot(String newName){
        name = newName;
        age = 0;
        String[] preferences = { "Hi, I'm" , "Yo!, My name's" , "Sup bro, I'm" };
        greetingPreference = preferences[rand.nextInt(3)];
    }

    //Methods
    public void grows() {
        age++;
        System.out.println("Happy birthday, " + name + "!\n");
    }

    public void greeting() {
        System.out.println(greetingPreference + " " + name + ".\n and I'm " + age + " years old.\n");
    }
}

public class Popo {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Let name your new parrot: ");
        String name = sc.nextLine();
        Parrot myParrot = new Parrot(name);
        myParrot.greeting();
        myParrot.grows();
        myParrot.greeting();
        sc.close();
    }
}