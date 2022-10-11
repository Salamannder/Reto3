package com.usa.ciclo3.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.usa.ciclo3.reto3.model.Admin;
import com.usa.ciclo3.reto3.repository.CRUD.AdminCrudRepositoryInterfaz;

@Repository
public class AdminRepository {
    @Autowired
    public AdminCrudRepositoryInterfaz adminCrudRepositoryInterfaz;

    public List<Admin> obtenerAdmins() {
        return (List<Admin>) adminCrudRepositoryInterfaz.findAll();
    }

    public Admin salvarAdmin(Admin admin) {
        return adminCrudRepositoryInterfaz.save(admin);
    }

    public Optional<Admin> getAdmin(int id) {
        return adminCrudRepositoryInterfaz.findById(id);
    }

    public void delete(Admin admin) {
        adminCrudRepositoryInterfaz.delete(admin);
    }

}
