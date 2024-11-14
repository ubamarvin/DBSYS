/**
 * Licensee: 
 * License Type: Evaluation
 */
import org.orm.*;
public class RetrieveAndUpdateDatenbanksysteme2Data {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = Datenbanksysteme2PersistentManager.instance().getSession().beginTransaction();
		try {
			Vorlesung vorlesung = Vorlesung.loadVorlesungByQuery(null, null);
			// Update the properties of the persistent object
			vorlesung.save();
			Studiengang studiengang = Studiengang.loadStudiengangByQuery(null, null);
			// Update the properties of the persistent object
			studiengang.save();
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateDatenbanksysteme2Data retrieveAndUpdateDatenbanksysteme2Data = new RetrieveAndUpdateDatenbanksysteme2Data();
			try {
				retrieveAndUpdateDatenbanksysteme2Data.retrieveAndUpdateTestData();
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
