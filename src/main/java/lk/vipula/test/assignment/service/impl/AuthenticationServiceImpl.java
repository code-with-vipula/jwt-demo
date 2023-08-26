package lk.vipula.test.assignment.service.impl;

import lk.vipula.test.assignment.config.util.JWTService;
import lk.vipula.test.assignment.dto.AuthenticationRequestDTO;
import lk.vipula.test.assignment.dto.AuthenticationResponseDTO;
import lk.vipula.test.assignment.dto.RegisterRequestDTO;
import lk.vipula.test.assignment.entity.User;
import lk.vipula.test.assignment.entity.UserLoggingDetail;
import lk.vipula.test.assignment.enumarations.Role;
import lk.vipula.test.assignment.repository.UserLoggingDetailsRepository;
import lk.vipula.test.assignment.repository.UserRepository;
import lk.vipula.test.assignment.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserLoggingDetailsRepository userLoggingDetailsRepository;
    @Override
    public AuthenticationResponseDTO registerUser(RegisterRequestDTO registerRequestDTO) {
        User user = User.builder()
                .firstName(registerRequestDTO.getFirstname())
                .lastName(registerRequestDTO.getLastname())
                .email(registerRequestDTO.getEmail())
                .username(registerRequestDTO.getUsername())
                .password(passwordEncoder.encode(registerRequestDTO.getPassword()))
                .role(Role.USER)   /* only crete users for this demo */
                .build();
        userRepository.save(user);
        String jwtToken = jwtService.generateJwtToken(user);
        return AuthenticationResponseDTO.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponseDTO authenticateUser(AuthenticationRequestDTO authenticationRequestDTO) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequestDTO.getUsername(),
                        authenticationRequestDTO.getPassword()
                )
        );

        User user = userRepository.findByUsername(authenticationRequestDTO.getUsername()).orElseThrow();
        UserLoggingDetail userLoggingDetail = new UserLoggingDetail();
        userLoggingDetail.setUser(user);
        userLoggingDetail.setLocalDateTime(LocalDateTime.now());
        userLoggingDetailsRepository.save(userLoggingDetail);

        String jwtToken = jwtService.generateJwtToken(user);
        return AuthenticationResponseDTO.builder()
                .token(jwtToken)
                .build();
    }
}
