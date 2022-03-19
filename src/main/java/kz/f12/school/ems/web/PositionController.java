package kz.f12.school.ems.web;

import kz.f12.school.ems.model.entity.Position;
import kz.f12.school.ems.service.PositionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PositionController {

    private final PositionService positionService;

    @GetMapping("/position")
    public List<Position> findAll() {
        return positionService.findAll();
    }

    @GetMapping("/position/findByName")
    public Position findByName(@RequestParam("name") String name) {
        return positionService.findByName(name);
    }

    @GetMapping("/position/{id}")
    public Position findById(@PathVariable("id") Long id) {
        return positionService.findById(id);
    }
}
