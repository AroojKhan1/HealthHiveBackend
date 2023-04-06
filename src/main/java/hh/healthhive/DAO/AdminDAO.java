package hh.healthhive.DAO;

import hh.healthhive.Model.User;

import java.util.List;

public interface AdminDAO {
    public int saveAdminDetail(User user);

    public int adminLogin(String emailId , String password);

    public List<User> getAdminData();
}
