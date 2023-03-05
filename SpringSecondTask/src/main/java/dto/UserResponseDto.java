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
public class UserResponseDto {

    private Integer id;

    private String name;

    private String email;

    private Integer date;

    public static UserResponseDto fromEntity(User user) {//fromEntity   from в чем разница???шо это такое вообще
        return UserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .date(user.getDate())
                .build();
    }

    public static List<UserResponseDto> fromEntity(List<User> authors) {
        return authors.stream().map(UserResponseDto::fromEntity).collect(Collectors.toList());
    }


}
