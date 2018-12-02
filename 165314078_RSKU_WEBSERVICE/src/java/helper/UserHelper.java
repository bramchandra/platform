/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.Collections;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pojos.User;
import util.RskuHibernateUtil;

/**
 *
 * @author danielbram
 */
public class UserHelper {

    public UserHelper() {
    }

    public List<User> getAllUser() {
        List<User> result = null;
        Session session = RskuHibernateUtil.getSessionFactory().openSession();
        String query = "from User u";
        Query q = session.createQuery(query);
        result = q.list();
        session.close();
        return result;
    }

    public User getUser(String username, String password) {
        List<User> list = this.getAllUser();
        Collections.sort(list);
        User user = new User(username, password);
        int result = Collections.binarySearch(list, user);
        if (result == -1) {
            //cek user
            return null;
        } else {
            User index = list.get(result);
            if (user.getPassword().equals(index.getPassword())) {
                return user;
            } else {
                return null;
            }
        }
    }
}
