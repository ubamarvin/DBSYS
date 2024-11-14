import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.hibernate.Query;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;

public class Aufgabe4 {

   
    public static void main(String[] args) {
        /*
         * Teil c
        Programmieren Sie ein Java-Programm, in dem man mit
        Hibernate die Daten der
        Studiengänge AIN und WIN, sowie jeweils 5 Vorlesungen
        für diese Studiengänge */

        //Studiengänge Ain WIN
        /* */

        /* 
        try {
            PersistentSession session = Datenbanksysteme2PersistentManager.instance().getSession();
            PersistentTransaction t = session.beginTransaction();
            try {
                Studiengang ain = new Studiengang();
                ain.setName("ANGEWANDTE_INFORMATIK");
                ain.setKuerzel("AIN");
                ain.setAbschluss("BACHELOR");
                ain.save();

                Studiengang win = new Studiengang();
                win.setName("WIRTSCHAFTS_INFORMATIK");
                win.setKuerzel("WIN");
                win.setAbschluss("BACHELOR");
                win.save();

                Vorlesung db = new Vorlesung();
                db.setName("DBSYS");
                db.setEcts(120);
                db.setSws(800);
                db.set_studiengang(ain);
                db.save();

                Vorlesung prog1 = new Vorlesung();
                prog1.setName("PROG1");
                prog1.setEcts(140);
                prog1.setSws(900);
                prog1.set_studiengang(ain);
                prog1.save();
            
                Vorlesung mathe = new Vorlesung();
                mathe.setName("MATHE");
                mathe.setEcts(180); // Beispiel-ECTS-Wert
                mathe.setSws(600);  // Beispiel-SWS-Wert
                mathe.set_studiengang(ain);
                mathe.save();

                Vorlesung mathe2 = new Vorlesung();
                mathe2.setName("MATHE");
                mathe2.setEcts(180); // Beispiel-ECTS-Wert
                mathe2.setSws(600);  // Beispiel-SWS-Wert
                mathe2.set_studiengang(win);
                mathe2.save();

                Vorlesung digital = new Vorlesung();
                digital.setName("DIGITAL");
                digital.setEcts(160); // Beispiel-ECTS-Wert
                digital.setSws(450);  // Beispiel-SWS-Wert
                digital.set_studiengang(ain);
                digital.save();
                
                Vorlesung somo = new Vorlesung();
                somo.setName("SOMO");
                somo.setEcts(200); // Beispiel-ECTS-Wert
                somo.setSws(750);  // Beispiel-SWS-Wert
                somo.set_studiengang(ain);
                somo.save();


                t.commit();
                
            }
            catch (PersistenceException e) {
                t.rollback();
                e.printStackTrace();
            }
            finally {
                Datenbanksysteme2PersistentManager.instance().disposePersistentManager();
            }
        
        }catch (Exception e) {
            e.printStackTrace();
        }

        */



        try {
            PersistentSession session = Datenbanksysteme2PersistentManager.instance().getSession();
            PersistentTransaction t = session.beginTransaction();
            try {
            
                /*Programmieren Sie ein Java-Programm,
                das mit Hibernate alle Vorlesungsnamen mit
                ECTS und Studiengang ausgibt */
                System.out.println("Alle Vorlesungsnamen mit Ects: ");
                Query query = session.createQuery("from Vorlesung");
                                                
                @SuppressWarnings("unchecked")
                List<Vorlesung> results = query.list();
                for (Vorlesung v : results) {
                    System.out.println("Vorlesungsname: " + v.getName() + " Ects: " + v.getEcts());

                }
                System.out.println();

                

                /**
                 * Programmieren Sie ein Java-Programm,
                 * das mit Hibernate den Namen der einzelnen
                   Studiengänge und die Summe der ECTS der
                   enthaltenen Vorlesungen ausgibt.
                 */
                System.out.println("Studiengang und Summe Ects: ");


                Query query2 = session.createQuery("select s.name, sum(v.ects) from Studiengang s ,"
                                                + " Vorlesung v "
                                                + " where v._studiengang = s.kuerzel"
                                                + " group by s.name");

                @SuppressWarnings("unchecked")
                List<Object[]> results2 = query2.list();

                for(Object[] row : results2) {
                    String studiengangName = (String) row[0];
                    Long totalEcts = (Long) row[1];

                    System.out.println("Studiengang: " + studiengangName + ", Sum ECTS: " + totalEcts);
                    
                }
                System.out.println();


                /**
                 *  Programmieren Sie ein Java-Programm, das mit Hibernate überprüft, ob es in AIN
                    und WIN Vorlesungen mit gleichem Namen gibt. Geben Sie diese Vorlesungsnamen
                    aus.
                 */

            System.out.println("Vorlesungen in WIN und AIN mit identischaen Namen");
            
            Query query3 = session.createQuery("select v.name "
                                              + "from Vorlesung v "
                                              + "group by v.name "
                                              + "having count(v.name) > 1");
            
            @SuppressWarnings("unchecked") 
            List<String> doppelt = query3.list();
            
            System.out.println("Name in WIN und AIN:");
            for (String lectureName : doppelt) {
                System.out.println(lectureName);
            }



                
            }
            catch (PersistenceException e) {
                t.rollback();
                e.printStackTrace();
            }
            finally {
                Datenbanksysteme2PersistentManager.instance().disposePersistentManager();
            }
        
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}