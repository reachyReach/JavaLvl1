package DaGame;

import javax.swing.*;
import java.awt.*;

public class ResultField extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (Logic.checkWinLines(Logic.DOT_X)) {
            EndGameWindow.player(g);
        }
        if (Logic.checkWinLines(Logic.DOT_O)) {
            EndGameWindow.ai(g);
        }
        if (Logic.isFull()) {
            EndGameWindow.nichia(g);
        }
        repaint();

    }
}