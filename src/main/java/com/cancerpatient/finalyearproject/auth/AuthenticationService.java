package com.cancerpatient.finalyearproject.auth;

import com.cancerpatient.finalyearproject.config.JwtService;
import com.cancerpatient.finalyearproject.repository.RoleRepository;
import com.cancerpatient.finalyearproject.repository.UserRepository;
import com.cancerpatient.finalyearproject.user.Role;
import com.cancerpatient.finalyearproject.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    private final RoleRepository roleRepository;

    public AuthenticationResponse register(RegisterRequest request, String role) {

        Set<Role> roles = new HashSet<>();
        Role v= roleRepository.findByName(role);
        roles.add(v);

     var user = User.builder()
             //.id(5)
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .address(request.getAddress())
                .phoneNumber(request.getPhoneNumber())
                .dateOfBirth((Date) request.getDateOfBirth())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(roles)
                .build();

        //user.getRoles().add(new Role(null, role));
        userRepository.save(user);


        var jwtToken = jwtService.generateToken(user);
        
        return AuthenticationResponse.builder()
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .role(role)
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
//        var refreshToken = jwtService.generateRefreshToken(user);
//        revokeAllUserTokens(user);
//        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder()
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .token(jwtToken)
                .build();
    }
}
