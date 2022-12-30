package work.appdeploys.equipmentcontrolsystem.mappers.maperstruc;

import org.mapstruct.Mapper;
import work.appdeploys.equipmentcontrolsystem.models.Users;
import work.appdeploys.equipmentcontrolsystem.models.dtos.UserResponseDto;
import work.appdeploys.equipmentcontrolsystem.models.dtos.UsersDto;

// con esta notacion hacemos que le mapper sea un componente springboot
// Spring IoC
@Mapper(componentModel = "spring")
public interface UsersMapper {

    Users toModel(UsersDto dto);
    UserResponseDto toResponseDto(Users users);
}
