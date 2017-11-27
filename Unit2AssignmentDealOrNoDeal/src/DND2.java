import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class DND2 extends JFrame implements ActionListener {
	private JLabel lblMessage, lblPlayersCase;
	private JLabel[][] Moneyslabel;
	private JButton[][] Casesbuttons;
	private ImageIcon[][] Casesicon;
	private ImageIcon[][] Moneyicon;
	private boolean Firstcases = false, Playagain = false;
	private ImageIcon FirstcasesImg, lastCaseImg, tempCaseImg;
	private int Remainingbox = 26, Box2choose = 5, Round = 1,
			FirstcasesValue = 0, Num = 0;
	private double Sum = 0, Offer = 0;
	private String[] boxesRemainingString = { "zero(0)", "one(1)", "two(2)",
			"three(3)", "four(4)", "five(5)", "six(6)" }, deal = { "DEAL!",
			"NO DEAL!" };
	private int[] value = { 0, 1, 5, 10, 25, 50, 75, 100, 200, 300, 400, 500,
			750, 1000, 5000, 10000, 25000, 50000, 75000, 100000, 200000,
			300000, 400000, 500000, 750000, 1000000 };
	private double[] Moneyvalues = { 0.01, 1, 5, 10, 25, 50, 75, 100, 200, 300,
			400, 500, 750, 1000, 5000, 10000, 25000, 50000, 75000, 100000,
			200000, 300000, 400000, 500000, 750000, 1000000 };
	private DecimalFormat df = new DecimalFormat("#,###,###.##");

	public static void main(String[] args) {

		new DND2();
	}

	public DND2() {
		// Create icons for money
		Moneyicon = new ImageIcon[2][13];
		Moneyicon[0][0] = new ImageIcon("0.01.png");
		Moneyicon[0][1] = new ImageIcon("1.png");
		Moneyicon[0][2] = new ImageIcon("5.png");
		Moneyicon[0][3] = new ImageIcon("10.png");
		Moneyicon[0][4] = new ImageIcon("25.png");
		Moneyicon[0][5] = new ImageIcon("50.png");
		Moneyicon[0][6] = new ImageIcon("75.png");
		Moneyicon[0][7] = new ImageIcon("100.png");
		Moneyicon[0][8] = new ImageIcon("200.png");
		Moneyicon[0][9] = new ImageIcon("300.png");
		Moneyicon[0][10] = new ImageIcon("400.png");
		Moneyicon[0][11] = new ImageIcon("500.png");
		Moneyicon[0][12] = new ImageIcon("750.png");
		Moneyicon[1][0] = new ImageIcon("1000.png");
		Moneyicon[1][1] = new ImageIcon("5000.png");
		Moneyicon[1][2] = new ImageIcon("10000.png");
		Moneyicon[1][3] = new ImageIcon("25000.png");
		Moneyicon[1][4] = new ImageIcon("50000.png");
		Moneyicon[1][5] = new ImageIcon("75000.png");
		Moneyicon[1][6] = new ImageIcon("100000.png");
		Moneyicon[1][7] = new ImageIcon("200000.png");
		Moneyicon[1][8] = new ImageIcon("300000.png");
		Moneyicon[1][9] = new ImageIcon("400000.png");
		Moneyicon[1][10] = new ImageIcon("500000.png");
		Moneyicon[1][11] = new ImageIcon("750000.png");
		Moneyicon[1][12] = new ImageIcon("1000000.png");

		// Create buttons icons for cases
		Moneyslabel = new JLabel[2][13];
		Casesicon = new ImageIcon[2][13];
		Casesbuttons = new JButton[2][13];
		for (int i = 0; i < 13; i++) {
			Casesicon[0][i] = new ImageIcon("case" + (i + 1) + ".png");
		}
		for (int i = 0; i < 13; i++) {
			Casesicon[1][i] = new ImageIcon("case" + (i + 14) + ".png");
		}
		
		// Set icons to labels of money and set buttons for cases
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 13; j++) {
				Casesbuttons[i][j] = new JButton();
				Casesbuttons[i][j].setIcon(Casesicon[i][j]);
				Casesbuttons[i][j].setBackground(Color.BLACK);
				Casesbuttons[i][j].setBorder(BorderFactory.createEmptyBorder());
				Casesbuttons[i][j].addActionListener(this);
				Moneyslabel[i][j] = new JLabel();
				Moneyslabel[i][j].setIcon(Moneyicon[i][j]);
			}
		}

		// Create title label of image
		JLabel lblTitle = new JLabel();
		lblTitle.setIcon(new ImageIcon("dond_logo.png"));
		lblTitle.setPreferredSize(new Dimension(660, 90));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		// Set title label to north panel
		JPanel northPanel = new JPanel();
		northPanel.setBackground(Color.BLACK);
		northPanel.add(lblTitle);
		// Set 13 of money labels to west panel
		JPanel westPanel = new JPanel();
		westPanel.setLayout(new GridLayout(13, 1, 10, 0));
		westPanel.setBackground(Color.BLACK);
		for (int i = 0; i < 13; i++) {
			westPanel.add(Moneyslabel[0][i]);
		}
		// Set the other 13 of money labels to east panel
		JPanel eastPanel = new JPanel();
		eastPanel.setLayout(new GridLayout(13, 1, 10, 0));
		eastPanel.setBackground(Color.BLACK);
		for (int i = 0; i < 13; i++) {
			eastPanel.add(Moneyslabel[1][i]);
		}
		// Set first 20 buttons to the first case panel
		JPanel casePanel1 = new JPanel();
		casePanel1.setBackground(Color.BLACK);
		casePanel1.setLayout(new GridLayout(4, 5, 20, 20));
		for (int i = 0; i < 13; i++) {
			casePanel1.add(Casesbuttons[0][i]);
		}
		for (int i = 0; i < 7; i++) {
			casePanel1.add(Casesbuttons[1][i]);
		}
		// Set last 6 buttons to the second case panel
		JPanel casePanel2 = new JPanel();
		casePanel2.setBackground(Color.BLACK);
		casePanel2.setLayout(new GridLayout(1, 6, 20, 20));
		for (int i = 7; i < 13; i++) {
			casePanel2.add(Casesbuttons[1][i]);
		}
		// Set 2 case panels to center panel
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
		centerPanel.setBackground(Color.BLACK);
		centerPanel.add(casePanel1);
		centerPanel.add(casePanel2);

		// Create message label to south panel
		lblMessage = new JLabel();
		lblMessage.setPreferredSize(new Dimension(430, 50));
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setFont(new Font("Arial", Font.BOLD, 18));
		lblMessage.setForeground(new Color(252, 234, 151));
		lblMessage.setVerticalAlignment(SwingConstants.TOP);
		lblMessage.setText("Choose one of the briefcases!");

		// Create player's case to south panel
		lblPlayersCase = new JLabel();
		lblPlayersCase.setPreferredSize(new Dimension(100, 50));
		lblPlayersCase.setHorizontalAlignment(SwingConstants.CENTER);

		// Set message label and player's case to south panel
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		southPanel.setBackground(Color.BLACK);
		southPanel.add(lblPlayersCase);
		southPanel.add(lblMessage);
		southPanel.add(Box.createRigidArea(new Dimension(100, 50)));

		// Set north, west, east, south panel to the main panel
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBackground(Color.BLACK);
		mainPanel.add(northPanel, BorderLayout.NORTH);
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		mainPanel.add(eastPanel, BorderLayout.EAST);
		mainPanel.add(westPanel, BorderLayout.WEST);
		mainPanel.add(southPanel, BorderLayout.SOUTH);

		// Main panel construction
		setContentPane(mainPanel);
		setSize(680, 550);
		setTitle("Deal or No Deal");
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 2; i++) {
			for (int k = 0; k < 13; k++) {
				if (e.getSource() == Casesbuttons[i][k]) {
					if (!Firstcases) {
						
						// Way of shuffling the value of array from Internet 
						for (int j = value.length - 1; j >= 0; j--) {
							int index = (int) (Math.random() * (j + 1));
							int a = value[index];
							value[index] = value[j];
							value[j] = a;
						}
						
						// Cheat code
						for (int j = 0; j < 26; j++) {
							if (value[j] == 1000000) {
								System.out.println(j + 1);
							}
						}
						
						// Choose the first case
						Num = 13 * i + k;
						lblPlayersCase.setIcon(Casesicon[i][k]);
						FirstcasesImg = Casesicon[i][k];
						FirstcasesValue = value[Num];
						Casesbuttons[i][k].setVisible(false);
						Firstcases = true;
						lblMessage.setText("Open six(6) briefcases!");
						Box2choose = 6;
						Playagain = false;
					} else {			
						Num = 13 * i + k;
						tempCaseImg = Casesicon[i][k];
						
						// Open the cases
						if (value[Num] == 0) {
							JOptionPane.showMessageDialog(null, "Case #"
									+ (Num + 1) + " contains $0.01!",
									"Deal or No Deal",
									JOptionPane.INFORMATION_MESSAGE,
									tempCaseImg);
						} else if (value[Num] != 0) {
							JOptionPane.showMessageDialog(
									null,
									"Case #" + (Num + 1) + " contains $"
											+ df.format(value[Num]) + "!",
									"Deal or No Deal",
									JOptionPane.INFORMATION_MESSAGE,
									tempCaseImg);
						}
						Casesbuttons[i][k].setVisible(false);
						Box2choose--;
						Remainingbox--;
						
						// Set the money label to invisible
						if (value[Num] == 0) {
							Moneyslabel[0][0].setVisible(false);
						}
						for (int l = 0; l < 13; l++) {
							if ((Moneyslabel[0][l].getIcon().toString())
									.equals(value[Num] + ".png")) {
								Moneyslabel[0][l].setVisible(false);
							}

						}
						for (int l = 0; l < 13; l++) {
							if ((Moneyslabel[1][l].getIcon().toString())
									.equals(value[Num] + ".png")) {
								Moneyslabel[1][l].setVisible(false);
							}
						}
					}
					for (int j = 0; j < 26; j++) {
						if (value[Num] == (int) Moneyvalues[j]) {
							Moneyvalues[j] = 0;
						}
					}
					if (!Playagain) {
						lblMessage.setText("Open "
								+ boxesRemainingString[Box2choose]
								+ " briefcases!");
					}
					
					// Banker makes offer
					if (Remainingbox == 20 || Remainingbox == 15
							|| Remainingbox == 11 || Remainingbox == 8
							|| (Remainingbox <= 6 && Remainingbox >= 2)) {
						Sum = 0;
						for (int j = 0; j < 26; j++) {
							Sum += Moneyvalues[j];
						}
						Offer = Sum / Remainingbox * Round / 10;
						int choice = JOptionPane.showOptionDialog(null,
								"The banker's offer is $" + df.format(Offer)
										+ "! Deal or no deal?",
								"Deal Or No Deal", JOptionPane.YES_NO_OPTION,
								JOptionPane.INFORMATION_MESSAGE, null, deal,
								deal[0]);
						if (Remainingbox == 20) {
							Box2choose = 5;
						} else if (Remainingbox == 15) {
							Box2choose = 4;
						} else if (Remainingbox == 11) {
							Box2choose = 3;
						} else if (Remainingbox == 8) {
							Box2choose = 2;
						} else if (Remainingbox >= 3 && Remainingbox <= 6) {
							Box2choose = 1;
						}
						lblMessage.setText("Open "
								+ boxesRemainingString[Box2choose]
								+ " briefcases!");
						
						// To deal or not to deal is a problem
						if (choice == 0) {
							JOptionPane.showMessageDialog(null,
									"Congratulations...you're going home with $"
											+ df.format(Offer) + "!",
									"Deal or no deal",
									JOptionPane.INFORMATION_MESSAGE,
									new ImageIcon("moneybag.png"));
							if (FirstcasesValue == 0) {
								JOptionPane.showMessageDialog(null,
										"You could have gone home with $0.01!",
										"Deal or no deal",
										JOptionPane.INFORMATION_MESSAGE,
										FirstcasesImg);
								JOptionPane
										.showMessageDialog(
												null,
												"Thank you for playing Deal or No Deal!",
												"Game over",
												JOptionPane.INFORMATION_MESSAGE,
												new ImageIcon("dond_icon.png"));
								int choice2 = JOptionPane.showConfirmDialog(
										null, "Do you want to play again?",
										"Deal or No Deal",
										JOptionPane.YES_NO_OPTION);
								if (choice2 == 0) {
									Playagain();
								} else
									System.exit(0);
							} else {
								JOptionPane.showMessageDialog(
										null,
										"You could have gone home with $"
												+ df.format(FirstcasesValue)
												+ "!", "Deal or no deal",
										JOptionPane.INFORMATION_MESSAGE,
										FirstcasesImg);
								JOptionPane
										.showMessageDialog(
												null,
												"Thank you for playing Deal or No Deal!",
												"Game over",
												JOptionPane.INFORMATION_MESSAGE,
												new ImageIcon("dond_icon.png"));
								int choice2 = JOptionPane.showConfirmDialog(
										null, "Do you want to play again?",
										"Deal or No Deal",
										JOptionPane.YES_NO_OPTION);
								if (choice2 == 0) {
									Playagain();
								} else
									System.exit(0);
							}
						}
						Round++;
					}
					
					// Last 2 cases to open
					if (Remainingbox == 2) {
						int choice = JOptionPane
								.showConfirmDialog(
										null,
										"There is only one case left! Would you like to keep your case?",
										"Deal or No Deal",
										JOptionPane.YES_NO_OPTION);
						// Keep the case
						if (choice == 0) {
							if (FirstcasesValue == 0) {
								JOptionPane
										.showMessageDialog(
												null,
												"Congratulations...you're going home with $0.01!",
												"Deal or no deal",
												JOptionPane.INFORMATION_MESSAGE,
												FirstcasesImg);
								
								// Choose if you want to play again
								int choice2 = JOptionPane.showConfirmDialog(
										null, "Do you want to play again?",
										"Deal or No Deal",
										JOptionPane.YES_NO_OPTION);
								
								// Execute play again method
								if (choice2 == 0) {
									Playagain();
								}// Execute exit
								else
									System.exit(0);
							} else {
								JOptionPane.showMessageDialog(null,
										"Congratulations...you're going home with $"
												+ df.format(FirstcasesValue)
												+ "!", "Deal or no deal",
										JOptionPane.INFORMATION_MESSAGE,
										FirstcasesImg);
							}
							int choice2 = JOptionPane.showConfirmDialog(null,
									"Do you want to play again?",
									"Deal or No Deal",
									JOptionPane.YES_NO_OPTION);
							if (choice2 == 0) {
								Playagain();
							} else
								System.exit(0);
						} // Abandon the previous case
						else if (choice == 1) {
							for (int j = 0; j < 13; j++) {
								if (Casesbuttons[0][j].isVisible() == true) {
									lastCaseImg = (Casesicon[0][j]);
								}
								if (Casesbuttons[1][j].isVisible() == true) {
									lastCaseImg = (Casesicon[1][j]);
								}
							}
							for (int j = 0; j < 26; j++) {
								if (Moneyvalues[j] != 0
										&& (int) (Moneyvalues[j]) != FirstcasesValue) {
									JOptionPane.showMessageDialog(null,
											"Congratulations...you're going home with $"
													+ df.format(Moneyvalues[j])
													+ "!", "Deal or no deal",
											JOptionPane.INFORMATION_MESSAGE,
											lastCaseImg);

								}
							}
							int choice2 = JOptionPane.showConfirmDialog(null,
									"Do you want to play again?",
									"Deal or No Deal",
									JOptionPane.YES_NO_OPTION);
							if (choice2 == 0) {
								Playagain();
							} else
								System.exit(0);
						}
					}
				}
			}
		}
	}

	// Play again method
	public void Playagain() {
		Playagain = true;
		Remainingbox = 26;
		Round = 1;
		lblMessage.setText("Choose one of the briefcases!");
		Firstcases = false;
		lblPlayersCase.setIcon(null);
		for (int j = 0; j < 2; j++) {
			for (int i = 0; i < 13; i++) {
				Casesbuttons[j][i].setVisible(true);
				Moneyslabel[j][i].setVisible(true);
			}
		}
		Moneyvalues[0] = 0.01;
		for (int i = 0; i < 26; i++) {
			Moneyvalues[i] = (double) value[i];
		}
	}
}