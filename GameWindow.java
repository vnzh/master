import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class GameWindow extends JFrame implements Serializable {

    private static final int WIN_WIDTH = 507;
    private static final int WIN_HEIGHT = 555;
    private static final int WIN_POSX = 650;
    private static final int WIN_POSY = 250;

    private Map map;
    private Settings settings;

    GameWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tic tac toe game");
        setLocation(WIN_POSX, WIN_POSY);
        setSize(WIN_WIDTH, WIN_HEIGHT);

        JButton btnStart = new JButton("Start");
        JButton btnExit = new JButton("Exit");
        JButton btnSetting = new JButton("Setting");
        JPanel panelButtons = new JPanel(new GridLayout(1, 3));
        panelButtons.add(btnStart);
        panelButtons.add(btnSetting);
        panelButtons.add(btnExit);
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //settings.setVisible(true);
                start();
            }
        });

        btnSetting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                settings.setVisible(true);
            }
        });


        map = new Map();
        settings = new Settings(this);

        add(map, BorderLayout.CENTER);
        add(panelButtons, BorderLayout.SOUTH);
        setVisible(true);
    }

    void start() {
            SaveSettings sv = null;
        try {
            FileInputStream fis = new FileInputStream("setting.ser");
            ObjectInputStream ois = new ObjectInputStream((fis));
           sv = (SaveSettings) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }

        map.startNewGame(sv.getGameMode(), sv.getFieldSizeX(), sv.getFieldSizeY(), sv.getWinLength());
    }
}