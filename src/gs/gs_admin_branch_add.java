package gs;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.*;
import PosDAO.*;
import PosVO.*;

public class gs_admin_branch_add extends JDialog {
	private JTextField txt_name;
	private JTextField txt_adress;
	private JTextField txt_pw = new JTextField();
	private JTextField txt_id = new JTextField();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			gs_admin_branch_add dialog = new gs_admin_branch_add();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public gs_admin_branch_add() {
		setResizable(false);
		setBounds(500, 200, 480, 360);
		getContentPane().setLayout(null);
		setLocation(200,200);
		setUndecorated(true);
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
			btn_save.addActionListener(new MyActionListener_save());
			getRootPane().setDefaultButton(btn_save);
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
		{
			txt_name = new JTextField();
			txt_name.setBounds(107, 85, 234, 21);
			getContentPane().add(txt_name);
			txt_name.setColumns(10);
		}
		{
			txt_adress = new JTextField();
			txt_adress.setBounds(107, 116, 234, 21);
			getContentPane().add(txt_adress);
			txt_adress.setColumns(10);
		}
		

		txt_pw.setBounds(107, 240, 234, 21);
		getContentPane().add(txt_pw);
		txt_pw.setColumns(10);

		txt_id.setBounds(107, 186, 234, 21);
		getContentPane().add(txt_id);
		txt_id.setColumns(10);
		JLabel bgimage = new JLabel("");
		bgimage.setIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\dialogue_user_add.png"));
		bgimage.setBounds(0, 0, 480, 360);
		getContentPane().add(bgimage);
		bgimage.setBorder(null);
		setVisible(true);
	}
	class MyActionListener_save implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String name = txt_name.getText();
			String adress = txt_adress.getText();
			String id = txt_id.getText();
			String pw = txt_pw.getText();
			if(name.equals("") || adress.equals("") || id.equals("") || pw.equals(""))
			{
				new txt_warning();
			}
			else
			{
				adminBranchDAO dao = new adminBranchDAO();
				dao.branchInsert(new BranchAccountVO(id,pw,name,adress));
				new save_information();
				dispose();
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
