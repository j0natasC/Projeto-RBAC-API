package com.jonatas.rbacapi.config;

import com.jonatas.rbacapi.domain.Permission;
import com.jonatas.rbacapi.repository.PermissionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadPermissions(PermissionRepository repository) {
        return args -> {
            createIfNotExists(repository, "CREATE_USER");
            createIfNotExists(repository, "READ_USER");
            createIfNotExists(repository, "DELETE_USER");
        };
    }

    private void createIfNotExists(PermissionRepository repository, String name) {
        repository.findByName(name)
                .orElseGet(() -> repository.save(new Permission(name)));
    }
}
