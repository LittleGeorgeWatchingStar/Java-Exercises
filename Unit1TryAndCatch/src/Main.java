import javax.swing.*;

import java.awt.Window;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener {
	private static final Window lbl1 = null;
	private JButton btnOK;
	private JTextField txtName;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

	public Main() {
		// Declare and initialize a JLabel
		JLabel lbl1 = new JLabel("Enter your name: ");
		lbl1.setVisible(false);
		
		// Initialize JButton
		btnOK = new JButton("OK");
		btnOK.addActionListener(this);
		
		// Initialize JTextField
		txtName = new JTextField(10);
		
		
		// Declare and initialize JPanel
		JPanel panel = new JPanel();
		panel.add(lbl1);
		panel.add(txtName);
		panel.add(btnOK);
		
		
		
		// Set properties of the JFrame
		setContentPane(panel);
		setSize(325, 100);
		setLocationRelativeTo(null);
		setTitle("W");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		
		// Get the text entered in the text field
		String name = txtName.getText();
		
		// Nothing is entered in the text field
		if (e.getSource() == btnOK) {
			
			double num = 0;
			try{
			 num = Double.parseDouble(txtName.getText());
			}
			catch (NumberFormatException axm){
				JOptionPane.showMessageDialog(null, "Invalid", "Error", JOptionPane.ERROR_MESSAGE);
				txtName.requestFocus();
		}
			finally {
		System.out.println(num);
		}
	}
}
}