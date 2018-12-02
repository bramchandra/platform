/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Dokter;
import pojos.Klinik;
import util.RskuHibernateUtil;

/**
 *
 * @author danielbram
 */
public class KlinikHelper {
    public  KlinikHelper(){
        
    }
    public List<Klinik> getAllKlinik(){
        List<Klinik> result = null;
        Session session = RskuHibernateUtil.getSessionFactory().openSession();
        String query = "from Klinik k";
        Query q = session.createQuery(query);
        result = q.list();
        session.close();
        return result;
    }
     public void addNewKlinik(String idKlinik, String nama, String spesialis){
        Session session = RskuHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();                        
        Klinik klinik = new Klinik(idKlinik, nama, spesialis);
        session.save(klinik);
        transaction.commit();
        session.close();
    }
    
}
