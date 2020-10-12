package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.codegym.model.Role;
import vn.codegym.model.User;
import vn.codegym.repository.UserRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional //dung de mo tac vu de lay cac role.
public class UserImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User Not Found");
        }
        System.err.println(user.getUserName());
        System.err.println(user.getPassword());

        Set<Role> roleList = user.getRoles();
//        System.out.println(roleList);
        Set<GrantedAuthority> grantList = new HashSet<>();
        for (Role temp : roleList) {
            GrantedAuthority authority = new SimpleGrantedAuthority(temp.getRoleName());
            grantList.add(authority);
            System.err.println(authority);
        }

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), grantList);
        return userDetails;
    }
}
