package media;

import java.util.List;
import com.oms.bean.Book;
import com.oms.bean.Media;

import abstractdata.ADataListPane;
import abstractdata.ADataPageController;
import abstractdata.IDataManageController;
import api.MediaApi;
import cart.CartController;
import editdialog.ADataEditDialog;
import editdialog.BookEditDialog;

public abstract class AdminMediaPageController extends ADataPageController<Media> {
	
	public AdminMediaPageController() {
		super();
	}
	public AdminMediaPageController(CartController cartController) {
		this();
		setCartController(cartController);
	}
	
	public void setCartController(CartController cartController) {
	}
	
	@Override
	public ADataListPane<Media> createListPane() {
		return new AdminMediaListPane(this);
	}
//	@SuppressWarnings("unchecked")
	@Override
	public ADataEditDialog<?> createEditDialog(Media media) {
		if(media instanceof Book) {
			Book book = (Book) media;
			return new BookEditDialog(book, new IDataManageController<Media>() {

				@Override
				public void create(Media t) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void read(Media t) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void delete(Media t) {
					// TODO Auto-generated method stub
					
				}

				@SuppressWarnings("unchecked")
				@Override
				public void update(Media t) {
					// TODO Auto-generated method stub
//					System.out.println(t);
					AdminMediaPageController.this.updateMedia(t);
//					ADataPageController.this.listPane.updateData(list);
//					listPane.updateData(list);
					List<? extends Media> list = new MediaApi().getBooks(null);
					AdminMediaPageController.listPane.updateData(list);
				}
				
			});
			
		}
		return null;
	}
	
	@Override
	public Media updateMedia(Media t) {
		if(t instanceof Book) {
			Book book = (Book)t;
			
			return new MediaApi().updateBook(book);
		}
		
		return t;
		
	}
}
