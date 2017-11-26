import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class Locky extends JFrame implements ActionListener {
	private JButton btnsignin, btnexit;
	private JTextField name;
	private JPasswordField password;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Locky();
	}

	public Locky() {
		// Declare and initialize a JLabel
		JLabel l1 = new JLabel();
		l1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		l1.setForeground(Color.RED);
		l1.setText("    918    Emergency Service");
		l1.setBounds(220, 5, 250, 45);

		JLabel l2 = new JLabel();
		l2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		l2.setForeground(Color.BLUE);
		l2.setText("Dear agent, please enter your name");
		l2.setBounds(220, 35, 250, 45);

		JLabel l3 = new JLabel();
		l3.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		l3.setForeground(Color.BLUE);
		l3.setText("Dear agent, I need your password");
		l3.setBounds(220, 85, 250, 45);

		//set an image to a label
		ImageIcon img = new ImageIcon("15.png");
		JLabel Imglabel = new JLabel();
		Imglabel.setIcon(img);
		Imglabel.setBounds(5, 5, 200, 200);
		
		// Initialize JButtons
		btnsignin = new JButton("Sign in");
		/*btnsignin.setIcon(img);
		 * You can set an image to a  button if you want
		 */
		btnsignin.setBounds(225, 170, 80, 30);
		btnsignin.addActionListener(this);

		btnexit = new JButton("Exit");
		btnexit.setBounds(325, 170, 80, 30);
		btnexit.addActionListener(this);

		// Initialize JTextField
		name = new JTextField(10);
		name.setBounds(220, 70, 196, 22);
		password = new JPasswordField(10);
		password.setBounds(220, 125, 196, 22);

		// Declare and initialize JPanel
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.add(l1);
		panel.add(l2);
		panel.add(l3);
		panel.add(Imglabel);
		panel.add(name);
		panel.add(password);
		panel.add(btnsignin);
		panel.add(btnexit);

		// Set properties of the JFrame
		setContentPane(panel);
		setSize(450, 250);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Welcome");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

		// Get the text entered in the text field
		String yourname = name.getText();
		String your = password.getText();

		// Nothing is entered in the text field
		if (e.getSource() == btnsignin) {
			if (yourname.equals("Steve")) {
				if (your.equals("333")) {
					ImageIcon img1 = new ImageIcon("12.jpg");
					JOptionPane.showMessageDialog(null, "Haha,yes", "JButton",
							JOptionPane.INFORMATION_MESSAGE,img1);
				}
				
				else {
					ImageIcon img2 = new ImageIcon("13.jpg");
					JOptionPane.showMessageDialog(null, "Nope, wrong password",
							"Information Dialog", JOptionPane.WARNING_MESSAGE,img2);

				}
			}
				else{
					JOptionPane.showMessageDialog(null, "Not an agent yet? Apply to us now~", "JButton",
							JOptionPane.INFORMATION_MESSAGE);
				}
			
		}
		else if (e.getSource() == btnexit) {
			JOptionPane.showMessageDialog(null, "Thank you agent, our mission is to protect our people", "JButton",
					JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
	}

}
