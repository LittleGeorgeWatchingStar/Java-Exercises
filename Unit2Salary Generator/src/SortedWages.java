import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;

public class SortedWages extends JFrame implements ActionListener {
	private JButton btnAscend, btnDescend, btnGenerate, btnSearch;
	private DecimalFormat df = new DecimalFormat("$ 0.00 million");
	private JTextArea Textofwage;
	private int nemployees;
	private Double salary[];
	private double psearch;
	private Highlighter hilit;
	private HighlightPainter painter;

	public static void main(String[] args) {

		new SortedWages();
	}

	public SortedWages() {

		JLabel lblTitle = new JLabel("SALARY GENERATOR");
		lblTitle.setPreferredSize(new Dimension(300, 30));
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);

		Textofwage = new JTextArea(12, 20);
		Textofwage.setEditable(false);
		Textofwage.setBackground(Color.WHITE);
		Textofwage.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		Textofwage.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		Textofwage.setForeground(Color.BLUE);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4, 1, 5, 5));

		Dimension d = new Dimension(100, 30);

		btnGenerate = new JButton("GENERATE");
		btnGenerate.setPreferredSize(d);
		btnGenerate.setBackground(Color.BLUE);
		btnGenerate.setForeground(Color.WHITE);
		btnGenerate.addActionListener(this);
		btnAscend = new JButton("ASCEND");
		btnAscend.setPreferredSize(d);
		btnAscend.setBackground(Color.BLUE);
		btnAscend.setForeground(Color.WHITE);
		btnAscend.setEnabled(false);
		btnAscend.addActionListener(this);
		btnDescend = new JButton("DESCEND");
		btnDescend.setPreferredSize(d);
		btnDescend.setBackground(Color.BLUE);
		btnDescend.setForeground(Color.WHITE);
		btnDescend.setEnabled(false);
		btnDescend.addActionListener(this);
		btnSearch = new JButton("SEARCH");
		btnSearch.setPreferredSize(d);
		btnSearch.setBackground(Color.BLUE);
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setEnabled(false);
		btnSearch.addActionListener(this);

		buttonPanel.add(btnGenerate);
		buttonPanel.add(btnAscend);
		buttonPanel.add(btnDescend);
		buttonPanel.add(btnSearch);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.add(lblTitle);
		panel.add(new JScrollPane(Textofwage,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
		panel.add(buttonPanel);

		setContentPane(panel);
		setTitle("BEE.Salary Generator \u00A9 2015");
		setSize(330, 280);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGenerate) {
			int act = 1;
			try {
				nemployees = Integer.parseInt(JOptionPane.showInputDialog(null,
						"Enter number of employees", "Salary Generator",
						JOptionPane.INFORMATION_MESSAGE));
			} catch (NumberFormatException axm) {
				act = 0;
				JOptionPane.showMessageDialog(null, "Please Behave", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
			if (act == 1) {
				btnAscend.setEnabled(true);
				btnDescend.setEnabled(true);
				btnSearch.setEnabled(true);

				salary = new Double[nemployees];
				Textofwage.append("  RANK     " + "         SALARY" + "\n");
				for (int i = 0; i < nemployees; i++) {
					salary[i] = (Math.random() * 7 + 8);
					System.out.println(salary[2]);
					int l = i + 1;
					Textofwage.append("     " + l + "\t" + df.format(salary[i])
							+ "\n");
					Textofwage.setCaretPosition(0);
				}
			}
		} else if (e.getSource() == btnAscend) {
			Textofwage.setText("");
			Arrays.sort(salary);
			Textofwage.append("  RANK     " + "         SALARY" + "\n");
			for (int k = 0; k < nemployees; k++) {
				int l = k + 1;
				Textofwage.append("     " + l + "\t" + df.format(salary[k])
						+ "\n");
				Textofwage.setCaretPosition(0);
			}
		} else if (e.getSource() == btnDescend) {
			Textofwage.setText("");
			Arrays.sort(salary, Collections.reverseOrder());
			Textofwage.append("  RANK     " + "         SALARY" + "\n");
			int j = 1;
			for (int k = 0; k < nemployees; k++) {
				Textofwage.append("     " + j + "\t" + df.format(salary[k])
						+ "\n");
				Textofwage.setCaretPosition(0);
				j++;
			}
		} else if (e.getSource() == btnSearch) {
			Arrays.sort(salary);
			psearch =Double.parseDouble(JOptionPane.showInputDialog(null,
					"What amount of salary", "Salary Generator",
					JOptionPane.INFORMATION_MESSAGE));
			String psearchS = String.valueOf(psearch);
			int index = Arrays.binarySearch(salary, psearch);
			if (index >= 0) {
				JOptionPane.showMessageDialog(null, psearch +" is founded", "Information Dialog",
						JOptionPane.PLAIN_MESSAGE);
				hilit = new DefaultHighlighter();
				painter = new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
				Textofwage.setHighlighter(hilit);
				String content = Textofwage.getText();
				int start = content.indexOf(psearchS.length(), 0);
				Textofwage.setCaretPosition(0);
				try
				{
				int end = start + psearchS.length();
				hilit.addHighlight(start, end, painter);
				Textofwage.setCaretPosition(end);
				}
				catch (BadLocationException b)
				{}
			}

			else {
				JOptionPane.showMessageDialog(null, "Sorry but no team is founded", "Information Dialog",
						JOptionPane.PLAIN_MESSAGE);
			}
			
		}
	}

	private String getlength(double psearch2) {
		// TODO Auto-generated method stub
		return null;
	}
}