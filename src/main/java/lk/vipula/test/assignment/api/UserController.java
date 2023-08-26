package lk.vipula.test.assignment.api;

import io.swagger.v3.oas.annotations.Operation;
import lk.vipula.test.assignment.config.util.JWTService;
import lk.vipula.test.assignment.dto.UserDTO;
import lk.vipula.test.assignment.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/v1/user")
public class UserController {

    private final JWTService jwtService;
    private final UserService userService;

    @Operation(description = "Get endpoint for show demo for getting logged user details")
    @GetMapping
    public ResponseEntity<UserDTO> getUser(@RequestHeader("Authorization") String jwtToken){
        String username = jwtService.extractUsername(jwtToken.substring(7));
        UserDTO user = userService.getUser(username);
        return ResponseEntity.ok(user);
    }
}
