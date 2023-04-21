package hh.healthhive.Controller;

import hh.healthhive.Model.Post;
import hh.healthhive.Model.Reply;
import hh.healthhive.Model.SymptomJournal;
import hh.healthhive.Model.Workout;
import hh.healthhive.Repository.PostRepository;
import hh.healthhive.Repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalTime;
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


    @PostMapping("/forum/{userId}")
    public String addPost(@Valid @RequestBody Post post, @PathVariable Long userId) {
        post.setPost_date(new Date());
        post.setTime(LocalTime.now());
        post.setUser(userId);
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
            reply.setUser_id(userId);
            post.setReply(reply);
            rr.save(reply);
            return ResponseEntity.ok("Reply Added to the post!");
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/forum/{postId}")
    @ResponseBody
    public List<Reply> getAllReplies() {
        return rr.findAll();
    }

}
