package kz.f12.school.model.repository;

import kz.f12.school.model.dto.DepartmentDTO;

public class DepartmentRepository extends AbstractRepository<DepartmentDTO> {
    @Override
    public String getTableName() {
        return "departments";
    }
}
