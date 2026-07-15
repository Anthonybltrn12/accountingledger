package com.yearup.SkillsSprint_accountingledger.Service;

import com.yearup.SkillsSprint_accountingledger.Repository.ProfileRepository;
import com.yearup.SkillsSprint_accountingledger.model.Profile;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService
{
    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository)
    {
        this.profileRepository = profileRepository;
    }

    public Optional<Profile> getByUserId(int userId) { return profileRepository.findById(userId);
    }

    public Profile getProfileById(Long id) {
        return profileRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("Profile not found with id: " + id));
    }

    public Profile createProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    public Profile updateProfile(int userId, Profile profile) {
        Profile existing = profileRepository.findById(userId).orElseThrow();
        existing.setFirstName(profile.getFirstName());
        existing.setLastName(profile.getLastName());
        existing.setPhone(profile.getPhone());
        existing.setEmail(profile.getEmail());
        existing.setAddress(profile.getAddress());
        existing.setCity(profile.getCity());
        existing.setState(profile.getState());
        existing.setZip(profile.getZip());
        return profileRepository.save(existing);
    }

    public void deleteProfile(int userId) {
        if (profileRepository.existsById(userId)) {
            profileRepository.deleteById(userId);
        } else {
            System.out.println("Profile not deleted.");
        }
    }
}

