import javax.swing.*;

import java.text.DecimalFormat;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class PrimeNumbers extends JFrame implements ActionListener {
	private JTextArea txtOutput;
	private JButton btnMake, btnClear, btnExit;
	private JLabel lbtitle, lbname;
	private JTextField input;
	private int n = 0, totaln = 0, nodd = 0, neven = 0, nzero = 0, twelve1 = 0,
			twelve2 = 0, twelve3 = 0, half1 = 0, half2 = 0, red = 0, black = 0;
	private DecimalFormat df = new DecimalFormat("0");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PrimeNumbers();
	}

	public PrimeNumbers() {
		// create title label
		lbtitle = new JLabel();
		lbtitle.setFont(new Font("Broadway", Font.ITALIC, 34));
		lbtitle.setForeground(Color.BLUE);
		lbtitle.setText("PRIME NUMBERS  ");

		lbname = new JLabel();
		lbname.setFont(new Font("Magneto", Font.PLAIN, 14));
		lbname.setForeground(Color.BLUE);
		lbname.setText("Enter the range of numbers:  ");

		input = new JTextField(4);
		input.setHorizontalAlignment(SwingConstants.CENTER);

		Dimension d = new Dimension(110, 25);
		btnMake = new JButton("SUBMIT");
		btnMake.setPreferredSize(d);
		btnMake.setBackground(Color.BLUE);
		btnMake.setForeground(Color.WHITE);
		btnMake.setEnabled(true); // false
		btnMake.addActionListener(this);

		btnClear = new JButton("CLEAR");
		btnClear.setPreferredSize(d);
		btnClear.setBackground(Color.BLUE);
		btnClear.setForeground(Color.WHITE);
		btnClear.addActionListener(this);

		btnExit = new JButton("EXIT");
		btnExit.setPreferredSize(d);
		btnExit.setBackground(Color.BLUE);
		btnExit.setForeground(Color.WHITE);
		btnExit.addActionListener(this);

		txtOutput = new JTextArea(24, 24);
		txtOutput.setEditable(false);
		txtOutput.setBackground(Color.WHITE);
		txtOutput.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		txtOutput.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtOutput.setForeground(Color.BLUE);
		txtOutput.setLineWrap(true);

		// set components for main panel
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 4, 12));
		panel.add(lbtitle);
		panel.setBackground(Color.WHITE);
		panel.add(lbname);
		panel.add(input);
		panel.add(btnMake);
		panel.add(btnClear);
		panel.add(btnExit);
		panel.add(new JScrollPane(txtOutput,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));

		// main panel construction
		setContentPane(panel);
		setSize(370, 450);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("BEE.Sieve of Eratosthenes \u00A9 2015");
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnExit) {
			System.exit(0);
		} else if (e.getSource() == btnClear) {
			n = 0;
			txtOutput.setText("");
			input.setText("");
			input.requestFocus();
		} else if (e.getSource() == btnMake) {
			boolean prime = true;
			n = Integer.parseInt(input.getText());
			if (n < 600) {
				for (int i = 2; i <= n; i++) {
					for (int j = 2; j < i; j++) {
						if (i % j == 0)
							prime = false;
					}
					if (prime)
						txtOutput.append(String.format("  "+i));
					prime = true;
				}
			} else {
				JOptionPane.showMessageDialog(null, "Sorry. Please behave.",
						"JButton", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}
