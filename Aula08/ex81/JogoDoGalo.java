
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
public class JogoDoGalo extends JFrame{
    private String play;
    private int plays=0;
    private JToggleButton b[] = new JToggleButton[9];
    public JogoDoGalo(String whoStarts){
        super("Jogo do Galo");
        play=whoStarts.substring(whoStarts.length()-1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,600);
        setVisible(true);
        JPanel panel = new JPanel(new GridLayout(3,3));
        panel.setBackground(Color.WHITE);
        
        for( int i = 0; i < 9 ; i++){
            b[i]=new JToggleButton("-");
            b[i].setFont(new Font("",1,100));
            panel.add(b[i]);
            
        }
        
        for( JToggleButton btmp:b){
            btmp.addActionListener(e-> {
                                            ((JToggleButton)e.getSource()).setText(play());
                                            ((JToggleButton)e.getSource()).setEnabled(false);
                                            if(checkGameState()) 
                                                for(JToggleButton btmp2:b)
                                                    btmp2.setEnabled(false); 
                                        });
        }
        add(panel);
        
    }
    
    public static void main(String[] args) {
        new JogoDoGalo("Jogo do Galo O");
        
    }
    
    private String play(){
        plays++;
        if(play.equals("X")){
            play="O";
            return "X";
        }
        play="X";
        return "O";
    }
    
    private boolean checkGameState(){
        String result="Horizontais:";
        for(int i=0;i<b.length;i++){
            if(i%3==0)
                result+=" ";
            result+=b[i].getText();
        }
        result+=" Verticais: ";
        for(int i=0;i<b.length;i=i+3){
            if(i==0 || i== 1 || i==2)
                result+=" ";
            result+=b[i].getText();
            if(i==6)
                i=-2;
            if(i==7)
                i=-1;
            
        }
        result+=" Diagonais: ";
        for(int i=0;i<b.length;i=i+4){
            result+=b[i].getText();
        }
        result+=" ";
        for(int i=2;i<b.length-1;i=i+2){
            result+=b[i].getText();
        }
        System.out.println(result);
        if(result.contains("XXX"))
            JOptionPane.showMessageDialog(this, "O jogador X venceu!");
        else if(result.contains("OOO"))
            JOptionPane.showMessageDialog(this, "O jogador O venceu!");
        else if(plays==9)
            JOptionPane.showMessageDialog(this, "Empate!");
        else return false;
        return true;
        
    }
    
    
}
