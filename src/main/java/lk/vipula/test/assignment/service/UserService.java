package lk.vipula.test.assignment.service;

import lk.vipula.test.assignment.dto.UserDTO;
import lk.vipula.test.assignment.entity.User;

public interface UserService {
    UserDTO getUser(String username);
}
