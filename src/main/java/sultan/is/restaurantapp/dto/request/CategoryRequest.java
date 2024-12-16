package sultan.is.restaurantapp.dto.request;

import lombok.Builder;

@Builder
public record CategoryRequest(
        String name
) {
}
