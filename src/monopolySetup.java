import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.Border;

public class monopolySetup {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel[] labels = new JLabel[100];
	

	
	public void Setup() {
		frame.setSize(1100, 1100);
		frame.setVisible(true);
		frame.add(panel);
		GridLayout gridLayout = new GridLayout(10, 10);
		for(int i = 0; i<100; i++) {
			labels[i] = new JLabel();
			panel.add(labels[i]);
			Border border = BorderFactory.createLineBorder(Color.black, 2);
			labels[i].setBorder(border);
			labels[i].setOpaque(true);
			labels[i].setBackground(Color.BLACK);
			labels[i].setHorizontalAlignment(SwingConstants.CENTER);
			labels[i].setVerticalAlignment(SwingConstants.TOP);
			labels[i].setFont(new Font(null).deriveFont(Font.BOLD, 12));
			
			if(i<10) {
				labels[i].setBackground(Color.WHITE);
			}
			if(i%10 == 0) {
				labels[i].setBackground(Color.WHITE);
			}
			if(i%10 == 9) {
				labels[i].setBackground(Color.WHITE);
			}
			if(i>89) {
				labels[i].setBackground(Color.WHITE);
			}
			if(i == 99) {
				labels[i].setText("GO, get $200");
				labels[i].setBackground(new Color(31, 61, 12));
			}
			if(i == 98) {
				labels[i].setText("baltic, 60$");
				labels[i].setBackground(new Color(66, 40, 14));
			}
			if(i == 97) {
				labels[i].setText("Tax pay 200");
				labels[i].setBackground(new Color(194, 24, 7));
			}
			if(i == 96) {
				labels[i].setText("wyoming $60");
				labels[i].setBackground(new Color(66, 40, 14));
			}
			
		}
		panel.setLayout(gridLayout);

		
	}
	
}
