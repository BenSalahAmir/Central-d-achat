package tn.esprit.pidev.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.pidev.Entity.Role;
import tn.esprit.pidev.Entity.User;
import tn.esprit.pidev.Repository.RoleRepository;
import tn.esprit.pidev.generic.IGenericServiceImp;
@Service
@RequiredArgsConstructor
@Slf4j
public class IRoleServiceImp extends IGenericServiceImp<Role,Long> implements IRoleService{

    private  final RoleRepository roleRepo;

    @Override
    public Role getRole(String name) {
        Role role = roleRepo.findByName(name);

        if(role!=null){
            log.info("role finded");
            return role;
        }
        log.info("role indfinded");
        return role;
    }
}
