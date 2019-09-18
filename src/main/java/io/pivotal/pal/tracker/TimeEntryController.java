package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

    /*@Autowired
   private TimeEntryRepository repo;*/

    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntry){
        TimeEntry entry = timeEntryRepository.create(timeEntry);
        return new ResponseEntity<>(entry, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<TimeEntry>> list(){
        return new ResponseEntity<>(timeEntryRepository.list(), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable Long id) {
       TimeEntry entry =  timeEntryRepository.find(id);
       if(entry!=null){
           return new ResponseEntity<>(entry,HttpStatus.OK);
       }else{
           return new ResponseEntity<>(entry,HttpStatus.NOT_FOUND);
       }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<TimeEntry> delete(@PathVariable Long id){
        timeEntryRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("{id}")
    public ResponseEntity<TimeEntry> update(@PathVariable Long id,@RequestBody TimeEntry timeEntry){
        TimeEntry updatedTimeEntry = timeEntryRepository.update(id,timeEntry);
        if(updatedTimeEntry !=null){
            return new ResponseEntity<>(updatedTimeEntry,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(updatedTimeEntry,HttpStatus.NOT_FOUND);
        }
    }

}
