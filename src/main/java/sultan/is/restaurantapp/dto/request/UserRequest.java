package sultan.is.restaurantapp.dto.request;

import sultan.is.restaurantapp.enums.Role;

import java.time.LocalDate;

public record UserRequest(
        String firstName,
        String lastName,
        LocalDate dateOfBirth,
        String email,
        String password,
        String phoneNumber,
        Role role,
        int experience
) {
}
