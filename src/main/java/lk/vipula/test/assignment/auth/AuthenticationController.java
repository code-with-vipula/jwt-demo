package lk.vipula.test.assignment.auth;

import io.swagger.v3.oas.annotations.Operation;
import lk.vipula.test.assignment.dto.AuthenticationRequestDTO;
import lk.vipula.test.assignment.dto.AuthenticationResponseDTO;
import lk.vipula.test.assignment.dto.RegisterRequestDTO;
import lk.vipula.test.assignment.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Operation(description = "Post endpoint for creating a new user")
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponseDTO> register(@RequestBody RegisterRequestDTO registerRequestDTO){
        return ResponseEntity.ok(authenticationService.registerUser(registerRequestDTO));
    }

    @Operation(description = "Post endpoint for authenticating a user")
    @PostMapping("/authentication")
    public ResponseEntity<AuthenticationResponseDTO> authenticate(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password){
        AuthenticationRequestDTO authenticationRequestDTO = new AuthenticationRequestDTO();
        authenticationRequestDTO.setUsername(username);
        authenticationRequestDTO.setPassword(password);
        return ResponseEntity.ok(authenticationService.authenticateUser(authenticationRequestDTO));
    }

}
