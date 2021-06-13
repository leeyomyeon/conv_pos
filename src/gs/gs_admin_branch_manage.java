package gs;

import PosDAO.*;
import PosVO.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.*;


public class gs_admin_branch_manage extends JDialog {
	private JTextField txt_name;
	private JTextField txt_adress;
	public JTextField txt_num;
	adminBranchDAO dao;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the dialog.
	 */
	public gs_admin_branch_manage(String num, String name, String adress) {
		setResizable(false);
		setBounds(500, 200, 480, 360);
		getContentPane().setLayout(null);
		setLocation(200,200);
		setUndecorated(true);
		
		txt_adress = new JTextField(adress);
		txt_adress.setBounds(116, 119, 209, 21);
		getContentPane().add(txt_adress);
		txt_adress.setColumns(10);
		txt_name = new JTextField(name);
		txt_name.setBounds(116, 88, 209, 21);
		getContentPane().add(txt_name);
		txt_name.setColumns(10);
		
		txt_num = new JTextField(num);
		txt_num.setEditable(false);
		txt_num.setBounds(116, 202, 209, 21);
		getContentPane().add(txt_num);
		txt_num.setColumns(10);
		{
			JButton btn_save = new JButton("");
			btn_save.setPressedIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\btn_save_click.png"));
			btn_save.setIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\btn_save.png"));
			btn_save.setBorderPainted(false);
			btn_save.setFocusPainted(false);
			btn_save.setRolloverEnabled(false);
			btn_save.setBounds(179, 299, 146, 54);
			getContentPane().add(btn_save);
			btn_save.setActionCommand("OK");
			getRootPane().setDefaultButton(btn_save);
			btn_save.addActionListener(new MyActionListener_save());
		}
		{
			JButton btn_cancel = new JButton("");
			btn_cancel.setPressedIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\btn_cancel_click.png"));
			btn_cancel.setIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\btn_cancel.png"));
			btn_cancel.setRolloverEnabled(false);
			btn_cancel.setFocusPainted(false);
			btn_cancel.setBorderPainted(false);
			btn_cancel.setBounds(327, 299, 146, 54);
			getContentPane().add(btn_cancel);
			btn_cancel.setActionCommand("Cancel");
			btn_cancel.addActionListener(new MyActionListener_cancel());
		}
		JLabel bgimage = new JLabel("");
		bgimage.setIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\dialogue_manage_user.png"));
		bgimage.setBounds(0, 0, 480, 360);
		getContentPane().add(bgimage);
		bgimage.setBorder(null);
		
		setVisible(true);
	}
	class MyActionListener_save implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(txt_name.getText().equals("") || txt_adress.getText().equals(""))
			{
				new txt_warning();
			}
			else
			{
				dao = new adminBranchDAO();
				boolean result = dao.branchUpdate(new BranchInfoVO(Integer.parseInt(txt_num.getText()), txt_name.getText(), txt_adress.getText()));
				if(result == true)
				{
					new save_information();
					dispose();
				}
				else
				{
					new fail_warning();
				}
			}
		}
	}
	class MyActionListener_cancel implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			dispose();
		}
	}
}
