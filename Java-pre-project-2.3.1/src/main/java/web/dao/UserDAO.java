package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;
import web.models.User;

import java.util.List;

@Component
public class UserDAO {


    @Autowired
    private UserRepository repository;

    public List<User> index() {
        List<User> userList = repository.findAll();
        return userList;
    }

    public User show(int id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public void save(User user) {
        repository.save(user);
    }

    @Transactional
    public void update(int id, User updateUser) {
        User userToBeUpdate = repository.getById(id);
        userToBeUpdate.setName(updateUser.getName());
        userToBeUpdate.setSurname(updateUser.getSurname());
        userToBeUpdate.setAge(updateUser.getAge());
        userToBeUpdate.setEmail(updateUser.getEmail());
    }

    @Transactional
    public void delete(int id) {
        repository.deleteById(id);
    }
}
