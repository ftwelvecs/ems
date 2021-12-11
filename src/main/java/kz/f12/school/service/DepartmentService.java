package kz.f12.school.service;

import kz.f12.school.model.dto.DepartmentDTO;
import kz.f12.school.model.repository.DepartmentRepository;

import java.util.List;

public class DepartmentService {

    private DepartmentRepository repository = new DepartmentRepository();

    public void create(DepartmentDTO departmentDTO) {
        repository.create(departmentDTO);
    }

    public void update(DepartmentDTO departmentDTO) {
        // TODO: реализовать метод в репозитории
        // repository.update(departmentDTO);
    }

    public void delete(DepartmentDTO departmentDTO) {
        // TODO: реализовать метод в репозитории
        // repository.delete(departmentDTO);
    }

    public DepartmentDTO findById(int departmentId) {
        return repository.findById(departmentId);
    }

    public List<DepartmentDTO> getAll() {
        return repository.getAll();
    }

}
