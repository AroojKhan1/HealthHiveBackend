package hh.healthhive.Controller;

import hh.healthhive.Model.*;
import hh.healthhive.Repository.PostRepository;
import hh.healthhive.Repository.ReplyRepository;
import hh.healthhive.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class ForumController {
    @Autowired
    ReplyRepository rr;
    @Autowired
    PostRepository pr;

    @Autowired
    UserRepository ur;


    @PostMapping("/forum/{userId}")
    public String addPost(@Valid @RequestBody Post post, @PathVariable Long userId) {
        post.setPost_date(new Date());
        post.setTime(LocalTime.now());
        System.out.println("time"+post.getTime());
        post.setUser(userId);

        System.out.println("userId:" + userId);

        System.out.println("post:" + post);
        pr.save(post);
        return "Post Uploaded!";
    }


    @GetMapping("/forum")
    @ResponseBody
    public List<Post> getAllPosts() {
     return pr.findAll();
    }


    @PostMapping("/forum/{postId}/{userId}")
    public ResponseEntity<?> addReplyToPost(@PathVariable Long postId, @PathVariable Long userId, @RequestBody Reply reply) {

        Optional<Post> postOptional = pr.findById(postId);
        if(postOptional.isPresent()) {
            Post post = postOptional.get();

            reply.setReply_date(new Date());
            reply.setTime(LocalTime.now());
            reply.setPost_id(postId);
            reply.setUser_id(userId);
            post.setReply_content(reply.getContent());

            pr.save(post);
            System.out.println("replycontent:" + reply.getContent());
            rr.save(reply);
            return ResponseEntity.ok("Reply posted!");
        } else {

            System.out.println("in else:" + userId);
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/forum/{postId}")
    @ResponseBody
    public List<ReplyResponse> getAllReplies(@PathVariable Long postId) {
        List<Reply> replies = rr.findByPostId(postId);
        List<ReplyResponse> response = new ArrayList<>();

        for(Reply r: replies){
            User user = ur.findByUserId(r.getUser_id());
            ReplyResponse rr = new ReplyResponse();
            rr.setReply(r);
            rr.setUserName(user.getUser_name());
            response.add(rr);
        }


        return response;
    }

}
