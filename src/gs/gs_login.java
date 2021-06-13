package gs;

import PosDAO.*;
import PosVO.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class gs_login {

	private JFrame frame;
	private JTextField txt_id;
	private JPasswordField txt_pw;
	private JButton btn_manlesspay;
	private JButton btn_exit;
	private JButton btn_minsize;
	LoginDAO dao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gs_login window = new gs_login();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gs_login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(400, 100, 360, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		frame.setResizable(false);
		JButton btn_login = new JButton("");
		btn_login.setMnemonic(KeyEvent.VK_ENTER);
		btn_login.setPressedIcon(
				new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\btn_login_click.png"));
		btn_login.setIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\btn_login.png"));
		btn_login.setBorderPainted(false);
		btn_login.setRolloverEnabled(false);
		btn_login.setForeground(Color.WHITE);
		btn_login.setContentAreaFilled(false);
		btn_login.setBackground(Color.WHITE);
		btn_login.setFocusTraversalKeysEnabled(false);
		btn_login.setFocusPainted(false);
		btn_login.setBounds(30, 350, 304, 54);
		frame.getContentPane().add(btn_login);

		btn_manlesspay = new JButton("");
		btn_manlesspay.setPressedIcon(
				new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\btn_manless_click.png"));
		btn_manlesspay.setIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\btn_manless.png"));
		btn_manlesspay.setRolloverEnabled(false);
		btn_manlesspay.setForeground(Color.WHITE);
		btn_manlesspay.setFocusTraversalKeysEnabled(false);
		btn_manlesspay.setFocusPainted(false);
		btn_manlesspay.setContentAreaFilled(false);
		btn_manlesspay.setBorderPainted(false);
		btn_manlesspay.setBackground(Color.WHITE);
		btn_manlesspay.setBounds(30, 413, 304, 54);
		frame.getContentPane().add(btn_manlesspay);

		btn_exit = new JButton("",
				new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\small_exit.png"));
		btn_exit.setPressedIcon(
				new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\small_exit_click.png"));
		btn_exit.setRolloverEnabled(false);
		btn_exit.setOpaque(false);
		btn_exit.setFocusable(false);
		btn_exit.setFocusTraversalKeysEnabled(false);
		btn_exit.setFocusPainted(false);
		btn_exit.setContentAreaFilled(false);
		btn_exit.setBorderPainted(false);
		btn_exit.setBorder(null);
		btn_exit.setBounds(324, 1, 32, 32);
		frame.getContentPane().add(btn_exit);

		btn_minsize = new JButton("",
				new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\small_under.png"));
		btn_minsize.setPressedIcon(
				new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\small_under_click.png"));
		btn_minsize.setRolloverEnabled(false);
		btn_minsize.setOpaque(false);
		btn_minsize.setFocusable(false);
		btn_minsize.setFocusTraversalKeysEnabled(false);
		btn_minsize.setFocusPainted(false);
		btn_minsize.setContentAreaFilled(false);
		btn_minsize.setBorderPainted(false);
		btn_minsize.setBorder(null);
		btn_minsize.setBounds(291, 1, 32, 32);
		frame.getContentPane().add(btn_minsize);

		txt_pw = new JPasswordField();
		txt_pw.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		txt_pw.setBorder(null);
		txt_pw.setBounds(127, 234, 203, 24);
		frame.getContentPane().add(txt_pw);

		txt_id = new JTextField();
		txt_id.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		txt_id.setBorder(null);
		txt_id.setBounds(127, 126, 203, 24);
		frame.getContentPane().add(txt_id);
		txt_id.setColumns(10);

		JLabel lbl_img = new JLabel("");
		lbl_img.setIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\gs_login.png"));
		lbl_img.setBounds(0, 0, 360, 480);
		frame.getContentPane().add(lbl_img);

		btn_exit.addActionListener(new MyActionListener_exit());
		btn_minsize.addActionListener(new MyActionListener_minsize());
		btn_manlesspay.addActionListener(new MyActionListener_manlessPay());
		btn_login.addActionListener(new MyActionListener_login());

		frame.setVisible(true);
	}

	class MyActionListener_login implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dao = new LoginDAO();
			LoginVO vo = new LoginVO(txt_id.getText(), txt_pw.getText());
			LoginResultVO rvo = dao.loginSelect(vo);

			if (rvo.isSuccess()) {
				if (rvo.isAdmin()) {
					new gs_admin();
					frame.dispose();
				} else {
					new gs_branch();
					frame.dispose();
				}
			} else {
				new login_warning();
			}
		}
	}

	class MyActionListener_manlessPay implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new gs_manless_pay();
			frame.dispose();
		}
	}

	class MyActionListener_exit implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	class MyActionListener_minsize implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			frame.setState(Frame.ICONIFIED);
		}
	}
}
