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
import pojos.Location;
import util.RskuHibernateUtil;

/**
 *
 * @author danielbram
 */
public class LocationHelper {
    public LocationHelper(){
        
    }
    public List<Location> getAllLocation(){
        List<Location> result = null;
        Session session = RskuHibernateUtil.getSessionFactory().openSession();
        String query = "from Location l";
        Query q = session.createQuery(query);
        result = q.list();
        session.close();
        return result;
    }
    public void addNewLocation(double latitude, double longtitude, String nama){
        Session session = RskuHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Location location = new Location(latitude, longtitude, nama);
        session.save(location);
        transaction.commit();
        session.close();
    }
}
