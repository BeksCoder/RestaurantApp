package sultan.is.restaurantapp.services.impl;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import sultan.is.restaurantapp.entities.User;
import sultan.is.restaurantapp.enums.Role;
import sultan.is.restaurantapp.repositories.UserRepository;

import java.time.LocalDate;

@Service
public class UserServiceImpl {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    private void saveAdmin(){
        if (!userRepository.existsUserByEmail("adminov@gmail.com")) {
            User user = User.builder()
                    .firstName("Admin")
                    .lastName("Adminov")
                    .role(Role.ADMIN)
                    .phoneNumber("996543543")
                    .password("javaCode")
                    .email("adminov@gmail.com")
                    .dateOfBirth(LocalDate.of(2002,2,2))
                    .build();
            userRepository.save(user);



        }


     }

}
