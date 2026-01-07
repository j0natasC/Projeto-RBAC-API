package com.jonatas.rbacapi.config;

import com.jonatas.rbacapi.domain.Permission;
import com.jonatas.rbacapi.domain.Role;
import com.jonatas.rbacapi.repository.PermissionRepository;
import com.jonatas.rbacapi.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(
            PermissionRepository permissionRepository,
            RoleRepository roleRepository) {
        return args -> {

            Permission create = permissionRepository.findByName("CREATE_USER")
                    .orElseGet(() -> permissionRepository.save(new Permission("CREATE_USER")));

            Permission read = permissionRepository.findByName("READ_USER")
                    .orElseGet(() -> permissionRepository.save(new Permission("READ_USER")));

            Permission delete = permissionRepository.findByName("DELETE_USER")
                    .orElseGet(() -> permissionRepository.save(new Permission("DELETE_USER")));

            roleRepository.findByName("ADMIN")
                    .orElseGet(() -> {
                        Role admin = new Role("ADMIN");
                        admin.addPermission(create);
                        admin.addPermission(read);
                        admin.addPermission(delete);
                        return roleRepository.save(admin);
                    });
        };
    }
}
