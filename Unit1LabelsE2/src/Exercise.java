import javax.swing.*;

import java.awt.*;

import javax.swing.border.*;

public class Exercise extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Exercise();
	}
	// constructor
			public Exercise() {
				
				//create a JPanel object
				JPanel panel = new JPanel();
				
				
				//create a JLabel object
				JLabel label = new JLabel();
				
				label.setFont(new Font("Times New Roman", Font.PLAIN, 12));
				label.setText("   RED LABEL");
				label.setOpaque(true);
				label.setBackground(Color.RED);
				label.setForeground(Color.WHITE);
				label.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
				label.setBounds(100,10,200,25);
				
				
				//create a JLabel object
				JLabel label2 = new JLabel();
				
				label2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
				label2.setText("   BLUE LABEL");
				label2.setOpaque(true);
				label2.setBackground(Color.BLUE);
				label2.setForeground(Color.WHITE);
				label2.setBorder(BorderFactory.createLineBorder(Color.ORANGE,3));
				label2.setBounds(100,40,200,25);
				
				
				//create a JLabel object
				JLabel label3 = new JLabel();
				
				label3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
				label3.setText("   ORANGE LABEL");
				label3.setOpaque(true);
				label3.setBackground(Color.ORANGE);
				label3.setForeground(Color.RED);
				label3.setBorder(BorderFactory.createLineBorder(Color.WHITE,3));
				label3.setBounds(100,70,200,25);
				
				
				//create a JLabel object
				JLabel label4 = new JLabel();
				
				label4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
				label4.setText("   MAGENTA LABEL");
				label4.setOpaque(true);
				label4.setBackground(Color.PINK);
				label4.setForeground(Color.WHITE);
				label4.setBounds(100,100,200,25);
				
				//add label to panel
				panel.setLayout(null);
				panel.add(label);
				panel.add(label2);
				panel.add(label3);
				panel.add(label4);
				
				
				//set the properties of the frame
				setContentPane(panel);
				setSize(400,170);
				setTitle("My First JPanel");
				setResizable(false);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setVisible(true);
				
				//background property
				getContentPane().setBackground(Color.BLUE);
				

	
			}

}
