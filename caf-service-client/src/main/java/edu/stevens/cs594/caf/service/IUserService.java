package edu.stevens.cs594.caf.service;

import edu.stevens.cs594.caf.service.dto.UserDto;

import java.util.List;

public interface IUserService {

    class UserException extends Exception {
        public UserException(String message) {
            super(message);
        }
    }

    void addUser(UserDto userDto) throws UserException;

    List<UserDto> getUsers();

}
