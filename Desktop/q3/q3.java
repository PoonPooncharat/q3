import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import javax.swing.*;

public class q3 implements ActionListener { 
    g2d = (Graphics2D) canvas.getGraphics();
    JFrame frame = new JFrame(); 
    JPanel textpanel = new JPanel(); 
    JPanel buttonpanel = new JPanel();
    JLabel textfield = new JLabel();
    char BoardArray[][] = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
    int turn_count = 0;
    boolean check = true;
    
    public q3() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setTitle("XO Game");
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        textpanel.setLayout(new BorderLayout());
        textpanel.setBounds(0, 0, 800, 100);
        buttonpanel.setLayout(new GridLayout(3, 3));
       
        textpanel.add(textfield);
        frame.add(buttonpanel);
    }

    private void updateMap() {
        g2d.setStroke(new BasicStroke(2));
        g2d.setFont(new Font ("TimesRoman", Font.PLAIN, 48 ));
        //g2d.setBackground(Color.white);
        
        for(int y=0; y<3; y++) {
            for(int x=0; x<3; x++ ) {
                g2d.setColor(Color.white);
                g2d.fillRect(x*100, y*100, 100, 100);
                g2d.setColor(Color.black);
                g2d.drawRect(x*100, y*100, 100, 100);
                
                    g2d.drawString(BoardArray[y][x] + "",35 + (x*100), 65 + (y*100));
                
            }
        }
    }
    public void mouseReleased(MouseEvent e) {
        if (nextBlock != null) {
            BoardArray[nextBlock.y][nextBlock.x] = BoardArray[selectedBlock.y][selectedBlock.x];
            BoardArray[selectedBlock.y][selectedBlock.x] = ' ';
            movecount++;
        }
        
        if (Check_Winner()) {
            System.out.println("You Win");
            //JOptionPane.showMessageDialog(null, "You Win " + (playtime + millis())/1000 + " seconds " + movecount + " Move");
            System.exit(0);
        }
    }


    public void Check_Winner() {
        for (int y =0;y < 3;y++) {
            for (int x =0;x < 4;x++) {
                if (BoardArray[y][x] == BoardArray[y+1][x+1] || BoardArray[y][x] == BoardArray[y+2][x+2] || BoardArray[y+2][x+2] == BoardArray[y+1][x+1])return true;
            }
        }
    }
    
    public void gameOver(String s){
        turn_count = 0;
        Object[] option={"Restart"};
        int n=JOptionPane.showOptionDialog(frame, "Game Over\n"+s,"Game Over",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,option,option[0]);
        if(n==0){
            frame.dispose();
            new q3();
        }
        else{
            frame.dispose();
        }
    
    }
    public static void main(String[] args) throws Exception{
        new q3();
        }
}