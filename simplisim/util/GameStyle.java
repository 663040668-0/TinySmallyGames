package simplisim.util;

import java.awt.Color;
import java.awt.Font;

/**
 * This class use to define color palette for SimpliSim.
 * 
 * @author Fire Of Ender
 */

public class GameStyle {
    // Define colors
    private static final Color[] PALETTE = {
        Color.decode("#0000aa"),
        Color.decode("#fefefe"),
        Color.decode("#00aabb"),
    };

    // Constants to call from other classes
    public static final Color PRIMARY_BACKGROUND = PALETTE[0];
    public static final Color PRIMARY_BUTTON_BACKGROUND = PALETTE[2];
    public static final Color PRIMARY_TEXT = PALETTE[1];
    public static final Font PRIMARY_FONT_PLAIN = new Font(Font.MONOSPACED, Font.PLAIN, 20);
    public static final Font PRIMARY_FONT_ITALIC = new Font(Font.MONOSPACED, Font.ITALIC, 20);
    public static final Font PRIMARY_FONT_BOLD = new Font(Font.MONOSPACED, Font.BOLD, 20);
}
