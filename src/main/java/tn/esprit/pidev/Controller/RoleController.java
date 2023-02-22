package tn.esprit.pidev.Controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pidev.Entity.Role;
import tn.esprit.pidev.Entity.User;
import tn.esprit.pidev.Service.IRoleService;
import tn.esprit.pidev.Service.IUserService;
import tn.esprit.pidev.generic.GenericController;

@RestController
@AllArgsConstructor
@RequestMapping("/role")
public class RoleController extends GenericController<Role,Long> {
    private IRoleService roleService;

    @GetMapping("/getrole/{name}")
    public Role getrole(@PathVariable String name) {

        return roleService.getRole(name);
    }
}
