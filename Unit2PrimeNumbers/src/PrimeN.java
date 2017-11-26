import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class PrimeN extends JFrame implements ActionListener {
	private JTextArea txtOutput;
	private JTextField txtRange;
	private JButton btnGenerate, btnClear, btnExit;
	private int num = 0, result = 0;
	private int[] array;

	public static void main(String[] args) {

		new PrimeN();
	}

	public PrimeN() {

		JLabel lblTitle = new JLabel();
		lblTitle.setText("PRIME NUMBERS");
		lblTitle.setPreferredSize(new Dimension(400, 40));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Britannic Bold", Font.PLAIN, 36));

		JLabel lblRange = new JLabel();
		lblRange.setText("Enter the range of numbers:");
		lblRange.setPreferredSize(new Dimension(200, 30));
		lblRange.setHorizontalAlignment(SwingConstants.CENTER);

		txtRange = new JTextField(5);
		txtRange.setHorizontalAlignment(SwingConstants.CENTER);

		btnGenerate = new JButton("GENERATE");
		btnGenerate.setPreferredSize(new Dimension(100, 30));
		btnGenerate.addActionListener(this);

		btnClear = new JButton("CLEAR");
		btnClear.setPreferredSize(new Dimension(100, 30));
		btnClear.addActionListener(this);

		btnExit = new JButton("EXIT");
		btnExit.setPreferredSize(new Dimension(100, 30));
		btnExit.addActionListener(this);

		txtOutput = new JTextArea(16, 22);
		txtOutput.setEditable(false);
		txtOutput.setBackground(Color.WHITE);
		txtOutput.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		txtOutput.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtOutput.setForeground(Color.BLUE);

		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
		panel.add(lblTitle);
		panel.setBackground(Color.WHITE);
		panel.add(Box.createHorizontalStrut(50));
		panel.add(lblRange);
		panel.add(txtRange);
		panel.add(Box.createHorizontalStrut(50));
		panel.add(btnGenerate);
		panel.add(btnClear);
		panel.add(btnExit);
		panel.add(Box.createRigidArea(new Dimension(400, 5)));
		panel.add(new JScrollPane(txtOutput,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));

		setContentPane(panel);
		setSize(400, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Sieve of Eratosthenes");
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnExit) {
			System.exit(0);
		} else if (e.getSource() == btnClear) {
			num = 0;
			txtOutput.setText("");
			txtRange.setText("");
			txtRange.requestFocus();
		} else if (e.getSource() == btnGenerate) {
			num = Integer.parseInt(txtRange.getText());
			array = new int[num];
			boolean isPrime = true;
			for (int i = 1; i < num; i++) {
				array[i] = i + 1;
				System.out.println(array[i]);
				for (int j = 2; j <= array[i]; j++) {
					//System.out.println(j);
					if (array[i]%j == 0)
						
						isPrime = true;
					System.out.println(isPrime);
				}
				if (isPrime)
					
					txtOutput.append(String.format("%-9s", array[i]));
				
				
				isPrime = false;
			}
		}
	}
}
