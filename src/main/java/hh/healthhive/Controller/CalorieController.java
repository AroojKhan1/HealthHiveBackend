package hh.healthhive.Controller;

import hh.healthhive.Model.Calorie;
import hh.healthhive.Model.ToDo;
import hh.healthhive.Repository.CalorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CalorieController {
    @Autowired
    CalorieRepository cr;

    @PostMapping("/calorie")
    public String addMeal(@Valid @RequestBody Calorie calorie){
        calorie.setMeal_date(new Date());
        cr.save(calorie);
        return "meal recorded";
    }

    @GetMapping("/calorie")
    @ResponseBody
    public List<Calorie> getCalorieOnDay(@RequestParam("date")String date){
        System.out.println("date: "+date);
        List<Calorie> calories = cr.findByMeal_date(date);
        return calories;
    }


}
