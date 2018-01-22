package hasiera;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.sql.Date;
import java.util.Vector;
import javax.swing.ImageIcon;

import Kudeatzaile.DBKudeatzaileSQLite;

public class Lag {
	String izena;
	String abizena;
	String kirola;
	Integer tamaina;
	Boolean baiez;
	ImageIcon argazkia;
	public Lag(String izena, String abizena, String kirola, Integer tamaina, Boolean baiez) {
		this(izena, abizena, kirola, tamaina, baiez, "/pics/person.png");
	}
	public Lag(String izena, String abizena, String kirola, Integer tamaina, Boolean baiez, String argazkia) {
		super();
		this.izena = izena;
		this.abizena = abizena;
		this.kirola = kirola;
		this.tamaina = tamaina;
		this.baiez = baiez;
		String path = "";
		try{
			path = this.getClass().getResource(argazkia).getPath();
		} catch(Exception e){
			System.out.println(argazkia + "not found");
		}
		Image irudia = new ImageIcon(path).getImage();
		ImageIcon irudiaIcon = new ImageIcon(irudia.getScaledInstance(-5, 50, java.awt.Image.SCALE_SMOOTH));
		this.argazkia = irudiaIcon;
	}


	@Override
	public String toString() {
		return "Lag [izena=" + izena + ", abizena=" + abizena + ", kirola=" + kirola + ", tamaina=" + tamaina
				+ ", baiez=" + baiez + ",argazkia=" + argazkia + "]";
	}

	public Object getBalioa(int i) {
		Object emaitza=null;
		switch (i) {
		case 0:
			emaitza = izena;
			break;
		case 1:
			emaitza = abizena;
			break;
		case 2:
			emaitza = kirola;
			break;
		case 3:
			emaitza = tamaina;
			break;
		case 4:
			emaitza = baiez;
			break;
		case 5:
			emaitza = argazkia;
			break;
		default:
			break;
		}
		return emaitza;
	}

	public void insertElementAt(Object value, int i){
		Object emaitza=null;
		switch (i) {
		case 0:
			this.izena = (String)value;
			break;
		case 1:
			this.abizena = (String)value;
			break;
		case 2:
			this.kirola = (String)value;
			break;
		case 3:
			this.tamaina = (Integer) value;
			break;
		case 4:
			this.baiez = (Boolean) value;
			break;
		case 5:
			this.argazkia = (ImageIcon) value;
			break;
		default:
			break;
		}
	}
	
	public static void main(String[] args) {
		Vector<Lag> datuak = new Vector<Lag>();
		DBKudeatzaileSQLite dbk = DBKudeatzaileSQLite.getInstantzia();
		System.out.println(datuak);
	}
		public String toQuery() {
			return "'" + izena + "', '" + abizena + "', '" + kirola + "','" + tamaina + "','" + baiez + "','" + argazkia + "'"; 
		}
		public String getIzena() {
			return izena;
		}
		public String getAbizena() {
			return abizena;
		}
		public String getKirola() {
			return kirola;
		}
		public Integer getTamaina() {
			return tamaina;
		}
		public Boolean getBaiez() {
			return baiez;
		}

		
//		Vector<Lag> data = new Vector<Lag>();
//		data.add(new Lag("Kathy", "Smith", "Snowboarding", 5, false));
//		data.add(new Lag("John", "Doe", "Rowing", 3, true));
//		data.add(new Lag("Sue", "Black", "Knitting", 2, true));
//		data.add(new Lag("Jane", "White", "Speed reading", 20, true));
//				
//		System.out.println(data);
//		Lag lerroa = data.get(0);
//		System.out.println("Emaitza 'Smith' izan beharko luke:");
//		System.out.println("Lehenengo lerroko bigarren atributuaren balioa (0,1):" + lerroa.getBalioa(1));
//		
//		lerroa = data.get(3);
//		System.out.println("Azken lerroko hirugarren atributuaren balioa (3,2):" + lerroa.getBalioa(2));
//		
//		Lag lerro0 = data.get(0);
//		lerro0.insertElementAt("Sierra", 1);
//		System.out.println("Lehenengo lerroko bigarren atributuaren balioa (0,1):" + lerro0.getBalioa(1));
//
//		Lag lerro3 = data.get(3);
//		lerro3.insertElementAt(new Integer(4), 3);
//		System.out.println("Azken lerroko laugarren atributuaren balioa (3,3):" + lerro3.getBalioa(3));
	
 }