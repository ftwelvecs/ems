package kz.f12.school.ems.service;

import kz.f12.school.ems.exception.DeleteUsedRecordException;
import kz.f12.school.ems.exception.EntityNotFountException;
import kz.f12.school.ems.model.entity.Department;
import kz.f12.school.ems.model.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    public Department findById(Long id) {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        if (optionalDepartment.isPresent())
            return optionalDepartment.get();
        else
            throw new EntityNotFountException();
    }

    public void save(Department department) {
        departmentRepository.save(department);
    }

    public void delete(Department department) {
        try {
            departmentRepository.delete(department);
        } catch (DataIntegrityViolationException e) {
            throw new DeleteUsedRecordException();
        }
    }
}
