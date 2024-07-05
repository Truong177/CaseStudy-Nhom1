package com.example.phonestore.services;

import com.example.phonestore.models.Phone;

import java.util.List;

public interface IPhoneService {
    List<Phone> findAll();

    void savePhone(Phone phone);

    boolean deleteById(int phoneId);
}
