package com.YADHU.CRUD_APP.Service;

import java.util.List;


import com.YADHU.CRUD_APP.Model.Users;

public interface UserService {
Users registerUSer(Users user);
Users validateUser(String email,String password);
void  deleteUser(String email);
List<Users> getAllUsers();
}
