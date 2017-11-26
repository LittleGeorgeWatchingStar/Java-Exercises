import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class MemoryGame extends JFrame implements ActionListener {
	private JPanel panel;
	private JLabel lblTimer, lblTime, lblresult;
	private JButton btnStart, btnExit;
	private JButton[][] b;
	private int rows, cols, i, j, w, x, y, z;
	private Timer timer;
	private int mins, seconds, num, random, counter, wcom;
	private DecimalFormat df = new DecimalFormat("00");
	private int[] logonum, comp, refer;
	private int[][] reme;
	private ImageIcon[] img;

	public static void main(String[] args) {
		new MemoryGame();
	}

	public MemoryGame() {
		seconds = 0;
		timer = new Timer(1000, this);

		logonum = new int[8];
		comp = new int[8];
		refer = new int[2];
		img = new ImageIcon[8];
		reme = new int[4][4];
		img[0] = new ImageIcon("49ers.gif");
		img[1] = new ImageIcon("bills.gif");
		img[2] = new ImageIcon("broncos.gif");
		img[3] = new ImageIcon("chiefs.gif");
		img[4] = new ImageIcon("colts.gif");
		img[5] = new ImageIcon("dolphins.gif");
		img[6] = new ImageIcon("giants.gif");
		img[7] = new ImageIcon("patriots.gif");

		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

		JLabel lblTitle = new JLabel("MEMORY GAME");
		lblTitle.setPreferredSize(new Dimension(700, 30));
		lblTitle.setFont(new Font("Britannic Bold", Font.BOLD, 28));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(Color.BLUE);
		panel.add(lblTitle);

		b = new JButton[5][5];
		Dimension d = new Dimension(150, 100);
		for (rows = 0; rows < 4; rows++) {
			for (cols = 0; cols < 4; cols++) {
				b[rows][cols] = new JButton("");
				b[rows][cols].setPreferredSize(d);
				b[rows][cols].setMargin(new Insets(0, 0, 0, 0));
				b[rows][cols].setBorder(BorderFactory.createEmptyBorder());
				// [rows][cols].setContentAreaFilled(false);
				b[rows][cols].setBackground(Color.WHITE);
				b[rows][cols].setEnabled(false);
				b[rows][cols].addActionListener(this);
			}
		}

		// create a grid panel for buttons
		JPanel gridpanel = new JPanel();
		gridpanel.setLayout(new GridLayout(4, 4, 0, 0));
		for (rows = 0; rows < 4; rows++) {
			for (cols = 0; cols < 4; cols++) {
				gridpanel.add(b[rows][cols]);
			}
		}
		
		lblTime = new JLabel("ELAPSED TIME:");
		lblTime.setFont(new Font("Britannic Bold", Font.BOLD, 18));
		lblTime.setForeground(Color.BLUE);

		lblTimer = new JLabel();
		lblTimer.setPreferredSize(new Dimension(100, 20));
		lblTimer.setFont(new Font("Britannic Bold", Font.BOLD, 18));
		lblTimer.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimer.setForeground(Color.BLUE);
		lblTimer.setText(df.format(mins) + ":" + df.format(seconds));

		lblresult = new JLabel();
		lblresult.setPreferredSize(new Dimension(600, 20));
		lblresult.setFont(new Font("Britannic Bold", Font.BOLD, 18));
		lblresult.setHorizontalAlignment(SwingConstants.CENTER);
		lblresult.setForeground(Color.BLUE);
		lblresult.setText("");

		btnStart = new JButton("START");
		btnStart.setPreferredSize(new Dimension(606, 30));
		btnStart.setFocusable(false);
		btnStart.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnStart.setForeground(Color.WHITE);
		btnStart.setBackground(Color.BLUE);
		btnStart.addActionListener(this);

		btnExit = new JButton("EXIT");
		btnExit.setPreferredSize(new Dimension(606, 30));
		btnExit.setFocusable(false);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.setForeground(Color.WHITE);
		btnExit.setBackground(Color.BLUE);
		btnExit.addActionListener(this);

		panel.setBackground(Color.WHITE);
		panel.add(gridpanel);
		panel.add(btnStart);
		panel.add(lblTime);
		panel.add(lblTimer);

		setContentPane(panel);
		setSize(700, 670);
		setTitle("Memory Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (wcom == 8) {
			timer.stop();
			lblresult.setText("You have cleaned up all " + wcom + " set(s).");
			JOptionPane.showMessageDialog(null, "congrats, you made it in "
					+ mins + " minute(s) and " + seconds + " second(s)",
					"Information Dialog", JOptionPane.INFORMATION_MESSAGE);
			wcom = 0;
			int option = JOptionPane.showConfirmDialog(null, "Play again?",
					"BEE \u00a9 2015", JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.NO_OPTION) {
				JOptionPane
						.showMessageDialog(
								null,
								"TNAK YOU SO MUCH FOR CHOOSING BEE! \nWELCOME TO COME AGAIN SOON~",
								"BEE \u00a9 2015",
								JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			} else if (option == JOptionPane.YES_OPTION){
			for (rows = 0; rows < 4; rows++) {
				for (cols = 0; cols < 4; cols++) {
					b[rows][cols].setText("");
					b[rows][cols].setIcon(null);
					b[rows][cols].setBackground(Color.WHITE);
					b[rows][cols].setEnabled(false);
				}
			}
			seconds = 0; mins = 0;counter = 0; wcom = 0;
			panel.remove(btnExit);
			panel.add(btnStart);
			panel.add(lblTime);
			panel.add(lblTimer);
			panel.add(lblresult);
			lblTimer.setText(df.format(mins) + ":" + df.format(seconds));
			lblresult.setText("You have cleaned up " + wcom + " set(s).");
			}
		} else if (counter == 2) {
			for (i = 0; i < 4; i++) {
				for (j = 0; j < 4; j++) {
					if (comp[0] == 2 || comp[1] == 2 || comp[2] == 2
							|| comp[3] == 2 || comp[4] == 2 || comp[5] == 2
							|| comp[6] == 2 || comp[7] == 2) {

						for (num = 0; num < 8; num++) {
							comp[num] = 0;
						}
						counter = 0;
						wcom++;
						b[w][x].setEnabled(false);
						b[y][z].setEnabled(false);
						b[w][x].setIcon(null);
						b[y][z].setIcon(null);
						b[w][x].setBackground(Color.RED);
						b[y][z].setBackground(Color.RED);
						w = 4;
						x = 4;
						y = 4;
						z = 4;
//						JOptionPane.showMessageDialog(null,
//								"You found a match", "Information Dialog",
//								JOptionPane.WARNING_MESSAGE);
						return;
					} else {
						counter = 0;
						for (num = 0; num < 8; num++) {
							comp[num] = 0;
						}
						b[w][x].setIcon(null);
						b[y][z].setIcon(null);
						b[w][x].setBackground(Color.WHITE);
						b[y][z].setBackground(Color.WHITE);
						w = 4;
						x = 4;
						y = 4;
						z = 4;
//						JOptionPane.showMessageDialog(null, "No match",
//								"Dialog", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
			}
		} else if (e.getSource() == btnExit) {
			System.exit(0);
		} else if (e.getSource() == btnStart) {
			w = 4; x = 4; y = 4; z = 4;
			seconds = 0; mins = 0;counter = 0; wcom = 0;
			for (num = 0; num < 8; num++) {
				logonum[num] = 0;
			}
			for (num = 0; num < 8; num++) {
				comp[num] = 0;
			}
			for (num = 0; num < 1; num++) {
				refer[num] = 0;
			}
			for (i = 0; i < 4; i++) {
				for (j = 0; j < 4; j++) {
					do {
						random = (int) (Math.random() * 8);
						reme[i][j] = random;
						logonum[random]++;
					} while (logonum[random] > 2);

				}
			}
			
			for (rows = 0; rows < 4; rows++) {
				for (cols = 0; cols < 4; cols++) {
					b[rows][cols].setEnabled(true);
				}
			}
			timer.start();
			panel.remove(btnStart);
			panel.add(btnExit);
			panel.add(lblTime);
			panel.add(lblTimer);
			panel.add(lblresult);
		} else if (e.getSource() != b[0][0] && e.getSource() != b[0][1]
				&& e.getSource() != b[0][2] && e.getSource() != b[0][3]
				&& e.getSource() != b[1][0] && e.getSource() != b[1][1]
				&& e.getSource() != b[1][2] && e.getSource() != b[1][3]
				&& e.getSource() != b[2][0] && e.getSource() != b[2][1]
				&& e.getSource() != b[2][2] && e.getSource() != b[2][3]
				&& e.getSource() != b[3][0] && e.getSource() != b[3][1]
				&& e.getSource() != b[3][2] && e.getSource() != b[3][3]) {
			seconds++;
			if (seconds > 59) {
				seconds = 0;
				mins++;
			}
			lblTimer.setText(df.format(mins) + ":" + df.format(seconds));
			lblresult.setText("You have cleaned up " + wcom + " set(s).");
		}
		for (i = 0; i < 4; i++) {
			for (j = 0; j < 4; j++) {
				if (e.getSource() == b[i][j]) {
					counter++;
					b[i][j].setIcon(img[reme[i][j]]);
					comp[reme[i][j]]++;
					if (counter == 1) {
						w = i;
						x = j;
					} else if (counter == 2) {
						y = i;
						z = j;
						if (w == y && x == z) {
							counter = 1;
							comp[reme[i][j]] = 1;
							y = 4;
							z = 4;
							b[w][x].setIcon(img[reme[i][j]]);
//							 b[w][x].setIcon(null);
//							 b[w][x].setBackground(Color.WHITE);
							return;
						}
					}
				}
			}
		}
	}
}