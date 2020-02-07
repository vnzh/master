import javax.swing.*;
import java.awt.*;

public class Map extends JPanel   {
    public static final int GAME_MODE_HVH = 0;
    public static final int GAME_MODE_HVA = 1;

 //   private JButton[][] fieldsButton;

    Map() {
        setBackground(Color.BLACK);

    }

//    public JButton getFieldsButton(int i, int j) {
//        return fieldsButton[i][j];
//    }
//
//    public void setFieldsButton(JButton button, int i, int j) {
//        this.fieldsButton[i][j] = button;
//    }

    //    Map(int fieldSizeX, int fieldSizeY ) {
//
//        JButton btnDef = new JButton("");
//        JButton btnX = new JButton("X");
//        JButton btnO = new JButton("O");
//
// //       JPanel Map = new JPanel(new GridLayout(2, 2));
//
//        for (int i = 0, k = 0; i < fieldSizeX; i++) {
//            for (int j = 0; j < fieldSizeY; j++) {
////                String btnIndex = "" + i + j;
////                this.add(btnIndex, new JButton(""));
//                fieldsButton[i][j] = new JButton("-");
//            }
//        }
//
//    }




    void startNewGame(int gameMode, int fieldSizeX, int fieldSizeY, int winLength) {

        GridLayout gridLayout = new GridLayout(fieldSizeX,fieldSizeY);
        this.setLayout(gridLayout);
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {

                this.add((new JButton("-")));
            }
        }


        this.updateUI();
        System.out.printf("game mode: %d\nfieldSize: %d\nwinLength: %d",
                gameMode, fieldSizeX, winLength);
    }



}
