import java.awt.*;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.Border;

public class monopolySetup extends JPanel implements ActionListener {
	boxes box = new boxes(new JLabel());
	money mo = new money(1500);
	pieces piece = new pieces(new JLabel());
	Property pro = new Property("");
	PropertyDisplay screen = new PropertyDisplay();
	boolean buyable = false;
	Player play = new Player(piece, pro, box, mo, screen);
	JFrame frame = new JFrame();
	JLabel money = new JLabel();
	int oneSpacing = 0;
	int twoSpacing = 0;
	int threeSpacing = 0;
	int fourSpacing = 0;
	int boardspace[] = { 0, 0, 0, 0 };
	int whichPlayer = 0;
	Random r = new Random();

	Tile tiles[] = new Tile[40];
	JButton button = new JButton();
	String names[] = { "go", "baltic", "chest", "medditaranian", "income tax", "oriental", "chance", "vermont",
			"conneticut", "jail", "st.Charles", "electric company", "states", "virginia", "st.James Place", "chest",
			"tennessee", "new York", "free Parking", "Kentucky", "chance", "Indiana", "Illinois", "atlantic", "ventnor",
			"water Works", "marvin Gardens", "go to jail", "pacific", "north Carolina", "chest", "Pensylvania",
			"chance", "park place", "luxury tax", "boardwalk" };
	int cost[] = { 0, 60, 0, 60, 0, 100, 0, 100, 120, 0, 140, 150, 140, 160, 180, 0, 180, 200, 0, 220, 0, 220, 240, 260,
			260, 150, 280, 0, 300, 300, 0, 320, 0, 350, 0, 400 };
	Color colors[] = { new Color(20, 120, 50), new Color(66, 40, 14), new Color(20, 80, 140), new Color(66, 40, 14),
			new Color(147, 151, 143), new Color(50, 168, 168), new Color(166, 111, 50), new Color(50, 168, 168),
			new Color(50, 168, 168), new Color(255, 102, 0), new Color(202, 0, 202), new Color(255),
			new Color(202, 0, 202), new Color(202, 0, 202), new Color(253, 177, 0), new Color(20, 80, 140),
			new Color(253, 177, 0), new Color(253, 177, 0), new Color(180, 60, 20), new Color(255, 0, 0),
			new Color(166, 111, 50), new Color(255, 0, 0), new Color(255, 0, 0), new Color(214, 228, 24),
			new Color(214, 228, 24), new Color(246, 255, 105), new Color(214, 228, 24), new Color(0, 50, 255),
			new Color(0, 255, 75), new Color(0, 255, 75), new Color(20, 80, 140), new Color(0, 255, 75),
			new Color(166, 111, 50), new Color(0, 255, 20), new Color(125), new Color(0, 255, 20) };
	int boardx[] = { 900, 800, 700, 600, 500, 400, 300, 200, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100, 200, 300, 400, 500,
			600, 700, 800, 900, 900, 900, 900, 900, 900, 900, 900, 900 };
	int boardy[] = { 900, 900, 900, 900, 900, 900, 900, 900, 900, 900, 800, 700, 600, 500, 400, 300, 200, 100, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 100, 200, 300, 400, 500, 600, 700, 800 };
	int boxx[] = { 250, 650, 250, 650 };
	int boxy[] = { 250, 250, 650, 650 };
	JLabel moneys[] = new JLabel[4];
	JLabel players[] = new JLabel[4];
	JLabel boxes[] = { box.box, box.box, box.box, box.box };
	JButton props[] = new JButton[4];
	JButton x = screen.exit;
	JLabel display = new JLabel();
	String properties[] = { pro.prop, pro.prop, pro.prop, pro.prop };
	Color playerColors[] = { new Color(1, 68, 33), new Color(25, 25, 122), new Color(255, 223, 0),
			new Color(217, 33, 33) };
	JLabel oneDisplay[] = new JLabel[24];
	JLabel twoDisplay[] = new JLabel[24];
	JLabel threeDisplay[] = new JLabel[24];
	JLabel fourDisplay[] = new JLabel[24];

	int playerOffsetX[] = { 0, 75, 0, 75 };
	int playerOffsetY[] = { 0, 0, 75, 75 };
	int cash[] = { 1500, 1500, 1500, 1500 };

	@Override
	public void paintComponent(Graphics g) {
		draw(g);

	}

