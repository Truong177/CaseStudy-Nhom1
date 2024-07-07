package com.example.phonestore.repositories.impl;

import com.example.phonestore.models.Phone;
import com.example.phonestore.repositories.IPhoneRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhoneRepository implements IPhoneRepository {

    @Override
    public List<Phone> findAll() {
        List<Phone> phones = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        if (connection == null) {
            throw new RuntimeException("Database connection is null");
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id_product, name_product, manufacture, price, quantity, size, color, ram, battery, image FROM product");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_product");
                String name = resultSet.getString("name_product");
                String manufacture = resultSet.getString("manufacture");
                long price = resultSet.getLong("price");
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

    @Override
    public void savePhone(Phone phone) {
        String sql = "INSERT INTO product (name_product, image, manufacture, price, quantity, size, color, ram, battery) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = BaseRepository.getConnection();
        if (connection == null) {
            throw new RuntimeException("Database connection is null");
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, phone.getName());
            preparedStatement.setString(2, phone.getImg());
            preparedStatement.setString(3, phone.getManufacture());
            preparedStatement.setLong(4, phone.getPrice());
            preparedStatement.setInt(5, phone.getQuantity());
            preparedStatement.setFloat(6, phone.getSize());
            preparedStatement.setString(7, phone.getColor());
            preparedStatement.setInt(8, phone.getRam());
            preparedStatement.setInt(9, phone.getBattery());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteById(int phoneId) {
        boolean isDeleted;
        Connection connection = BaseRepository.getConnection();
        if (connection == null) {
            throw new RuntimeException("Database connection is null");
        }
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM product WHERE id_product = ?");
            statement.setInt(1, phoneId);
            isDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isDeleted;
    }

    @Override
    public List<Phone> findByName(String name) {
        List<Phone> result = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        if (connection == null) {
            throw new RuntimeException("Database connection is null");
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id_product, name_product, image, manufacture, price, quantity, size, color, ram, battery FROM product WHERE name_product LIKE ?");
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_product");
                String phoneName = resultSet.getString("name_product");
                String image = resultSet.getString("image");
                String manufacture = resultSet.getString("manufacture");
                long price = resultSet.getLong("price");
                int quantity = resultSet.getInt("quantity");
                float size = resultSet.getFloat("size");
                String color = resultSet.getString("color");
                int ram = resultSet.getInt("ram");
                int battery = resultSet.getInt("battery");

                Phone phone = new Phone(id, phoneName, image, manufacture, price, quantity, size, color, ram, battery);
                result.add(phone);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public Phone findById(int id) {
        Phone phone = null;
        Connection connection = BaseRepository.getConnection();
        if (connection == null) {
            throw new RuntimeException("Database connection is null");
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM product WHERE id_product = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String phoneName = resultSet.getString("name_product");
                String image = resultSet.getString("image");
                String manufacture = resultSet.getString("manufacture");
                long price = resultSet.getLong("price");
                int quantity = resultSet.getInt("quantity");
                float size = resultSet.getFloat("size");
                String color = resultSet.getString("color");
                int ram = resultSet.getInt("ram");
                int battery = resultSet.getInt("battery");

                phone = new Phone(id, phoneName, image, manufacture, price, quantity, size, color, ram, battery);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return phone;
    }

    @Override
    public void update(int id, Phone phone) {
        Connection connection = BaseRepository.getConnection();
        if (connection == null) {
            throw new RuntimeException("Database connection is null");
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE product SET name_product = ?, image = ?, manufacture = ?, price = ?, quantity = ?, size = ?, color = ?, ram = ?, battery = ? WHERE id_product = ?");

            preparedStatement.setString(1, phone.getName());
            preparedStatement.setString(2, phone.getImg());
            preparedStatement.setString(3, phone.getManufacture());
            preparedStatement.setLong(4, phone.getPrice());
            preparedStatement.setInt(5, phone.getQuantity());
            preparedStatement.setFloat(6, phone.getSize());
            preparedStatement.setString(7, phone.getColor());
            preparedStatement.setInt(8, phone.getRam());
            preparedStatement.setInt(9, phone.getBattery());
            preparedStatement.setInt(10, phone.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
