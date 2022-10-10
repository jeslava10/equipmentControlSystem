package work.appdeploys.equipmentcontrolsystem.models.structures;

import lombok.AllArgsConstructor;
import lombok.Data;
import work.appdeploys.equipmentcontrolsystem.models.dtos.OrdersDto;

import java.util.List;

@Data
@AllArgsConstructor
public class OrdersResponse {
    private String message;
    private List<OrdersDto> ordersDtos;
}
