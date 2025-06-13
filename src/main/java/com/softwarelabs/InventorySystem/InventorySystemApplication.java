package com.softwarelabs.InventorySystem;

import com.softwarelabs.InventorySystem.modules.user.entity.Role;
import com.softwarelabs.InventorySystem.modules.user.repo.RoleRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class InventorySystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(InventorySystemApplication.class, args);
	}

	@Bean
	public CommandLineRunner initRoles(RoleRepo roleRepo) {
		return args -> {
			List<String> hardCodeRoles = Arrays.asList(
					"ROLE_ADMIN",
					"ROLE_MANAGER",
					"ROLE_INVENTORY",
					"ROLE_SALES",
					"ROLE_CASHIER"
			);
			hardCodeRoles.forEach( roleName -> {
				Role role = new Role();
				role.setRoleName(roleName);
				roleRepo.save(role);
				System.out.println("Inserted Role...");
			});
		};
	}
}