	public void setup() {

		frame.setSize(1000, 1050);
		frame.setVisible(true);
		frame.add(this);
		this.setLayout(null);
		this.add(x);
		for (int i = 0; i < 24; i++) {
			oneDisplay[i] = new JLabel();
			this.add(oneDisplay[i]);
			oneDisplay[i].setText("");
			oneDisplay[i].setVisible(false);
			oneDisplay[i].setFont(new Font("Times New Roman", Font.BOLD, 22));

			twoDisplay[i] = new JLabel();
			this.add(twoDisplay[i]);
			twoDisplay[i].setText("");
			twoDisplay[i].setVisible(false);
			twoDisplay[i].setFont(new Font("Times New Roman", Font.BOLD, 22));

			threeDisplay[i] = new JLabel();
			this.add(threeDisplay[i]);
			threeDisplay[i].setText("");
			threeDisplay[i].setVisible(false);
			threeDisplay[i].setFont(new Font("Times New Roman", Font.BOLD, 22));

			fourDisplay[i] = new JLabel();
			this.add(fourDisplay[i]);
			fourDisplay[i].setText("");
			fourDisplay[i].setVisible(false);
			fourDisplay[i].setFont(new Font("Times New Roman", Font.BOLD, 22));
		}
		this.add(display);
		this.add(button);
		x.setVisible(false);
		x.setOpaque(true);
		x.setBounds(410, 235, 50, 50);
		x.setText("X");
		x.addActionListener(this);
		display.setBackground(Color.lightGray);
		display.setVisible(false);
		display.setBounds(400, 225, 300, 600);
		button.setBounds(450, 475, 150, 75);
		button.setText("player " + (whichPlayer + 1) + ": roll");
		button.addActionListener(this);
		for (int i = 0; i < 4; i++) {
			boxes[i] = new JLabel();
			props[i] = new JButton();
			moneys[i] = new JLabel();
			players[i] = new JLabel();
			this.add(moneys[i]);
			this.add(props[i]);
			this.add(boxes[i]);
			this.add(players[i]);

			boxes[i].setOpaque(true);
			boxes[i].setBackground(Color.gray);
			boxes[i].setBounds(boxx[i], boxy[i], 150, 150);
			moneys[i].setBounds(boxx[i], boxy[i], 150, 15);
			moneys[i].setText("money: " + cash[i]);
			props[i].setBounds(boxx[i], boxy[i] + 25, 70, 20);
			props[i].setText("properties");
			props[i].addActionListener(this);
			players[i].setBounds(boardx[boardspace[i]] + playerOffsetX[i], boardy[boardspace[i]] + playerOffsetY[i], 25,
					25);
			players[i].setOpaque(true);
			players[i].setBackground(playerColors[i]);
			players[i].setBorder(BorderFactory.createLineBorder(Color.black, 2));

		}

		for (int i = 0; i < 36; i++) {
			tiles[i] = new Tile(cost[i], names[i], new Color(0), true, boardx[i], boardy[i]);
		}

	}

