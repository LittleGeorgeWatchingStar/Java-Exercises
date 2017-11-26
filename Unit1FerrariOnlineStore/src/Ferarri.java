import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class Ferarri extends JFrame implements ActionListener {
	private JButton checkout, clear;
	private JCheckBox Turbo, Confort, Body, Wheel;
	private JPanel panel;
	private JLabel l1, l2, l3, l4, l5, l6, l7;
	private int a = 255000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ferarri();
	}

	public Ferarri() {
		// create checkboxes
		Turbo = new JCheckBox("2015 QuickSliver Turbo Charger ($8200)", false);
		Turbo.setForeground(Color.RED);
		Turbo.setBounds(340, 145, 340, 20);
		Turbo.addActionListener(this);

		Confort = new JCheckBox("Daytona Style UltraSafe Sports Seats ($2000)",
				false);
		Confort.setForeground(Color.RED);
		Confort.setBounds(340, 175, 340, 20);
		Confort.addActionListener(this);

		Body = new JCheckBox("Carbon Front Wings and Covers ($24000)", false);
		Body.setForeground(Color.RED);
		Body.setBounds(340, 205, 340, 20);
		Body.addActionListener(this);

		Wheel = new JCheckBox("20'' Forged Dark Painted Rims ($3000)", false);
		Wheel.setForeground(Color.RED);
		Wheel.setBounds(340, 235, 340, 20);
		Wheel.addActionListener(this);

		//create labels
		l1 = new JLabel();
		l1.setFont(new Font("Times New Roman", Font.BOLD, 32));
		l1.setForeground(Color.RED);
		l1.setText("Build Your Ferrari Online");
		l1.setBounds(200, 25, 380, 40);

		l2 = new JLabel();
		l2.setFont(new Font("Magneto", Font.ITALIC, 24));
		l2.setForeground(Color.RED);
		l2.setText("Ferrari 458 Speciale");
		l2.setBounds(340, 67, 340, 30);

		//set images to labels
		ImageIcon img = new ImageIcon("1.jpg");
		l3 = new JLabel();
		l3.setIcon(img);
		l3.setBounds(40, 113, 230, 143);

		ImageIcon img2 = new ImageIcon("ferrari-logo.png");
		l4 = new JLabel();
		l4.setIcon(img2);
		l4.setBounds(40, 30, 110, 63);

		//create a label for accessories section
		l5 = new JLabel();
		l5.setFont(new Font("Calibri", Font.BOLD, 16));
		l5.setForeground(Color.RED);
		l5.setText("Select Optional Accessories");
		l5.setBounds(375, 110, 200, 30);

		//give results
		l6 = new JLabel();
		l6.setFont(new Font("Calibri", Font.BOLD, 20));
		l6.setForeground(Color.RED);
		l6.setText("GRAND TOTAL");
		l6.setBounds(200, 285, 130, 20);

		l7 = new JLabel();
		l7.setFont(new Font("Calibri", Font.BOLD, 20));
		l7.setOpaque(true);
		l7.setBackground(Color.WHITE);
		l7.setForeground(Color.RED);
		l7.setText("   $ " + a);
		l7.setBounds(380, 273, 100, 40);

		//create buttons
		checkout = new JButton("CHECKOUT");
		checkout.setOpaque(true);
		checkout.setBackground(Color.RED);
		checkout.setForeground(Color.WHITE);
		checkout.setBounds(180, 330, 160, 30);
		checkout.addActionListener(this);

		clear = new JButton("CLEAR");
		clear.setOpaque(true);
		clear.setBackground(Color.RED);
		clear.setForeground(Color.WHITE);
		clear.setBounds(360, 330, 160, 30);
		clear.addActionListener(this);

		//create main panel and add components
		panel = new JPanel();
		panel.setLayout(null);
		panel.add(l1);
		panel.add(l2);
		panel.add(l3);
		panel.add(l4);
		panel.add(l5);
		panel.add(l6);
		panel.add(l7);
		panel.add(Turbo);
		panel.add(Confort);
		panel.add(Body);
		panel.add(Wheel);
		panel.add(checkout);
		panel.add(clear);

		//frame of main panel construction
		setContentPane(panel);
		setSize(680, 410);

		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Purchase");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
        //add values of accessories
		//turbo
		if (e.getSource() == Turbo) {
			if (Turbo.isSelected()) {
				JOptionPane.showMessageDialog(null,
						"This Option will Cost $8200", "CONFIRM",
						JOptionPane.INFORMATION_MESSAGE);
				a += 8200;
				l7.setText("   $ " + a);
			} else {
				JOptionPane.showMessageDialog(null, "This Option Is Cancelled",
						"CONFIRM", JOptionPane.INFORMATION_MESSAGE);
				a -= 8200;
				l7.setText("   $ " + a);
			}

		}
		//confort
		else if (e.getSource() == Confort) {
			if (Confort.isSelected()) {
				JOptionPane.showMessageDialog(null,
						"This Option will Cost $2000", "CONFIRM",
						JOptionPane.INFORMATION_MESSAGE);
				a += 2000;
				l7.setText("   $ " + a);
			} else {
				JOptionPane.showMessageDialog(null, "This Option Is Cancelled",
						"CONFIRM", JOptionPane.INFORMATION_MESSAGE);
				a -= 2000;
				l7.setText("   $ " + a);
			}

		}
		//body
		else if (e.getSource() == Body) {
			if (Body.isSelected()) {
				JOptionPane.showMessageDialog(null,
						"This Option will Cost $24000", "CONFIRM",
						JOptionPane.INFORMATION_MESSAGE);
				a += 24000;
				l7.setText("   $ " + a);
			}
			if (!Body.isSelected()) {
				JOptionPane.showMessageDialog(null, "This Option Is Cancelled",
						"CONFIRM", JOptionPane.INFORMATION_MESSAGE);
				a -= 24000;
				l7.setText("   $ " + a);
			}

		}

		// Wheel
		else if (e.getSource() == Wheel) {
			if (Wheel.isSelected()) {
				JOptionPane.showMessageDialog(null,
						"This Option will Cost $3000", "CONFIRM",
						JOptionPane.INFORMATION_MESSAGE);
				a += 3000;
				l7.setText("   $ " + a);
			}
			if (!Wheel.isSelected()) {
				JOptionPane.showMessageDialog(null, "This Option Is Cancelled",
						"CONFIRM", JOptionPane.INFORMATION_MESSAGE);
				a -= 3000;
				l7.setText("   $ " + a);
			}

		}
		
		//actions of buttons
		if (e.getSource() == clear) {
			Turbo.setSelected(false);
			Confort.setSelected(false);
			Body.setSelected(false);
			Wheel.setSelected(false);
			a = 255000;
			l7.setText("   $ " + a);
		} else if (e.getSource() == checkout) {
			int option = JOptionPane.showConfirmDialog(null,
					"You Have To Make Payment of $" + a, "Return",
					JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.YES_OPTION)
				System.exit(0);
			else if (option == JOptionPane.NO_OPTION)
				return;
		}

	}

}
