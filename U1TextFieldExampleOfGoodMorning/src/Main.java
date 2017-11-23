import javax.swing.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener {
	private JButton btnOK;
	private JTextField txtName;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

	public Main() {
		// Declare and initialize a JLabel
		JLabel lbl1 = new JLabel("Enter your name: ");
		
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
		setTitle("Welcome");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		
		// Get the text entered in the text field
		String name = txtName.getText();
		
		// Nothing is entered in the text field
		if (name.length() == 0) {
			JOptionPane.showMessageDialog(this, "You didn't enter anything!",
					"Invalid data!", JOptionPane.INFORMATION_MESSAGE);
		}
		// Output message to user
		else {
			JOptionPane.showMessageDialog(this, "Good Morning " + name + "!",
					"Salutations!", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
	}
}
