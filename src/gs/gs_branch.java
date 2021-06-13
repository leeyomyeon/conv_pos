package gs;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class gs_branch {
	private CardLayout card;
	private JFrame frame;
	private JPanel main_panel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gs_branch window = new gs_branch();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public gs_branch() {
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
		dragwindow.addMouseListener(new MyMouseListener_drag());
		
		JButton btn_sell = new JButton("", new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\gs_branch_sell.png"));
		btn_sell.setContentAreaFilled(false);
		btn_sell.setFocusable(false);
		btn_sell.setFocusTraversalKeysEnabled(false);
		btn_sell.setOpaque(false);
		
		btn_sell.setPressedIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\gs_branch_sell_click.png"));
		
		btn_sell.setFocusPainted(false);
		btn_sell.setBorderPainted(false);
		btn_sell.setRolloverEnabled(false);
		btn_sell.setBorder(null);
		btn_sell.setBounds(8, 182, 50, 50);
		frame.getContentPane().add(btn_sell);
		
		JButton btn_inventory = new JButton("", new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\gs_branch_inventory.png"));
		btn_inventory.setContentAreaFilled(false);
		btn_inventory.setPressedIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\gs_branch_inventory_click.png"));
		btn_inventory.setRolloverEnabled(false);
		btn_inventory.setOpaque(false);
		btn_inventory.setFocusable(false);
		btn_inventory.setFocusTraversalKeysEnabled(false);
		btn_inventory.setFocusPainted(false);
		btn_inventory.setBorderPainted(false);
		btn_inventory.setBorder(null);
		btn_inventory.setBounds(8, 66, 50, 50);
		frame.getContentPane().add(btn_inventory);
		
		JButton btn_order = new JButton("", new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\gs_branch_order.png"));
		btn_order.setPressedIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\gs_branch_order_click.png"));
		btn_order.setRolloverEnabled(false);
		btn_order.setOpaque(false);
		btn_order.setFocusable(false);
		btn_order.setFocusTraversalKeysEnabled(false);
		btn_order.setFocusPainted(false);
		btn_order.setContentAreaFilled(false);
		btn_order.setBorderPainted(false);
		btn_order.setBorder(null);
		btn_order.setBounds(8, 124, 50, 50);
		frame.getContentPane().add(btn_order);
		
		JButton btn_state = new JButton("", new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\gs_branch_status.png"));
		btn_state.setSelectedIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\gs_branch_status_click.png"));
		btn_state.setPressedIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\gs_branch_status_click.png"));
		btn_state.setRolloverEnabled(false);
		btn_state.setOpaque(false);
		btn_state.setFocusable(false);
		btn_state.setFocusTraversalKeysEnabled(false);
		btn_state.setFocusPainted(false);
		btn_state.setContentAreaFilled(false);
		btn_state.setBorderPainted(false);
		btn_state.setBorder(null);
		btn_state.setBounds(8, 240, 50, 50);
		frame.getContentPane().add(btn_state);
		
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
		
		JButton btn_home = new JButton("", new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\gs_branch_home.png"));
		btn_home.setPressedIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\gs_branch_home_click.png"));
		btn_home.setRolloverEnabled(false);
		btn_home.setOpaque(false);
		btn_home.setFocusable(false);
		btn_home.setFocusTraversalKeysEnabled(false);
		btn_home.setFocusPainted(false);
		btn_home.setContentAreaFilled(false);
		btn_home.setBorderPainted(false);
		btn_home.setBorder(null);
		btn_home.setBounds(8, 8, 50, 50);
		frame.getContentPane().add(btn_home);
		
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
		
		main_panel.add(new gs_branch_home(), "home");
		main_panel.add(new gs_branch_sell(), "sell");
		main_panel.add(new gs_branch_inventory(), "inventory");
		main_panel.add(new gs_branch_order(), "order");
		main_panel.add(new gs_branch_state(), "state");

		card = (CardLayout)main_panel.getLayout();
		card.show(main_panel, "home");
		
		JLabel Main_Frame = new JLabel("");
		Main_Frame.setIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\GS_Branch_main.png"));
		Main_Frame.setBounds(0, 0, 960, 720);
		frame.getContentPane().add(Main_Frame);
		
		btn_sell.addActionListener(new MyActionListener_sell());
		btn_inventory.addActionListener(new MyActionListener_inventory());
		btn_state.addActionListener(new MyActionListener_state());
		btn_order.addActionListener(new MyActionListener_order());
		btn_home.addActionListener(new MyActionListener_home());
		btn_exit.addActionListener(new MyActionListener_exit());
		btn_minsize.addActionListener(new MyActionListener_minsize());
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
	class MyMouseListener_drag extends MouseAdapter
	{
		public void mouseDragged(MouseEvent e)
		{
			frame.setLocation(e.getPoint());
		}
	}
	class MyActionListener_state implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			card.show(main_panel, "state");
		}
	}
	class MyActionListener_order implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			card.show(main_panel, "order");
		}
	}
	class MyActionListener_home implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			card.show(main_panel, "home");
		}
	}
	class MyActionListener_sell implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			card.show(main_panel, "sell");
		}
	}
	class MyActionListener_inventory implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			card.show(main_panel, "inventory");
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
