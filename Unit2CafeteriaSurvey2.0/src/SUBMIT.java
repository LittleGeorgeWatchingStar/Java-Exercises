import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class SUBMIT extends JFrame implements ActionListener {

	int[] marks = { 0, 0, 0, 0, 0, 0, 0, 0 };

	private static String repeat(String str, int times) {
		StringBuilder repeatit = new StringBuilder();
		for (int i = 0; i < times; i++)
			repeatit.append(str);
		return repeatit.toString();
	}

	private JLabel titlelabel, results;
	private JComboBox<String> levels;
	private JButton calculate, clear;
	private JTextArea txtArea;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SUBMIT();
	}

	public SUBMIT() {
		titlelabel = new JLabel();
		titlelabel.setFont(new Font("Broadway", Font.ITALIC, 18));
		titlelabel.setForeground(Color.BLUE);
		titlelabel.setText("Rate Cafeteria Food:  ");

		results = new JLabel();
		results.setFont(new Font("Broadway", Font.ITALIC, 18));
		results.setForeground(Color.BLUE);
		results.setText("Survey Results:");

		// set up combox
		String[] bglevels = { "-Choose a rate -", "level 1 Very Awful",
				"level 2", "level 3", "level 4 Kinda Bad", "level 5 Kinda Good", "level 6",
				"level 7", "level 8 Excellent" };
		levels = new JComboBox<String>(bglevels);
		levels.addActionListener(this);

		Dimension d = new Dimension(220, 30);
		calculate = new JButton("SUBMIT");
		calculate.setPreferredSize(d);
		calculate.setBackground(Color.BLUE);
		calculate.setForeground(Color.WHITE);
		calculate.setEnabled(false);
		calculate.addActionListener(this);

		clear = new JButton("CLEAR");
		clear.setPreferredSize(d);
		clear.setBackground(Color.BLUE);
		clear.setForeground(Color.WHITE);
		clear.addActionListener(this);

		txtArea = new JTextArea(10, 20);

		// set buttons for main panel
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		panel.add(titlelabel);
		panel.setBackground(Color.WHITE);
		panel.add(levels);
		panel.add(calculate);
		panel.add(clear);
		panel.add(results);
		panel.add(new JScrollPane(txtArea,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));

		// main panel construction
		setContentPane(panel);
		setSize(400, 450);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("BEE ONLINE SURVEY \u00A9 2015");
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == clear) {
			txtArea.setText("");
			calculate.setEnabled(false);
			levels.setSelectedIndex(0);
			for (int counter = 0; counter < marks.length; counter++) {

				marks[counter] = 0;

			}
			if (levels.getSelectedIndex() == 0) {
				return;
			}
		}
		if (e.getSource() == levels) {
			
			if (levels.getSelectedIndex() == 0) {
				/* optional
				 * JOptionPane.showMessageDialog(null, "Sorry. Please rate.",
						"JButton", JOptionPane.INFORMATION_MESSAGE);
						*/ 
			}

		}
		if (marks[0] == 0 || marks[1] == 0 || marks[2] == 0 || marks[3] == 0
				|| marks[4] == 0 || marks[5] == 0 || marks[6] == 0
				|| marks[7] == 0) {
			calculate.setEnabled(true);
		}
		if (e.getSource() == calculate) {
			if (levels.getSelectedIndex() == 1) {
				marks[0] += 1;
			} else if (levels.getSelectedIndex() == 2) {
				marks[1] = marks[1] + 1;
			} else if (levels.getSelectedIndex() == 3) {
				marks[2] = marks[2] + 1;
			} else if (levels.getSelectedIndex() == 4) {
				marks[3] = marks[3] + 1;
			} else if (levels.getSelectedIndex() == 5) {
				marks[4] = marks[4] + 1;
			} else if (levels.getSelectedIndex() == 6) {
				marks[5] = marks[5] + 1;
			} else if (levels.getSelectedIndex() == 7) {
				marks[6] = marks[6] + 1;
			} else if (levels.getSelectedIndex() == 8) {
				marks[7] = marks[7] + 1;
			}

			{
				txtArea.setText("               Rate                  Frequency"+"\n"
						+ "             Level 1                     "
						+ repeat("*", marks[0])
						+ "\n"
						+ "             Level 2                     "
						+ repeat("*", marks[1])
						+ "\n"
						+ "             Level 3                     "
						+ repeat("*", marks[2])
						+ "\n"
						+ "             Level 4                     "
						+ repeat("*", marks[3])
						+ "\n"
						+ "             Level 5                     "
						+ repeat("*", marks[4])
						+ "\n"
						+ "             Level 6                     "
						+ repeat("*", marks[5])
						+ "\n"
						+ "             Level 7                     "
						+ repeat("*", marks[6])
						+ "\n"
						+ "             Level 8                     "
						+ repeat("*", marks[7]));
			}
		}
	}
}
