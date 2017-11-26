import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class SuperBowl extends JFrame implements ActionListener {

	private JButton btnSimulate, btnClear, btnExit;
	private JTextArea output;
	private JLabel lblMessage;
	private int[][] scores;
	private int rows, cols, Lam, Fer, nlam, nfer;

	public static void main(String[] args) {
		new SuperBowl();
	}

	public SuperBowl() {
		output = new JTextArea(5, 34);
		output.setEditable(false);
		output.setBackground(Color.WHITE);
		output.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		output.setForeground(Color.BLUE);
		// output.setBorder(BorderFactory.createLineBorder(Color.BLUE));

		scores = new int[6][2];
		for (rows = 0; rows < 5; rows++) {

			for (cols = 0; cols < 2; cols++) {
				scores[rows][cols] = 0;
			}

		}
		output.setText("\n" + "\t" + "          1     " + " 2     "
				+ " 3     " + " 4     " + " OT " + "      FINAL");
		output.append("\n");
		output.append(String.format("%-22s%-7d%-7d%-7d%-9d%-13d%-13d\n",
				"     LAMBOR", scores[0][0], scores[1][0], scores[2][0],
				scores[3][0], scores[4][0], scores[5][0]));
		output.append(String.format("%-23s%-7d%-7d%-7d%-9d%-13d%-13d",
				"     FERRARI", scores[0][1], scores[1][1], scores[2][1],
				scores[3][1], scores[4][1], scores[5][1]));

		JLabel lblPackers = new JLabel(new ImageIcon("logo.png"));
		lblPackers.setPreferredSize(new Dimension(100, 75));
		lblPackers.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblSteelers = new JLabel(new ImageIcon("logo_ferrari.png"));
		lblSteelers.setPreferredSize(new Dimension(100, 75));
		lblSteelers.setHorizontalAlignment(SwingConstants.CENTER);

		btnSimulate = new JButton("SIMULATE");
		btnSimulate.setPreferredSize(new Dimension(100, 30));
		btnSimulate.setBackground(Color.BLUE);
		btnSimulate.setForeground(Color.WHITE);
		btnSimulate.addActionListener(this);

		btnClear = new JButton("CLEAR");
		btnClear.setPreferredSize(new Dimension(100, 30));
		btnClear.setBackground(Color.BLUE);
		btnClear.setForeground(Color.WHITE);
		btnClear.addActionListener(this);

		btnExit = new JButton("EXIT");
		btnExit.setPreferredSize(new Dimension(100, 30));
		btnExit.setBackground(Color.BLUE);
		btnExit.setForeground(Color.WHITE);
		btnExit.addActionListener(this);

		lblMessage = new JLabel("Click SIMULATE to begin!");
		lblMessage.setPreferredSize(new Dimension(500, 30));
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setForeground(Color.BLUE);

		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		panel.setBackground(Color.WHITE);
		panel.add(lblPackers);
		panel.add(Box.createHorizontalStrut(10));
		panel.add(output);
		panel.add(Box.createHorizontalStrut(10));
		panel.add(lblSteelers);
		panel.add(btnSimulate);
		panel.add(btnClear);
		panel.add(btnExit);
		panel.add(lblMessage);

		setContentPane(panel);
		setSize(680, 210);
		setTitle("BEE. WASHINGTON'S PISTON CUP \u00A9 2015");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnExit) {
			System.exit(0);
		} else if (e.getSource() == btnClear) {
			for (rows = 0; rows < 6; rows++) {
				for (cols = 0; cols < 2; cols++) {
					scores[rows][cols] = 0;
				}
			}
			output.setText("\n" + "\t" + "          1     " + " 2     "
					+ " 3     " + " 4     " + " OT " + "      FINAL");
			output.append("\n");
			output.append(String.format("%-22s%-7d%-7d%-7d%-9d%-13d%-13d\n",
					"     LAMBOR", scores[0][0], scores[1][0], scores[2][0],
					scores[3][0], scores[4][0], scores[5][0]));
			output.append(String.format("%-23s%-7d%-7d%-7d%-9d%-13d%-13d",
					"     FERRARI", scores[0][1], scores[1][1], scores[2][1],
					scores[3][1], scores[4][1], scores[5][1]));
			lblMessage.setText("Click SIMULATE to begin!");
		} else if (e.getSource() == btnSimulate) {
			scores[4][0] =0;
			scores[5][0] =0;
			scores[4][1] =0;
			scores[5][1] =0;
			for (rows = 0; rows < 4; rows++) {
				for (cols = 0; cols < 2; cols++) {
					scores[rows][cols] = (int) (Math.random() * 3);
				}
			}
			output.setText("\n" + "\t" + "          1     " + " 2     "
					+ " 3     " + " 4     " + " OT " + "      FINAL");
			output.append("\n");
			
			Lam= scores[0][0]+ scores[1][0]+ scores[2][0]+
					scores[3][0];
			Fer= scores[0][1]+ scores[1][1]+ scores[2][1]+
					scores[3][1];
			if (Lam == Fer){
				while(scores[4][0] == scores[4][1]){
					scores[4][0]=(int) (Math.random() * 2);
					scores[4][1]=(int) (Math.random() * 2);
				}
			}
			scores[5][0]=scores[0][0]+ scores[1][0]+ scores[2][0]+
					scores[3][0]+scores[4][0]+ scores[5][0];
			scores[5][1]=scores[0][1]+ scores[1][1]+ scores[2][1]+
					scores[3][1]+scores[4][1]+ scores[5][1];
			output.append(String.format("%-22s%-7d%-7d%-7d%-9d%-13d%-13d\n",
					"     LAMBOR", scores[0][0], scores[1][0], scores[2][0],
					scores[3][0], scores[4][0], scores[5][0]));
			output.append(String.format("%-23s%-7d%-7d%-7d%-9d%-13d%-13d",
					"     FERRARI", scores[0][1], scores[1][1], scores[2][1],
					scores[3][1], scores[4][1], scores[5][1]));
			if(scores[5][0]>scores[5][1]){
				lblMessage.setText("Lambo Team Is The Champion!");
				nlam++;
			}else{
				lblMessage.setText("Ferrari Team Is The Champion!");
				nfer++;
			}
		}
	}
}
