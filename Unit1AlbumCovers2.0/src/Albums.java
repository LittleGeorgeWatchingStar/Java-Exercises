import javax.swing.*;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.*;

public class Albums extends JFrame implements ActionListener, ItemListener {
	private JRadioButton deng, wu, zhou;
	private JButton clear, exit;
	private JLabel l1, l2;
	private JPanel panel;
	private ButtonGroup group;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Albums();
	}

	public Albums() {
		// Create radio buttons
		deng = new JRadioButton("“ª’£—€-µÀ¿ˆ–¿", false);
		deng.setBackground(Color.WHITE);
		deng.setBounds(30, 130, 120, 20);
		deng.addItemListener(this);

		wu = new JRadioButton("∫›∫›-Œ‚”Íˆ≠", false);
		wu.setBackground(Color.WHITE);
		wu.setBounds(30, 170, 120, 20);
		wu.addItemListener(this);

		zhou = new JRadioButton("∂´∑Á∆∆-÷‹Ω‹¬◊", false);
		zhou.setBackground(Color.WHITE);
		zhou.setBounds(30, 210, 120, 20);
		zhou.addItemListener(this);

		// Create button group for album options
		group = new ButtonGroup();
		group.add(deng);
		group.add(wu);
		group.add(zhou);

		// labels
		l1 = new JLabel();
		l1.setFont(new Font("Calibri", Font.PLAIN, 32));
		l1.setForeground(Color.BLUE);
		l1.setText("   BEE RECORDS");
		l1.setBounds(8, 8, 380, 40);

		l2 = new JLabel();
		l2.setText("           Album Cover Goes Here");
		l2.setBounds(230, 80, 200, 200);

		clear = new JButton("Clear");
		clear.setOpaque(true);
		clear.setBackground(Color.BLUE);
		clear.setForeground(Color.WHITE);
		clear.setToolTipText("Double Click Here");
		clear.setBounds(30, 340, 160, 30);
		clear.addActionListener(this);

		exit = new JButton("Buy Now");
		exit.setOpaque(true);
		exit.setBackground(Color.BLUE);
		exit.setForeground(Color.WHITE);
		exit.setBounds(255, 340, 160, 30);
		exit.addActionListener(this);

		// Create main panel
		panel = new JPanel();
		panel.setLayout(null);
		panel.add(deng);
		panel.add(wu);
		panel.add(zhou);
		panel.add(l1);
		panel.add(l2);
		panel.add(clear);
		panel.add(exit);

		// Set frame properties
		setContentPane(panel);
		setSize(470, 420);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Albums");
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void itemStateChanged(ItemEvent f) {
		JRadioButton selected = (JRadioButton) f.getItem();

		if (selected == deng) {
			ImageIcon imgdeng = new ImageIcon("1.jpg");
			l2.setIcon(imgdeng);
		}

		else if (selected.equals(wu)) {
			ImageIcon imgwu = new ImageIcon("2.jpg");
			l2.setIcon(imgwu);
		}

		else if (selected.equals(zhou)) {
			ImageIcon imggray = new ImageIcon("3.jpg");
			l2.setIcon(imggray);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == clear) {
			group.clearSelection();
			l2.setIcon(null);
		} else if (e.getSource() == exit) {

			int option = JOptionPane.showConfirmDialog(null,
					"You Want To Make Payment Now?", "Confirm",
					JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.YES_OPTION)
				System.exit(0);
			else if (option == JOptionPane.NO_OPTION)
				return;
		}
	}
}