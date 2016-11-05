import java.awt.*;
import java.util.*;
import java.nio.file.*;
import javax.swing.*;
import java.awt.event.*;
import java.nio.*;
import java.io.*;

public class QQSM extends JFrame{
	
	private final int prize[] = {0,25,40,125,250,500,750,1500,2500,5000,10000,16000,32000,64000,125000,250000};	
	private Pergunta[] perguntas;
	private int qNr=-1;	

	private JLabel img;
	private JLabel money;
	private JButton ajuda;
	private JButton telefone;
	private JButton cc;
	private JButton desistir;
	private JButton confirmar;
	private JTextArea pergunta;
	private JRadioButton resp[];
	private ButtonGroup btn;
	private JPanel mpn;
	private JPanel bpn;
	private JPanel gpn;
	private JPanel apn;
	private JPanel cpn;
	
	public QQSM(String n,Path pergs) throws IOException{
		super(n);
		
		perguntas=Pergunta.parseFile(pergs);	
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		img = new JLabel();
		money = new JLabel("xxx€");
		ajuda = new JButton("Ajuda Publico");
		telefone = new JButton("Telefone...");
		cc = new JButton("50-50");
		desistir = new JButton("Desistir");
		confirmar = new JButton("Confirmar");
		pergunta = new JTextArea("---pergunta---");
		pergunta.setEditable(false);
		pergunta.setLineWrap(true);
		resp = new JRadioButton[4]; 
		resp[0] = new JRadioButton("A");
		resp[1] = new JRadioButton("B");
		resp[2] = new JRadioButton("C");
		resp[3] = new JRadioButton("D");
		btn = new ButtonGroup();
		btn.add(resp[0]);
		btn.add(resp[1]);
		btn.add(resp[2]);
		btn.add(resp[3]);

		mpn = new JPanel(new BorderLayout());
		bpn = new JPanel(new BorderLayout());
		gpn = new JPanel(new GridLayout(2,2));
		apn = new JPanel(new FlowLayout(FlowLayout.LEFT));
		cpn = new JPanel();

		mpn.add(img,BorderLayout.WEST);
		mpn.add(money,BorderLayout.NORTH);
		mpn.add(pergunta,BorderLayout.CENTER);

		apn.add(ajuda);
		apn.add(telefone);
		apn.add(cc);

		gpn.add(resp[0]);
		gpn.add(resp[1]);
		gpn.add(resp[2]);
		gpn.add(resp[3]);

		cpn.add(confirmar);
		cpn.add(desistir);

		bpn.add(apn,BorderLayout.NORTH);
		bpn.add(gpn,BorderLayout.CENTER);
		bpn.add(cpn,BorderLayout.EAST);

		mpn.add(bpn,BorderLayout.SOUTH);
		mpn.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

	
		add(mpn);

		confirmar.addActionListener(e -> checkCorrect());
		cc.addActionListener(e -> fiftyfifty());
		desistir.addActionListener(e -> winEnd(0));
		telefone.addActionListener(e -> guess(2,telefone));
		ajuda.addActionListener(e -> guess(4,ajuda));
		

		setSize(800,500);
		setVisible(true);
		
		newQuestion();
	}

	private void checkCorrect(){
		String right=perguntas[qNr].getAnswers()[perguntas[qNr].getCorrectIndex()];
		String ans=null;
		for(JRadioButton a : resp){
			if(a.isSelected()){
				ans=a.getText();
				break;
			}
		}
		if(ans==null){
		}
		else if(right.equals(ans)){
			if(qNr<perguntas.length-1)
				newQuestion();
			else
				winEnd(1);
		}
		else{
			lostEnd();
		}
		
	}
	private void guess(int a,JButton bbb){
		Random rnd = new Random();
		String g="";
		double p[]=new double[4];
		double r;
		
		for(int i=0;i<p.length;i++){
			p[i]=(1f-(0.8f-qNr*0.7f/perguntas.length))/3f;
		}
		p[perguntas[qNr].getCorrectIndex()]=(0.8-qNr*0.7/perguntas.length);
		
		for(int i=0;i<a;i++){
			r=rnd.nextDouble();
			g+=">";
			if(r<p[0]) g+=resp[0].getText();	
			else if(r>p[0]&&r<p[1]+p[0]) g+=resp[1].getText();	
			else if(r>p[0]+p[1]&&r<p[0]+p[1]+p[2]) g+=resp[2].getText();	
			else g+=resp[3].getText();
			g+="\n";	
		}
		JOptionPane.showMessageDialog(getContentPane(),"They choosed:\n"+g);
		bbb.setEnabled(false);
	}
	private void winEnd(int a){
		JOptionPane.showMessageDialog(getContentPane(),"You won "+prize[qNr+a]+"€ !");
		System.exit(0);
	}
	private void lostEnd(){
		JOptionPane.showMessageDialog(getContentPane(),"You lost...");
		System.exit(0);
	}
	private void fiftyfifty(){
		Random r = new Random();
		int[] a= new int[2];
		
		do{
			a[0]=r.nextInt(4);
		}while(a[0]==perguntas[qNr].getCorrectIndex());

		do{
			a[1]=r.nextInt(4);
		}while(a[1]==perguntas[qNr].getCorrectIndex()||a[0]==a[1]);

		resp[a[0]].setEnabled(false);
		resp[a[1]].setEnabled(false);
		cc.setEnabled(false);
	}
	private void newQuestion(){
		img.setIcon(perguntas[++qNr].getImage());	
		pergunta.setText(perguntas[qNr].getQuestion());	
		for(int i=0;i<resp.length;i++){
			resp[i].setEnabled(true);
			resp[i].setText(perguntas[qNr].getAnswers()[i]);	
		}
		money.setText(""+prize[qNr+1]+"€");	
	} 

	public static void main(String args[]) throws IOException{
		Path quest = Paths.get("questions.txt"); 
		new QQSM("Quem Quer Ser Milionário",quest);
	}
}
