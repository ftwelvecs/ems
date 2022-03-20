package kz.f12.school.ems.web;

import kz.f12.school.ems.model.entity.Position;
import kz.f12.school.ems.service.PositionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PositionController {

    private final PositionService positionService;

    @GetMapping("/position")
    public ResponseEntity<List<Position>> findAll() {
        return ResponseEntity.ok(positionService.findAll());
    }

    @GetMapping("/position/{id}")
    public Position findById(@PathVariable("id") Long id) {
        return positionService.findById(id);
    }
}
