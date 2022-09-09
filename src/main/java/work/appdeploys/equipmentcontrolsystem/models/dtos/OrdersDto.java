package work.appdeploys.equipmentcontrolsystem.models.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
@Schema(description = "orders")
public class OrdersDto {
    @Schema(description = "Code order", example="1")
    private Long id;
    @Schema(description = "model computer", example="DELL 3100 CB")
    private String model;
    @Schema(description = "serial computer", example="6c0v073")
    private String serial;
    @Schema(description = "numbrer asset", example="71223117")
    private Long asset;
    @Schema(description = "issue", example="KEYBOARD")
    private String issue;
    @Schema(description = "number incident", example="INC0199012")
    private Long incident_id;
    @Schema(description = "note", example="some one")
    private String note;
    @Schema(description = "status", example="Fixed")
    private String status;
    @Schema(description = "Id user create", example="2")
    private UsersDto idusercreate;
    @Schema(description = "date create", example="2021-01-01")
    private Date datecreate;
    @Schema(description = "Id user create", example="2")
    private UsersDto idusermod;
    @Schema(description = "csq order", example="1")
    private Long order;
}