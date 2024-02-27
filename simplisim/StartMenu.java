package simplisim;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import simplisim.util.GameWindowDimension; 
import simplisim.util.GameStyle;

/**
 * This class create and show GUI of start menu for SimpliSim.
 * This class extends {@link JFrame}.
 * 
 * <p><strong>Menu Buttons :</strong>
 * <blockquote>
 * <br>
 * - {@code New game} route to {@link StartMenu} <br> <br>
 * - {@code Load game} show lists and route to {@link LifeSimulation} <br> <br>
 * - {@code Settings} route to Settings (implement later) <br> <br>
 * - {@code Exit} runs {@code dispose()} <br> <br>
 * </blockquote>
 * 
 * @author Fire Of Ender
 */

public class StartMenu extends JFrame implements ActionListener {
    // Attributes
    protected String status;
    protected Dimension windowSize;

    // Constructor
    public StartMenu(String gameTitle) {
        super(gameTitle);
        this.status = "Running " + this.getClass().getSimpleName();
        this.windowSize = GameWindowDimension.getWindowSize();
        this.addComponents();
        this.addListeners();
        this.setFrameFeatures();
    }

    // Components
    protected JPanel mainPanel, gameTitlePanel, buttonPanel;
    protected JLabel gameTitleLabel;
    protected JButton newGameButton, loadGameButton, settingsButton, exitButton;

    // Important methods
    protected void addComponents() {
        mainPanel = (JPanel)getContentPane();
        mainPanel.setLayout(null); // !-important else it won't scale correctly
        mainPanel.setBackground(GameStyle.PRIMARY_BACKGROUND);

        gameTitlePanel = new JPanel(new BorderLayout());
        gameTitlePanel.setBounds(0, 0, (int)windowSize.getWidth(), (int)(windowSize.getHeight()/4f));
        gameTitlePanel.setBackground(null); // Transparent
        mainPanel.add(gameTitlePanel);

        gameTitleLabel = new JLabel("SimpliSim");
        // gameTitleLabel.setSize(gameTitlePanel.getSize());
        gameTitleLabel.setHorizontalAlignment(JLabel.CENTER);
        gameTitleLabel.setVerticalAlignment(JLabel.CENTER);
        gameTitleLabel.setHorizontalTextPosition(JLabel.CENTER);
        gameTitleLabel.setVerticalTextPosition(JLabel.CENTER);
        gameTitleLabel.setFont(GameStyle.PRIMARY_FONT_BOLD.deriveFont(100f));
        gameTitleLabel.setForeground(GameStyle.PRIMARY_TEXT);
        gameTitleLabel.setBackground(null);
        gameTitlePanel.add(gameTitleLabel, BorderLayout.CENTER);

        // TODO : Fix panel overflow
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1, 0, (int)(windowSize.getHeight()/20f)));
        buttonPanel.setBounds((int)(3*windowSize.getWidth()/8f), gameTitlePanel.getHeight(), (int)(windowSize.getWidth()/4f), (int)(windowSize.getHeight() - gameTitlePanel.getHeight()));
        mainPanel.add(buttonPanel);

        newGameButton = new JButton("New game");
        newGameButton.setHorizontalAlignment(JLabel.CENTER);
        newGameButton.setVerticalAlignment(JLabel.CENTER);
        newGameButton.setHorizontalTextPosition(JLabel.CENTER);
        newGameButton.setVerticalTextPosition(JLabel.CENTER);
        newGameButton.setFont(GameStyle.PRIMARY_FONT_PLAIN.deriveFont(40f));
        newGameButton.setForeground(GameStyle.PRIMARY_TEXT);
        newGameButton.setBackground(GameStyle.PRIMARY_BUTTON_BACKGROUND);
        buttonPanel.add(newGameButton);

        loadGameButton = new JButton("Load game");
        loadGameButton.setHorizontalAlignment(JLabel.CENTER);
        loadGameButton.setVerticalAlignment(JLabel.CENTER);
        loadGameButton.setHorizontalTextPosition(JLabel.CENTER);
        loadGameButton.setVerticalTextPosition(JLabel.CENTER);
        loadGameButton.setFont(GameStyle.PRIMARY_FONT_PLAIN.deriveFont(40f));
        loadGameButton.setForeground(GameStyle.PRIMARY_TEXT);
        loadGameButton.setBackground(GameStyle.PRIMARY_BUTTON_BACKGROUND);
        buttonPanel.add(loadGameButton);

        settingsButton = new JButton("Settings");
        settingsButton.setHorizontalAlignment(JLabel.CENTER);
        settingsButton.setVerticalAlignment(JLabel.CENTER);
        settingsButton.setHorizontalTextPosition(JLabel.CENTER);
        settingsButton.setVerticalTextPosition(JLabel.CENTER);
        settingsButton.setFont(GameStyle.PRIMARY_FONT_PLAIN.deriveFont(40f));
        settingsButton.setForeground(GameStyle.PRIMARY_TEXT);
        settingsButton.setBackground(GameStyle.PRIMARY_BUTTON_BACKGROUND);
        buttonPanel.add(settingsButton);

        exitButton = new JButton("Exit");
        exitButton.setHorizontalAlignment(JLabel.CENTER);
        exitButton.setVerticalAlignment(JLabel.CENTER);
        exitButton.setHorizontalTextPosition(JLabel.CENTER);
        exitButton.setVerticalTextPosition(JLabel.CENTER);
        exitButton.setFont(GameStyle.PRIMARY_FONT_PLAIN.deriveFont(40f));
        exitButton.setForeground(GameStyle.PRIMARY_TEXT);
        exitButton.setBackground(GameStyle.PRIMARY_BUTTON_BACKGROUND);
        buttonPanel.add(exitButton);
    }

    protected void addListeners() {
        // Add listener to buttons
        newGameButton.addActionListener(this);
        loadGameButton.addActionListener(this);
        settingsButton.addActionListener(this);
        exitButton.addActionListener(this);
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
        if (src == newGameButton) {
            handleNewGame();
        } else if (src == loadGameButton) {
            handleLoadGame();
        } else if (src == settingsButton) {
            handleSettings();
        } else if (src == exitButton) {
            handleExit();
        }
    }

    // Handler methods
    protected void handleNewGame() {
        // TODO : Show CharacterCreator GUI
    }

    protected void handleLoadGame() {
        // TODO : Show Lists of available saves
    }

    protected void handleSettings() {
        // TODO : Show settings GUI
    }

    protected void handleExit() {
        dispose();
    }

    // Other methods
    @Override
    public String toString() {
        return this.status;
    }
}
