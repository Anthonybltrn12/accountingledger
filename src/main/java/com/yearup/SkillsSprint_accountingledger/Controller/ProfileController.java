package com.yearup.SkillsSprint_accountingledger.Controller;

import com.yearup.SkillsSprint_accountingledger.Service.ProfileService;
import com.yearup.SkillsSprint_accountingledger.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
@CrossOrigin(origins = "*")
public class ProfileController {

    @Autowired
    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    // GET http://localhost:8080/profile/{id}
    @GetMapping("/{userId}")
    public ResponseEntity<Profile> getProfile(@PathVariable Integer userId) {
        Profile profile = profileService.getProfileById(userId);
        return ResponseEntity.ok(profile);
    }

    // POST http://localhost:8080/profile
    @PostMapping("")
    public ResponseEntity<Profile> createProfile(@RequestBody Profile profile) {
        Profile created = profileService.createProfile(profile);
       // return ResponseEntity.status(201).body(created);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // PUT http://localhost:8080/profile/{id}
    @PutMapping("/{userId}")
    public ResponseEntity<Profile> updateProfile(@PathVariable Integer userId,
                                                 @RequestBody Profile profile) {
        Profile updated = profileService.updateProfile(userId, profile);
        return ResponseEntity.ok(updated);
    }

    // DELETE http://localhost:8080/profile/{id}
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Integer userId) {
        profileService.deleteProfile(userId);
        return ResponseEntity.noContent().build();
    }
}
