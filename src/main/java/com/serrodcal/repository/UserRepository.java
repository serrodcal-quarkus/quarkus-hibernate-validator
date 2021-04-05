package com.serrodcal.repository;

import com.serrodcal.repository.dao.User;
import com.serrodcal.service.dto.UserDTO;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;

import javax.inject.Singleton;

@Singleton
public class UserRepository implements PanacheRepository<User> {

    public Uni<User> create(UserDTO userDTO) {
        User user = mapUserDTOtoUserDao(userDTO);
        return user.persist().chain(() -> Uni.createFrom().item(user));
    }

    public Uni<User> findByUsername(String username){
        return find("username", username).firstResult();
    }

    private User mapUserDTOtoUserDao(UserDTO userDTO) {
        return new User(
                userDTO.getEmail(),
                userDTO.getUsername(),
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getAdmin(),
                userDTO.getHashedPassword()
        );
    }

}
