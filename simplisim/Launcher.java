package simplisim;

import javax.swing.*;

/*
 * What's SimpliSim?
 * SimpliSim is a text-based life simulation game.
 * It's allowed you to create and save your own characters.
 * You can then play them in the game eg., Eating, Sleeping, Exercise, etc.
 * 
 * Available Features:
 *      - Create and save your characters into an obj file
 *      - Load your character from an obj file
 *      - Play your character in the game (life management)
 * 
 * @author Fire Of Ender
 */

/**
 * This class is the launcher for the game <strong>SimpliSim</strong>.
 * which will {@code createAndShowGUI} from the {@link StartMenu} class extended {@link JFrame}.
 * 
 * @author Fire Of Ender
 */

public class Launcher {
    // Constants
    private static final String TITLE = "SimpliSim";
    private static final String SAVES_LOCATION = "./saves";

    // Run in thread-safe mode
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    // Create and show GUI from StartMenu class
    public static void createAndShowGUI() {
        // Run start menu
        StartMenu startMenu = new StartMenu(TITLE);
    }
}
