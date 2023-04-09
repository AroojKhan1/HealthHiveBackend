package hh.healthhive.Controller;

import hh.healthhive.Model.WaterIntake;
import hh.healthhive.Repository.WaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WaterController {
    @Autowired
    WaterRepository wr;

    @PostMapping("/water")
    public String addWater(@Valid @RequestBody WaterIntake waterIntake){
        waterIntake.setWater_date(new Date());
        waterIntake.setWater_time(LocalTime.now());
        wr.save(waterIntake);
        return "Good job Keep on drinking";
    }

    @GetMapping("/water")
    @ResponseBody
    public List<WaterIntake> getWaterData(){
        List<WaterIntake> waterHist = wr.findAll();
        return waterHist;

    }

}
