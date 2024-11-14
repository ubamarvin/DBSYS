/**
 * Licensee: 
 * License Type: Evaluation
 */
import org.orm.*;
public class CreateDatenbanksysteme2DatabaseSchema {
	public static void main(String[] args) {
		try {
			ORMDatabaseInitiator.createSchema(Datenbanksysteme2PersistentManager.instance());
			Datenbanksysteme2PersistentManager.instance().disposePersistentManager();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
