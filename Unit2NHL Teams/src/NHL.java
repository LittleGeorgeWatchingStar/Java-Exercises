import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Collections;

public class NHL extends JFrame implements ActionListener {

	private JButton btnEastA, btnEastD, btnWestA, btnWestD, btnSearchEast,
			btnSearchWest;
	private JTextArea west, east;
	private String swest, seast, newy;
	private Highlighter hilit;
	private HighlightPainter painter;
	private int index;
	private String[] westname = { "los angeles kings", "winnipeg jets",
			"st. louis blues", "nashville predators", "edmonton oilers",
			"minnesota wild", "arizona coyotes", "dallas stars",
			"calgary flames", "colorado avalanche", "edmonton oilers",
			"chicago blackhawks", "san jose sharks", "vancouver canucks" },
			eastname = { "new york rangers", "philadelphia flyers",
					"boston bruins", "new jersey devils", "buffalo sabres",
					"columbus blue jackets", "detroit red wings",
					"carolina hurricanes", "florida panthers",
					"toronto maple leafs", "montreal canadiens",
					"tampa bay lightning", "ottawa senators",
					"washington capitals", "pittsburgh penguins",
					"new york islanders" };

	public static void main(String[] args) {

		new NHL();
	}

	public NHL() {

		west = new JTextArea(10, 20);
		west.setEditable(false);
		west.setBackground(Color.WHITE);
		west.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		west.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		west.setForeground(Color.BLUE);
		west.setLineWrap(true);
		for (int i = 0; i < 14; i++) {
			west.append(westname[i] + "\n");
		}

		east = new JTextArea(10, 20);
		east.setEditable(false);
		east.setBackground(Color.WHITE);
		east.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		east.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		east.setForeground(Color.BLUE);
		east.setLineWrap(true);
		for (int j = 0; j < 16; j++) {
			east.append(eastname[j] + "\n");
		}
		

		JLabel lblEast = new JLabel(new ImageIcon("east.gif"));
		JLabel lblWest = new JLabel(new ImageIcon("west.gif"));

		Font f = new Font("Arial", Font.BOLD, 10);

		btnEastA = new JButton("ASCEND");
		btnEastA.setPreferredSize(new Dimension(85, 30));
		btnEastA.setFont(f);
		btnEastA.setBackground(Color.BLUE);
		btnEastA.setForeground(Color.WHITE);
		btnEastA.addActionListener(this);
		btnEastD = new JButton("DESCEND");
		btnEastD.setPreferredSize(new Dimension(85, 30));
		btnEastD.setFont(f);
		btnEastD.setBackground(Color.BLUE);
		btnEastD.setForeground(Color.WHITE);
		btnEastD.addActionListener(this);
		btnWestA = new JButton("ASCEND");
		btnWestA.setPreferredSize(new Dimension(85, 30));
		btnWestA.setFont(f);
		btnWestA.setBackground(Color.BLUE);
		btnWestA.setForeground(Color.WHITE);
		btnWestA.addActionListener(this);
		btnWestD = new JButton("DESCEND");
		btnWestD.setPreferredSize(new Dimension(85, 30));
		btnWestD.setFont(f);
		btnWestD.setBackground(Color.BLUE);
		btnWestD.setForeground(Color.WHITE);
		btnWestD.addActionListener(this);

		btnSearchEast = new JButton("SEARCH");
		btnSearchEast.setFont(f);
		btnSearchEast.setBackground(Color.BLUE);
		btnSearchEast.setForeground(Color.WHITE);
		btnSearchEast.setPreferredSize(new Dimension(180, 30));
		btnSearchEast.addActionListener(this);

		btnSearchWest = new JButton("SEARCH");
		btnSearchWest.setFont(f);
		btnSearchWest.setBackground(Color.BLUE);
		btnSearchWest.setForeground(Color.WHITE);
		btnSearchWest.setPreferredSize(new Dimension(180, 30));
		btnSearchWest.addActionListener(this);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridwidth = 2;
		gc.weightx = 100;
		gc.weighty = 100;
		gc.insets = new Insets(5, 5, 5, 5);
		panel.add(lblEast, gc);
		gc.gridx = 2;
		panel.add(lblWest, gc);
		gc.gridx = 0;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.CENTER;
		panel.add(new JScrollPane(east,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), gc);
		gc.gridx = 2;
		panel.add(new JScrollPane(west,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), gc);
		gc.gridx = 0;
		gc.gridy = 2;
		gc.gridwidth = 1;
		gc.anchor = GridBagConstraints.EAST;
		panel.add(btnEastA, gc);
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.WEST;
		panel.add(btnEastD, gc);
		gc.gridx = 2;
		gc.anchor = GridBagConstraints.EAST;
		panel.add(btnWestA, gc);
		gc.gridx = 3;
		gc.anchor = GridBagConstraints.WEST;
		panel.add(btnWestD, gc);
		gc.gridx = 0;
		gc.gridwidth = 2;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.CENTER;
		panel.add(btnSearchEast, gc);
		gc.gridx = 2;
		panel.add(btnSearchWest, gc);

		setContentPane(panel);
		pack();
		setTitle("National Hockey League");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEastA) {
			east.setText("");
			for (int k = 0; k < 16; k++) {
				Arrays.sort(eastname);
				east.append(eastname[k] + "\n");
				east.setCaretPosition(0);
			}
		} else if (e.getSource() == btnEastD) {
			east.setText("");
			Arrays.sort(eastname, Collections.reverseOrder());
			for (int k = 0; k < 16; k++) {
				east.append(eastname[k] + "\n");
				east.setCaretPosition(0);
			}
		} else if (e.getSource() == btnWestA) {
			west.setText("");
			Arrays.sort(westname);
			for (int k = 0; k < 14; k++) {
				west.append(westname[k] + "\n");
				west.setCaretPosition(0);
			}
		} else if (e.getSource() == btnWestD) {
			west.setText("");
			Arrays.sort(westname, Collections.reverseOrder());
			for (int k = 0; k < 14; k++) {
				west.append(westname[k] + "\n");
				west.setCaretPosition(0);
			}
		} else if (e.getSource() == btnSearchEast) {
			Arrays.sort(eastname);

			seast = JOptionPane.showInputDialog(null, "Enter name of a team",
					"Salary Generator", JOptionPane.INFORMATION_MESSAGE);

			// System.out.println(seast);

			if (seast.equals("toronto") || seast.equals("maple leafs")) {
				seast = "toronto maple leafs";
			}else if (seast.equals("boston") || seast.equals("bruins")) {
				seast = "boston bruins";
			}else if (seast.equals("washington") || seast.equals("capitals")) {
				seast = "washington capitals";
			}else if (seast.equals("buffalo") || seast.equals("sabres")) {
				seast = "buffalo sabres";
			}else if (seast.equals("detroit") || seast.equals("red wings")) {
				seast = "detroit red wings";
			}else if (seast.equals("florida") || seast.equals("panthers")) {
				seast = "florida panthers";
			}else if (seast.equals("montreal") || seast.equals("canadiens")) {
				seast = "montreal canadiens";
			}else if (seast.equals("ottawa") || seast.equals("senators")) {
				seast = "ottawa senators";
			}else if (seast.equals("tampa bay") || seast.equals("lightning")) {
				seast = "tampa bay lightning";
			}else if (seast.equals("carolina") || seast.equals("hurricanes")) {
				seast = "carolina hurricanes";
			}else if (seast.equals("columbus") || seast.equals("blue jackets")) {
				seast = "columbus blue jackets";
			}else if (seast.equals("new jersey") || seast.equals("devils")) {
				seast = "new jersey devils";
			}else if (seast.equals("new york")) {
				newy = JOptionPane.showInputDialog(null, "Which team ?",
						"Salary Generator", JOptionPane.INFORMATION_MESSAGE);
				if(newy.equals("islanders")){
					seast = "new york islanders";
				}else if (newy.equals("rangers")){
					seast = "new york rangers";
				}
			}else if (seast.equals("philadelphia") || seast.equals("flyers")) {
				seast = "philadelphia flyers";
			}else if (seast.equals("pittsburgh") || seast.equals("penguins")) {
				seast = "philadelphia flyers";
			}else if (seast.equals("islanders")) {
				seast = "new york islanders";
			}else if (seast.equals("rangers")) {
				seast = "new york rangers";
			}

			index = Arrays.binarySearch(eastname, seast);
			if (index >= 0) {
				JOptionPane.showMessageDialog(null, seast+" is founded", "Information Dialog",
						JOptionPane.PLAIN_MESSAGE);
				hilit = new DefaultHighlighter();
				painter = new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
				east.setHighlighter(hilit);
				String content = east.getText();
				int start = content.indexOf(seast, 0);
				try
				{
				int end = start + seast.length();
				hilit.addHighlight(start, end, painter);
				east.setCaretPosition(end);
				}
				catch (BadLocationException b)
				{}
				east.setCaretPosition(0);
			}

			else {
				JOptionPane.showMessageDialog(null, "Sorry but no team is founded", "Information Dialog",
						JOptionPane.PLAIN_MESSAGE);
			}

		} else if (e.getSource() == btnSearchWest) {
			Arrays.sort(westname);

			swest = JOptionPane.showInputDialog(null, "Enter name of a team",
					"Salary Generator", JOptionPane.INFORMATION_MESSAGE);
			
			if (swest.equals("anaheim") || swest.equals("ducks")) {
				swest = "anaheim ducks";
			}else if (swest.equals("arizona") || swest.equals("coyotes")) {
				swest = "arizona coyotes";
			}else if (swest.equals("calgary") || swest.equals("flames")) {
				swest = "calgary flames";
			}else if (swest.equals("edmonton") || swest.equals("oilers")) {
				swest = "edmonton oilers";
			}else if (swest.equals("los angeles") || swest.equals("kings")) {
				swest = "los angeles kings";
			}else if (swest.equals("san jose") || swest.equals("sharks")) {
				swest = "san jose sharks";
			}else if (swest.equals("vancouver") || swest.equals("canucks")) {
				swest = "vancouver canucks";
			}else if (swest.equals("chicago") || swest.equals("blackhawks")) {
				swest = "chicago blackhawks";
			}else if (swest.equals("colorado") || swest.equals("avalanche")) {
				swest = "colorado avalanche";
			}else if (swest.equals("dallas") || swest.equals("stars")) {
				swest = "dallas stars";
			}else if (swest.equals("minnesota") || swest.equals("wild")) {
				swest = "minnesota wild";
			}else if (swest.equals("nashville") || swest.equals("predators")) {
				swest = "nashville predators";
			}else if (swest.equals("st. louis") || swest.equals("blues")) {
				swest = "minnesota wild";
			}else if (swest.equals("winnipeg jets") || swest.equals("jets")) {
				swest = "winnipeg jets";
			}

			int index = Arrays.binarySearch(westname, swest);
			if (index >= 0) {
				JOptionPane.showMessageDialog(null, swest+" is founded", "Information Dialog",
						JOptionPane.PLAIN_MESSAGE);
				hilit = new DefaultHighlighter();
				painter = new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
				west.setHighlighter(hilit);
				String content = west.getText();
				int start = content.indexOf(swest, 0);
				try
				{
				int end = start + swest.length();
				hilit.addHighlight(start, end, painter);
				west.setCaretPosition(end);
				}
				catch (BadLocationException b)
				{}
				west.setCaretPosition(0);
			}

			else {
				JOptionPane.showMessageDialog(null, "Sorry but no team is founded", "Information Dialog",
						JOptionPane.PLAIN_MESSAGE);
			}
		}
	}
}