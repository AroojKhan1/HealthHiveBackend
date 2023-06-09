package hh.healthhive.Controller;
import hh.healthhive.Model.Calorie;
import hh.healthhive.Repository.CalorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
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
        return "Meal recorded!";
    }

    @GetMapping("/getAllcalorie/{id}")
    @ResponseBody
    public List<Calorie> getCalorie(@PathVariable Long id){

        List<Calorie> calories = cr.findByUserId(id);
        return calories;
    }

    @GetMapping("/calorie/{id}")
    @ResponseBody
    public List<Calorie> getCalorieOnDay(@RequestParam("date")String date,@PathVariable Long id){
        System.out.println("date: "+date);

        List<Calorie> calories = cr.findByMeal_date_AndUserId(date,id);
        return calories;
    }


}
