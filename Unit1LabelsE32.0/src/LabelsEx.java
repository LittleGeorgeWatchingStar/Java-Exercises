import javax.swing.*;

import java.awt.*;

import javax.swing.border.*;

public class LabelsEx extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LabelsEx();
	}
	public LabelsEx() {
		
		//create a JPanel object
		JPanel panel = new JPanel();
		
		//create a label
		JLabel label = new JLabel();
		
		//set image to label
		ImageIcon img = new ImageIcon("duke_badge.png");
		label.setIcon(img);
		label.setBounds(20,120,200,25);
		
		panel.add(label);
		
		setContentPane(panel);
		setSize(400,390);
		setTitle("EXERCISE");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
		
  
	}

}
