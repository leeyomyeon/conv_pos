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
import gs.gs_admin_goods.MyListSelectionListener;

public class gs_branch_inventory extends JPanel {
	String[] Header = {"바코드", "상품명","상품가격","수량","금액"};
	private String[] row = new String[5];
	private ImageIcon icon;
	String[][] Object = {};
	private DefaultTableModel model = new DefaultTableModel(Object, Header);
	private JTable table = new JTable(model){public boolean isCellEditable(int row, int column){return false;}};
	private JScrollPane scrollpane = new JScrollPane(table);
	private JComboBox cbx_type;
	public JLabel lbl_image = new JLabel("");
	InventoryDAO dao;
	ArrayList<InventoryVO> list;
	private final JLabel label = new JLabel("");
	/**
	 * Create the panel.
	 */
	public gs_branch_inventory() {
		setLayout(null);
		label.setIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\\uC7AC\uACE0\uD655\uC778.png"));
		label.setBorder(null);
		label.setBounds(0, 0, 357, 56);
		
		add(label);
		cbx_type = new JComboBox();
		cbx_type.setModel(new DefaultComboBoxModel(new String[] {"\uC804\uCCB4", "\uC2DD\uD488", "\uC544\uC774\uC2A4\uD06C\uB9BC", "\uACFC\uC790", "\uC74C\uB8CC"}));
		cbx_type.setMaximumRowCount(5);
		cbx_type.setLightWeightPopupEnabled(false);
		cbx_type.setFont(new Font("굴림", Font.PLAIN, 18));
		cbx_type.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		cbx_type.setBorder(null);
		cbx_type.setBackground(Color.WHITE);
		cbx_type.setBounds(80, 98, 130, 34);
		add(cbx_type);
		
		JButton btn_show = new JButton("");
		btn_show.setIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\btn_show.png"));
		btn_show.setPressedIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\btn_show_click.png"));
		btn_show.setRolloverEnabled(false);
		btn_show.setFocusPainted(false);
		btn_show.setBorderPainted(false);
		btn_show.setBounds(567, 75, 146, 54);
		add(btn_show);
		
		table.getTableHeader().setReorderingAllowed(false);
		table.getSelectionModel().addListSelectionListener(new MyListSelectionListener());

		scrollpane.setBounds(8, 139, 551, 529);
		add(scrollpane);
		
		lbl_image.setIcon(null);
		lbl_image.setBounds(614, 163, 210, 210);
		add(lbl_image);
		
		JLabel bgimage = new JLabel("");
		bgimage.setIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\label_frame_inventory.png"));
		bgimage.setBounds(0, 0, 879, 676);
		add(bgimage);
		
		btn_show.addActionListener(new MyActionListener_show());
		
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
			dao = new InventoryDAO();
			int index = cbx_type.getSelectedIndex();
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
			list = dao.inventorySelect(new gknameVO("", type));
			for(InventoryVO vo : list)
			{//"바코드", "상품명","상품가격","보유수량","금액"
				row[0] = vo.getGoods_code();
				row[1] = vo.getGoods_name();
				row[2] = vo.getGoods_price()+"";
				row[3] = vo.getinven_count()+"";
				row[4] = (vo.getGoods_price()*vo.getinven_count())+"";
				lbl_image.setIcon(vo.getIcon());
				String a [] = {row[0], row[1], row[2], row[3], row[4]};
				model.addRow(a);
			}
		}
	}
}
