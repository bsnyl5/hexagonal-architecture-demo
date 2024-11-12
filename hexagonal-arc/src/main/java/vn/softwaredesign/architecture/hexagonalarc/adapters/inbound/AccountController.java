package vn.softwaredesign.architecture.hexagonalarc.adapters.inbound;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import vn.softwaredesign.architecture.hexagonalarc.application.ports.inbound.AccountDto;
import vn.softwaredesign.architecture.hexagonalarc.service.AccountApplicationService;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountApplicationService accountApplicationService;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/create")
    public ResponseEntity<String> createAccount(@RequestBody AccountDto accountDto) {
        try {
            accountApplicationService.createAccount(accountDto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Account created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
        try {
            String encodedPassword = passwordEncoder.encode(password);
            accountApplicationService.login(email, encodedPassword);
            return ResponseEntity.ok("Login successful");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }

}
