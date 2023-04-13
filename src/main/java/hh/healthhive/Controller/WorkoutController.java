package hh.healthhive.Controller;

import hh.healthhive.Model.Calorie;
import hh.healthhive.Model.Workout;
import hh.healthhive.Repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WorkoutController {

    @Autowired
    WorkoutRepository wo_r;

    @PostMapping("/workout")
    public String addWorkout(@Valid @RequestBody Workout workout) {
        workout.setW_date(new Date());
        wo_r.save(workout);
        return "Workout Recorded!";
    }

    @GetMapping("/getAllworkouts/{id}")
    @ResponseBody
    public List<Workout> getWorkouts(@PathVariable Long id){
        System.out.println("id"+id);
        List<Workout> workouts = wo_r.findByUserId(id);
        return workouts;
    }

    @GetMapping("/workout/{id}")
    @ResponseBody
    public List<Workout> getWorkoutByDate(@RequestParam("date")String date, @PathVariable Long id){
        System.out.println("date: "+date);
        List<Workout> workout = wo_r.findByW_date_AndUserId(date,id);
        return workout;
    }

}

