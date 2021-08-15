package kz.f12.school.model.repository;

import kz.f12.school.model.dto.RegionDTO;

public class RegionRepository extends AbstractRepository<RegionDTO> {

    @Override
    public String getTableName() {
        return "regions";
    }
}
