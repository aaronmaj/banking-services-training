package com.banque.services.core.persistence.jdbc;

import com.banque.services.core.model.Compte;
import com.banque.services.core.persistence.CompteDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CompteJdbc implements CompteDao {

    @Override
    public List<Compte> findAll() {
        List<Compte> people = new ArrayList<>();
        try (Connection connection =DatabaseConnection.get();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM COMPTES")) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                //people.add(new Compte(rs.getInt(1), rs.getString(2)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return people;
    }

    @Override
    public Optional<Compte> findbyId(Integer id) {
        try (Connection connection = DatabaseConnection.get();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM COMPTES WHERE id=?")) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                //return Optional.of(new Compte(rs.getInt(1), rs.getString(2)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Integer save(Compte Compte) {
        int generatedKey = 0;
        try (Connection connection = DatabaseConnection.get();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO COMPTE (NAME) VALUES (?)",
                     Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, Compte.getIntitule());
            int uc = ps.executeUpdate();

            if (uc != 1) throw new SQLException("Aucune ligne ajoutee.");
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    generatedKey = keys.getInt(1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return generatedKey;
    }

    @Override
    public void delete(Compte Compte) {
        try (Connection connection = DatabaseConnection.get();
             PreparedStatement ps = connection.prepareStatement("DELETE FROM COMPTES WHERE id=?")) {

            ps.setInt(1, Compte.getId());
            int uc = ps.executeUpdate();
            if (uc != 1) throw new SQLException("Aucune ligne supprimmee.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
