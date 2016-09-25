package person;

import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

public class PFrame extends JFrame
{
	public  PFrame() throws ClassNotFoundException, SQLException
	{
		setLayout(null);
		setBounds(100, 100, 800, 600);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		PGenPanel pp = new PGenPanel();
		pp.setBounds(50, 20, 700, 500);
		pp.setBorder(BorderFactory.createLoweredBevelBorder());
		add(pp);

		setVisible(true);
	}
}
