package com.yearup.SkillsSprint_accountingledger.Controller;

import com.yearup.SkillsSprint_accountingledger.Service.ProfileService;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
@CrossOrigin(origins = "*")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    // GET http://localhost:8080/profile/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfile(@PathVariable Long id) {
        Profile profile = profileService.getProfileById(id);
        return ResponseEntity.ok(profile);
    }

    // POST http://localhost:8080/profile
    @PostMapping("")
    public ResponseEntity<Profile> createProfile(@RequestBody Profile profile) {
        Profile created = profileService.createProfile(profile);
        return ResponseEntity.status(201).body(created);
    }

    // PUT http://localhost:8080/profile/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable Long id,
                                                 @RequestBody Profile profile) {
        Profile updated = profileService.updateProfile(id, profile);
        return ResponseEntity.ok(updated);
    }

    // DELETE http://localhost:8080/profile/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Long id) {
        profileService.deleteProfile(id);
        return ResponseEntity.noContent().build();
    }
}
