package org.example.projectforthecompetition.service;

import org.example.projectforthecompetition.dto.ForRegister.UserDto;
import org.example.projectforthecompetition.entity.Role;
import org.example.projectforthecompetition.entity.User;
import org.example.projectforthecompetition.exception.ResourceNotFoundException;
import org.example.projectforthecompetition.mapper.UserMapper;
import org.example.projectforthecompetition.repository.RoleRepository;
import org.example.projectforthecompetition.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       UserMapper userMapper,
                       RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
        this.roleRepository = roleRepository;
    }

    public User register(UserDto userDto) {
        User user = userMapper.toUser(userDto);

        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        String selectedRole = userDto.getRole();
        if (selectedRole == null || selectedRole.isEmpty()) {
            selectedRole = "ROLE_USER";
        }


        switch (selectedRole.toUpperCase()) {
            case "ROLE_CREATOR":
                Role creatorRole = roleRepository.findByName("ROLE_CREATOR")
                        .orElseThrow(() -> new ResourceNotFoundException("Role ROLE_CREATOR not found"));
                user.getRoles().add(creatorRole);
                break;
            default:
                Role userRole = roleRepository.findByName("ROLE_USER")
                        .orElseThrow(() -> new RuntimeException("Role ROLE_USER not found"));
                user.getRoles().add(userRole);
                break;
        }

        return userRepository.save(user);
    }
}