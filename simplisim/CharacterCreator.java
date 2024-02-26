package simplisim;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.*;

/**
 * This class will create and show GUI of what can be done to create a {@link Character}.
 * This class extends {@link JFrame}.
 */

public class CharacterCreator extends JFrame implements ActionListener {
    // Attributes
    protected String status;
    protected Dimension windowSize;

    // Constructor
    public CharacterCreator(String gameTitle, Dimension windowSize) {
        super(gameTitle);
        this.status = "Creating character";
        this.windowSize = windowSize;
        this.addMenus();
        this.addComponents();
        this.addListeners();
        this.setFrameFeatures();
    }

    // Components
    protected JMenuBar menuBar;
    protected JMenu menu;
    protected JMenuItem settingMenuItem, exitMenuItem;

    // Important methods
    protected void addMenus() {
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        menu = new JMenu("Menu");
        menuBar.add(menu);

        settingMenuItem = new JMenuItem("Settings");
        menu.add(settingMenuItem);

        exitMenuItem = new JMenuItem("Exit");
        menu.add(exitMenuItem);
    }

    protected void addComponents() {

    }

    protected void addListeners() {
        settingMenuItem.addActionListener(this);
        exitMenuItem.addActionListener(this);
    }

    // TODO : protected void enableKeyboard()

    protected void setFrameFeatures() {
        setSize(windowSize);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Listener implementations
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == settingMenuItem) {
            handleSettingsMenuItem();
        } else if (src == exitMenuItem) {
            handleExitMenuItem();
        }
    }

    // Handler methods
    protected void handleSettingsMenuItem() {
        // TODO : Show settings GUI
    }

    protected void handleExitMenuItem() {
        // TODO : Check if player saved character
        System.exit(0);
    }

    // Other methods
    @Override
    public String toString() {
        return this.status;
    }
}
