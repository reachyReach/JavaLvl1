package DaGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class GameWindow extends JPanel {

    public static final int MODE_H_V_A = 0;
    public static final int MODE_H_V_H = 1;

    int fieldSizeX;
    int fieldSizeY;
    int winLength;

    int cellHeight;
    int cellWidth;

    static boolean isInitialised = false;

    public GameWindow(){
        setBackground(Color.BLUE);


        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int cellX = e.getX() / cellWidth;
                int cellY = e.getY() / cellHeight;
                System.out.println(cellX + " " + cellY);
                Logic.humanTurn(cellX, cellY );
                repaint();
            }
        });
    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
//        System.out.println(mode + " " + fieldSizeX + " " + fieldSizeY + " " + winLength);
        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.winLength = winLength;
        isInitialised = true;

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        try {
            render(g);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void render(Graphics g) throws IOException {
        if (!isInitialised) {
            return;
        }

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        cellWidth = panelWidth / fieldSizeX;
        cellHeight = panelHeight / fieldSizeY;

        for (int i = 0; i < fieldSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int i = 0; i < fieldSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }


        for (int i = 0; i < Logic.SIZE_Y; i++) {
            for (int j = 0; j < Logic.SIZE_X; j++) {
                if(Logic.map[i][j] == Logic.DOT_X){
                    drawX(g,j,i);
                }
                if(Logic.map[i][j] == Logic.DOT_O){
                    drawO(g,j,i);
                }
            }
        }

        if (Logic.checkWinLines(Logic.DOT_X) || Logic.checkWinLines(Logic.DOT_O) || Logic.isFull()){
            new EndGameWindow();
        }

    }

    private void drawX(Graphics g, int cellX, int cellY){
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(8.0F));
        g2.setColor(new Color(0,255,0));
        g2.drawLine((cellX * cellWidth) + 10, (cellY * cellHeight) + 10, (cellX * cellWidth) + cellWidth-10,(cellY * cellHeight) + cellHeight-10 );
        g2.drawLine((cellX * cellWidth) + 10, (cellY * cellHeight) + cellHeight - 10, (cellX * cellWidth) + cellWidth-10,(cellY * cellHeight) + 10 );
    }

    private void drawO(Graphics g, int cellX, int cellY){
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(8.0F));
        g2.setColor(new Color(255,0,0));
        g2.drawOval((cellX * cellWidth) + 10, (cellY * cellHeight) + 10, cellWidth-20,cellHeight-20 );
    }


}
