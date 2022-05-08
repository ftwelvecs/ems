package kz.f12.school.ems.web;

import kz.f12.school.ems.model.entity.Region;
import kz.f12.school.ems.service.RegionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/region")
@AllArgsConstructor
public class RegionController {

    private final RegionService regionService;

    @GetMapping
    public ResponseEntity<List<Region>> findAll() {
        return ResponseEntity.ok(regionService.findAll());
    }

    @GetMapping("/{id}")
    public Region findById(@PathVariable("id") Long id) {
        return regionService.findById(id);
    }

    @PostMapping
    public void create(@RequestBody Region region) {
        regionService.save(region);
    }

    @PutMapping
    public void update(@RequestBody Region region) {
        regionService.save(region);
    }

    @DeleteMapping
    public void delete(@RequestBody Region region) {
        regionService.delete(region);
    }

}
