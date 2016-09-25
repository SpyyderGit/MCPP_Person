package person;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class PersonDM extends AbstractTableModel
{
	private static final long serialVersionUID = 1L;
	public ArrayList<Person> pp;

	public PersonDM(ArrayList<Person> pp)
	{
		this.pp = pp;
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
		switch (col)
		{
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
}
