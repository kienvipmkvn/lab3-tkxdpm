package book;

import java.util.List;
import java.util.Map;

import com.oms.bean.Media;

import api.MediaApi;
import cart.CartController;
import editdialog.ADataEditDialog;
import media.MediaSinglePane;
import media.UserMediaPageController;
import search.BookSearchPane;
import search.MediaSearchPane;

public class UserBookPageController extends UserMediaPageController{
	public UserBookPageController() {
		super();
	}
	public UserBookPageController(CartController cartController) {
		super(cartController);
	}
	@Override
	public List<? extends Media> search(Map<String, String> searchParams) {
		System.out.print("da");
		return new MediaApi().getBooks(searchParams);
	}
	@Override
	public MediaSinglePane createSinglePane() {
		return new BookSinglePane();
	}
	@Override
	public MediaSearchPane createSearchPane() {
		return new BookSearchPane();
	}
	@Override
	protected ADataEditDialog<?> createEditDialog() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Media updateMedia(Media t) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected ADataEditDialog<?> createEditDialog(Media t) {
		// TODO Auto-generated method stub
		return null;
	}
}
