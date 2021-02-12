package hw.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hw.model.User;
import hw.repository.UserRepository;



@Service("UserDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

	private final  UserRepository userRepository;
	
	
	@Autowired
	public UserDetailsServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}



	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("error, please check you email"));
		return SecurityUser.fromUser(user);
	}

}
