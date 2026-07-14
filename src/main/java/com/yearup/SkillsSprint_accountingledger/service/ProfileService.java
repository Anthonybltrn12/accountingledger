package com.yearup.SkillsSprint_accountingledger.Service;

import com.yearup.SkillsSprint_accountingledger.Repository.ProfileRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
public class ProfileService
{
    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository)
    {
        this.profileRepository = profileRepository;
    }

    public Profile getByUserId(int id) { return profileRepository.findById(id).orElseThrow();
    }

    public Profile getProfileById(Long id) {
        return profileRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("Profile not found with id: " + id));
    }

    public Profile createProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    public Profile updateProfile(Long id, Profile profile) {

        return profile;
    }

    public void deleteProfile(Long id) {
    }
}

