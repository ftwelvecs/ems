package kz.f12.school.service;

import kz.f12.school.model.dto.AddressDTO;
import kz.f12.school.model.repository.AddressRepository;

import java.util.List;

public class AddressService {

    private AddressRepository repository = new AddressRepository();

    public AddressDTO findById(int addressId) {
        return repository.findById(addressId);
    }

    public List<AddressDTO> getAll() {
        return repository.getAll();
    }

}
