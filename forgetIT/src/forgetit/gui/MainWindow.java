package forgetit.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class MainWindow {
	
	private Shell shell = null;
	
	public MainWindow(Display display) {
		shell = new Shell(display);
		shell.setText("forgetIT");
		
		// define outter layout
		GridLayout outterLayout = new GridLayout();		
		outterLayout.numColumns = 8;
		shell.setLayout(outterLayout);

		// init row by row
		initFirstRow();
		initSecondRow();
		initContentView();

		// resize shell to contents
        shell.pack();
        // open shell
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	private void initFirstRow() {
		// searchBar
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalSpan = 7;
		Text text = new Text(shell, SWT.SINGLE);		
		text.setLayoutData(gridData);
		
		// settings button
		gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.horizontalSpan = 1;
		Button settings = new Button(shell, SWT.PUSH);
		settings.setLayoutData(gridData);
		settings.setText("Config");		
		settings.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                // TODO show Dialog for settings
            }
        });		
	}
	
	private void initSecondRow() {
		// date
		GridData gridData = new GridData(GridData.BEGINNING,GridData.BEGINNING,false,false);
		gridData.horizontalSpan = 3;
		gridData.verticalSpan = 3;
		Composite comDate = new Composite(shell, SWT.NONE);
		comDate.setLayoutData(gridData);
		comDate.setLayout(new FillLayout());
		new ViewDate(comDate);
		
		// tags
		gridData = new GridData(GridData.FILL,GridData.BEGINNING,true,false);
		gridData.horizontalSpan = 5;
		gridData.verticalSpan = 3;
		Composite comTags = new Composite(shell, SWT.NONE);
		comTags.setLayoutData(gridData);
		comTags.setLayout(new FillLayout());
		new ViewTags(comTags);
	}

	private void initContentView() {
		// calendar
		GridData gridData = new GridData(GridData.FILL,GridData.FILL,true,true);
		gridData.horizontalSpan = 4;
		gridData.verticalSpan = 8;
		Composite comCal = new Composite(shell, SWT.NONE);
		comCal.setLayoutData(gridData);
		comCal.setLayout(new FillLayout());
		new ViewCalendar(comCal);
		
		// todos
		gridData = new GridData(GridData.FILL,GridData.FILL,true,true);
		gridData.horizontalSpan = 4;
		gridData.verticalSpan = 4;
		Composite comTodo = new Composite(shell, SWT.NONE);
		comTodo.setLayoutData(gridData);
		comTodo.setLayout(new FillLayout());
		new ViewTodo(comTodo);
		
		// notes
		gridData = new GridData(GridData.FILL,GridData.FILL,true,true);
		gridData.horizontalSpan = 4;
		gridData.verticalSpan = 4;
		Composite comNotes = new Composite(shell, SWT.NONE);
		comNotes.setLayoutData(gridData);
		comNotes.setLayout(new FillLayout());
		new ViewNotes(comNotes);
	}	
}