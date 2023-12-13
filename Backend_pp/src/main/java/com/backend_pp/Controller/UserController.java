package com.backend_pp.Controller;

import com.backend_pp.Dto.UserDto;
import com.backend_pp.Dto.UserSensitiveDto;
import com.backend_pp.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserSensitiveDto>> getAllUsers(){
        List<UserSensitiveDto> users=userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<UserSensitiveDto> createUser(@Valid @RequestBody UserDto userDto){
        UserSensitiveDto user=userService.createUser(userDto);
        return  new ResponseEntity<>(user,HttpStatus.CREATED);
    }
}
