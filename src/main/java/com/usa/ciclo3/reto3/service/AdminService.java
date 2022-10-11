package com.usa.ciclo3.reto3.service;

import java.util.List;
import java.util.Optional;

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

    public Admin actualizaAdmin(Admin admin) {
        if (admin.getId() != null) {
            Optional<Admin> e = adminRepository.getAdmin(admin.getId());
            if (!e.isEmpty()) {
                if (admin.getName() != null) {
                    e.get().setName(admin.getName());
                }
                if (admin.getEmail() != null) {
                    e.get().setEmail(admin.getEmail());
                }
                if (admin.getPassword() != null) {
                    e.get().setPassword(admin.getPassword());
                }
                adminRepository.salvarAdmin(e.get());
                return e.get();

            } else {
                return admin;
            }
        } else {
            return admin;
        }
    }

    public boolean borrarAdmin(int adminId) {
        boolean flag = false;
        Optional<Admin> c = adminRepository.getAdmin(adminId);
        if (c.isPresent()) {
            adminRepository.delete(c.get());
            flag = true;
        }
        return flag;

    }

}
