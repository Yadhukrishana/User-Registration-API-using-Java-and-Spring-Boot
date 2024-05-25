package com.YADHU.CRUD_APP.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.YADHU.CRUD_APP.Model.Users;
import com.YADHU.CRUD_APP.Repo.UserRepository;

@Service
public class UserServiceImplimentation implements UserService{
	@Autowired
	private UserRepository repository;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public Users registerUSer(Users user) {
		Optional<Users> users = repository.findByEmail(user.getEmail());
		if(users.isPresent())
		{
			throw new RuntimeException("user with is Email already exists");
		}
		 user.setPassword(passwordEncoder.encode(user.getPassword()));
		return repository.save(user);
	}
	@Override

    public Users validateUser(String email, String password) {
        Users user = repository.findByEmail(email)
                                  .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        return user;
    }

	@Override
	  public void deleteUser(String email) {
        Users user = repository.findByEmail(email)
                                  .orElseThrow(() -> new RuntimeException("user not fount"));

        repository.delete(user);
    }

	@Override
	public List<Users> getAllUsers() {
		
		return repository.findAll();
	}
	
	

}
