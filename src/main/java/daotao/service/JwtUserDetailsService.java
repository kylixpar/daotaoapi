package daotao.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import daotao.model.User;
import daotao.repository.UserRepository;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
  private UserRepository userRepository;
	
	//private static final String USER_NAME = "trungpq";
  //private static final String PASSWORD = "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6";

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
  	User user = userRepository.findByUsername(username);
  	if (user == null) {
          throw new UsernameNotFoundException(username);
      }
      return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());

  }
}
