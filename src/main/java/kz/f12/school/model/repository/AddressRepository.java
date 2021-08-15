package kz.f12.school.model.repository;

import kz.f12.school.model.dto.AddressDTO;

public class AddressRepository extends AbstractRepository<AddressDTO> {
    @Override
    public String getTableName() {
        return "addresses";
    }
}
