package tn.esprit.pidev.Controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pidev.Entity.User;
import tn.esprit.pidev.Service.IUserService;
import tn.esprit.pidev.generic.GenericController;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController extends GenericController<User,Long> {
    private IUserService userService;


    @GetMapping("/getuser/{userName}")
        public User getUser(@PathVariable String userName) {

        return userService.getUser(userName);
    }

    @PostMapping("/save")
    public User saveUser(@RequestBody User  user) {
      return  userService.SaveUser(user);
    }

/*
    @PostMapping("/role/addtouser/{email}/{name}")
    public void addRoleToUser(@PathVariable String  email ,@PathVariable String name) {
        userService.addRoleToUser(email,name);

    }
    */

    @PostMapping("/role/addtouser")
    public ResponseEntity<?>addRoleToUser(@RequestBody RoleToUserForm form) {
        userService.addRoleToUser(form.getUserName(),form.getRoleName());
        return ResponseEntity.ok().build();
    }

}
@Data
class RoleToUserForm {
    private String userName;
    private String roleName;
}
