package gs;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class gs_admin {
	private JFrame frame;
	private JPanel main_panel;
	private CardLayout card;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gs_admin window = new gs_admin();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public gs_admin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setResizable(false);
		frame.setBounds(400, 100, 960, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel dragwindow = new JLabel("");
		dragwindow.setBorder(null);
		dragwindow.setBounds(70, 1, 819, 32);
		frame.getContentPane().add(dragwindow);
		
		JLabel Main_Frame = new JLabel("");
		
		JButton btn_manage_goods = new JButton("", new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\manage_goods.png"));
		btn_manage_goods.setToolTipText("");
		btn_manage_goods.setContentAreaFilled(false);
		btn_manage_goods.setPressedIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\manage_goods_click.png"));
		btn_manage_goods.setRolloverEnabled(false);
		btn_manage_goods.setOpaque(false);
		btn_manage_goods.setFocusable(false);
		btn_manage_goods.setFocusTraversalKeysEnabled(false);
		btn_manage_goods.setFocusPainted(false);
		btn_manage_goods.setBorderPainted(false);
		btn_manage_goods.setBorder(null);
		btn_manage_goods.setBounds(8, 66, 50, 50);
		frame.getContentPane().add(btn_manage_goods);
		
		JButton btn_manage_branch = new JButton("", new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\manage_user.png"));
		btn_manage_branch.setToolTipText("");
		btn_manage_branch.setPressedIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\manage_user_click.png"));
		btn_manage_branch.setRolloverEnabled(false);
		btn_manage_branch.setOpaque(false);
		btn_manage_branch.setFocusable(false);
		btn_manage_branch.setFocusTraversalKeysEnabled(false);
		btn_manage_branch.setFocusPainted(false);
		btn_manage_branch.setContentAreaFilled(false);
		btn_manage_branch.setBorderPainted(false);
		btn_manage_branch.setBorder(null);
		btn_manage_branch.setBounds(8, 8, 50, 50);
		frame.getContentPane().add(btn_manage_branch);
		
		JButton btn_logout = new JButton("", new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\logout_icon.png"));
		btn_logout.setPressedIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\logout_icon_click.png"));
		btn_logout.setRolloverEnabled(false);
		btn_logout.setOpaque(false);
		btn_logout.setFocusable(false);
		btn_logout.setFocusTraversalKeysEnabled(false);
		btn_logout.setFocusPainted(false);
		btn_logout.setContentAreaFilled(false);
		btn_logout.setBorderPainted(false);
		btn_logout.setBorder(null);
		btn_logout.setBounds(8, 662, 50, 50);
		frame.getContentPane().add(btn_logout);
		
		JButton btn_minsize = new JButton("", new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\small_under.png"));
		btn_minsize.setPressedIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\small_under_click.png"));
		btn_minsize.setRolloverEnabled(false);
		btn_minsize.setOpaque(false);
		btn_minsize.setFocusable(false);
		btn_minsize.setFocusTraversalKeysEnabled(false);
		btn_minsize.setFocusPainted(false);
		btn_minsize.setContentAreaFilled(false);
		btn_minsize.setBorderPainted(false);
		btn_minsize.setBorder(null);
		btn_minsize.setBounds(892, 1, 32, 32);
		frame.getContentPane().add(btn_minsize);
		
		JButton btn_exit = new JButton("", new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\small_exit.png"));
		btn_exit.setPressedIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\small_exit_click.png"));
		btn_exit.setRolloverEnabled(false);
		btn_exit.setOpaque(false);
		btn_exit.setFocusable(false);
		btn_exit.setFocusTraversalKeysEnabled(false);
		btn_exit.setFocusPainted(false);
		btn_exit.setContentAreaFilled(false);
		btn_exit.setBorderPainted(false);
		btn_exit.setBorder(null);
		btn_exit.setBounds(926, 1, 32, 32);
		frame.getContentPane().add(btn_exit);
		
		main_panel = new JPanel();
		
		main_panel.setBounds(76, 39, 879, 676);
		frame.getContentPane().add(main_panel);
		main_panel.setLayout(new CardLayout(0, 0));
		card = (CardLayout)main_panel.getLayout();
		
		main_panel.add(new gs_admin_goods(), "admin_goods");
		main_panel.add(new gs_admin_branch(), "admin_branch");
		Main_Frame.setIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\GS_admin.png"));
		Main_Frame.setBounds(0, 0, 960, 720);
		frame.getContentPane().add(Main_Frame);
		
		btn_exit.addActionListener(new MyActionListener_exit());
		btn_minsize.addActionListener(new MyActionListener_minsize());
		btn_manage_goods.addActionListener(new MyActionListener_goods());
		btn_manage_branch.addActionListener(new MyActionListener_branch());
		btn_logout.addActionListener(new MyActionListener_logout());
		frame.setVisible(true);
	}
	class MyActionListener_logout implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			frame.dispose();
			new gs_login();
		}
	}
	class MyActionListener_goods implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			card.show(main_panel, "admin_goods");
		}
	}
	class MyActionListener_branch implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			card.show(main_panel, "admin_branch");
		}
	}
	class MyActionListener_exit implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}
	class MyActionListener_minsize implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			frame.setState(Frame.ICONIFIED);
		}
	}
}
