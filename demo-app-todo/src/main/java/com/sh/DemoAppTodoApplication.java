package com.sh;

import com.sh.entities.Authority;
import com.sh.entities.User;
import com.sh.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoAppTodoApplication {
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserDetailsRepository userDetailsRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoAppTodoApplication.class, args);
	}

	@PostConstruct
	protected void init() {

		List<Authority> authorityList=new ArrayList<>();

		authorityList.add(createAuthority("USER","User role"));
		//authorityList.add(createAuthority("ADMIN","Admin role"));

		User user=new User();

		user.setUserName("pardeep161");
		user.setFirstName("Pardeep");
		user.setLastName("K");

		user.setPassword(passwordEncoder.encode("pardeep@123"));
		user.setEnabled(true);
		user.setAuthorities(authorityList);

		userDetailsRepository.save(user);



	}


	private Authority createAuthority(String roleCode,String roleDescription) {
		Authority authority=new Authority();
		authority.setRoleCode(roleCode);
		authority.setRoleDescription(roleDescription);
		return authority;
	}



}
