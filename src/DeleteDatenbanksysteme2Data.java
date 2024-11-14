/**
 * Licensee: 
 * License Type: Evaluation
 */
import org.orm.*;
public class DeleteDatenbanksysteme2Data {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = Datenbanksysteme2PersistentManager.instance().getSession().beginTransaction();
		try {
			Vorlesung vorlesung = Vorlesung.loadVorlesungByQuery(null, null);
			vorlesung.delete();
			Studiengang studiengang = Studiengang.loadStudiengangByQuery(null, null);
			studiengang.delete();
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteDatenbanksysteme2Data deleteDatenbanksysteme2Data = new DeleteDatenbanksysteme2Data();
			try {
				deleteDatenbanksysteme2Data.deleteTestData();
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
