package com.example.phonestore.services.impl;

import com.example.phonestore.models.Phone;
import com.example.phonestore.repositories.IPhoneRepository;
import com.example.phonestore.repositories.impl.PhoneRepository;
import com.example.phonestore.services.IPhoneService;

import java.util.List;

public class PhoneService implements IPhoneService {
    private IPhoneRepository phoneRepository = new PhoneRepository();
    @Override
    public List<Phone> findAll() {
        return phoneRepository.findAll();
    }

    @Override
    public void savePhone(Phone phone) {
        phoneRepository.savePhone(phone);
    }
}
