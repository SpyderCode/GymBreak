package Gym;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Locale;
import java.util.Properties;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;



public class Pagos extends JPanel{
	public Pagos(GymBreak g) {
		setBackground(Color.WHITE);
		setLayout(null);

		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(Color.WHITE);
		MainPanel.setBounds(0, 0, 933, 447);
		add(MainPanel);
		MainPanel.setLayout(null);
		
		JCalendar calendar = new JCalendar();
		calendar.setBackground(Color.WHITE);
		calendar.setBounds(594, 102, 327, 216);
		MainPanel.add(calendar);
		
	}
}
