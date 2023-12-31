package com.naja.userservice.service.impl;

import com.naja.userservice.model.Role;
import com.naja.userservice.repository.RoleRepository;
import com.naja.userservice.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }
}
