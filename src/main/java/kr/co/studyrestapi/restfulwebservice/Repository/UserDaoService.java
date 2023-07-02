package kr.co.studyrestapi.restfulwebservice.Repository;

import kr.co.studyrestapi.restfulwebservice.Domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int userCount=3;
    static{
        users.add(new User(1,"LDH", new Date()));
        users.add(new User(2,"BGJ", new Date()));
        users.add(new User(3,"LYH", new Date()));
    }
    //사용자 전체 목록 조회
    public List<User> findAllUser(){
        return users;
    }
    //특정 사용자 조회
    public User findUser(int id){
        for(User user : users){
            if (user.getId()==id){
                return user;
            }
        }
        return null;
    }
    //사용자 추가
    public User createUser(User user){
        if(user.getId()==null){
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }

    public User deleteUserById(int id){
        Iterator<User> iterator = users.iterator();
        while(iterator.hasNext()){
            User user = iterator.next();
            if (user.getId()==id){
                users.remove(id);
                return user;
            }
        }
        return null;
    }
}
