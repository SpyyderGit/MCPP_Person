package person;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class PGenPanel extends JPanel
{

	public JButton btnCreate;

	public PGenPanel() throws ClassNotFoundException, SQLException
	{
		setLayout(null);

		JLabel lblId = new JLabel("ID: ");
		lblId.setBounds(20, 20, 90, 30);
		add(lblId);

		JTextField txtId = new JTextField("");
		txtId.setBounds(90, 20, 150, 30);
		add(txtId);

		JLabel lblFName = new JLabel("Фамилия: ");
		lblFName.setBounds(20, 60, 90, 30);
		add(lblFName);

		JTextField txtFName = new JTextField("");
		txtFName.setBounds(90, 60, 150, 30);
		add(txtFName);

		JLabel lblLName = new JLabel("Имя: ");
		lblLName.setBounds(20, 100, 90, 30);
		add(lblLName);

		JTextField txtLName = new JTextField("");
		txtLName.setBounds(90, 100, 150, 30);
		add(txtLName);

		JLabel lblAge = new JLabel("Возраст: ");
		lblAge.setBounds(20, 140, 90, 30);
		add(lblAge);

		JTextField txtAge = new JTextField("");
		txtAge.setBounds(90, 140, 150, 30);
		add(txtAge);

		// ======================================================
		// создание обьекта TableModel с параметрами JTextField
		// ======================================================

		PDriver pd = new PDriver();
		PersonDM pm = new PersonDM(txtId, txtFName, txtLName, txtAge);

		// ==========================================================

		setBackground(Color.lightGray);
		JTable tab = new JTable(pm);
		JScrollPane jsp = new JScrollPane(tab);
		jsp.setBounds(25, 230, 650, 200);
		add(jsp);

		btnCreate = new JButton("Create");
		btnCreate.setBounds(125, 450, 90, 30);
		btnCreate.setActionCommand("create");
		btnCreate.addActionListener(pm);
		add(btnCreate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(410, 450, 90, 30);
		btnDelete.setActionCommand("delete");
		btnDelete.addActionListener(pm);
		add(btnDelete);

		JButton btnRead = new JButton("Read");
		btnRead.setBounds(220, 450, 90, 30);
		btnRead.setActionCommand("read");
		btnRead.addActionListener(pm);
		add(btnRead);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(315, 450, 90, 30);
		btnUpdate.setActionCommand("update");
		btnUpdate.addActionListener(pm);
		add(btnUpdate);

	}
}
