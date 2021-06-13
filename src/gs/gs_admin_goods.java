package gs;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import PosDAO.*;
import PosVO.*;

public class gs_admin_goods extends JPanel {
	String[] Header = {"바코드", "상품명","상품가격","묶음수량","상품종류"};
	private String[] row = new String[5];
	private ImageIcon icon;
	String[][] Object = {};
	private DefaultTableModel model = new DefaultTableModel(Object, Header);
	private JTable table = new JTable(model){public boolean isCellEditable(int row, int column){return false;}};
	private JScrollPane scrollpane = new JScrollPane(table);
	private JLabel lbl_image = new JLabel("");
	private JComboBox comboBox = new JComboBox();
	ArrayList<GoodsVO> list;
	GoodsDAO dao;
	/**
	 * Create the panel.
	 */
	public gs_admin_goods() {
		setLayout(null);
		

		comboBox.setLightWeightPopupEnabled(false);
		comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		comboBox.setFont(new Font("굴림", Font.PLAIN, 18));
		comboBox.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		comboBox.setBackground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\uC804\uCCB4", "\uC2DD\uD488", "\uC544\uC774\uC2A4\uD06C\uB9BC", "\uACFC\uC790", "\uC74C\uB8CC"}));
		comboBox.setMaximumRowCount(5);
		comboBox.setBorder(null);
		comboBox.setBounds(80, 98, 130, 34);
		add(comboBox);
		
		JButton btn_manage_goods = new JButton("");
		btn_manage_goods.setPressedIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\btn_manage_goods_click.png"));
		btn_manage_goods.setIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\btn_manage_goods.png"));
		btn_manage_goods.setRolloverEnabled(false);
		btn_manage_goods.setBorderPainted(false);
		btn_manage_goods.setBorder(null);
		btn_manage_goods.setBounds(567, 76, 304, 54);
		add(btn_manage_goods);
		
		JButton btn_delete = new JButton("");
		btn_delete.setPressedIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\btn_delete_click.png"));
		btn_delete.setIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\btn_delete.png"));
		btn_delete.setRolloverEnabled(false);
		btn_delete.setFocusPainted(false);
		btn_delete.setBorderPainted(false);
		btn_delete.setBounds(725, 13, 146, 54);
		add(btn_delete);
		
		JButton btn_add = new JButton("");
		btn_add.setPressedIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\btn_add_click.png"));
		btn_add.setIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\btn_add.png"));
		btn_add.setRolloverEnabled(false);
		btn_add.setFocusPainted(false);
		btn_add.setBorderPainted(false);
		btn_add.setBounds(567, 13, 146, 54);
		add(btn_add);
		
		JButton btn_show = new JButton("");
		btn_show.setPressedIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\btn_show_click.png"));
		btn_show.setIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\btn_show.png"));
		btn_show.setBorderPainted(false);
		btn_show.setFocusPainted(false);
		btn_show.setRolloverEnabled(false);
		btn_show.setBounds(413, 76, 146, 54);
		add(btn_show);
		table.getTableHeader().setReorderingAllowed(false);
		table.getSelectionModel().addListSelectionListener(new MyListSelectionListener());
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\\uC0C1\uD488\uAD00\uB9AC.png"));
		label.setBorder(null);
		label.setBounds(0, 0, 357, 56);
		add(label);
		scrollpane.setBounds(8, 139, 551, 529);
		add(scrollpane);

		lbl_image.setBounds(614, 163, 210, 210);
		add(lbl_image);
		
		JLabel bgimage = new JLabel("");
		bgimage.setIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\label_admin_goods.png"));
		bgimage.setBounds(0, 0, 879, 676);
		add(bgimage);
		
		btn_show.addActionListener(new MyActionListener_show());
		
		btn_manage_goods.addActionListener(new MyActionListener_goods_manage());
		btn_add.addActionListener(new MyActionListener_goods_add());
		btn_delete.addActionListener(new MyActionListener_goods_delete());
	}
	
	class MyActionListener_goods_delete implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dao = new GoodsDAO();
			boolean result = false;
			int index = table.getSelectedRow();
			if (index < 0)
				new select_warning();
			else {
				result = dao.goodsDelete((String)table.getValueAt(table.getSelectedRow(), 0));
				if(result == true)
				{
					model.removeRow(index);
					lbl_image.setIcon(list.get(list.size()-1).getIcon());
					new information_delete();
					System.out.println("delete success");
				}
				else
				{
					new delete_warning();
				}
			}
		}
	}
	class MyListSelectionListener implements ListSelectionListener
	{
		@Override
		public void valueChanged(ListSelectionEvent e){
			if(table.getSelectedRow() > -1 && e.getValueIsAdjusting()){
				lbl_image.setIcon(list.get(table.getSelectedRow()).getIcon());
			}
		}
	}
	
	class MyActionListener_show implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			model.setNumRows(0);
			GoodsDAO dao = new GoodsDAO();
			int index = comboBox.getSelectedIndex();
			String type = "";
			if(index == 0)
				type = "";
			else if(index == 1)
				type = "식품";
			else if(index == 2)
				type = "아이스크림";
			else if(index == 3)
				type = "과자";
			else if(index == 4)
				type = "음료";
			list = dao.goodsSelect(type);
			for(GoodsVO vo : list)
			{//"바코드", "상품명","상품가격","묶음수량", "상품종류"
				row[0] = vo.getGoodsCode();
				row[1] = vo.getGoodsName();
				row[2] = vo.getGoodsPrice()+"";
				row[3] = vo.getGoodsPackageNum()+"";
				row[4] = vo.getGoodsKind();
				lbl_image.setIcon(icon = vo.getIcon());
				String a [] = {row[0], row[1], row[2], row[3],row[4]};
				model.addRow(a);
			}
		}
	}
	class MyActionListener_goods_add implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			new gs_admin_goods_add();
		}
	}
	class MyActionListener_goods_manage implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			new gs_admin_goods_manage(
					(String)table.getValueAt(table.getSelectedRow(), 0),
					(String)table.getValueAt(table.getSelectedRow(), 1),
					(String)table.getValueAt(table.getSelectedRow(), 2),
					(String)table.getValueAt(table.getSelectedRow(), 3),
					(String)table.getValueAt(table.getSelectedRow(), 4),
					list.get(table.getSelectedRow()).getIcon());
		}
	}
}
