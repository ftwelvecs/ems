package kz.f12.school.service;

import kz.f12.school.model.dto.PositionDTO;
import kz.f12.school.model.repository.PositionRepository;

import java.util.List;

public class PositionService {

    private PositionRepository repository = new PositionRepository();

    public void create(PositionDTO positionDTO) {
        // TODO: реализовать метод в репозитории
        // repository.create(positionDTO);
    }

    public void update(PositionDTO positionDTO) {
        // TODO: реализовать метод в репозитории
        // repository.update(positionDTO);
    }

    public void delete(PositionDTO positionDTO) {
        // TODO: реализовать метод в репозитории
        // repository.delete(positionDTO);
    }

    public PositionDTO findById(int positionId) {
        return repository.findById(positionId);
    }

    public List<PositionDTO> getAll() {
        return repository.getAll();
    }

}
