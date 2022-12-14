package work.appdeploys.equipmentcontrolsystem.models.structures;

import lombok.AllArgsConstructor;
import lombok.Data;
import work.appdeploys.equipmentcontrolsystem.models.dtos.UserResponseDto;

import java.util.List;

@Data
@AllArgsConstructor
public class UsersResponse {
    private String message;
    private List<UserResponseDto> usersDto;
}
