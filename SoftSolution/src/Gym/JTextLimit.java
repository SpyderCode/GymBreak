package Gym;

import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class JTextLimit extends PlainDocument {
	private int limit;

	JTextLimit(int limit) {
		super();
		this.limit = limit;
	}

	public void insertString(int offs, String str, javax.swing.text.AttributeSet a){
		if (str == null)
			return;

		try {
			if ((getLength() + str.length()) <= limit) {
				super.insertString(offs, str, a);
			}
		} catch (BadLocationException e) {
			JOptionPane.showMessageDialog(null, "Error: Son demasiados numeros o letras", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

}
