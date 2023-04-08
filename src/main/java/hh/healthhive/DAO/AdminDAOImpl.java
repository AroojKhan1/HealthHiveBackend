package hh.healthhive.DAO;

import hh.healthhive.Model.User;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("adminDAO")
public class AdminDAOImpl {
    // Autowired SessionFactory Object So that we can get session object used for interaction with Database.
    @Autowired
    private SessionFactory sessionFactory;

    /*
     * Register Admin Details.
     */
    public int saveAdminDetail(User adminDetail) {

        Session session = null;
        try
        {
            session = sessionFactory.getCurrentSession();

            int id = (Integer) session.save(adminDetail);
            return id;
        }
        catch(Exception exception)
        {
            System.out.println("Excecption while saving admin Details : " + exception.getMessage());
            return 0;
        }
        finally
        {
            session.flush();
        }
    }

    public int adminLogin(String emailId, String password) {

        Session session = null;
        try
        {
            session = sessionFactory.getCurrentSession();

            Query query = session.createQuery("from User where email=:emailId and password=:password");
            query.setParameter("emailId", emailId);
            query.setParameter("password", password);
            List<User> list = query.list();

            int size = list.size();
            if(size == 1)
            {
                //cast added to convert to int from long
                return list.get(0).getId_user().intValue();
            }
            else
            {
                return -1;
            }
        }
        catch(Exception exception)
        {
            System.out.println("Excecption while saving admin Details : " + exception.getMessage());
            return 0;
        }
        finally
        {
            session.flush();
        }

    }


    public List<User> getAdminData() {
        Session session = null;
        try
        {
            session = sessionFactory.getCurrentSession();

            Query<User> query = session.createQuery("from User");
            List<User> list = query.list();

            if(list.size() > 0)
            {
                return list;
            }
            else
            {
                return null;
            }

        }
        catch(Exception exception)
        {
            System.out.println("Excecption while saving admin Details : " + exception.getMessage());
            return null;
        }
        finally
        {
            session.flush();
        }

    }


}
