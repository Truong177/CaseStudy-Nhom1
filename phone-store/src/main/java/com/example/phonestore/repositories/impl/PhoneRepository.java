package com.example.phonestore.repositories.impl;

import com.example.phonestore.models.Phone;
import com.example.phonestore.repositories.IPhoneRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhoneRepository implements IPhoneRepository {
    @Override
    public List<Phone> findAll() {
        List<Phone> phones = new ArrayList<>();
        try{

            PreparedStatement preparedStatement = BaseRepository.getConnection().
                    prepareStatement("SELECT id_product, name_product, manufacture, price, quantity, size, color, ram, battery, image FROM product");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id_product");
                String name = resultSet.getString("name_product");
                String manufacture = resultSet.getString("manufacture");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                float size = resultSet.getFloat("size");
                String color = resultSet.getString("color");
                int ram = resultSet.getInt("ram");
                int battery = resultSet.getInt("battery");
                String image = resultSet.getString("image");
                Phone phone = new Phone(id, name, image, manufacture, price, quantity, size, color, ram, battery);
                phones.add(phone);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return phones;
    }
}
