import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.text.DecimalFormat;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Roulette extends JFrame implements ActionListener {
	private JTextArea txtOutput;
	private JButton btnSpin, btnClear, btnExit;
	private JLabel[] lblResults;
	private int n = 0, totaln = 0, nodd = 0, neven = 0, nzero = 0, twelve1 = 0,
			twelve2 = 0, twelve3 = 0, half1 = 0, half2 = 0, red = 0, black = 0;
	private DecimalFormat df = new DecimalFormat("0.0");
	private double[] percent = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	public static void main(String[] args) {
		new Roulette();
	}

	public Roulette() {
		// create text-area for results
		txtOutput = new JTextArea(30, 32);
		txtOutput.setEditable(false);
		txtOutput.setBackground(new Color(0, 115, 0));
		txtOutput.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		txtOutput.setFont(new Font("Courier New", Font.PLAIN, 14));
		txtOutput.setForeground(Color.LIGHT_GRAY);
		txtOutput.setText(String.format("\n%-2s%-10s%-10s%-10s", "", "ODD",
				"EVEN", "ZERO"));

		// create buttons for main panel
		btnSpin = new JButton("SPIN");
		btnSpin.setPreferredSize(new Dimension(80, 30));
		btnSpin.setFocusable(false);
		btnSpin.addActionListener(this);

		btnClear = new JButton("CLEAR");
		btnClear.setPreferredSize(new Dimension(80, 30));
		btnClear.setFocusable(false);
		btnClear.addActionListener(this);

		btnExit = new JButton("EXIT");
		btnExit.setPreferredSize(new Dimension(80, 30));
		btnExit.setFocusable(false);
		btnExit.addActionListener(this);

		// create main panel
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());

		// set grid-bag layout for main panel
		GridBagConstraints gc = new GridBagConstraints();
		gc.insets = new Insets(5, 5, 5, 5);
		gc.anchor = GridBagConstraints.CENTER;
		gc.gridheight = 10;
		panel.add(new JLabel(new ImageIcon("roulette.png")), gc);
		gc.gridx = 1;
		gc.gridy = 0;
		gc.gridwidth = 3;
		panel.add(new JScrollPane(txtOutput,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), gc);
		gc.gridx = 1;
		gc.gridy = 10;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		panel.add(btnSpin, gc);
		gc.gridx = 2;
		panel.add(btnClear, gc);
		gc.gridx = 3;
		panel.add(btnExit, gc);
		lblResults = new JLabel[10];
		String[] strResults = new String[] { "ODD", "EVEN", "ZERO", "1st 12",
				"2nd 12", "3rd 12", "1-18", "19-36", "RED", "BLACK" };
		gc.gridx = 4;
		gc.gridheight = 1;

		// automatically show the labels on panel
		int yPos = 0;
		for (int i = 0; i < lblResults.length; i++) {
			lblResults[i] = new JLabel();
			lblResults[i].setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createLineBorder(Color.LIGHT_GRAY),
					strResults[i], TitledBorder.DEFAULT_POSITION,
					TitledBorder.DEFAULT_POSITION, new Font("Arial", Font.BOLD,
							12), Color.LIGHT_GRAY));
			lblResults[i].setHorizontalAlignment(SwingConstants.CENTER);
			lblResults[i].setForeground(Color.LIGHT_GRAY);
			lblResults[i].setPreferredSize(new Dimension(90, 40));
			gc.gridy = yPos;
			panel.add(lblResults[i], gc);
			yPos++;
		}

		// main panel construction
		setContentPane(panel);
		setSize(700, 670);
		setTitle("BEE.Roulette \u00a9 2015");
		setLocationRelativeTo(null);
		getRootPane().setDefaultButton(btnSpin);
		getContentPane().setBackground(new Color(0, 115, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		// set action to clear button
		if (e.getSource() == btnClear) {
			n = 0;
			nodd = 0;
			neven = 0;
			nzero = 0;
			totaln = 0;
			twelve1 = 0;
			twelve2 = 0;
			twelve3 = 0;
			half1 = 0;
			half2 = 0;
			red = 0;
			black = 0;
			for (int counter = 0; counter < percent.length; counter++) {
				percent[counter] = 0;
			}
			for (int i = 0; i < lblResults.length; i++) {
				lblResults[i].setText(df.format(percent[i]) + "%");
			}
			txtOutput.setText(String.format("\n%-2s%-10s%-10s%-10s", "", "ODD",
					"EVEN", "ZERO"));
		}

		// set action to exit button
		if (e.getSource() == btnExit) {
			int option = JOptionPane.showConfirmDialog(null,
					"You Sure You Wanna Leave Me?", "Exit",
					JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.YES_OPTION) {
				JOptionPane
						.showMessageDialog(
								null,
								"TNAK YOU FOR PLAYING WITH BEE! \nWELCOME TO COME AGAIN~",
								"BEE \u00a9 2015",
								JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			} else if (option == JOptionPane.NO_OPTION)
				return;
		}

		// set action to calculate button
		if (e.getSource() == btnSpin) {
			totaln++;

			/*
			 * for 1.0 only, traffic does not need to be handled anymore if
			 * (totaln >= 10) { btnClear.doClick();
			 * 
			 * }
			 */
			if (totaln != 0) {
				n = (int) (Math.random() * 38);
				if (n % 2 != 0) {
					if (n == 37) {
						nzero++;
						txtOutput.append(String.format("\n%-2s%-10s%-10s%-10s",
								"", "", "", " 00"));
						txtOutput.setCaretPosition(txtOutput.getDocument()
								.getLength());
					} else {
						nodd++;
						txtOutput.append(String.format("\n%-2s%-10s%-10s%-10s",
								"", " " + n, "", ""));
						txtOutput.setCaretPosition(txtOutput.getDocument()
								.getLength());
					}
				}
				if (n % 2 == 0) {
					if (n == 0) {
						nzero++;
						System.out.println(percent[2]);
						txtOutput.append(String.format("\n%-2s%-10s%-10s%-10s",
								"", "", "", "  " + n));
						txtOutput.setCaretPosition(txtOutput.getDocument()
								.getLength());
					} else {
						neven++;
						txtOutput.append(String.format("\n%-2s%-10s%-10s%-10s",
								"", "", " " + n, ""));
						txtOutput.setCaretPosition(txtOutput.getDocument()
								.getLength());
					}
				}
			} else {
				txtOutput.setText(String.format("\n%-2s%-10s%-10s%-10s", "",
						"ODD", "EVEN", "ZERO"));
			}
			if (n >= 1 && n <= 12) {
				twelve1++;
			}
			if (n >= 13 && n <= 24) {
				twelve2++;
			}
			if (n >= 25 && n <= 36) {
				twelve3++;
			}
			if (n >= 1 && n <= 18) {
				half1++;
			}
			if (n >= 19 && n <= 36) {
				half2++;
			}
			if (n == 1 || n == 3 || n == 5 || n == 7 || n == 9 || n == 12
					|| n == 14 || n == 16 || n == 18 || n == 19 || n == 21
					|| n == 23 || n == 25 || n == 27 || n == 28 || n == 30
					|| n == 32 || n == 34 || n == 36) {
				red++;
			} else if (!(n == 1 || n == 3 || n == 5 || n == 7 || n == 9
					|| n == 12 || n == 14 || n == 16 || n == 18 || n == 19
					|| n == 21 || n == 23 || n == 25 || n == 27 || n == 28
					|| n == 30 || n == 32 || n == 34 || n == 36)) {
				black++;
			}
			percent[0]=(double) nodd / totaln * 100;
			percent[1]=(double) neven / totaln * 100;
			percent[2]=(double) nzero / totaln * 100;
			percent[3]=(double) twelve1 / totaln * 100;
			percent[4]=(double) twelve2 / totaln * 100;
			percent[5]=(double) twelve3 / totaln * 100;
			percent[6]=(double) half1 / totaln * 100;
			percent[7]=(double) half2 / totaln * 100;
			percent[8]=(double) red / totaln * 100;
			percent[9]=(double) black / totaln * 100;
			lblResults[0].setText(df.format(percent[0]) + "%");
			lblResults[1].setText(df.format(percent[1]) + "%");
			lblResults[2].setText(df.format(percent[2]) + "%");
			lblResults[3].setText(df.format(percent[3]) + "%");
			lblResults[4].setText(df.format(percent[4]) + "%");
			lblResults[5].setText(df.format(percent[5]) + "%");
			lblResults[6].setText(df.format(percent[6]) + "%");
			lblResults[7].setText(df.format(percent[7]) + "%");
			lblResults[8].setText(df.format(percent[8]) + "%");
			lblResults[9].setText(df.format(percent[9]) + "%");
		}
	}
}