package hh.healthhive.Controller;

import hh.healthhive.Model.Calorie;
import hh.healthhive.Model.Chats;
import hh.healthhive.Model.User;
import hh.healthhive.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class ChatController {
    @Autowired
    UserRepository userRepository;


    @GetMapping("/askDr/{id}")
    @ResponseBody
    public Chats getUserName(@PathVariable Long id){
        Chats chat = new Chats();

        User user = userRepository.findByUserId(id);
        chat.setUserName(user.getUser_name());
        return chat;
    }




    }
