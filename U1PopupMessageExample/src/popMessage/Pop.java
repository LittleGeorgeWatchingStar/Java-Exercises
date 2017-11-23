package popMessage;

import javax.swing.*;

import java.awt.*;
import java.awt.color.*;
import java.awt.Font;
import java.awt.event.*;

public class Pop extends JFrame {
	JButton error, info, warning, question, input, confirm;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Pop();
	}

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			String name;

			if (e.getSource() == error) {
				JOptionPane.showMessageDialog(null, "Error", "Error Dialog",
						JOptionPane.ERROR_MESSAGE);
			} else if (e.getSource() == info) {
				ImageIcon imgIcon = new ImageIcon("duke_badge.png");
				JOptionPane.showMessageDialog(null, "", "Information Dialog",
						JOptionPane.PLAIN_MESSAGE, imgIcon);
			} else if (e.getSource() == warning) {
				JOptionPane.showMessageDialog(null, "warning",
						"Information Dialog", JOptionPane.WARNING_MESSAGE);
			} else if (e.getSource() == question) {
				JOptionPane.showMessageDialog(null, "question",
						"Information Dialog", JOptionPane.QUESTION_MESSAGE);
			} else if (e.getSource() == input) {

				name = JOptionPane.showInputDialog(null, "Enter Name",
						"Input Dialog", JOptionPane.INFORMATION_MESSAGE);

				System.out.println(name);
			} else if (e.getSource() == confirm) {
				int option = JOptionPane.showConfirmDialog(null, "Exit",
						"Exit", JOptionPane.YES_NO_CANCEL_OPTION);
				if (option == JOptionPane.YES_OPTION)
					System.exit(0);
				else if (option == JOptionPane.NO_OPTION)
					System.out.println("NO");
				else if (option == JOptionPane.CANCEL_OPTION)
					System.out.println("CANCEL_OPTION");
			}
		}
	}

	// constructor
	public Pop() {
		// button
		error = new JButton("Error");
		error.addActionListener(new ButtonListener());
		info = new JButton("Info");
		info.addActionListener(new ButtonListener());
		warning = new JButton("Warning");
		warning.addActionListener(new ButtonListener());
		question = new JButton("Question");
		question.addActionListener(new ButtonListener());
		input = new JButton("Input Dialog");
		input.addActionListener(new ButtonListener());
		confirm = new JButton("confirm");
		confirm.addActionListener(new ButtonListener());

		// panel
		JPanel panel = new JPanel();

		panel.add(error);
		panel.add(info);
		panel.add(warning);
		panel.add(question);
		panel.add(input);
		panel.add(confirm);

		// Frame
		setContentPane(panel);
		setSize(300, 100);
		setTitle("pop");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
