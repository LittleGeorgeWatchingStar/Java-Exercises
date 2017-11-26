import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class Joke extends JFrame implements ActionListener {

	private JButton btnClick, btnExit;

	private JLabel label, label2;

	public JPanel panel;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Joke();
	}

	public Joke() {

		// label
		label = new JLabel();
		label.setBounds(20, 10, 180, 45);
		label.setText("What's the best car in the world");

		label2 = new JLabel();
		label2.setBounds(20, 100, 220, 45);
		// create a button
		btnClick = new JButton("Answer");
		btnClick.setToolTipText("Check the answer here");
		btnClick.setBounds(20, 50, 260, 40);

		btnClick.addActionListener(this);

		btnExit = new JButton("Quit");
		btnExit.setToolTipText("Go find a trabsformer");
		btnExit.setBounds(20, 50, 260, 40);
		btnExit.addActionListener(this);

		// panel
		panel = new JPanel();
		panel.setLayout(null);
		panel.add(btnClick);
		panel.add(label);

		panel.add(label2);

		// Frame
		setContentPane(panel);
		setSize(300, 200);
		setTitle("Joke");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnClick) {
			panel.remove(btnClick);
			panel.add(btnExit);
			label2.setText("An Autobox, Go find a transformer");

		} else if (e.getSource() == btnExit) {
			JOptionPane.showMessageDialog(null, "Haha. Are you tricked? I hope you enjoyed it. Goodbye!",
					"JButton", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}

	}
}
