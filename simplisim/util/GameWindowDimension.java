package simplisim.util;

import java.awt.*;

public class GameWindowDimension {
    private static final float WINDOW_RATIO = 3 / 2f;
    private static final float WINDOW_WIDTH_BY_SCREEN_WIDTH = 3 / 5f;
    
    public static Dimension getWindowSize() {
        double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double windowWidth = screenWidth * WINDOW_WIDTH_BY_SCREEN_WIDTH;
        double windowHeight = windowWidth / WINDOW_RATIO;

        return new Dimension((int) windowWidth, (int) windowHeight);
    }
}
