package com.example.phonestore.repositories;

import com.example.phonestore.models.Phone;

import java.util.List;

public interface IPhoneRepository {
    List<Phone> findAll();

    void savePhone(Phone phone);

    boolean deleteById(int phoneId);

    List<Phone> findByName(String name);

    Phone findById(int id);

    void update(int id, Phone phone);
}
