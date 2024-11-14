/**
 * Licensee: 
 * License Type: Evaluation
 */
import org.orm.*;
public class CreateDatenbanksysteme2Data {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = Datenbanksysteme2PersistentManager.instance().getSession().beginTransaction();
		try {
			Vorlesung vorlesung = Vorlesung.createVorlesung();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : sws, ects, _studiengang
			vorlesung.save();
			Studiengang studiengang = Studiengang.createStudiengang();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : _vorlesung, kuerzel
			studiengang.save();
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateDatenbanksysteme2Data createDatenbanksysteme2Data = new CreateDatenbanksysteme2Data();
			try {
				createDatenbanksysteme2Data.createTestData();
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
