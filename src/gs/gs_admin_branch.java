package gs;

import PosDAO.*;
import PosVO.*;
import gs.gs_admin_goods.MyListSelectionListener;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class gs_admin_branch extends JPanel {
	private JTextField txt_name;

	String[] Header = { "\uC9C0\uC810\uBC88\uD638", "\uC8FC\uC18C", "\uC9C0\uC810\uBA85" };
	String[][] Object = {};
	private DefaultTableModel model = new DefaultTableModel(Object, Header);
	private JTable table = new JTable(model) {
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	private JScrollPane scrollpane = new JScrollPane(table);
	String[] row = new String[3];
	adminBranchDAO dao;

	ArrayList<BranchInfoVO> list;

	/**
	 * Create the panel.
	 */
	public gs_admin_branch() {
		setLayout(null);
		dao = new adminBranchDAO();

		txt_name = new JTextField();
		txt_name.setBorder(null);
		txt_name.setFont(new Font("±¼¸²", Font.PLAIN, 18));
		txt_name.setBounds(101, 76, 300, 54);
		add(txt_name);
		txt_name.setColumns(10);

		JButton btn_manage_branch = new JButton("");
		btn_manage_branch.setPressedIcon(
				new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\btn_manage_branch_click.png"));
		btn_manage_branch
				.setIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\btn_manage_branch.png"));
		btn_manage_branch.setRolloverEnabled(false);
		btn_manage_branch.setBorderPainted(false);
		btn_manage_branch.setBorder(null);
		btn_manage_branch.setBounds(567, 76, 304, 54);
		add(btn_manage_branch);

		JButton btn_delete = new JButton("");
		btn_delete.setPressedIcon(
				new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\btn_delete_click.png"));
		btn_delete.setIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\btn_delete.png"));
		btn_delete.setRolloverEnabled(false);
		btn_delete.setFocusPainted(false);
		btn_delete.setBorderPainted(false);
		btn_delete.setBounds(725, 13, 146, 54);
		add(btn_delete);
		
		JLabel lbname = new JLabel("");
		lbname.setBorder(null);
		lbname.setIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\\uC9C0\uC810\uAD00\uB9AC.png"));
		lbname.setBounds(0, 0, 357, 56);
		add(lbname);

		JButton btn_add = new JButton("");
		btn_add.setPressedIcon(
				new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\btn_add_click.png"));
		btn_add.setIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\btn_add.png"));
		btn_add.setRolloverEnabled(false);
		btn_add.setFocusPainted(false);
		btn_add.setBorderPainted(false);
		btn_add.setBounds(567, 13, 146, 54);
		add(btn_add);

		JButton btn_show = new JButton("");
		btn_show.setPressedIcon(
				new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\btn_show_click.png"));
		btn_show.setIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\btn_show.png"));
		btn_show.setBorderPainted(false);
		btn_show.setFocusPainted(false);
		btn_show.setRolloverEnabled(false);
		btn_show.setBounds(413, 76, 146, 54);
		add(btn_show);

		table.getColumnModel().getColumn(1).setPreferredWidth(371);
		table.setRowSelectionAllowed(false);
		table.setBounds(32, 152, 817, 466);
		table.getTableHeader().setReorderingAllowed(false);
		scrollpane.setSize(863, 530);
		scrollpane.setLocation(8, 139);
		add(scrollpane);

		JLabel lbl_goods_image = new JLabel("");
		lbl_goods_image.setBounds(614, 163, 210, 210);
		add(lbl_goods_image);

		JLabel bgimage = new JLabel("");
		bgimage.setIcon(
				new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\label_fraim_minbranch.png"));
		bgimage.setBounds(0, 0, 879, 676);
		add(bgimage);

		btn_show.addActionListener(new MyActionListener_show());
		btn_add.addActionListener(new MyActionListener_manage_add());
		btn_manage_branch.addActionListener(new MyActionListener_manage_branch());
		btn_delete.addActionListener(new MyActionListener_delete());

	}

	class MyActionListener_delete implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			int index = table.getSelectedRow();

			if (index < 0)
				new select_warning();
			else {
				int num = Integer
						.parseInt((String) table.getValueAt(table.getSelectedRow(),0));
				boolean result = dao.branchDelete(num);
				if (result == true)
				{
					System.out.println("update success");
					new save_information();
				}
				model.removeRow(index);
			}
		}
	}

	class MyActionListener_show implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			model.setNumRows(0);
			adminBranchDAO dao = new adminBranchDAO();
			list = dao.branchSelect(txt_name.getText());
			for (BranchInfoVO vo : list) {
				row[0] = vo.getBranchNum() + "";
				row[1] = vo.getBranchAddr();
				row[2] = vo.getBranchName();
				String a[] = { row[0], row[1], row[2] };
				model.addRow(a);
			}
		}
	}

	class MyActionListener_manage_add implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new gs_admin_branch_add();
		}
	}

	class MyActionListener_manage_branch implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new gs_admin_branch_manage(
					(String)table.getValueAt(table.getSelectedRow(), 0),
					(String)table.getValueAt(table.getSelectedRow(), 2),
					(String)table.getValueAt(table.getSelectedRow(), 1));
		}
	}
}
