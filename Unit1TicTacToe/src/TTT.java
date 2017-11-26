import javax.swing.*;

import java.awt.*;

public class TTT extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
new TTT();
	}
public TTT(){
	//create the head label
	JLabel l1 = new JLabel();
	l1.setFont(new Font("Calibri", Font.BOLD, 24));
	l1.setForeground(Color.RED);
	l1.setText(" TIC TAC TOE");
	l1.setVisible(true);
	
	//create buttons and set dimension
	Dimension d = new Dimension(60, 60);
	JButton b1 = new JButton("");
	b1.setPreferredSize(d);
	JButton b2 = new JButton("");
	JButton b3 = new JButton("");
	JButton b4 = new JButton("");
	JButton b5 = new JButton("");
	JButton b6 = new JButton("");
	JButton b7 = new JButton("");
	JButton b8 = new JButton("");
	JButton b9 = new JButton("");
	
	//create a grid panel for buttons
	JPanel gridpanel = new JPanel();
	gridpanel.setLayout(new GridLayout(3, 3, 2, 2));
	gridpanel.add(b1);
	gridpanel.add(b2);
	gridpanel.add(b2);
	gridpanel.add(b3);
	gridpanel.add(b4);
	gridpanel.add(b5);
	gridpanel.add(b6);
	gridpanel.add(b7);
	gridpanel.add(b8);
	gridpanel.add(b9);
	
	//create main panel and add components
	JPanel panel = new JPanel();
	panel.add(l1);
	panel.add(gridpanel);
	
	//main panel construction
	setContentPane(panel);
	setSize(250, 280);
	setLocationRelativeTo(null);
	setResizable(false);
	setTitle("Apple");
	getContentPane().setBackground(Color.WHITE);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
}
}
