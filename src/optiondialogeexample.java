import javax.swing.*;

public class optiondialogeexample {

public static void main(String[] args) {
	JFrame frame = new JFrame();
	String[][] options = new String[10][2];
	String characters[] = {"Film", "Tech", "breakfast", "lunch"};
	for(int i = 0; i<10; i++) {
	for(int p = 0; p<2; p++) {
	options[i][p] = characters[i*p];

}
	}
	JOptionPane.showOptionDialog(frame.getContentPane(), "film or tech", "1", 0, JOptionPane.INFORMATION_MESSAGE, null, options[0], null);
}
}
