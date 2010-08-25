package org.vojtajina.sudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.swing.table.AbstractTableModel;

public class MatrixModel extends AbstractTableModel implements List<IField>, ActionListener {
	
	private static final long serialVersionUID = 63L;
	private List<IField> fields; 
	private int size;
	private RowIndexConverter converter;

	public MatrixModel(IField field, RowIndexConverter conv, int size) {
		fields = new ArrayList<IField>(size*size);
		this.size = size;
		converter = conv;
		
		field.addActionListener(this);
		fields.add(field);
		for (int i = 1; i < size*size; i++)
			fields.add(field.clone());
	}
	
	@Override
	public boolean add(IField arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void add(int arg0, IField arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean addAll(Collection<? extends IField> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int arg0, Collection<? extends IField> arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IField get(int arg0) {
		return fields.get(arg0);
	}

	@Override
	public int indexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<IField> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int lastIndexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<IField> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<IField> listIterator(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IField remove(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IField set(int arg0, IField arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<IField> subList(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
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
		int val = fields.get(arg0 * size + arg1).getValue();
		
		return val > 0 ? val : null; 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		IField f = (IField) e.getSource();
		fireTableCellUpdated(converter.getRow(f.getIndex()), converter.getCol(f.getIndex()));
	}

}
