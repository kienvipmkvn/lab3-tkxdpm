package main;

import javax.swing.JPanel;

//import book.AdminBookPageController;
import book.AdminBookPageController;
import cart.CartController;

public class OMSAdminController {
	private CartController cartController;
	
	public OMSAdminController() {
		cartController = new CartController();
	}
	
	public JPanel getBookEditDialog() {
		return cartController.getCartPane();
	}
	
	public JPanel getBookPage() {
		AdminBookPageController controller = new AdminBookPageController();
//		controller.setCartController(cartController);
		return controller.getDataPagePane();
	}
}
