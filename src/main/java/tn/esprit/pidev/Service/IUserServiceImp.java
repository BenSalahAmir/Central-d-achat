package tn.esprit.pidev.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.pidev.Entity.Role;
import tn.esprit.pidev.Entity.User;
import tn.esprit.pidev.Repository.RoleRepository;
import tn.esprit.pidev.Repository.UserRepository;
import tn.esprit.pidev.generic.IGenericServiceImp;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;

@Service
@Transactional
@Slf4j
public class IUserServiceImp extends IGenericServiceImp<User,Long> implements IUserService, UserDetailsService {

    @Autowired
    private  UserRepository userRepo;
    @Autowired

    private   RoleRepository roleRepo;
    @Autowired
    private  PasswordEncoder passwordEncoder;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
/*
atef methode

		User user = userRepo.findByUserName(username);
		Assert.notNull(user, new UsernameNotFoundException(username).getMessage());
		return new User(user.getUsername(),user.getPassword(),getAuthorities(user.getRole()));

		//relation with user and role one to many

 */
        User user = userRepo.findUserByUsername(username);
        if(user == null) {
            log.error("User not found in the database");
            throw new UsernameNotFoundException ("User not found in the database");
        } else {
            log.info("User found in the database: {}", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority (role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }


    @Override
    public User SaveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public User getUser(String userName) {

        User user = userRepo.findUserByUsername(userName);
        System.out.println(user);

        if(user!=null){
            log.info("user finded");

            return user;
        }

        return null;
    }



    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = userRepo.findUserByUsername(username);
        Role role = roleRepo.findByName(roleName);
        user.getRoles().add(role);


    }
}


