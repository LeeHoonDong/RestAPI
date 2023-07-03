package kr.co.studyrestapi.restfulwebservice.Controller;

import jakarta.validation.Valid;
import kr.co.studyrestapi.restfulwebservice.Domain.User;
import kr.co.studyrestapi.restfulwebservice.Exception.UserNotFoundException;
import kr.co.studyrestapi.restfulwebservice.Repository.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserDaoService userDaoService;

    //전체 사용자 조회
    @GetMapping("/users")
    public List<User> findAllUsers(){
        return userDaoService.findAllUser();
    }
    //특정 사용자 조회
    @GetMapping("/users/{id}")
    public User findOneUser(@PathVariable int id){
        User savedUser=userDaoService.findUser(id);
        if(savedUser==null){
            throw new UserNotFoundException(String.format("[%s]는없는 사용자입니다.",id));
        }
        return userDaoService.findUser(id);
    }
    @PostMapping("/users")
    public ResponseEntity<User> saveUser(@Valid @RequestBody User user){
        User savedUser=userDaoService.createUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        User deleteUser = userDaoService.deleteUserById(id);
        if(deleteUser==null) {
            throw new UserNotFoundException(String.format(String.format("[%s]는없는 사용자입니다.", id)));
        }
    }
}
