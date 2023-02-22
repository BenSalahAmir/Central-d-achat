package tn.esprit.pidev.Service;

import tn.esprit.pidev.Entity.Role;
import tn.esprit.pidev.generic.IGenericService;

public interface IRoleService extends IGenericService<Role,Long> {
    public Role getRole(String name);
}
