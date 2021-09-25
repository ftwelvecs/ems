package kz.f12.school.service;

import kz.f12.school.model.dto.RegionDTO;
import kz.f12.school.model.repository.RegionRepository;

import java.util.List;

public class RegionService {

    private RegionRepository repository = new RegionRepository();

    public void create(RegionDTO regionDTO) {

    }

    public void update(RegionDTO regionDTO) {

    }

    public void delete(RegionDTO regionDTO) {

    }

    public RegionDTO findById(int regionId) {
        return repository.findById(regionId);
    }

    public List<RegionDTO> getAll() {
        return repository.getAll();
    }

}
