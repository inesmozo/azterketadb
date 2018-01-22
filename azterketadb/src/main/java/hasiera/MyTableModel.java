package hasiera;

import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

import hasiera.Lag;
import Kudeatzaile.PertsonaKud;


public class MyTableModel extends AbstractTableModel {

	private Vector<Lag> data = new Vector<Lag>();
	private Vector<String> columnNames = new Vector<String>();
	
	public MyTableModel() {

		kargatu();
	}
	public int getRowCount() {
		
		return data.size();
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		
		return data.get(rowIndex).getBalioa(columnIndex);
	}
	public String getColumnName(int i){
		return columnNames.get(i);
	}
	public boolean isCellEditable(int row, int col) {
        return true;
    }
	public void setValueAt(Object value, int row, int col) {
		Lag lerroa = data.get(row);
		lerroa.insertElementAt(value, col);
		  fireTableCellUpdated(row, col); // informe any object about changes
		}
	public void kargatu(){
//		data.add(new Lag("Kathy", "Smith", "Snowboarding", 5, false));
//		data.add(new Lag("John", "Doe", "Rowing", 3, true));
//		data.add(new Lag("Sue", "Black", "Knitting", 2, true));
//		data.add(new Lag("Jane", "White", "Speed reading", 20, true));
		hasieratuZutabeIzenak();
		List<Object[]> pertsona = PertsonaKud.getInstantzia().getPertsona();
		for(Object[] s : pertsona ){
			System.out.println(s[0]);
//			String zero = s[0].toString();
//			String 
			String inte = s[3].toString();
			String inte2 = s[4].toString();
			data.add(new Lag(s[0].toString(),s[1].toString(),s[2].toString(),Integer.parseInt(inte),Boolean.parseBoolean(inte2)));
		}
	}
	public void dbEguneratu() {
		Kudeatzaile.PertsonaKud.getInstantzia().DBanGorde(data);
	}
	
	public void addRow(Lag emaitza){
		data.add(emaitza);
		fireTableStructureChanged();
		}
	public void borratu(int hautatutakoa){
		data.remove(hautatutakoa);
		fireTableStructureChanged();
	}
	
	public void hasieratuZutabeIzenak(){
		columnNames.add("Izena");
		columnNames.add("Abizena");
		columnNames.add("Kirola");
		columnNames.add("Tamaina");
		columnNames.add("barazkijale");
		columnNames.add("Argazkia");
	}
	public Class<?> getColumnClass(int col){
		Class<?>  emaitza = null;
		switch (col) {
		case 0:
			emaitza = String.class;
			break;
		case 1:
			emaitza =  String.class;
			break;
		case 2: 
			emaitza = String.class;
			break;
		case 3:
			emaitza  = Integer.class;
			break;
		case 4:
			emaitza =  Boolean.class;
			break;
		case 5:
			emaitza =  ImageIcon.class;
			break;
		default:
			break;
		}
		return emaitza;
	}
	public Lag errenkadaAtera(int errenkada) {
		Lag emaitza = data.get(errenkada);
		return emaitza;
	}
	public static void main(String[] args) {
		MyTableModel taula = new MyTableModel();
		System.out.println("Lerroak:" + taula.getRowCount());
		System.out.println("Zutabeak:" + taula.getColumnCount());
		System.out.println("(2,2) elementuaren balioa:" + taula.getValueAt(2, 2));
		System.out.println("Lehenengo zutabearen izena:" + taula.getColumnName(0));
		
}
}