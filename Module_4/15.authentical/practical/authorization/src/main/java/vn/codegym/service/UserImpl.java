package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.codegym.model.User;
import vn.codegym.model.UserRole;
import vn.codegym.repository.UserRepository;
import vn.codegym.repository.UserRoleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.SimpleTimeZone;

@Service
public class UserImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User Not Found");
        }
        System.err.println(user.getUserName());
        System.err.println(user.getPassword());

        List<UserRole> userRoles = userRoleRepository.findByUser(user);
        List<GrantedAuthority> grantList = new ArrayList<>();
        if (!userRoles.isEmpty())
        for (UserRole temp: userRoles) {
            GrantedAuthority authority =new SimpleGrantedAuthority(temp.getRole().getRoleName());
            grantList.add(authority);
            System.err.println(authority);
        }

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), grantList);
        return userDetails;
    }
}
