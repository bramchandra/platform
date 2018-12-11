/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Antrian;
import util.RskuHibernateUtil;

/**
 *
 * 
 * @author danielbram
 */
public class AntrianHelper {
      public AntrianHelper(){
        
    }
    public List<Antrian> getAllAntrian(){
        List<Antrian> result = null;
        Session session = RskuHibernateUtil.getSessionFactory().openSession();
        String query = "from Antrian d";
        Query q = session.createQuery(query);
        result = q.list();
        session.close();
        return result;
    }
    public void addNewAntrian(Date tanggal, String noRm, String nama, String alamat, String namaKlinik){
        Session session = RskuHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();                
        Antrian antrian = new Antrian(tanggal, noRm, nama, alamat, namaKlinik);
        session.save(antrian);
        transaction.commit();
        session.close();
    }
}
