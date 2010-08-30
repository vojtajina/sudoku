package org.vojtajina.sudoku;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableModel;

public class MainForm extends JFrame implements IMainView {

	private static final long serialVersionUID = 1L;
	private LinkedList<IMainViewListener> listeners;
	private TableModel tableModel = null;
	private JPanel jContentPane = null;
	private JButton solveButton = null;
	private JTable fieldsTable = null;
	/**
	 * This is the default constructor
	 */
	public MainForm(TableModel tm) {
		super();
		listeners = new LinkedList<IMainViewListener>();
		tableModel = tm;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(561, 243);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getSolveButton(), BorderLayout.SOUTH);
			jContentPane.add(getFieldsTable(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

	/**
	 * This method initializes solveButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getSolveButton() {
		if (solveButton == null) {
			solveButton = new JButton();
			solveButton.setText("SOLVE");
			solveButton.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					Iterator<IMainViewListener> i = listeners.iterator();
					while (i.hasNext())
						i.next().solveClick(e);
					
					fieldsTable.updateUI();
				}
			});
		}
		return solveButton;
	}
	
	/**
	 * This method initializes fieldsTable	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getFieldsTable() {
		if (fieldsTable == null) {
			fieldsTable = new JTable(tableModel);
			fieldsTable.setFont(new Font("Dialog", Font.BOLD, 18));
			fieldsTable.setRowHeight(30);
			fieldsTable.setEnabled(true);
			fieldsTable.setRowSelectionAllowed(false);
			fieldsTable.setIntercellSpacing(new Dimension(0, 0));
		}
		return fieldsTable;
	}

	@Override
	public void addListener(IMainViewListener l) {
		listeners.add(l);		
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
