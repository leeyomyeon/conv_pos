package gs;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import PosDAO.*;
import PosVO.*;
import gs.gs_branch_inventory.MyListSelectionListener;

import java.util.*;

public class gs_branch_order extends JPanel 
{
	CardLayout card;
	String[] Header1 = {"바코드", "상품명","상품가격","묶음개수","발주개수","발주금액"};
	private String[] arow = new String[6];
	String[][] Object1 = {};
	private DefaultTableModel model1 = new DefaultTableModel(Object1, Header1);
	private JTable table1 = new JTable(model1) {
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	private JScrollPane scrollpane1 = new JScrollPane(table1);
	private JPanel panel = new JPanel();
	
	String[] Header = { "바코드", "상품명", "상품가격", "묶음개수"};
	private String[] row = new String[4];
	private ImageIcon icon;
	String[][] Object = {};
	private DefaultTableModel model = new DefaultTableModel(Object, Header);
	private JTable table = new JTable(model) {
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	private JScrollPane scrollpane = new JScrollPane(table);
	private JComboBox comboBox = new JComboBox();
	public JLabel lbl_image = new JLabel("");
	ArrayList<OrderVO> list;
	ArrayList<OrderVO> list2;
	OrderDAO dao;
	private JTextField txt_amount;
	private final JLabel label = new JLabel("");

	/**
	 * Create the panel.
	 */
	public gs_branch_order() {
		setLayout(null);
		dao = new OrderDAO();
		card = (CardLayout)getLayout();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "\uC804\uCCB4", "\uC2DD\uD488",
				"\uC544\uC774\uC2A4\uD06C\uB9BC", "\uACFC\uC790", "\uC74C\uB8CC" }));
		comboBox.setMaximumRowCount(5);
		comboBox.setLightWeightPopupEnabled(false);
		comboBox.setFont(new Font("굴림", Font.PLAIN, 18));
		comboBox.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		comboBox.setBorder(null);
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(80, 98, 130, 34);
		add(comboBox);
		label.setIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\\uC0C1\uD488\uBC1C\uC8FC.png"));
		label.setBorder(null);
		label.setBounds(0, 0, 357, 56);
		
		add(label);

