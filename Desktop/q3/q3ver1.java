import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import javax.swing;

public class TicTacToeGame implements ActionListener {

    private BufferStrategy strategy;
    private boolean gameIsRunning = true;
    private int mousePressedX = -1;
    private int mousePressedY = -1;
    private boolean enterPressed = false;
    private char currentMove = 'X';
    private char gameWinner = '0';
    private char[][] BoardArray = new char[3][3];
    private int moves = 0;


    TicTacToeGame() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setBounds(0,0,800, 600);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setTitle("Tic Tac Toe");
        panel.setPreferredSize(new Dimension(800,600));
        panel.setLayout(null);
        frame.setVisible(true);
        textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic Tac Toe");
        textfield.setOpaque(true);
    }

    

    private void check_win(long delta) {
        if((mousePressedX >= 0 || mousePressedY >= 0) && gameWinner == '0') {
            int xIndex = (int) Math.floor(mousePressedX / 80);
            int yIndex = (int) Math.floor(mousePressedY / 60);

            if(BoardArray[yIndex][xIndex] == '0') {
                BoardArray[yIndex][xIndex] = currentMove;
                nextMove();
            }
        }

        if(BoardArray[0][0] == BoardArray[1][1] && BoardArray[0][0] == BoardArray[2][2]) {

            if(BoardArray[0][0] == 'X')
                gameWinner = 'X';
            else if(BoardArray[0][0] == 'O')
                gameWinner = 'O';

        } else if(BoardArray[0][2] == BoardArray[1][1] && BoardArray[0][2] == BoardArray[2][0]) {

            if(BoardArray[0][2] == 'X')
                gameWinner = 'X';
            else if(BoardArray[0][2] == 'O')
                gameWinner = 'O';

        } else {
            for(int i=0; i<3; i++) {
                if(BoardArray[i][0] == BoardArray[i][1] && BoardArray[i][0] == BoardArray[i][2]) {

                    if(BoardArray[i][0] == 'X')
                        gameWinner = 'X';
                    else if(BoardArray[i][0] == 'O')
                        gameWinner = 'O';

                } else if(BoardArray[0][i] == BoardArray[1][i] && BoardArray[0][i] == BoardArray[2][i]) {
                    if(BoardArray[0][i] == 'X')
                        gameWinner = 'X';
                    else if(BoardArray[0][i] == 'O')
                        gameWinner = 'O';
                }
            }
        }
    }

    private void Movement() {
        if(currentMove == 'X')
            currentMove = 'O';
        else
            currentMove = 'X';
        moves--;
    }

    public void startGame() {
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                BoardArray[i][j] = '0';
            }
        }
    }
    public void gameOver(String s){
        chance_flag = 0;
        Object[] option={"Restart","Exit"};
        int n=JOptionPane.showOptionDialog(frame, "Game Over\n"+s,"Game Over",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,option,option[0]);
        if(n==0){
            frame.dispose();
            new TicTacToeGame();
        }
        else{
            frame.dispose();
        }

    }


}
