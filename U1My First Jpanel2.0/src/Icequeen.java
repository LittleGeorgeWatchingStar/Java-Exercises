import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;

public class Icequeen extends JFrame implements ActionListener{
private JCheckBox vanila,chocolate;
private JPanel panel;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
new Icequeen();
	}
	public void itemStateChanged(ItemEvent e){
		JCheckBox clicked = (JCheckBox) e.getItem();
		clicked.setEnabled(false);
	}
public Icequeen(){
	//create checkboxes
	vanila = new JCheckBox("vanila");
	vanila.addActionListener(this);
	chocolate = new JCheckBox("chocolate");
	chocolate.addActionListener(this);
	//create main panel
	panel = new JPanel();
	panel.add(vanila);
	panel.add(chocolate);
	
	
	//frame
	setContentPane(panel);
	setSize(500, 500);
	setLocationRelativeTo(null);
	setResizable(false);
	setTitle("Icecream");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
}
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if (e.getSource() == vanila){
		if (vanila.isSelected()){
			panel.setBackground(Color.YELLOW);
		
		}
		else panel.setBackground(null);
	}
	
	else if (e.getSource() == chocolate){
		if (chocolate.isSelected())
			panel.setBackground(new Color(255,255,123));
		else panel.setBackground(null);
		
	}
}

}
