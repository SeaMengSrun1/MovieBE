package com.example.movie.Service;

import com.example.movie.Model.Profile;
import com.example.movie.Repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {
    final ProfileRepo profileRepo;

    @Autowired
    public ProfileService(ProfileRepo profileRepo) {
        this.profileRepo = profileRepo;
    }

    public List<Profile> getProfiles() {
        return profileRepo.findAll();
    }

    public Profile getProfileById(Long id) {
        return profileRepo.findById(id).
                orElseThrow(()-> new IllegalArgumentException("Profile with id " + id + " not found"));
    }

    public void createProfile(Profile profile) {
        profileRepo.save(profile);
    }

    public void deleteProfile(Long id) {
        boolean exists = profileRepo.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Profile with id " + id + " does not exist");
        }
        profileRepo.deleteById(id);
    }
}
