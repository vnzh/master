import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Settings extends JFrame implements Serializable {
    transient private static final int WINDOW_WIDTH = 350;
    transient private static final int WINDOW_HEIGHT = 270;
    transient private GameWindow gameWindow;

    transient private JRadioButton jrbHumVsAi;
    transient private JRadioButton jrbHumVsHum;
    transient private JSlider jsFieldSize;
    transient private JSlider jsWinLength;
    transient private static final String FIELD_SIZE_PREFIX = "Field size is: ";
    transient private static final String WIN_LENGTH_PREFIX = "Winning length is: ";
    transient private static final int MIN_FIELD_SIZE = 3;
    transient private static final int MAX_FIELD_SIZE = 10;
    transient private static final int MIN_WIN_LENGTH = 3;

    int gameMode = Map.GAME_MODE_HVA;
    int fieldSizeX = 3;
    int fieldSizeY = 3;
    int winLength = 3;

    Settings(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        Rectangle gameWindowBounds = gameWindow.getBounds();
        int posX = (int) gameWindowBounds.getCenterX() - WINDOW_WIDTH / 2;
        int posY = (int) gameWindowBounds.getCenterY() - WINDOW_HEIGHT / 2;
        setLocation(posX, posY);
        setResizable(false);
        setTitle("Creating a new settings");
        setLayout(new GridLayout(10, 1));
        addGameModeControls();
        addFieldControls();
//        JButton btnStart = new JButton("Start a game");
//        btnStart.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                startGame();
//            }
//        });
//        add(btnStart);
        JButton btnSaveSettings = new JButton("Save settings");
        btnSaveSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveSettings();

 //               btnSaveSettings.setVisible(false);
            }


        });

        add(btnSaveSettings);
        this.setVisible(false);



    }

    private void addGameModeControls() {
        add(new JLabel("Choose game mode"));
        jrbHumVsAi = new JRadioButton("Human vs. AI", true);
        jrbHumVsHum = new JRadioButton("Human vs Human");
        ButtonGroup mode = new ButtonGroup();
        mode.add(jrbHumVsAi);
        mode.add(jrbHumVsHum);
        add(jrbHumVsAi);
        add(jrbHumVsHum);
    }

    private void addFieldControls() {
        JLabel jlFieldSize = new JLabel(FIELD_SIZE_PREFIX + MIN_FIELD_SIZE);
        JLabel jlWinLength = new JLabel(WIN_LENGTH_PREFIX + MIN_WIN_LENGTH);
        jsFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        jsWinLength = new JSlider(MIN_WIN_LENGTH, MIN_FIELD_SIZE, MIN_WIN_LENGTH);
        jsFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentValue = jsFieldSize.getValue();
                jlFieldSize.setText(FIELD_SIZE_PREFIX + currentValue);
                jsWinLength.setMaximum(currentValue);
            }
        });
        jsWinLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                jlWinLength.setText(WIN_LENGTH_PREFIX + jsWinLength.getValue());
            }
        });
        add(new JLabel("Choose field size"));
        add(jlFieldSize);
        add(jsFieldSize);
        add(new JLabel("Choose winning length"));
        add(jlWinLength);
        add(jsWinLength);
    }

    private void saveSettings() {
        int gameMode;
        if (jrbHumVsAi.isSelected()) {
            gameMode = Map.GAME_MODE_HVA;
        } else if (jrbHumVsHum.isSelected()) {
            gameMode = Map.GAME_MODE_HVH;
        } else {
            throw new RuntimeException("Unexpected game mode");
        }
        int fieldSizeX = jsFieldSize.getValue();
        int fieldSizeY = jsFieldSize.getValue();
        int winLength = jsWinLength.getValue();
        SaveSettings sv = new SaveSettings(gameMode, fieldSizeX, fieldSizeY, winLength);
        try {
            FileOutputStream fos = new FileOutputStream("setting.ser");
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(sv);
            os.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
//        gameWindow.start(gameMode, fieldSizeX, fieldSizeY, winLength);
        this.setVisible(false);

    }
}
