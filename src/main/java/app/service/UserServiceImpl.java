package app.service;

import app.domain.User;
import app.service.inputPorts.UserService;
import app.service.outputPorts.UserRepository;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User create(Integer id, String name, String lastName, String email, String phone, String password, String state, String city, String preferences) {

        User user = new User(id, name, lastName, email, phone, password, state, city, preferences);

        return userRepository.save(user);
    }

    @Override
    public void selectById(int id) {
        User user = selectUserById(id);
        if (user == null) {
            System.out.println("No se encontró un usuario con ese id");
            return;
        }
        System.out.println(user.getId() + " " + user.getName() + " " + user.getLastName() + " "
                + user.getEmail() + " " + user.getPhone() + " " + user.isState() + " "
                + user.getCity() + " " + user.getPreferences());
    }

    @Override
    public User selectUserById(int id) {
        return userRepository.selectById(id);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.updateUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public int countUsers() {
        return userRepository.countUsers();
    }

    @Override
    public List<User> selectUsers() {

        return userRepository.selectAll();
    }

}
