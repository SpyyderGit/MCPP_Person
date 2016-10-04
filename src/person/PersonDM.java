package person;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

public class PersonDM extends AbstractTableModel
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

	CreateListener cl = new CreateListener();
	ReadListener rl = new ReadListener();
	UpdateListener ul = new UpdateListener();
	DeleteListener dl = new DeleteListener();

	class CreateListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{

			try
			{
				if (txtId.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Поле ID не заполнено", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else if (txtAge.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Поле Age не заполнено", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					int id = Integer.parseInt(txtId.getText());
					int age = Integer.parseInt(txtAge.getText());
					pd.create(new Person(id, txtFName.getText(), txtLName.getText(), age));
					fireTableDataChanged();
				}
			}
			catch (ClassNotFoundException | SQLException e1)
			{
				JOptionPane.showMessageDialog(null, "Запись с таким индексом уже существует", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	class ReadListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			pd.read();
			fireTableDataChanged();
		}
	}

	class UpdateListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				if (txtId.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Параметры для обновления не заданы", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					int id = Integer.parseInt(txtId.getText());
					int age = Integer.parseInt(txtAge.getText());
					pd.update(new Person(id, txtFName.getText(), txtLName.getText(), age));
					pd.read();
					fireTableDataChanged();
				}
			}
			catch (ClassNotFoundException | SQLException e1)
			{
				e1.printStackTrace();
			}
		}
	}

	class DeleteListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			try
			{

				if (txtId.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Параметры для удаления не заданы", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					int id = Integer.parseInt(txtId.getText());
					int age = Integer.parseInt(txtAge.getText());
					pd.delete(new Person(id, txtFName.getText(), txtLName.getText(), age));
					pd.read();
					fireTableDataChanged();
				}
			}
			catch (ClassNotFoundException | SQLException e1)
			{
				e1.printStackTrace();
			}
		}
	}
}
