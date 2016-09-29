package person;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

public class PersonDM extends AbstractTableModel implements ActionListener
{
	private static final long serialVersionUID = 1L;

	PDriver pd = new PDriver();
	public ArrayList<Person> pp = pd.read();

	JTextField txtId;
	JTextField txtFName;
	JTextField txtLName;
	JTextField txtAge;

	public PersonDM(JTextField txtId, JTextField txtFName, JTextField txtLName, JTextField txtge)
	{
		this.txtId = txtId;
		this.txtFName = txtFName;
		this.txtLName = txtLName;
		this.txtAge = txtge;
	}

	@Override
	public int getColumnCount()
	{
		return 4;
	}

	@Override
	public int getRowCount()
	{
		return pp.size();
	}

	@Override
	public String getColumnName(int c)
	{
		String[] result = { "id", "fName", "lName", "age" };
		return result[c];
	}

	@Override
	public Object getValueAt(int row, int col)
	{
		switch (col) {
		case 0:
			return pp.get(row).getId();
		case 1:
			return pp.get(row).getfName();
		case 2:
			return pp.get(row).getlName();
		case 3:
			return pp.get(row).getAge();
		default:
			return "";
		}
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String com = e.getActionCommand();
		int id = Integer.parseInt(txtId.getText());
		int age = Integer.parseInt(txtAge.getText());

		if (com.equals("create"))
		{
			try
			{
				pd.create(new Person(id, txtFName.getText(), txtLName.getText(), age));
				fireTableDataChanged();
			}
			catch (ClassNotFoundException | SQLException e1)
			{
				JOptionPane.showMessageDialog(null, "Запись с таким индексом уже существует", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		else if (com.equals("delete"))
		{
			try
			{
				pd.delete(new Person(id, txtFName.getText(), txtLName.getText(), age));
				pd.read();
				fireTableDataChanged();
			}
			catch (ClassNotFoundException | SQLException e1)
			{
				e1.printStackTrace();
			}
		}
		else if (com.equals("read"))
		{
			pd.read();
			fireTableDataChanged();
		}
		else if (com.equals("update"))
		{
			try
			{
				pd.update(new Person(id, txtFName.getText(), txtLName.getText(), age));
				pd.read();
				fireTableDataChanged();
			}
			catch (ClassNotFoundException | SQLException e1)
			{
				e1.printStackTrace();
			}
		}
	}
}
