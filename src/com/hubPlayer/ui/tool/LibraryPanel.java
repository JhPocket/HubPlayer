package com.hubPlayer.ui.tool;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.AbstractCellEditor;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;

import com.hubPlayer.player.HigherPlayer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * netBean ���� �ֿ����
 * 
 * @date 2014-11-8
 */
public class LibraryPanel extends JPanel {

	/**
	 * Creates new form HubLibraryPanel
	 */
	public LibraryPanel() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings({ "unchecked", "serial" })
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		aScrollPanel = new JScrollPane();
		dataTable = new JTable();
		libraryTableModel = new LibraryTableModel();
		libraryOperation = new LibraryOperation();

		aToolBar = new JToolBar();
		moreSearch = new JButton();

		setLayout(new BorderLayout());

		aScrollPanel
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		aScrollPanel
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		aScrollPanel.setMaximumSize(new Dimension(615, 481));

		// ����20�п�����
		dataTable.setModel(libraryTableModel);
		libraryTableModel.setLibraryOperation(libraryOperation);

		// ����"������"����Ⱦ�� ��ʾ��ť
		dataTable.getColumn("����").setCellRenderer(
				new DefaultTableCellRenderer() {

					@Override
					public Component getTableCellRendererComponent(
							JTable table, Object value, boolean isSelected,
							boolean hasFocus, int row, int column) {

						return value instanceof JPanel ? (JPanel) value : super
								.getTableCellRendererComponent(table, value,
										isSelected, hasFocus, row, column);
					}
				});
		// ����"������"�ı༭�� ��Ӧ��ť�¼�
		dataTable.getColumn("����").setCellEditor(new CellEditor());

		dataTable.setColumnSelectionAllowed(true);
		dataTable.setRowHeight(23);
		aScrollPanel.setViewportView(dataTable);
		dataTable.getColumnModel().getSelectionModel()
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		add(aScrollPanel, BorderLayout.CENTER);

		aToolBar.setFloatable(false);
		aToolBar.setRollover(true);
		aToolBar.setOpaque(false);

		moreSearch.setText("��������");
		moreSearch.setFocusable(false);
		moreSearch.setHorizontalTextPosition(SwingConstants.CENTER);
		moreSearch.setVerticalTextPosition(SwingConstants.BOTTOM);
		// moreSearch.setEnabled(false);
		aToolBar.add(moreSearch);

		Box box = Box.createVerticalBox();
		box.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		box.setOpaque(true);
		box.add(aToolBar);

		add(box, BorderLayout.SOUTH);

	}// </editor-fold>

	// �����������,����չʾ�������
	public LibraryTableModel getLibraryTableModel() {
		return libraryTableModel;
	}

	public JTable getDataTable() {
		return dataTable;
	}

	public JScrollBar getTableScrollBar() {
		return aScrollPanel.getVerticalScrollBar();
	}

	public JButton getMoreSearch() {
		return moreSearch;
	}

	public void setListTree(JTree[] trees) {

		libraryOperation.setListTree(trees);
	}

	public void setPlayer(HigherPlayer player) {
		libraryOperation.setPlayer(player);
	}

	// Variables declaration - do not modify
	private JScrollPane aScrollPanel;
	private JTable dataTable;
	private LibraryTableModel libraryTableModel;
	private LibraryOperation libraryOperation;

	private JToolBar aToolBar;
	private JButton moreSearch;

	// End of variables declaration
}

class CellEditor extends AbstractCellEditor implements TableCellEditor {

	private JPanel panel;

	// ����Ԫ��ӱ༭״̬�˳�ʱ,���ô˷���,���˵�Ԫ��Ⱦ����value��Ϊ���Object,����ʾ���Object
	@Override
	public Object getCellEditorValue() {
		return panel;
	}

	// ����Ҫ�༭��Ԫ��ʱ,���ô˷���,�༭���Ƿ��ص��������
	@Override
	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		return value instanceof JPanel ? panel = (JPanel) value : null;
	}

}