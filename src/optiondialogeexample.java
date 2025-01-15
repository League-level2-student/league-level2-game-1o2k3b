import javax.swing.*;

public class optiondialogeexample {

public static void main(String[] args) {
	JFrame frame = new JFrame();
	String[] options = new String[2];
	options[0] = "Film";
	options[1] = "Tech";
	JOptionPane.showOptionDialog(frame.getContentPane(), "film or tech", "1", 0, JOptionPane.INFORMATION_MESSAGE, null, options, null);
}
}
