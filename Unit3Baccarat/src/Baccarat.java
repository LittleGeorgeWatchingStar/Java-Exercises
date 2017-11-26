import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Baccarat extends JFrame implements ActionListener {
	JLabel[] lblPlayerHand, lblBankerHand;
	private JLabel lblPlayer, lblBanker, lblPTotal, lblBTotal, lblChips,
			lblResult, lblBet;
	private JTextField txtBet;
	private JButton btnDeal,btnAgain;
	private ImageIcon imgBack;
	private boolean playerDraw = false;
	private int player = 500, score1 = 0, score2 = 0, betDefault = 50, bet;
	private DeckofCardofB deck;
	private CardofB mc1, mc2, mc3, bc1, bc2, bc3;

	public static void main(String[] args) {
		new Baccarat();
	}

	public Baccarat() {
		// Use a deck of shuffled cards
		deck = new DeckofCardofB(true);
		
		// Set image to background label
		ImageIcon imgTable = new ImageIcon("baccarat-table.gif");
		JLabel lblBackground = new JLabel();
		lblBackground.setIcon(imgTable);
		lblBackground.setBounds(0, 0, imgTable.getIconWidth(),
				imgTable.getIconHeight());
		
		// Create a layer on top of background label
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(imgTable.getIconWidth(),
				imgTable.getIconHeight()));
		
		// Create a label of user's chips
		lblChips = new JLabel();
		lblChips.setText("$" + player);
		lblChips.setBounds(10, 0, 75, 20);
		lblChips.setHorizontalAlignment(JLabel.LEFT);
		lblChips.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblChips.setForeground(Color.WHITE);

		// Create a title label of player's cards
		lblPlayer = new JLabel("Player has:");
		lblPlayer.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer.setBounds(90, 200, 100, 20);
		lblPlayer.setForeground(Color.WHITE);

		// Create a title label of banker's cards
		lblBanker = new JLabel("Banker has:");
		lblBanker.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBanker.setHorizontalAlignment(SwingConstants.CENTER);
		lblBanker.setBounds(290, 200, 100, 20);
		lblBanker.setForeground(Color.WHITE);
		
		// Create a label of sum of user's cards
		lblPTotal = new JLabel("");
		lblPTotal.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblPTotal.setBounds(90, 225, 100, 20);

		// Create a label of sum of banker's cards
		lblBTotal = new JLabel();
		lblBTotal.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblBTotal.setBounds(290, 225, 100, 20);

		// Create a label to show result
		lblResult = new JLabel();
		lblResult
				.setBounds(imgTable.getIconWidth() / 2 - 150 / 2, 220, 150, 30);
		lblResult.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblResult.setForeground(Color.BLUE);
		lblResult.setText("Click DEAL to begin!");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);

		// Create a text field of bet
		txtBet = new JTextField();
		txtBet.setEditable(false);
		txtBet.setText("" + betDefault);
		txtBet.setHorizontalAlignment(SwingConstants.CENTER);
		txtBet.setBounds(205, 130, 70, 30);

		// Create a control button
		btnDeal = new JButton("DEAL");
		btnDeal.setBounds(205, 165, 70, 30);
		btnDeal.setFocusable(false);
		btnDeal.addActionListener(this);
		btnDeal.setMnemonic(KeyEvent.VK_Z);
		
		// Create a button to restart
		btnAgain = new JButton("PLAY AGAIN");
		btnAgain
		.setBounds(imgTable.getIconWidth() / 2 - 150 / 2, 250, 150, 30);
		btnAgain.setFocusable(false);
		btnAgain.setEnabled(false);
		btnAgain.addActionListener(this);
		btnAgain.setMnemonic(KeyEvent.VK_A);

		// Create a title label of bet
		lblBet = new JLabel("YOUR BET:");
		lblBet.setHorizontalAlignment(SwingConstants.CENTER);
		lblBet.setForeground(Color.BLUE);
		lblBet.setBounds(205, 95, 70, 30);

		// Add all those things to the layered panel
		layeredPane.add(lblBackground, new Integer(0));
		layeredPane.add(btnDeal, new Integer(1));
		layeredPane.add(lblChips, new Integer(1));
		layeredPane.add(lblBet, new Integer(1));
		layeredPane.add(txtBet, new Integer(1));
		layeredPane.add(lblPlayer, new Integer(1));
		layeredPane.add(lblPTotal, new Integer(1));
		layeredPane.add(lblBanker, new Integer(1));
		layeredPane.add(lblBTotal, new Integer(1));
		layeredPane.add(lblResult, new Integer(1));
		layeredPane.add(btnAgain, new Integer(1));

		// Create labels of player and banker's cards
		lblPlayerHand = new JLabel[3];
		lblBankerHand = new JLabel[3];
		int xPos = 80;
		Integer layer = 1;
		imgBack = new ImageIcon("back.png");
		for (int i = 0; i < 3; i++) {
			lblPlayerHand[i] = new JLabel(imgBack);
			lblPlayerHand[i].setBounds(xPos, 100, imgBack.getIconWidth(),
					imgBack.getIconHeight());
			layeredPane.add(lblPlayerHand[i], layer);
			xPos += 20;
			layer++;
		}

		xPos = 285;
		layer = 1;
		for (int i = 0; i < 3; i++) {
			lblBankerHand[i] = new JLabel(imgBack);
			lblBankerHand[i].setBounds(xPos, 100, imgBack.getIconWidth(),
					imgBack.getIconHeight());
			layeredPane.add(lblBankerHand[i], layer);
			xPos += 20;
			layer++;
		}

		// Main panel construction
		setContentPane(layeredPane);
		setTitle("Baccarat");
		setSize(imgTable.getIconWidth(), imgTable.getIconHeight());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		// Restart the game
		if (e.getSource()== btnAgain){
			btnDeal.setEnabled(true);
			btnAgain.setEnabled(false);
			for (int i = 0; i < 3; i++) {
				lblBankerHand[i].setIcon(imgBack);
				lblPlayerHand[i].setIcon(imgBack);
			}
			score1=0; score2=0;
			lblPTotal.setText(String.valueOf(score1));
			lblBTotal.setText(String.valueOf(score2));
			lblResult.setText("Click DEAL to play!");
		} else if (e.getSource() == btnDeal) {
			if (btnDeal.getText().equals("DEAL")) {
				bet = 0;
				txtBet.setEditable(false);
				playerDraw = false;
				txtBet.setText("" + betDefault);

				// Make a new deck if the cards are used up
				if (deck.getCardsRemaining() < 6) {
					JOptionPane.showMessageDialog(null,
							"Sorry, please wait for new cards", "Baccarat",
							JOptionPane.INFORMATION_MESSAGE);
					for (int i = 0; i < 3; i++) {
						lblBankerHand[i].setIcon(imgBack);
						lblPlayerHand[i].setIcon(imgBack);
					}
					deck = new DeckofCardofB(true);
					return;
				}
				lblPlayerHand[2].setIcon(imgBack);
				lblBankerHand[2].setIcon(imgBack);
				
				// Player's first two cards
				mc1 = deck.dealCard();
				lblPlayerHand[0].setIcon(mc1.getImage());
				mc2 = deck.dealCard();
				lblPlayerHand[1].setIcon(mc2.getImage());
				score1 = (mc1.getValue() + mc2.getValue()) % 10;
				lblPTotal.setText(String.valueOf(score1));
				// Banker's first two cards
				bc1 = deck.dealCard();
				lblBankerHand[0].setIcon(bc1.getImage());
				bc2 = deck.dealCard();
				lblBankerHand[1].setIcon(bc2.getImage());
				score2 = (bc1.getValue() + bc2.getValue()) % 10;
				lblBTotal.setText(String.valueOf(score2));
				
				// Situation when a third card is required
				if ((score1 <= 5 && score2 < 8) || (score2 <= 5 && score1 < 8)) {

					btnDeal.setText("DRAW");
					txtBet.setEditable(true);
					playerDraw = true;
					lblResult.setText("Enter a bet!");
				} else {
					compare(score1, score2);
					btnDeal.setEnabled(false);
					btnAgain.setEnabled(true);
				}
			} else if (btnDeal.getText().equals("DRAW")) {
				
				// Let player bet
				try {
					bet = Integer.parseInt(txtBet.getText());
					// Catch player if betting larger than balance
					if (bet > player) {
						ImageIcon Icon2 = new ImageIcon("Thumbs_up copy.jpeg");
						JOptionPane.showMessageDialog(null,
								"Please behave! I assume you bet everything.", "Baccarat",
								JOptionPane.INFORMATION_MESSAGE, Icon2);
						bet = player;
					}

				} catch (NumberFormatException f) {
					// Catch player if not entering an integer
					ImageIcon Icon2 = new ImageIcon("Thumbs_up copy.jpeg");
					JOptionPane.showMessageDialog(null,
							"Entered an integer! The bet is set to default!", "Baccarat",
							JOptionPane.INFORMATION_MESSAGE, Icon2);
				}
				
				// Conditions for player to draw third card
				if (score1 <= 5) {
					mc3 = deck.dealCard();
					lblPlayerHand[2].setIcon(mc3.getImage());
					score1 += mc3.getValue();
					score1 %= 10;
					lblPTotal.setText(String.valueOf(score1));
				}
				btnDeal.setText("DEAL");
				
				// Conditions for banker to draw third card
				if ((score2 <= 5 && !playerDraw)
						|| (playerDraw && score2 >= 0 && score2 <= 2)
						|| (playerDraw && score2 == 3 && score1 != 8)
						|| (playerDraw && score2 == 4 && score1 >= 2 && score1 <= 7)
						|| (playerDraw && score2 == 5 && score1 >= 4 && score1 <= 7)
						|| (playerDraw && score2 == 6 && score1 <= 7 && score1 >= 6)) {
					bc3 = deck.dealCard();
					lblBankerHand[2].setIcon(bc3.getImage());
					score2 += bc3.getValue();
					score2 %= 10;
					lblBTotal.setText(String.valueOf(score2));
				}
				compare(score1, score2);
				btnDeal.setEnabled(false);
				btnAgain.setEnabled(true);
			}
		}
		
		// Exit when player is broke
		if (player <= 0) {
			ImageIcon Icon2 = new ImageIcon("Thumbs_up copy.jpeg");
			JOptionPane.showMessageDialog(null,
					"GAME OVER!\nYou are out of money!", "Baccarat",
					JOptionPane.INFORMATION_MESSAGE, Icon2);
			System.exit(0);
		}
	}

	// The method of compare the scores of the player and the banker
	public void compare(int score1, int score2) {
		if (score1 > score2) {
			lblResult.setText("Player wins!");
			if (bet == 0) {
				bet = betDefault;
			}
			player += bet;
			lblChips.setText("$" + player);
		} else if (score1 < score2) {
			lblResult.setText("Banker wins!");
			if (bet == 0) {
				bet = betDefault;
			}
			player -= bet;
			lblChips.setText("$" + player);
		} else {
			lblResult.setText("It's a tie!");
		}
	}
}