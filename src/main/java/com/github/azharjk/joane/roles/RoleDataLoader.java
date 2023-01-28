package com.github.azharjk.joane.roles;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class RoleDataLoader implements ApplicationRunner {
  private final RoleRepository roleRepository;

  public RoleDataLoader(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    roleRepository.save(new Role(Role.READ_ID, RoleType.READ));
    roleRepository.save(new Role(Role.WRITE_ID, RoleType.WRITE));
  }
}
