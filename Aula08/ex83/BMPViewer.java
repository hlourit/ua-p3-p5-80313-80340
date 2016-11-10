
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Label;
import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class BMPViewer extends JFrame {
    
    public BMPViewer(String windowtitle){
        super(windowtitle);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 600);
        setVisible(true);
        JPanel mainPanel=new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.red);
        JComboBox<String> localFiles = new JComboBox<>();
        localFiles.setEditable(true);
        localFiles.addItemListener(e -> {
                                            File tmp=new File(((String)((JComboBox<String>)e.getSource()).getSelectedItem()));
                                            localFiles.removeAllItems();
                                            for(String s:tmp.list()){
                                                File f=new File(s);
                                                if(f.isDirectory())
                                                    localFiles.addItem(s);
                                            }
                                            
                                        });
        
        File root = new File("/");
        for(String s:root.list()){
            File f=new File(s);
            if(f.isDirectory())
                localFiles.addItem(s);
        }
        mainPanel.add(localFiles,BorderLayout.NORTH);
        mainPanel.add(new Label("teste"),BorderLayout.CENTER);
        add(mainPanel);
        
    }
    
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        JFrame f=new BMPViewer("BMPViewer");
        
    }
    
}
