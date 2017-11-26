import javax.swing.*;
import java.awt.*;

public class GRADE extends JFrame {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GRADE();
	}
	public GRADE(){
		//set constraints
		GridBagConstraints gc = new GridBagConstraints();
		gc.gridx = 0; 
		gc.gridy = 0;  
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 100.0;
		gc.weighty = 100.0;
		gc.insets = new Insets(3,3,3,3);
		gc.anchor = GridBagConstraints.WEST;
		gc.fill = GridBagConstraints.BOTH;

		//create labels
		JLabel l1 = new JLabel();
		l1.setFont(new Font("Calibri", Font.PLAIN, 18));
		l1.setForeground(Color.BLUE);
		l1.setText("  First Name:");
		l1.setVisible(true);
		
		JLabel l2 = new JLabel();
		l2.setFont(new Font("Calibri", Font.PLAIN, 18));
		l2.setForeground(Color.BLUE);
		l2.setText("  Last Name:");
		l2.setVisible(true);
		
		JLabel l3 = new JLabel();
		l3.setFont(new Font("Calibri", Font.PLAIN, 18));
		l3.setForeground(Color.BLUE);
		l3.setText("  Student Number:");
		l3.setVisible(true);
		
		//create textfields
		JTextField T1 = new  JTextField(20);
		JTextField T2 = new  JTextField(20);
		JTextField T3 = new  JTextField(20);
		
		//create buttons for main panel
		Dimension d = new Dimension(90, 30);
		JButton b1 = new JButton("OK");
		b1.setPreferredSize(d);
		JButton b2 = new JButton("CLEAR");
		b2.setPreferredSize(d);
		JButton b3 = new JButton("EXIT");
		b3.setPreferredSize(d);
		
		//set buttons for main panel into grid
		JPanel gridpanel = new JPanel();
		gridpanel.setLayout(new GridLayout(3, 3, 2, 9));
		gridpanel.add(b1);
		gridpanel.add(b2);
		gridpanel.add(b3);
		gridpanel.setBackground(Color.WHITE);
		
		//create radio buttons for gender
		JRadioButton male = new JRadioButton("  MALE");
		male.setBackground(Color.WHITE);
		JRadioButton female = new JRadioButton("  FEMALE");
		female.setBackground(Color.WHITE);
		
		// Create radio button group for gender options
		ButtonGroup group1 = new ButtonGroup();
		group1.add(male);
		group1.add(female);
		
		// Create button panel for gender
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBorder(BorderFactory
				.createTitledBorder("GENDER"));
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		buttonPanel.add(male);
		buttonPanel.add(female);
		buttonPanel.setBackground(Color.WHITE);
		
		//create radio buttons for grades
		JRadioButton b9 = new JRadioButton("     9   ");
		b9.setBackground(Color.WHITE);
		JRadioButton b10 = new JRadioButton("    10   ");
		b10.setBackground(Color.WHITE);
		JRadioButton b11 = new JRadioButton("    11   ");
		b11.setBackground(Color.WHITE);
		JRadioButton b12 = new JRadioButton("    12   ");
		b12.setBackground(Color.WHITE);
		
		// Create radio button group for grades options
		ButtonGroup group2 = new ButtonGroup();
		group2.add(b9);
		group2.add(b10);
		group2.add(b11);
		group2.add(b12);

		// Create button panel for grades
		JPanel buttonPanel2 = new JPanel();
		buttonPanel2.setBorder(BorderFactory
				.createTitledBorder("GRADE"));
		buttonPanel2.setLayout(new BoxLayout(buttonPanel2, BoxLayout.Y_AXIS));
		buttonPanel2.add(b9);
		buttonPanel2.add(b10);
		buttonPanel2.add(b11);
		buttonPanel2.add(b12);
		buttonPanel2.setBackground(Color.WHITE);
		
		//main panel adding components
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.add(l1,gc);
		gc.gridy = 1;
		panel.add(l2,gc); 
		gc.gridy = 2;
		panel.add(l3,gc);
		gc.gridx = 1; 
		gc.gridy = 0;
		gc.gridwidth = 2;
		panel.add(T1,gc);
		gc.gridx = 1; 
		gc.gridy = 1; 
		panel.add(T2,gc);
		gc.gridx = 1; 
		gc.gridy = 2; 
		panel.add(T3,gc);
		gc.gridx = 0; 
		gc.gridy = 3;
		gc.gridwidth = 1;
		gc.gridheight = 3;
		gc.anchor = GridBagConstraints.CENTER;
		gc.fill = GridBagConstraints.NONE;
		panel.add(buttonPanel,gc);
		gc.gridx = 1; 
		gc.gridy = 3;
		panel.add(buttonPanel2,gc);
		gc.gridx = 2; 
		gc.gridy = 3;
		panel.add(gridpanel,gc);
		
		//main panel construction
		setContentPane(panel);
		setSize(400, 300);
		setLocationRelativeTo(null);
		setResizable(true);
		setTitle("Bronte College");
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}