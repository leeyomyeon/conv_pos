package gs;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.util.*;
import java.awt.Color;

public class gs_branch_home extends JPanel {
	/**
	 * Create the panel.
	 */
	public gs_branch_home() {
		setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\\uBA54\uC778\uD654\uBA74.png"));
		label.setBorder(null);
		label.setBounds(0, 0, 357, 56);
		add(label);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(8, 139, 551, 529);
		add(panel);
		panel.setLayout(null);
		
		JLabel bgimage = new JLabel("");
		bgimage.setIcon(new ImageIcon("C:\\Users\\LEE\\Desktop\\\uC624\uD508\uC18C\uC2A4 (2)\\label_frame_home.png"));
		bgimage.setBounds(0, 0, 879, 676);
		add(bgimage);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(30);
		list.add(50);
		list.add(40);
		
		testgraphic testgraphic_ = new testgraphic();
		testgraphic_.setSize(551, 529);
		testgraphic_.setLocation(0, 0);
		panel.add(testgraphic_);
		
	}
}
