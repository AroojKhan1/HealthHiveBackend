package hh.healthhive.Controller;

import hh.healthhive.Model.SymptomJournal;
import hh.healthhive.Model.ToDo;
import hh.healthhive.Repository.SymptomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class SymptomController {
    @Autowired
    SymptomsRepository sa;

    @PostMapping("/addSymptom")
    public String addSymptom(@Valid @RequestBody SymptomJournal symptomJournal) {
        symptomJournal.setSymptom_date(new Date());
        symptomJournal.setTime(LocalTime.now());
        sa.save(symptomJournal);
        return "Added! Reload to view.";
    }

    @GetMapping("/symptoms/{id}")
    @ResponseBody
    public List<SymptomJournal> getSymp(@PathVariable Long id) {
        System.out.println("id"+id);
        List<SymptomJournal> symps = sa.findByUserId(id);
        return symps;
    }


}
