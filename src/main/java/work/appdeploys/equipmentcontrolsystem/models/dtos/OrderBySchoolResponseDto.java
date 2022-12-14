package work.appdeploys.equipmentcontrolsystem.models.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@Schema(description = "Order number by school")
@EqualsAndHashCode(callSuper=false)
public class OrderBySchoolResponseDto {

    @Schema(description = "id", example = "1")
    private Long id;

    @Schema(description = "Order number", example = "1020")
    private Long orderNro;

    @Schema(description = "Order date", example = "2022-10-30")
    private LocalDate orderDate;

    @Schema(description = "Id school", example = "1")
    private Long orderSchool;

    @Schema(description = "name of school", example = "Landcaster school")
    private String orderSchoolName;



}
