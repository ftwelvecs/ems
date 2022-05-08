package kz.f12.school.ems.service;

import kz.f12.school.ems.exception.EntityNotFountException;
import kz.f12.school.ems.model.entity.Region;
import kz.f12.school.ems.model.repository.RegionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RegionService {

    private final RegionRepository regionRepository;

    public List<Region> findAll() {
        return regionRepository.findAll();
    }

    public Region findById(Long id) {
        Optional<Region> optionalRegion = regionRepository.findById(id);
        if (optionalRegion.isPresent())
            return optionalRegion.get();
        else
            throw new EntityNotFountException();
    }

    public void save(Region region) {
        regionRepository.save(region);
    }

    public void delete(Region region) {
        regionRepository.delete(region);
    }
}
