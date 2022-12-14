package work.appdeploys.equipmentcontrolsystem.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import work.appdeploys.equipmentcontrolsystem.constants.MessageResource;
import work.appdeploys.equipmentcontrolsystem.models.structures.OrderBySchoolResponse;
import work.appdeploys.equipmentcontrolsystem.services.OrderBySchoolService;

import java.time.LocalDate;
import java.util.Arrays;

@Tag(name="Order numbrer by school")
@RequiredArgsConstructor
@RequestMapping(value = "/api/ordersnumber/")
@RestController
public class OrderBySchoolController {
    private final OrderBySchoolService orderBySchoolService;

    @GetMapping(path = "/date/{dateTo}" )
    public ResponseEntity<OrderBySchoolResponse> getByOrderNumberDate(@PathVariable("dateTo") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateTo){
        try{
            return ResponseEntity.ok(new OrderBySchoolResponse(MessageResource.ORDER_NUMBER_LISTED.getValue(),orderBySchoolService.findByAllDate(dateTo)));
        }catch (Exception ex){
            return ResponseEntity.badRequest().body(new OrderBySchoolResponse(ex.getMessage(), Arrays.asList()));
        }
    }

    @GetMapping(path = "/school/{idschool}")
    public ResponseEntity<OrderBySchoolResponse> getByOrderNumberDate(@PathVariable Long idschool){
        try{
            return ResponseEntity.ok(new OrderBySchoolResponse(MessageResource.ORDER_NUMBER_LISTED.getValue(),orderBySchoolService.findByAllOrderSchool(idschool)));
        }catch (Exception ex){
            return ResponseEntity.badRequest().body(new OrderBySchoolResponse(ex.getMessage(), Arrays.asList()));
        }
    }


}
