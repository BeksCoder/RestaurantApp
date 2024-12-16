package sultan.is.restaurantapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import sultan.is.restaurantapp.enums.Role;
import java.time.LocalDate;
@Builder
@Getter
@AllArgsConstructor
public class UserResponse {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String email;
    private String password;
    private String phoneNumber;
    private Role role;
    private int experience;
}
