package kz.f12.school.service;

import kz.f12.school.model.dto.DepartmentDTO;
import kz.f12.school.model.repository.DepartmentRepository;

import java.util.List;

public class DepartmentService {

    private DepartmentRepository repository = new DepartmentRepository();

    public void create(DepartmentDTO departmentDTO) {

    }

    public void update(DepartmentDTO departmentDTO) {

    }

    public void delete(DepartmentDTO departmentDTO) {

    }

    public DepartmentDTO findById(int departmentId) {
        return repository.findById(departmentId);
    }

    public List<DepartmentDTO> getAll() {
        return repository.getAll();
    }

}
