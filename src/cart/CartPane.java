package cart;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
//import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.OMSAdmin;
import main.OMSAdminController;
import main.OMSUser;

@SuppressWarnings("serial")
public class CartPane extends JPanel{
	private JLabel cartStatusLabel;
	private CartController controller;
//	private JPanel adminRootPanel; 
	
//	public CartPane() {
//		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
//		cartStatusLabel = new JLabel();
//		this.add(cartStatusLabel);
//		JButton detailButton = new JButton("Detail");
//		this.add(detailButton);
//		JButton changeModeButton = new JButton("Admin Mode");
//		this.add(changeModeButton);
//		
//		
//		detailButton.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				controller.showCartDialog();
//			}
//		});
//	}
	
	public CartPane() {
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		cartStatusLabel = new JLabel();
		this.add(cartStatusLabel);
		JButton detailButton = new JButton("Detail");
		this.add(detailButton);
		JButton changeModeButton = new JButton("Admin Mode");
		this.add(changeModeButton);
		
		
		detailButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.showCartDialog();
			}
		});
		
		changeModeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OMSUser.rootFrame.dispose();
				new OMSAdmin(new OMSAdminController());
			}
		});
		
	}
	
	public void setController(CartController controller) {
		this.controller = controller;
	}
	
	public void updateData(String text) {
		cartStatusLabel.setText(text);
	}
}