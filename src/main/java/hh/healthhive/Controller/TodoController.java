package hh.healthhive.Controller;
import hh.healthhive.Repository.TodoRepository;
import hh.healthhive.Model.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class TodoController {

    @Autowired
    TodoRepository todoRepository;

    @PostMapping("/addTodo")
    public String addTodo(@Valid @RequestBody ToDo todo) {
        todoRepository.save(todo);
        return "saved!";
    }
    @ResponseBody
    @GetMapping("/yourTodos")
    public List<ToDo> getTodos() {
        return todoRepository.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToDo> updateTodoStatus(@PathVariable("id") Long id, @RequestBody ToDo todo) {
        Optional<ToDo> optionalTodo = todoRepository.findById(id);
        if (!optionalTodo.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        ToDo existingTodo = optionalTodo.get();
        existingTodo.setCompleted(todo.isCompleted());
        todoRepository.save(existingTodo);
        return ResponseEntity.ok(existingTodo);
    }
}
