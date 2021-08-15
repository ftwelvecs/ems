package kz.f12.school.model.repository;

import kz.f12.school.model.dto.PositionDTO;

public class PositionRepository extends AbstractRepository<PositionDTO> {
    @Override
    public String getTableName() {
        return "positions";
    }
}
