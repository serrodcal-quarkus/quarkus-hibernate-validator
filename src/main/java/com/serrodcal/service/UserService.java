package com.serrodcal.service;

import com.serrodcal.model.User;
import com.serrodcal.repository.UserRepository;
import com.serrodcal.service.dto.UserDTO;
import io.smallrye.mutiny.Uni;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UserService {

    @Inject
    UserRepository userRepository;

    public Uni<User> create(UserDTO userDTO) {
        return userRepository.create(userDTO).chain(userDao -> Uni.createFrom().item(mapUserDaoToUser(userDao)));
    }

    private User mapUserDaoToUser(com.serrodcal.repository.dao.User userDao) {
        return new User(
                userDao.id,
                userDao.getEmail(),
                userDao.getUsername(),
                userDao.getFirstName(),
                userDao.getLastName(),
                userDao.getAdmin(),
                userDao.getHashedPassword()
        );
    }

}
