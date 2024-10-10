package more.pranav.springtransaction.controller;

import lombok.AllArgsConstructor;
import more.pranav.springtransaction.entity.Bus;
import more.pranav.springtransaction.service.RegisterBusService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class RegisterBusController {
    private final RegisterBusService registerBusService;

    @GetMapping(value = "/bus")
    public ResponseEntity<List<Bus>> getAllBus() {

        List<Bus> buses = registerBusService.getAllBuses();

        return ResponseEntity.ok(buses);
    }

    @PostMapping(value = "/bus")
    public ResponseEntity<Void> createBus(@RequestBody Bus bus) {

        boolean status = registerBusService.addBus(bus);

        if (status) {
            return ResponseEntity.accepted().build();
        } else {
            return ResponseEntity.badRequest().build();
        }

    }
}
