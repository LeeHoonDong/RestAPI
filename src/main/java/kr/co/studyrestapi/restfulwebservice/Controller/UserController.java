package kr.co.studyrestapi.restfulwebservice.Controller;

import kr.co.studyrestapi.restfulwebservice.Domain.User;
import kr.co.studyrestapi.restfulwebservice.Repository.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return userDaoService.findUser(id);
    }
    @PostMapping("/users")
    public User saveUser(@RequestBody User user){
        return userDaoService.createUser(user);
    }
}
