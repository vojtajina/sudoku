package org.vojtajina.sudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class MatrixModel extends AbstractTableModel implements IMatrixModel<IField>, ActionListener {
	
	private static final long serialVersionUID = 63L;
	private List<IField> fields; 
	private int size;
	private RowIndexConverter converter;
	private IFieldValidator validator;

	public MatrixModel(IField field, RowIndexConverter conv, IFieldValidator val, int size) {
		fields = new ArrayList<IField>(size*size);
		this.size = size;
		converter = conv;
		validator = val;
		
		field.addActionListener(this);
		fields.add(field);
		for (int i = 1; i < size*size; i++)
			fields.add(field.clone());
	}
	
	@Override
	public int getColumnCount() {
		return size;
	}

	@Override
	public int getRowCount() {
		return size;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		int val = fields.get(converter.getIndex(arg0, arg1)).getValue();
		
		return val > 0 ? val : null; 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		IField f = (IField) e.getSource();
		fireTableCellUpdated(converter.getRow(f.getIndex()), converter.getCol(f.getIndex()));
	}
	
	public boolean isCellEditable(final int row, final int column) {
		return true;
	}
	
	public void setValueAt(final Object value, final int row, final int column) {
		if (validator.validate((String)value))
		  fields.get(converter.getIndex(row, column)).setValue(validator.getCleanValue());		
	}

	@Override
	public IField get(int row, int col) {
		return fields.get(converter.getIndex(row, col));
	}

}
