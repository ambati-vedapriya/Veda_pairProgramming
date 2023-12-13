package com.backend_pp.Service;

import com.backend_pp.Dto.UserDto;
import com.backend_pp.Dto.UserSensitiveDto;
import com.backend_pp.Entity.User;
import com.backend_pp.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<UserSensitiveDto> getAllUsers() {
        List<User> users=userRepository.findAll();
        List<UserSensitiveDto> userSensitiveDTOList=users.stream().map(user -> modelMapper.map(user,UserSensitiveDto.class)).collect(Collectors.toList());
        return userSensitiveDTOList;
    }

    @Override
    public UserSensitiveDto createUser(UserDto userDto) {
        User user=modelMapper.map(userDto,User.class);
        user=userRepository.save(user);
        UserSensitiveDto userSensitiveDto=modelMapper.map(user,UserSensitiveDto.class);

        return userSensitiveDto;
    }
}
