package hh.healthhive.Controller;
import hh.healthhive.Model.User;
import hh.healthhive.Repository.TodoRepository;
import hh.healthhive.Model.ToDo;
import hh.healthhive.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class TodoController {

    @Autowired
    TodoRepository todoRepository;

    @Autowired
    UserRepository ur;

    @PostMapping("/addTodo")
    public String addTodo(@Valid @RequestBody ToDo todo) {
        System.out.println("todo:"+todo);
        todoRepository.save(todo);
        return "Added, Reload to view!";
    }




    @GetMapping("/yourTodos/{id}")
    @ResponseBody
    public List<ToDo> getTodo(@PathVariable Long id) {
        System.out.println("id"+id);
        List<ToDo> todos = todoRepository.findByUserId(id);
        return todos;
    }



//backend working fine & dndy chk front end for this...
    @PutMapping("/yourTodos/{itemId}")
    public ResponseEntity<ToDo> updateTodoStatus(@PathVariable("itemId") Long itemId, @RequestBody ToDo todo) {
        Optional<ToDo> optionalTodo = todoRepository.findById(itemId);
        if (!optionalTodo.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        ToDo existingTodo = optionalTodo.get();
        existingTodo.setCompleted(todo.isCompleted());
        todoRepository.save(existingTodo);
        return ResponseEntity.ok(existingTodo);
    }
}
