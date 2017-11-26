import javax.swing.*;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.*;

public class Radio extends JFrame implements ActionListener, ItemListener {
	private JRadioButton gold, silver, black;
	private JButton buynow;
	private JLabel l1, l2;
	private JPanel panel;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Radio();
	}

	public Radio() {
		// Create radio buttons
		gold = new JRadioButton("iPhone 6 Gold");
		gold.setBackground(Color.WHITE);
		gold.setBounds(5, 30, 120, 20);
		gold.addItemListener(this);

		silver = new JRadioButton("iPhone 6 silver");
		silver.setBackground(Color.WHITE);
		silver.setBounds(5, 60, 120, 20);
		silver.addItemListener(this);

		black = new JRadioButton("iPhone 6 gray");
		black.setBackground(Color.WHITE);
		black.setBounds(5, 90, 120, 20);
		black.addItemListener(this);

		// Create button group for soup options
		ButtonGroup group = new ButtonGroup();
		group.add(gold);
		group.add(silver);
		group.add(black);

		// Create soup panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBorder(BorderFactory
				.createTitledBorder("Choose a finish"));
		buttonPanel.setLayout(null);
		buttonPanel.add(gold);
		buttonPanel.add(silver);
		buttonPanel.add(black);
		buttonPanel.setBackground(Color.WHITE);
		buttonPanel.setBounds(70, 220, 140, 120);

		// labels
		l1 = new JLabel();
		l1.setFont(new Font("Calibri", Font.PLAIN, 32));
		l1.setForeground(Color.BLUE);
		l1.setText("Bigger than bigger");
		l1.setBounds(20, 80, 380, 40);

		ImageIcon img = new ImageIcon("iphone6-select-2014.png");

		l2 = new JLabel();
		l2.setIcon(img);
		l2.setBounds(285, 50, 470, 556);

		buynow = new JButton("Buy Now");
		buynow.setOpaque(true);
		buynow.setBackground(Color.BLUE);
		buynow.setForeground(Color.WHITE);
		buynow.setBounds(60, 380, 160, 30);
		buynow.addActionListener(this);

		// Create main panel
		panel = new JPanel();
		panel.setLayout(null);
		panel.add(l1);
		panel.add(buttonPanel);
		panel.add(l2);
		panel.add(buynow);

		// Set frame properties
		setContentPane(panel);
		setSize(750, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Apple");
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void itemStateChanged(ItemEvent e) {
		JRadioButton selected = (JRadioButton) e.getItem();

		if (selected == gold) {
			System.out.println("okay");
			ImageIcon imggold = new ImageIcon("iphone6-gold-select-2014.png");
			l2.setIcon(imggold);

		}

		else if (selected.equals(silver)) {
			ImageIcon imgsilver = new ImageIcon(
					"iphone6-silver-select-2014.png");
			l2.setIcon(imgsilver);
		}

		else if (selected.equals(black)) {
			ImageIcon imggray = new ImageIcon("iphone6-gray-select-2014.png");
			l2.setIcon(imggray);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buynow) {
			int option = JOptionPane.showConfirmDialog(null,
					"You Want To Make Payment Now?", "Return",
					JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.YES_OPTION)
				System.exit(0);
			else if (option == JOptionPane.NO_OPTION)
				return;
		}
	}
}
