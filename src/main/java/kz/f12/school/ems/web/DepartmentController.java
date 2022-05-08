package kz.f12.school.ems.web;

import kz.f12.school.ems.model.entity.Department;
import kz.f12.school.ems.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@AllArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<List<Department>> findAll() {
        return ResponseEntity.ok(departmentService.findAll());
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable("id") Long id) {
        return departmentService.findById(id);
    }

    @PostMapping
    public void create(@RequestBody Department department) {
        departmentService.save(department);
    }

    @PutMapping
    public void update(@RequestBody Department department) {
        departmentService.save(department);
    }

    @DeleteMapping
    public void delete(@RequestBody Department department) {
        departmentService.delete(department);
    }

}
