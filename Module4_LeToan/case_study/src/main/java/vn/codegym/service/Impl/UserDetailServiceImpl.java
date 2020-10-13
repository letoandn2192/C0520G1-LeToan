package vn.codegym.service.Impl;

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
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("Can not found User!!!");
        }

        Set<Role> roleList = user.getRoles();
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        for (Role role:roleList) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRoleName());
            grantList.add(grantedAuthority);
        }
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), grantList);
        return userDetails ;
    }
}
