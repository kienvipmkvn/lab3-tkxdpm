package editdialog;

import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import com.oms.bean.Book;

import abstractdata.IDataManageController;

@SuppressWarnings("serial")
public abstract class ADataEditDialog<T> extends JDialog {
	protected T t;
	protected GridBagLayout layout;
	protected GridBagConstraints c = new GridBagConstraints();
	@SuppressWarnings("unused")
	private IDataManageController<?> controller;

	public ADataEditDialog(T t, IDataManageController<T> controller) {
		super((Frame) null, "Edit", true);
		
		this.t = t;
		this.controller = controller;
		setContentPane(new JPanel());
		layout = new GridBagLayout();
		getContentPane().setLayout(layout);

		
		this.buildControls();
		
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				T newT = getNewData();
				if (newT instanceof Book) {
					controller.update(newT);
					
//					Book book = (Book) newT;
//					System.out.println("ok up kieu");
////					AdminMediaListPane
////					updateDate();
//					new MediaApi().updateBook(book);
//					
					ADataEditDialog.this.dispose();
					
				}
//				controller.update(newT);
			}
		});
		
		
		c.gridx = 1;
		c.gridy = getLastRowIndex();
		getContentPane().add(saveButton, c);
		
		
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public void setController(IDataManageController<?> controller) {
		this.controller = controller;
	}
	
	protected int getLastRowIndex() {
		layout.layoutContainer(getContentPane());
		int[][] dim = layout.getLayoutDimensions();
	    int rows = dim[1].length;
	    return rows;
	}
	
	public abstract void buildControls();
	
	public abstract T getNewData();
}
