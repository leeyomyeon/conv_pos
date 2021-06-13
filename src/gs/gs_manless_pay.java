package gs;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class gs_manless_pay {
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
					gs_manless_pay window = new gs_manless_pay();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public gs_manless_pay() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setResizable(false);
		frame.setBounds(100, 100, 960, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel dragwindow = new JLabel("");
		dragwindow.setBorder(null);
		dragwindow.setBounds(70, 1, 819, 32);
		frame.getContentPane().add(dragwindow);
		dragwindow.addMouseListener(new MyMouseListener_drag());
		
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
		
		main_panel.add(new gs_branch_sell(), "sell");

		card = (CardLayout)main_panel.getLayout();
		card.show(main_panel, "sell");
		
		JLabel Main_Frame = new JLabel("");
		Main_Frame.setIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\gs_manlesspay.png"));
		Main_Frame.setBounds(0, 0, 960, 720);
		frame.getContentPane().add(Main_Frame);
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
			frame.setLocation(e.getXOnScreen(), e.getYOnScreen());
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
