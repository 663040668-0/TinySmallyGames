import java.util.Random;

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
        greetingPreference = { "Hi, I'm" , "Yo!, My name's" , "Sup bro, I'm" }[rand.nextInt(3)];
    }

    //Methods
    public void grows()
        age++

    public void greeting() {
        System.out.println(greetingPreference + " " + name + ".\n and I'm " + age + " years old.\n");
    }
}

public class Popo {
    public static void main(String [] args) throws Exception {
        Parrot myParrot = new Parrot("Popo")
        myParrot.greeting();
    }
}