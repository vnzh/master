import java.io.Serializable;

public class SaveSettings implements Serializable {

    private int gameMode;
    private int fieldSizeX;
    private int fieldSizeY;
    private int winLength;



    public SaveSettings(int gameMode, int fieldSizeX, int fieldSizeY, int winLength) {
        this.gameMode = gameMode;
        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.winLength = winLength;
    }

    public int getGameMode() {
        return gameMode;
    }

    public int getFieldSizeX() {
        return fieldSizeX;
    }

    public int getFieldSizeY() {
        return fieldSizeY;
    }

    public int getWinLength() {
        return winLength;
    }
}
