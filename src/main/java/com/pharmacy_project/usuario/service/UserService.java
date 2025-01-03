package com.pharmacy_project.usuario.service;

import com.pharmacy_project.usuario.domain.User;
import com.pharmacy_project.usuario.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User>getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Usuario nao encontrado pelo id: ", id));
    }

    public User updateUser(User usuario, Long id) {
        if (userRepository.existsById(id)) {
            usuario.setId(id);
            return userRepository.save(usuario);
        } else {
            throw new ObjectNotFoundException("Usuario nao encontrado pelo id: ", id);
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
