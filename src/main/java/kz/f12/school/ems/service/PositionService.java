package kz.f12.school.ems.service;

import kz.f12.school.ems.exception.EntityNotFountException;
import kz.f12.school.ems.model.entity.Position;
import kz.f12.school.ems.model.repository.PositionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PositionService {

    private PositionRepository positionRepository;

    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    public Position findById(Long id) {
        Optional<Position> optionalPosition = positionRepository.findById(id);
        if (optionalPosition.isPresent())
            return optionalPosition.get();
        else
            throw new EntityNotFountException();
    }

    public void create(Position position) {
        positionRepository.save(position);
    }
}
