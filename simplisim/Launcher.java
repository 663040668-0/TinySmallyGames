package simplisim;

import javax.swing.*;
import java.awt.*;

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
 * which will {@code createAndShowGUI} from the {@link CharacterCreator} class extended {@link JFrame}.
 * 
 * @author Fire Of Ender
 */

public class Launcher {
    // Constants
    private static final String TITLE = "SimpliSim";
    private static final String SAVES_LOCATION = "./saves";
    private static final float WINDOW_RATIO = 3 / 2f;
    private static final float WINDOW_WIDTH_BY_SCREEN_WIDTH = 3 / 5f;

    // Run in thread-safe mode
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    // Create and show GUI from CharacterCreator class
    public static void createAndShowGUI() {
        // Start with character creation
        CharacterCreator characterCreator = new CharacterCreator(TITLE, getWindowSize());
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JOptionPane.showMessageDialog(null, characterCreator.toString());
            }
        });
    }

    // Other methods
    private static Dimension getWindowSize() {
        double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double windowWidth = screenWidth * WINDOW_WIDTH_BY_SCREEN_WIDTH;
        double windowHeight = windowWidth / WINDOW_RATIO;

        return new Dimension((int) windowWidth, (int) windowHeight);
    }
}
