import javax.swing.*;

import java.awt.Font;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener {
	public JButton btnClick, btnExit;
	public int counter = 1;

	public JPanel panel;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

	public Main() {

		// create a button
		btnClick = new JButton("You have clicked 0 times");
		btnClick.setToolTipText("Check here");
		btnClick.setBounds(20, 50, 260, 40);
		btnClick.setMnemonic(KeyEvent.VK_A);
		btnClick.addActionListener(this);

		// panel
		panel = new JPanel();
		panel.setLayout(null);
		panel.add(btnClick);

		// Frame
		setContentPane(panel);
		setSize(300, 200);
		setTitle("Clicker");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnClick)

		{
			if (counter < 11) {

				btnClick.setText("You have clicked " + counter + " times");
				counter++;

			}

			else {

				JOptionPane.showMessageDialog(null,
						"Haha, you are out of clicks!", "JButton",
						JOptionPane.INFORMATION_MESSAGE);

				System.exit(0);

			}
		}

	}
}
