/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pojos.Dokter;
import util.HibernateUtil;

/**
 *
 * @author danielbram
 */
public class DokterHelper {
    public DokterHelper(){
        
    }
    public List<Dokter> getAllPasien(){
        List<Dokter> result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        String query = "from Dokter d";
        Query q = session.createQuery(query);
        result = q.list();
        session.close();
        return result;
    }
    
}