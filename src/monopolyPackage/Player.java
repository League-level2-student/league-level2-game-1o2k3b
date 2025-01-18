package monopolyPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Player implements ActionListener {
	ArrayList<Property> properties = new ArrayList<>();
	int money = 1500;
	String name;
	Color color;
	int playerNumber;
	int currentTile = 0;
	int num = 0;
	int boxX[] = { 250, 650, 250, 650 };
	int boxY[] = { 225, 225, 675, 675 };
	JButton propertyButton = new JButton("properties");
	JButton houseButton = new JButton();
	ImageIcon houseIcon;
	ArrayList<Color> ownedSets = new ArrayList<Color>();
	Map<Color, Integer> setChecker = new HashMap();

	public Player(String name, Color color, int playerNumber) {
		super();
		this.name = name;
		this.color = color;
		this.playerNumber = playerNumber;
		propertyButton.setOpaque(true);
		propertyButton.setBounds(boxX[playerNumber], boxY[playerNumber] + 65, 90, 35);
		propertyButton.addActionListener(this);
		Board.getBoard().add(propertyButton);

		houseButton.setBounds(boxX[playerNumber] + 114, boxY[playerNumber] + 65, 35, 35);
		houseButton.addActionListener(this);
		houseIcon = new ImageIcon("src/monopolyPackage/house.jpg");

		houseButton.setIcon(houseIcon);
		Board.getBoard().add(houseButton);

		setChecker.put(new Color(66, 40, 14), 0);
		setChecker.put(new Color(50, 168, 168), 0);
		setChecker.put(new Color(202, 0, 202), 0);
		setChecker.put(new Color(253, 177, 0), 0);
		setChecker.put(new Color(255, 0, 0), 0);
		setChecker.put(new Color(214, 228, 24), 0);
		setChecker.put(new Color(0, 255, 75), 0);
		setChecker.put(new Color(0, 0, 128), 0);

	}

	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		int x = Board.tiles.get(currentTile).xPos;
		int y = Board.tiles.get(currentTile).yPos;

		g.setColor(color);
		if (playerNumber == 1 || playerNumber == 3) {
			x += 70;
		}
		if (playerNumber == 2 || playerNumber == 3) {
			y += 70;
		}
		g.fillRect(x, y, 30, 30);

		g.setColor(Color.LIGHT_GRAY);
		g.drawRect(boxX[playerNumber], boxY[playerNumber], 150, 100);
		g.setColor(Color.black);
		g.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		g.drawString("money: " + money, boxX[playerNumber], boxY[playerNumber] + 40);
		g.setFont(new Font("Times New Roman", Font.BOLD, 25));
		g.drawString(name, boxX[playerNumber], boxY[playerNumber] + 20);

		num++;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == propertyButton) {
			String propertyString = "";
			for (Property p : properties) {
				propertyString += p.name + "\n";
			}
			JOptionPane.showMessageDialog(null, propertyString);
		} else {
			if (ownedSets.size() != 0) {

				List<String> colors = new ArrayList<>();
				for (Color c : ownedSets) {
					colors.add(Board.colorToString.get(c));
				}

				int choice = JOptionPane.showOptionDialog(Board.frame, "which color set would you like to add to?", "",
						JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, houseIcon, colors.toArray(), null);
				int whichProp = JOptionPane.showOptionDialog(Board.frame,
						"which property in this color set would you like to put a house on?", "",
						JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, houseIcon,
						Board.map.get(ownedSets.get(choice)), null);
				String propName = Board.map.get(ownedSets.get(choice))[whichProp];
				Property p = null;
				for (int i = 0; i < 36; i++) {
					if (propName.equals(Board.tiles.get(i).name)) {
						p = (Property) Board.tiles.get(i);
					}
				}
				p.houses++;

			}

		}

	}

}
