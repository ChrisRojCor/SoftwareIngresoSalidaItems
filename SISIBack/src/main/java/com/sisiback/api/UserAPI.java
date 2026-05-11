package com.sisiback.api;

import com.sisiback.dao.UserDAO;
import com.sisiback.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*")
public class UserAPI {

    @Autowired
    private UserDAO userDAO;

    @PostMapping("/create")
    public void create(@RequestBody User user){userDAO.save(user);}

    @GetMapping("/read")
    public List<User> read(){return userDAO.findAll();}

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Integer id){userDAO.deleteById(id);}

    @PutMapping("/update")
    public void update(@RequestBody User user){userDAO.save(user);}

}
