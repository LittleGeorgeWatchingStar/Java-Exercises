import javax.swing.*;

import java.awt.*;

public class UsingLayoutsInClass extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UsingLayoutsInClass();
	}

	public UsingLayoutsInClass() {
		// JButtons
		JButton b1 = new JButton("Button1");
		JButton b2 = new JButton("Button2");
		JButton b3 = new JButton("Button3");
		JButton b4 = new JButton("Button4");
		JButton b5 = new JButton("Button5");

		// flow layout 1
		JPanel flowPanel = new JPanel();
		flowPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
		flowPanel.add(b1);
		flowPanel.add(b2);
		flowPanel.add(b3);
		flowPanel.add(b4);
		flowPanel.add(b5);

		// border layout 2
		JPanel borderPanel = new JPanel();
		borderPanel.setLayout(new BorderLayout());
		borderPanel.add(b1, BorderLayout.NORTH);
		borderPanel.add(b2, BorderLayout.WEST);
		borderPanel.add(b3, BorderLayout.SOUTH);
		borderPanel.add(b4, BorderLayout.EAST);
		borderPanel.add(b5, BorderLayout.CENTER);

		// box layout 3
		JPanel boxPanel = new JPanel();
		boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.Y_AXIS));
		Dimension d = new Dimension(200, 30);
		b1.setPreferredSize(d);
		b1.setMinimumSize(d);
		b1.setMaximumSize(d);
		b1.setAlignmentX(CENTER_ALIGNMENT);
		boxPanel.add(Box.createVerticalStrut(10));
		boxPanel.add(b1);
		boxPanel.add(Box.createVerticalStrut(0));
		boxPanel.add(b2);
		boxPanel.add(Box.createVerticalStrut(10));
		boxPanel.add(b2);
		boxPanel.add(Box.createVerticalStrut(10));
		boxPanel.add(b3);
		boxPanel.add(Box.createVerticalStrut(10));
		boxPanel.add(b4);
		boxPanel.add(Box.createVerticalStrut(10));
		boxPanel.add(b5);

		// grid layout
		JPanel gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(3, 2, 20, 60));
		gridPanel.add(b1);
		gridPanel.add(b2);
		gridPanel.add(b3);
		gridPanel.add(b4);
		gridPanel.add(b5);
		
		
		
		
		GridBagConstraints gc = new GridBagConstraints();
		gc.gridx = 1; 
		gc.gridy = 1;  
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 50.0;
		gc.weighty = 100.0;
		gc.insets = new Insets(5, 5, 5, 5);
		gc.anchor = GridBagConstraints.NORTHWEST;
		gc.fill = GridBagConstraints.NONE;
		
		JPanel gbpanel = new JPanel();
		gbpanel.setLayout(new GridBagLayout());
		gbpanel.add(b1, gc);
		
		GridBagConstraints gc2 = new GridBagConstraints();
		gc2.gridx = 2; 
		gc2.gridy = 1;  
		gc2.gridwidth = 2;
		gc2.gridheight = 1;
		gc2.weightx = 50.0;
		gc2.weighty = 60.0;
		gc2.insets = new Insets(5, 5, 5, 5);
		gc2.anchor = GridBagConstraints.NORTHWEST;
		gc2.fill = GridBagConstraints.NONE;
		
		JLabel label = new JLabel("NAAAAAAAA");
		label.setFont(new Font("Calibri", Font.BOLD, 40));
		gbpanel.add(label, gc2);
		
		GridBagConstraints gc3 = new GridBagConstraints();
		gc3.gridx = 3; 
		gc3.gridy = 2;  
		gc3.gridwidth = 3;
		gc3.gridheight = 1;
		gc3.weightx = 0.0;
		gc3.weighty = 50.0;
		gc3.insets = new Insets(5, 10, 5, 5);
		gc3.anchor = GridBagConstraints.SOUTH;
		gc3.fill = GridBagConstraints.CENTER;
		
		JTextField text = new JTextField(20);
		gbpanel.add(text, gc3);
	

		setContentPane(gbpanel);
		setSize(470, 420);
		setLocationRelativeTo(null);
		setResizable(true);
		setTitle("Learning from Ms Yang");
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
