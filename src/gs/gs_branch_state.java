package gs;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import PosDAO.*;
import PosVO.*;
import gs.gs_branch_order.MyListSelectionListener;

import java.util.*;

public class gs_branch_state extends JPanel {
	StateDAO dao;
	JSpinner txt_start_year = new JSpinner();
	JSpinner txt_end_day = new JSpinner();
	JSpinner txt_end_year = new JSpinner();
	JSpinner txt_start_day = new JSpinner();
	JSpinner txt_start_month = new JSpinner();
	JSpinner txt_end_month = new JSpinner();
	JComboBox comboBox = new JComboBox();
	JLabel lbl_image = new JLabel("");
	ArrayList<StateResultVO> list;
	int sum=0;
	
	String[] Header = {"판매번호","바코드", "상품명", "상품가격", "판매개수", "판매금액","날짜"};
	private String[] row = new String[7];
	private ImageIcon icon;
	String[][] Object = {};
	private DefaultTableModel model = new DefaultTableModel(Object, Header);
	private JTable table = new JTable(model) {
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	private JScrollPane scrollpane = new JScrollPane(table);
	private final JPanel panel = new JPanel();
	private JTextField amount;
	private final JLabel label = new JLabel("");
	
	
	
	
	/**
	 * Create the panel.
	 */
	public gs_branch_state() {
		setLayout(null);
		dao = new StateDAO();

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
		
		JButton btn_show = new JButton("");
		btn_show.setPressedIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\btn_show_click.png"));
		btn_show.setIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\btn_show.png"));
		btn_show.setBorderPainted(false);
		btn_show.setFocusPainted(false);
		btn_show.setRolloverEnabled(false);
		btn_show.setBounds(725, 77, 146, 54);
		add(btn_show);
		
		JButton btn_sell_cancel = new JButton("");
		btn_sell_cancel.setPressedIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\btn_sell_cancel_click.png"));
		btn_sell_cancel.setIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\btn_sell_cancel.png"));
		btn_sell_cancel.setRolloverEnabled(false);
		btn_sell_cancel.setFocusPainted(false);
		btn_sell_cancel.setBorderPainted(false);
		btn_sell_cancel.setBounds(8, 606, 304, 54);
		add(btn_sell_cancel);
		

		txt_end_year.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txt_end_year.setBorder(null);
		txt_end_year.setModel(new SpinnerNumberModel(2020, 2020, 2050, 1));
		txt_end_year.setFont(new Font("굴림", Font.PLAIN, 18));
		txt_end_year.setBounds(259, 97, 89, 34);
		add(txt_end_year);

		txt_end_month.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txt_end_month.setBorder(null);
		txt_end_month.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		txt_end_month.setFont(new Font("굴림", Font.PLAIN, 18));
		txt_end_month.setBounds(388, 97, 48, 34);
		add(txt_end_month);
		

		txt_end_day.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txt_end_day.setBorder(null);
		txt_end_day.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		txt_end_day.setFont(new Font("굴림", Font.PLAIN, 18));
		txt_end_day.setBounds(476, 97, 48, 34);
		add(txt_end_day);
		

		txt_start_year.setModel(new SpinnerNumberModel(2019, 2010, 2030, 1));
		txt_start_year.setFont(new Font("굴림", Font.PLAIN, 18));
		txt_start_year.setBorder(null);
		txt_start_year.setBounds(259, 55, 89, 34);
		add(txt_start_year);
		

		txt_start_month.setModel(new SpinnerNumberModel(12, 1, 12, 1));
		txt_start_month.setFont(new Font("굴림", Font.PLAIN, 18));
		txt_start_month.setBorder(null);
		txt_start_month.setBounds(388, 55, 48, 34);
		add(txt_start_month);
		
		amount = new JTextField();
		amount.setHorizontalAlignment(SwingConstants.CENTER);
		amount.setBorder(null);
		amount.setFont(new Font("굴림", Font.PLAIN, 18));
		amount.setEditable(false);
		amount.setBounds(318, 626, 241, 34);
		add(amount);
		amount.setColumns(10);
		

		txt_start_day.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		txt_start_day.setFont(new Font("굴림", Font.PLAIN, 18));
		txt_start_day.setBorder(null);
		txt_start_day.setBounds(476, 54, 48, 34);
		add(txt_start_day);
		label.setIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\\uB9E4\uC7A5\uD604\uD669.png"));
		label.setBorder(null);
		label.setBounds(0, 0, 357, 56);
		
		add(label);
		panel.setBounds(8, 139, 551, 454);
		
		add(panel);
		panel.setLayout(null);
		scrollpane.setBounds(0, 0, 551, 456);
		panel.add(scrollpane);
		table.getSelectionModel().addListSelectionListener(new MyListSelectionListener());
		
		JLabel lblNewLabel = new JLabel("\uCD1D \uD310\uB9E4\uAE08\uC561");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBorder(null);
		lblNewLabel.setBounds(393, 606, 89, 15);
		add(lblNewLabel);
		
		lbl_image.setBounds(615, 163, 210, 210);
		add(lbl_image);
		
		JLabel bg = new JLabel();
		bg.setIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\label_frame_state - \uBCF5\uC0AC\uBCF8.png"));
		bg.setBounds(0, 0, 879, 676);
		add(bg);
		btn_show.addActionListener(new MyActionListener_show());
		btn_sell_cancel.addActionListener(new MyActionListener_cancel());
	}
	class MyActionListener_cancel implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e){
			int index = table.getSelectedRow();
			if (index < 0)
				new select_warning();
			else
			{
				boolean result = dao.stateDelete((String)table.getValueAt(index, 0));
				if(result == true)
					new save_information();
				model.removeRow(index);
			}
		}
	}
	class MyListSelectionListener implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (table.getSelectedRow() > -1 && e.getValueIsAdjusting()) {
				lbl_image.setIcon(list.get(table.getSelectedRow()).getIcon());
			}
		}
	}
	class MyActionListener_show implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
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
			String startdate = txt_start_year.getValue().toString() + "-"+ txt_start_month.getValue().toString()+"-"+txt_start_day.getValue().toString();
			System.out.println();
			String enddate = txt_end_year.getValue().toString() + "-"+ txt_end_month.getValue().toString()+"-"+txt_end_day.getValue().toString();
			list = dao.stateSearch(new StateVO(type, startdate, enddate));
			for(StateResultVO vo : list)
			{//"판매번호","바코드", "상품명", "상품가격", "판매개수", "판매금액","날짜"
				row[0] = vo.getsellnum();
				row[1] = vo.getgoodscode();
				row[2] = vo.getgoodsname();
				row[3] = vo.getSellprice()+"";
				row[4] = vo.getSellcount()+"";
				row[5] = vo.getSelltotal()+"";
				row[6] = vo.getDate();
				lbl_image.setIcon(vo.getIcon());
				String a[] = { row[0], row[1], row[2], row[3], row[4], row[5], row[6] };
				sum += vo.getSelltotal();
				model.addRow(a);
			}
			amount.setText(sum+"");
		}
	}
}
