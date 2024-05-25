package com.YADHU.CRUD_APP.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.YADHU.CRUD_APP.DTO.DeletionRequest;
import com.YADHU.CRUD_APP.DTO.ValidationRequest;
import com.YADHU.CRUD_APP.Model.Users;
import com.YADHU.CRUD_APP.Service.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/users")
public class UserController {
@Autowired
	private UserService userService;
	
@PostMapping("/register")
public Users UserRegister(@RequestBody Users user) {   
    return userService.registerUSer(user) ;
}

@PostMapping("/validate")
public ResponseEntity<Users> validateUser(@RequestBody ValidationRequest request) {
    Users user = userService.validateUser(request.getEmail(), request.getPassword());
    return ResponseEntity.ok(user);
}


@DeleteMapping("/deleteuser")
public ResponseEntity<String> deleteUserBymail(@RequestBody DeletionRequest request)
{
	userService.deleteUser(request.getEmail());
	return ResponseEntity.ok("User deleted successfully");
}

@GetMapping
public List<Users> getUsers(){
	return userService.getAllUsers();
}


}
