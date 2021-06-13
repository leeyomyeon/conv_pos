package gs;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import PosDAO.*;
import PosVO.*;
import java.util.*;

public class gs_branch_sell extends JPanel {
	private JTextField txt_barcode;
	private JTextField txt_count;
	String[] Header = {"바코드", "상품명","상품가격","수량","금액"};
	String[] row = new String[5];
	String[][] Object = {};
	private DefaultTableModel model = new DefaultTableModel(Object,Header);
	private JTable table=new JTable(model){public boolean isCellEditable(int row, int column){return false;}};
	private JScrollPane scrollpane = new JScrollPane(table);
	SellDAO dao;
	int sum;
	JLabel amount;
	ArrayList<SellList> list;
	/**
	 * Create the panel.
	 */
	public gs_branch_sell() {
		setLayout(null);
		dao = new SellDAO();
		txt_barcode = new JTextField();
		txt_barcode.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txt_barcode.setFont(new Font("굴림", Font.PLAIN, 18));
		txt_barcode.setBorder(null);
		txt_barcode.setBounds(107, 97, 245, 33);
		add(txt_barcode);
		txt_barcode.setColumns(1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\\uC0C1\uD488\uD310\uB9E4.png"));
		label.setBorder(null);
		label.setBounds(0, 0, 357, 56);
		add(label);
		
		amount = new JLabel("0");
		amount.setHorizontalTextPosition(SwingConstants.CENTER);
		amount.setHorizontalAlignment(SwingConstants.CENTER);
		amount.setFont(new Font("굴림", Font.PLAIN, 18));
		amount.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		amount.setBorder(null);
		amount.setBounds(275, 634, 284, 34);
		add(amount);
		
		txt_count = new JTextField();
		txt_count.setFont(new Font("굴림", Font.PLAIN, 18));
		txt_count.setBorder(null);
		txt_count.setBounds(432, 97, 40, 33);
		add(txt_count);
		txt_count.setColumns(1);
		
		JButton btn_delete = new JButton("");
		btn_delete.setPressedIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\btn_goods_delete_click.png"));
		btn_delete.setIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\btn_goods_delete.png"));
		btn_delete.setBorderPainted(false);
		btn_delete.setRolloverEnabled(false);
		btn_delete.setBorder(null);
		btn_delete.setBounds(567, 308, 304, 54);
		add(btn_delete);
		
		JButton btn_allcancel = new JButton("");
		btn_allcancel.setPressedIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\btn_pay_allcancel_click.png"));
		btn_allcancel.setIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\btn_pay_allcancel.png"));
		btn_allcancel.setRolloverEnabled(false);
		btn_allcancel.setBorderPainted(false);
		btn_allcancel.setBorder(null);
		btn_allcancel.setBounds(567, 383, 304, 54);
		add(btn_allcancel);
		
		JButton btn_card = new JButton("");
		btn_card.setPressedIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\btn_pay_card_click.png"));
		btn_card.setIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\btn_pay_card.png"));
		btn_card.setRolloverEnabled(false);
		btn_card.setBorderPainted(false);
		btn_card.setBorder(null);
		btn_card.setBounds(567, 465, 304, 54);
		add(btn_card);
		
		JButton btn_cash = new JButton("");
		btn_cash.setIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\btn_pay_cash.png"));
		btn_cash.setPressedIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\btn_pay_cash_click.png"));
		btn_cash.setRolloverEnabled(false);
		btn_cash.setBorderPainted(false);
		btn_cash.setBorder(null);
		btn_cash.setBounds(567, 540, 304, 54);
		add(btn_cash);
		
		JButton btn_add = new JButton("");
		btn_add.setPressedIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\add_icon_click.png"));
		btn_add.setIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\add_icon.png"));
		btn_add.setRolloverEnabled(false);
		btn_add.setBorderPainted(false);
		btn_add.setBorder(null);
		btn_add.setBounds(481, 97, 78, 34);
		add(btn_add);
		
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(300);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.setBorder(null);
		table.setBounds(32, 152, 817, 466);
		table.getTableHeader().setReorderingAllowed(false);
		scrollpane.setBorder(null);
		scrollpane.setSize(551, 487);
		scrollpane.setLocation(8, 139);
		add(scrollpane);
		
		JLabel bgimage = new JLabel("");
		bgimage.setFont(new Font("굴림", Font.PLAIN, 18));
		bgimage.setIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\label_frame_sell1.png"));
		bgimage.setBounds(0, 0, 879, 676);
		add(bgimage);
		btn_delete.addActionListener(new MyActionListener_delete());
		btn_allcancel.addActionListener(new MyActionListener_allcancel());
		btn_card.addActionListener(new MyActionListener_pay());
		btn_cash.addActionListener(new MyActionListener_pay());
		btn_add.addActionListener(new MyActionListener_add());
	}
	class MyActionListener_delete implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			int index = table.getSelectedRow();
			String code = (String)table.getValueAt(index, 0);
			if(index < 0)
				new select_warning();
			else
			{
				dao.deleteSellList(code);
				model.removeRow(index);
			}
		}
	}
	class MyActionListener_allcancel implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			model.setNumRows(0);
			dao.deleteAllSellList();
			
		}
	}
	class MyActionListener_pay implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(dao.payment() == false)
				new fail_warning();
			else
			{
				model.setNumRows(0);
				amount.setText("");
				sum = 0;
				new pay_information();
			}
		}
	}
	class MyActionListener_add implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String goodsCode = txt_barcode.getText();
			int num = Integer.parseInt(txt_count.getText());
			
			boolean result = dao.addSellList(new SellVO(goodsCode, num));
			if(result == true)
			{
				model.setNumRows(0);
				list = dao.viewSellList();
				for(SellList vo : list)
				{//"바코드", "상품명","상품가격","수량","금액"
					row[0] = vo.getGoodscode();
					row[1] = vo.getGoodsname();
					row[2] = vo.getGoodsprice()+"";
					row[3] = vo.getGoodscount()+"";
					row[4] = (vo.getGoodsprice()*vo.getGoodscount())+"";
					sum += vo.getGoodsprice()*vo.getGoodscount();
					String a[] = {row[0], row[1], row[2], row[3], row[4]};
					model.addRow(a);
				}
				amount.setText(sum+"");
				txt_barcode.setText("");
				txt_count.setText("");
			}
		}
	}
}
