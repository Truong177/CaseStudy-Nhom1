package com.example.phonestore.repositories;

import com.example.phonestore.models.Phone;

import java.util.List;

public interface IPhoneRepository {
    List<Phone> findAll();
}
