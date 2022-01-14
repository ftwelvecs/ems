package kz.f12.school.service;

import kz.f12.school.model.dto.DepartmentDTO;
import kz.f12.school.model.repository.DepartmentRepository;

import java.util.List;
import java.util.stream.Collectors;

public class DepartmentService {

    private DepartmentRepository repository = new DepartmentRepository();

    public void create(DepartmentDTO departmentDTO) {
        repository.create(departmentDTO);
    }

    public void update(DepartmentDTO departmentDTO) {
        repository.update(departmentDTO);
    }

    public void delete(DepartmentDTO departmentDTO) {
        repository.delete(departmentDTO);
    }

    public DepartmentDTO findById(int departmentId) {
        return repository.findById(departmentId);
    }

    public List<DepartmentDTO> getAll() {
        return repository.getAll().stream().filter(DepartmentDTO::getIsActive).collect(Collectors.toList());
    }

}
