package com.usa.ciclo3.reto3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.ciclo3.reto3.model.Admin;
import com.usa.ciclo3.reto3.repository.AdminRepository;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> obtenerAdmins() {
        return adminRepository.obtenerAdmins();
    }

    public Admin salvarAdmin(Admin admin) {
        if (admin.getId() == null) {
            return adminRepository.salvarAdmin(admin);
        } else {
            return admin;
        }
    }

}
