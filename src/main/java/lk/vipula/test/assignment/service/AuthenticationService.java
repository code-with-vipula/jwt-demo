package lk.vipula.test.assignment.service;

import lk.vipula.test.assignment.dto.AuthenticationRequestDTO;
import lk.vipula.test.assignment.dto.AuthenticationResponseDTO;
import lk.vipula.test.assignment.dto.RegisterRequestDTO;

public interface AuthenticationService {
    AuthenticationResponseDTO registerUser(RegisterRequestDTO registerRequestDTO);

    AuthenticationResponseDTO authenticateUser(AuthenticationRequestDTO authenticationRequestDTO);
}
