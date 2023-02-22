package tn.esprit.pidev.Service;

import tn.esprit.pidev.Entity.User;
import tn.esprit.pidev.generic.IGenericService;

public interface IUserService extends IGenericService<User,Long> {


    public User SaveUser(User user);

    public User getUser(String username);


    public void addRoleToUser(String username, String roleName);

}
