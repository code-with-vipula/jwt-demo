package lk.vipula.test.assignment.service.impl;

import lk.vipula.test.assignment.dto.UserDTO;
import lk.vipula.test.assignment.entity.User;
import lk.vipula.test.assignment.repository.UserRepository;
import lk.vipula.test.assignment.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper mapper;
    @Override
    public UserDTO getUser(String username) {
        User user = userRepository.findByUsername(username).orElseThrow();
        UserDTO userDTO = mapper.map(user, UserDTO.class);
        userDTO.setPassword("");
        return userDTO;
    }
}
