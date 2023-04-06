package hh.healthhive.DAO;
import java.util.List;
import javax.transaction.Transactional;
import hh.healthhive.DAO.AdminDAO;

import hh.healthhive.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service("adminService")
public class AdminServiceImpl {


    //edit this autowired if shit goes south
    @Autowired
    private AdminDAOImpl adminDAO;

    @Transactional
    public int saveAdminDetail(User user) {
        return adminDAO.saveAdminDetail(user);
    }

    @Transactional
    public int adminLogin(String emailId, String password) {
        return adminDAO.adminLogin(emailId, password);
    }

    @Transactional
    public List<User> getAdminData() {
        return adminDAO.getAdminData();
    }
}
