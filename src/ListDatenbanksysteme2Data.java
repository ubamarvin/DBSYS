/**
 * Licensee: 
 * License Type: Evaluation
 */
import org.orm.*;
public class ListDatenbanksysteme2Data {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing Vorlesung...");
		Vorlesung[] vorlesungs = Vorlesung.listVorlesungByQuery(null, null);
		int length = Math.min(vorlesungs.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(vorlesungs[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Studiengang...");
		Studiengang[] studiengangs = Studiengang.listStudiengangByQuery(null, null);
		length = Math.min(studiengangs.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(studiengangs[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public static void main(String[] args) {
		try {
			ListDatenbanksysteme2Data listDatenbanksysteme2Data = new ListDatenbanksysteme2Data();
			try {
				listDatenbanksysteme2Data.listTestData();
			}
			finally {
				Datenbanksysteme2PersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
