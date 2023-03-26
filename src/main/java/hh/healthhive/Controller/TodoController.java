package hh.healthhive.Controller;

import hh.healthhive.Model.ToDo;
import hh.healthhive.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
}
