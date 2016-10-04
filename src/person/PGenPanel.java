package person;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class PGenPanel extends JPanel
{

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

		PersonDM pm = new PersonDM(txtId, txtFName, txtLName, txtAge);

		// ======================================================

		setBackground(Color.lightGray);
		JTable tab = new JTable(pm);
		JScrollPane jsp = new JScrollPane(tab);
		jsp.setBounds(25, 230, 650, 200);
		add(jsp);

		ImageIcon addIcon = new ImageIcon("D:\\Dropbox\\shared\\MCPP_Person\\icons\\add.png");
		JButton btnCreate = new JButton("Create", addIcon);
		btnCreate.setBounds(90, 450, 120, 30);
		btnCreate.addActionListener(pm.cl);
		add(btnCreate);

		ImageIcon deleteIcon = new ImageIcon("D:\\Dropbox\\shared\\MCPP_Person\\icons\\delete.png");
		JButton btnDelete = new JButton("Delete", deleteIcon);
		btnDelete.setBounds(480, 450, 120, 30);
		btnDelete.addActionListener(pm.dl);
		add(btnDelete);

		ImageIcon readIcon = new ImageIcon("D:\\Dropbox\\shared\\MCPP_Person\\icons\\read.png");
		JButton btnRead = new JButton("Read", readIcon);
		btnRead.setBounds(220, 450, 120, 30);
		btnRead.addActionListener(pm.rl);
		add(btnRead);

		ImageIcon updateIcon = new ImageIcon("D:\\Dropbox\\shared\\MCPP_Person\\icons\\update.png");
		JButton btnUpdate = new JButton("Update", updateIcon);
		btnUpdate.setBounds(350, 450, 120, 30);
		btnUpdate.addActionListener(pm.ul);
		add(btnUpdate);
	}
}