	public void draw(Graphics g) {

		for (int i = 0; i < 36; i++) {
			g.setColor(colors[i]);
			g.fillRect(boardx[i], boardy[i], 100, 100);
			g.setColor(Color.black);

			g.drawString("cost" + cost[i], boardx[i] + 25, boardy[i] + 25);
			g.drawString(names[i], boardx[i] + 10, boardy[i] + 50);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == button) {

			int ran = r.nextInt(12) + 1;

			boardspace[whichPlayer] += ran;
			boardspace[whichPlayer] %= 36;
			players[whichPlayer].setBounds(boardx[boardspace[whichPlayer]] + playerOffsetX[whichPlayer],
					boardy[boardspace[whichPlayer]] + playerOffsetY[whichPlayer], 25, 25);
			if (names[boardspace[whichPlayer]] == "chance") {
				int goodOrBad = r.nextInt(2);
				if (goodOrBad == 0) {
					cash[whichPlayer] -= r.nextInt(200);
				}
				if (goodOrBad == 1) {
					cash[whichPlayer] -= r.nextInt(175);
				}
			}
			if (names[boardspace[whichPlayer]] == "community chest") {
				int goodOrBad = r.nextInt(2);
				if (goodOrBad == 0) {
					cash[whichPlayer] -= r.nextInt(150);
				}
				if (goodOrBad == 1) {
					cash[whichPlayer] -= r.nextInt(100);
				}
			}
//			if (whichPlayer == 0) {
//				for (int i = 0; i < 24; i++) {
//					if (names[boardspace[whichPlayer]].equals(twoDisplay[i].getText())) {
//						cash[whichPlayer] -= (boardspace[whichPlayer] / 8);
//						buyable = false;
//					} else if (names[boardspace[whichPlayer]].equals(threeDisplay[i].getText())) {
//						cash[whichPlayer] -= (boardspace[whichPlayer] / 8);
//						buyable = false;
//					} else if (names[boardspace[whichPlayer]].equals(fourDisplay[i].getText())) {
//						cash[whichPlayer] -= (boardspace[whichPlayer] / 8);
//						buyable = false;
//					} else {
//						buyable = true;
//						System.out.println(buyable);
//					}
//				}
//			}
//			if (whichPlayer == 1) {
//				for (int i = 0; i < 24; i++) {
//					if (names[boardspace[whichPlayer]].equals(oneDisplay[i].getText())) {
//						cash[whichPlayer] -= (boardspace[whichPlayer] / 8);
//						buyable = false;
//					} else if (names[boardspace[whichPlayer]].equals(threeDisplay[i].getText())) {
//						cash[whichPlayer] -= (boardspace[whichPlayer] / 8);
//						buyable = false;
//					} else if (names[boardspace[whichPlayer]].equals(fourDisplay[i].getText())) {
//						cash[whichPlayer] -= (boardspace[whichPlayer] / 8);
//						buyable = false;
//					} else {
//						buyable = true;
//						System.out.println(buyable);
//					}
//				}
//			}
//			if (whichPlayer == 2) {
//				for (int i = 0; i < 24; i++) {
//					if (names[boardspace[whichPlayer]].equals(oneDisplay[i].getText())) {
//						cash[whichPlayer] -= (boardspace[whichPlayer] / 8);
//						buyable = false;
//					} else if (names[boardspace[whichPlayer]].equals(twoDisplay[i].getText())) {
//						cash[whichPlayer] -= (boardspace[whichPlayer] / 8);
//						buyable = false;
//					} else if (names[boardspace[whichPlayer]].equals(fourDisplay[i].getText())) {
//						cash[whichPlayer] -= (boardspace[whichPlayer] / 8);
//						buyable = false;
//					} else {
//						buyable = true;
//						System.out.println(buyable);
//					}
//				}
//			}
//			if (whichPlayer == 3) {
//				for (int i = 0; i < 24; i++) {
//					if (names[boardspace[whichPlayer]].equals(oneDisplay[i].getText())) {
//						cash[whichPlayer] -= (boardspace[whichPlayer] / 8);
//						buyable = false;
//					} else if (names[boardspace[whichPlayer]].equals(twoDisplay[i].getText())) {
//						cash[whichPlayer] -= (boardspace[whichPlayer] / 8);
//						buyable = false;
//					} else if (names[boardspace[whichPlayer]].equals(fourDisplay[i].getText())) {
//						cash[whichPlayer] -= (boardspace[whichPlayer] / 8);
//						buyable = false;
//					} else {
//						buyable = true;
//						System.out.println(buyable);
//					}
//				}
//			}

			if (cost[boardspace[whichPlayer]] != 0 ) {
				String buying = JOptionPane.showInputDialog("buy " + names[boardspace[whichPlayer]] + " for "
						+ cost[boardspace[whichPlayer]] + " dollars?");

				if (buying.equals("yes")) {
					cash[whichPlayer] -= cost[boardspace[whichPlayer]];
					moneys[whichPlayer].setText("money: " + cash[whichPlayer]);
					money.setText("money: " + cash);

					if (whichPlayer == 0) {
						oneDisplay[oneSpacing].setBounds(400, 300 + (oneSpacing * 30), 300, 50);
						oneDisplay[oneSpacing].setText(names[boardspace[0]]);
						oneSpacing++;
					//	names[boardspace[whichPlayer]]
					}
					if (whichPlayer == 1) {
						twoDisplay[twoSpacing].setBounds(400, 300 + (twoSpacing * 30), 300, 50);
						twoDisplay[twoSpacing].setText(names[boardspace[1]]);
						twoSpacing++;

					}
					if (whichPlayer == 2) {
						threeDisplay[threeSpacing].setBounds(400, 300 + (threeSpacing * 30), 300, 50);
						threeDisplay[threeSpacing].setText(names[boardspace[2]]);
						threeSpacing++;

					}
					if (whichPlayer == 3) {
						fourDisplay[fourSpacing].setBounds(400, 300 + (fourSpacing * 30), 300, 50);
						fourDisplay[fourSpacing].setText(names[boardspace[3]]);
						fourSpacing++;
					}

				}
			} else if (buyable == false) {
				JOptionPane.showMessageDialog(null, "you paid" + cash[boardspace[whichPlayer]] / 8);
			}

			System.out.println(boardspace[whichPlayer]);
			play.p.piece.setBounds(boardx[boardspace[whichPlayer]], boardy[boardspace[whichPlayer]], 25, 25);
			if (whichPlayer < 3) {
				whichPlayer++;
			} else {
				whichPlayer = 0;
			}

			button.setText("player " + (whichPlayer + 1) + ": roll");
		}
		for (int i = 0; i < 4; i++) {
			if (arg0.getSource() == props[i]) {
				System.out.println("hello world!");
				x.setVisible(true);
				display.setVisible(true);
				display.setOpaque(true);
			}
			if (arg0.getSource() == props[0]) {
				for (int t = 0; t < 24; t++) {
					oneDisplay[t].setVisible(true);
				}
			}
			if (arg0.getSource() == props[1]) {
				for (int t = 0; t < 24; t++) {
					twoDisplay[t].setVisible(true);
				}
			}
			if (arg0.getSource() == props[2]) {
				for (int t = 0; t < 24; t++) {
					threeDisplay[t].setVisible(true);
				}
			}
			if (arg0.getSource() == props[3]) {
				for (int t = 0; t < 24; t++) {
					fourDisplay[t].setVisible(true);
				}
			}
		}
		if (arg0.getSource() == x) {
			display.setVisible(false);
			for (int t = 0; t < 24; t++) {
				oneDisplay[t].setVisible(false);
				twoDisplay[t].setVisible(false);
				threeDisplay[t].setVisible(false);
				fourDisplay[t].setVisible(false);
			}
			x.setVisible(false);

		}

	}
}