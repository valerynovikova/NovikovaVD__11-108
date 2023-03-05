package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.User;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Integer id;

    private String name;

    private String email;

    public static UserDto fromEntity(User user) {//fromEntity   from в чем разница???шо это такое вообще
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    public static List<UserDto> fromEntity(List<User> authors) {
        return authors.stream().map(UserDto::fromEntity).collect(Collectors.toList());
    }


}
