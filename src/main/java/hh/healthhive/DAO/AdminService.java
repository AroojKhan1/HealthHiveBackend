package hh.healthhive.DAO;

import hh.healthhive.Model.User;

import java.util.List;

public interface AdminService {

    public int saveAdminDetail(User adminDetail);

    public int adminLogin(String emailId , String password);

    public List<User> getAdminData();
}
