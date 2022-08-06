package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
@RestController
public class AgeController {

    @GetMapping("/level1/{time}")
    public ResponseEntity<String> level1(@PathVariable("time") Integer unixtimeAge) {
        try {
            validateInput(unixtimeAge);
            // Convert seconds to miliseconds
            Date date = new Date(unixtimeAge * 1000L);
            // format of the date
            SimpleDateFormat jdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
            return ResponseEntity.ok(jdf.format(date));

        } catch (RuntimeException re) {
            return ResponseEntity.badRequest().body(re.getMessage());
        }
    }

    private boolean validateInput(Integer unixtime) {
        if (unixtime == 0) {
            throw new RuntimeException("Input time invalid : zero");
        }
        if (unixtime < 0) {
            throw new RuntimeException("Input time invalid : Negative");
        }
        return true;
    }

    @PatchMapping("/level2")
    public ResponseEntity<String> level2(@RequestParam("time") Integer unixTimeAge) {
        try {
            this.validateInput(unixTimeAge);
            long now = Instant.now().getEpochSecond();
            var different = now - unixTimeAge;
            var year = different / 31556926;
            var day = different / 86400;
            return ResponseEntity.ok("year : " + year + " day : " + day);
        } catch (RuntimeException re) {
            return ResponseEntity.badRequest().body(re.getMessage());
        }
    }
    // Path Variable
    @GetMapping("/level3/{time}")
    public ResponseEntity<String> level3(@PathVariable("time") Integer unixTimeAge){
        try {
            this.validateInput(unixTimeAge);
            long now = Instant.now().getEpochSecond();
            var different = now - unixTimeAge;
            var year = different / 31556926;
            var day = different / 86400;
            return ResponseEntity.ok("year : " + year + " day : " + day);
        } catch (RuntimeException re) {
            return ResponseEntity.badRequest().body(re.getMessage());
        }
    }
    //QueryString
    @PatchMapping("/level3")
    public ResponseEntity<String> level3_1(@RequestParam("time") Integer unixTimeAge){
        try {
            this.validateInput(unixTimeAge);
            long now = Instant.now().getEpochSecond();
            var different = now - unixTimeAge;
            var year = different / 31556926;
            var day = different / 86400;
            return ResponseEntity.ok("year : " + year + " day : " + day);
        } catch (RuntimeException re) {
            return ResponseEntity.badRequest().body(re.getMessage());
        }
    }
    // Body
    @PostMapping("/level3")
    public ResponseEntity<String> level3_2(@RequestBody Integer unixTimeAge){
        try {
            this.validateInput(unixTimeAge);
            long now = Instant.now().getEpochSecond();
            var different = now - unixTimeAge;
            var year = different / 31556926;
            var day = different / 86400;
            return ResponseEntity.ok("year : " + year + " day : " + day);
        } catch (RuntimeException re) {
            return ResponseEntity.badRequest().body(re.getMessage());
        }
    }
}
