package app.service.inputPorts;

import app.domain.User;

import java.util.List;

public interface UserService {
    public User create(Integer id, String name, String lastName, String email, String phone, String password, String state, String city, String preferences);
    public void selectById(int id);
    public User selectUserById(int id);
    public List<User> selectUsers();
    public User updateUser(User user);
    public void deleteUser(int id);
    public int countUsers();
}
