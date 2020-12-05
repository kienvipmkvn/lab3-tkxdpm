package abstractdata;

import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

import editdialog.ADataEditDialog;

public abstract class ADataPageController<T> {
	private ADataPagePane<T> pagePane;
	@SuppressWarnings("rawtypes")
	public static ADataListPane listPane;
	
	@SuppressWarnings("unchecked")
	public ADataPageController() {
		ADataSearchPane searchPane = createSearchPane();
		
		listPane = createListPane();
		
		searchPane.setController(new IDataSearchController() {
			@Override
			public void search(Map<String, String> searchParams) {
				List<? extends T> list = ADataPageController.this.search(searchParams);
				listPane.updateData(list);
			}
		});
		
		searchPane.fireSearchEvent();
		
		pagePane = new ADataPagePane<T>(searchPane, listPane);
	}
	
	protected abstract ADataEditDialog<?> createEditDialog(T t);
	
	public abstract T updateMedia(T t);

	public JPanel getDataPagePane() {
		return pagePane;
	}
	
	
	public abstract ADataSearchPane createSearchPane();

	public abstract List<? extends T> search(Map<String, String> searchParams);
	
	
	
	public abstract ADataSinglePane<T> createSinglePane();
	
	public abstract ADataListPane<T> createListPane();

	protected ADataEditDialog<?> createEditDialog() {
		// TODO Auto-generated method stub
		return null;
	}
}
