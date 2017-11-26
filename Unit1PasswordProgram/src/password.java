import javax.swing.*;

import java.awt.*;

public class password extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new password();
	}

	public password() {
		// Create buttons
		JButton b1 = new JButton("OK");
		JButton b2 = new JButton("CLEAR");
		JButton b3 = new JButton("EXIT");

		// set dimension
		Dimension d = new Dimension(100, 30);
		b1.setPreferredSize(d);
		b1.setMinimumSize(d);
		b1.setMaximumSize(d);
		b2.setPreferredSize(d);
		b2.setMinimumSize(d);
		b2.setMaximumSize(d);
		b3.setPreferredSize(d);
		b3.setMinimumSize(d);
		b3.setMaximumSize(d);

		// create label
		JLabel t1 = new JLabel("Your Password");
		t1.setPreferredSize(d);
		Dimension d2 = new Dimension(220, 25);
		JPasswordField p1 = new JPasswordField();
		p1.setPreferredSize(d2);
		// change dots to *
		p1.setEchoChar('*');

		// create panel and add components
		JPanel flowPanel = new JPanel();
		flowPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
		flowPanel.add(t1);
		flowPanel.add(p1);
		flowPanel.add(b1);
		flowPanel.add(b2);
		flowPanel.add(b3);

		// main panel construction
		setContentPane(flowPanel);
		setSize(400, 130);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Password");
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