		JButton btn_show = new JButton("");
		btn_show.setPressedIcon(
				new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\btn_show_click.png"));
		btn_show.setIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\btn_show.png"));
		btn_show.setRolloverEnabled(false);
		btn_show.setFocusPainted(false);
		btn_show.setBorderPainted(false);
		btn_show.setBounds(567, 75, 146, 54);
		add(btn_show);

		JButton btn_save = new JButton("");
		btn_save.setIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\btn_save.png"));
		btn_save.setPressedIcon(
				new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\btn_save_click.png"));
		btn_save.setBorderPainted(false);
		btn_save.setFocusPainted(false);
		btn_save.setRolloverEnabled(false);
		btn_save.setBounds(725, 75, 146, 54);
		add(btn_save);

		JButton btn_order_show = new JButton("");
		btn_order_show
				.setIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\btn_orderstate.png"));
		btn_order_show.setPressedIcon(
				new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\btn_orderstate_click.png"));
		btn_order_show.setRolloverEnabled(false);
		btn_order_show.setFocusPainted(false);
		btn_order_show.setBorderPainted(false);
		btn_order_show.setBounds(567, 405, 304, 54);
		add(btn_order_show);

		JButton btn_order = new JButton("");
		btn_order.setIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\btn_order.png"));
		btn_order.setPressedIcon(
				new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\btn_order_click.png"));
		btn_order.setBorderPainted(false);
		btn_order.setFocusPainted(false);
		btn_order.setRolloverEnabled(false);
		btn_order.setBounds(567, 469, 304, 54);
		add(btn_order);
		
		txt_amount = new JTextField();
		txt_amount.setHorizontalAlignment(SwingConstants.CENTER);
		txt_amount.setBorder(null);
		txt_amount.setBounds(307, 584, 166, 30);
		add(txt_amount);
		txt_amount.setColumns(10);
		

		panel.setBounds(8, 139, 551, 431);
		add(panel);
		panel.setLayout(new CardLayout(0, 0));
		card = (CardLayout)panel.getLayout();

		panel.add(scrollpane, "order");
		panel.add(scrollpane1, "order_state");
		
		table1.getSelectionModel().addListSelectionListener(new MyListSelectionListener2());
		table1.getTableHeader().setReorderingAllowed(false);
		table.getSelectionModel().addListSelectionListener(new MyListSelectionListener());
		table.getTableHeader().setReorderingAllowed(false);

		lbl_image.setBounds(614, 163, 210, 210);
		add(lbl_image);

		JLabel bgimage = new JLabel("");
		bgimage.setIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\label_frame_order.png"));
		bgimage.setBounds(0, 0, 879, 676);
		add(bgimage);
		btn_show.addActionListener(new MyActionListener_show());
		btn_save.addActionListener(new MyActionListener_save());
		btn_order_show.addActionListener(new MyActionListener_order_show());
		btn_order.addActionListener(new MyActionListener_order());
	}

	class MyListSelectionListener implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (table.getSelectedRow() > -1 && e.getValueIsAdjusting()) {
				lbl_image.setIcon(list.get(table.getSelectedRow()).getIcon());
			}
		}
	}
	class MyListSelectionListener2 implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (table.getSelectedRow() > -1 && e.getValueIsAdjusting()) {
				lbl_image.setIcon(list2.get(table1.getSelectedRow()).getIcon());
			}
		}
	}

	class MyActionListener_show implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			model.setNumRows(0);
			int index = comboBox.getSelectedIndex();
			String type = "";
			if (index == 0)
				type = "";
			else if (index == 1)
				type = "식품";
			else if (index == 2)
				type = "아이스크림";
			else if (index == 3)
				type = "과자";
			else if (index == 4)
				type = "음료";
			list = dao.goodsSelect(type);
			for (OrderVO vo : list) {// "바코드", "상품명","상품가격","묶음개수"
				row[0] = vo.getGoodsCode();
				row[1] = vo.getGoodsName();
				row[2] = vo.getGoodsPrice() + "";
				row[3] = vo.getGoodsPackageNum() + "";
				lbl_image.setIcon(vo.getIcon());
				String a[] = { row[0], row[1], row[2], row[3] };
				model.addRow(a);
			}
			card.show(panel, "order");
		}
	}
	
	class MyActionListener_save implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			OrderVO tmpvo = list.get(table.getSelectedRow());
			int amount = Integer.parseInt(txt_amount.getText());
			OrderVO vo = new OrderVO(tmpvo.getGoodsCode(), 
					tmpvo.getGoodsName(), 
					tmpvo.getGoodsPrice(), 
					tmpvo.getGoodsPackageNum(),
					tmpvo.getGoodsPackageSelectNum()+amount);
			vo.setIcon(tmpvo.getIcon());
			dao.inputOrderList(vo);
			new save_information();
			txt_amount.setText("");
		}
	}

	class MyActionListener_order_show implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			list2 = dao.viewOrderList();
			model1.setNumRows(0);
			int index = comboBox.getSelectedIndex();
			String type = "";
			if (index == 0)
				type = "";
			else if (index == 1)
				type = "식품";
			else if (index == 2)
				type = "아이스크림";
			else if (index == 3)
				type = "과자";
			else if (index == 4)
				type = "음료";
			for (OrderVO vo : list2) {// "바코드", "상품명","상품가격","묶음개수","발주개수","발주금액"
				arow[0] = vo.getGoodsCode();
				arow[1] = vo.getGoodsName();
				arow[2] = vo.getGoodsPrice() + "";
				arow[3] = vo.getGoodsPackageNum() + "";
				arow[4] = vo.getGoodsPackageSelectNum() + "";
				arow[5] = (vo.getGoodsPrice() * vo.getGoodsPackageSelectNum()) + "";
				lbl_image.setIcon(vo.getIcon());
				String a[] = { arow[0], arow[1], arow[2], arow[3], arow[4], arow[5] };
				model1.addRow(a);
			}
			card.show(panel, "order_state");
		}
	}

	class MyActionListener_order implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			boolean result = dao.inventoryInsert();
			if(result == true)
			{
				new order_information();
				model1.setNumRows(0);
				dao.clearalllist();
			}
		}
	}
}
