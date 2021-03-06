package gs;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.*;
import PosDAO.*;
import PosVO.*;

public class gs_admin_goods_add extends JDialog {
	private JTextField txt_name;
	private JTextField txt_price;
	private JTextField txt_kind;
	private JTextField txt_packagenum;
	private JLabel lbl_img = new JLabel("");
	private String filePath = "";
	private JTextField txt_code;
	GoodsDAO dao;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			gs_admin_goods_add dialog = new gs_admin_goods_add();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public gs_admin_goods_add() {
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
		
		JButton btn_search = new JButton("");
		btn_search.setRolloverEnabled(false);
		btn_search.setFocusPainted(false);
		btn_search.setBorderPainted(false);
		btn_search.setPressedIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\bth_search_click.png"));
		btn_search.setIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\btn_search.png"));
		btn_search.setBounds(7, 36, 78, 34);
		getContentPane().add(btn_search);
		btn_search.addActionListener(new OpenActionListener());
		{

			lbl_img.setBounds(13, 79, 210, 210);
			getContentPane().add(lbl_img);
		}
		{
			txt_name = new JTextField();
			txt_name.setBounds(331, 90, 116, 21);
			getContentPane().add(txt_name);
			txt_name.setColumns(10);
		}
		{
			txt_price = new JTextField();
			txt_price.setBounds(331, 177, 116, 21);
			getContentPane().add(txt_price);
			txt_price.setColumns(10);
		}
		{
			txt_kind = new JTextField();
			txt_kind.setBounds(331, 133, 116, 21);
			getContentPane().add(txt_kind);
			txt_kind.setColumns(10);
		}
		{
			txt_packagenum = new JTextField();
			txt_packagenum.setBounds(331, 219, 116, 21);
			getContentPane().add(txt_packagenum);
			txt_packagenum.setColumns(10);
		}
		{
			txt_code = new JTextField();
			txt_code.setBounds(331, 260, 116, 21);
			getContentPane().add(txt_code);
			txt_code.setColumns(10);
		}
		JLabel bgimage = new JLabel("");
		bgimage.setIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\dialogue_goods_add.png"));
		bgimage.setBounds(0, 0, 480, 360);
		getContentPane().add(bgimage);
		bgimage.setBorder(null);
		setVisible(true);
	}
	class MyActionListener_save implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			dao = new GoodsDAO();
			String code = txt_code.getText();
			String name = txt_name.getText();
			int price = Integer.parseInt(txt_price.getText());
			String kind = txt_kind.getText();
			int packagenum = Integer.parseInt(txt_packagenum.getText());
			if(filePath.equals(""))
				new txt_warning();
			else
			{
				boolean result = dao.goodsInsert(new InsertGoodsVO(
						code, 
						name, 
						kind, 
						price, 
						packagenum, 
						filePath));
				if(result == true)
				{
					new save_information();
					
				}
				else
					new fail_warning();
			}
		}
	}
	class OpenActionListener implements ActionListener
	{
		JFileChooser chooser;
		OpenActionListener()
		{
			chooser = new JFileChooser();
		}
		public void actionPerformed(ActionEvent e)
		{
			FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG images", "jpg");
			chooser.setFileFilter(filter);
			int ret = chooser.showOpenDialog(null);
			if(ret != JFileChooser.APPROVE_OPTION)
			{
				JOptionPane.showMessageDialog(null, "?????? ???????? ??????????.", "????", JOptionPane.WARNING_MESSAGE);
				return;
			}
			filePath = chooser.getSelectedFile().getPath();
			lbl_img.setIcon(new ImageIcon(filePath));
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
