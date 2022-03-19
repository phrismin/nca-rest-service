package com.nca.app.ncarestservice.service;

import com.nca.app.ncarestservice.entity.User;
import com.nca.app.ncarestservice.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Integer id) {
        // TODO catch somewhereException
        return userRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("User with this id isn't exist: " + id));
    }

    public List<User> findAll() {
        List<User> usersList = (List<User>) userRepository.findAll();
        if (usersList.isEmpty()) {
            // TODO catch somewhereException
            throw new IllegalStateException("List is empty");
        }
        return usersList;
    }

    public User saveUser(User user) {
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());
        if (userOptional.isPresent()) {
            throw new IllegalStateException("Email taken: " + userOptional.get().getEmail());
        }
        return userRepository.save(user);
    }

    public User updateUser(User newUser, Integer id) throws RuntimeException {
        Optional<User> userOptional = userRepository.findUserByEmail(newUser.getEmail());

        if (userOptional.isPresent()) {
            throw new IllegalStateException("Email taken: " + userOptional.get().getEmail());
        }

        User user = findById(id);

        user.setName(newUser.getName());
        user.setSurname(newUser.getSurname());
        user.setPatronymic(newUser.getPatronymic());
        user.setAge(newUser.getAge());
        user.setEmail(newUser.getEmail());

        return userRepository.save(newUser);
    }

    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }
}
