package com.example.movie.Controller;

import com.example.movie.Model.Profile;
import com.example.movie.Service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/profile")
public class ProfileController {

    final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping
    public List<Profile> getProfiles(){
        return profileService.getProfiles();
    }

    @GetMapping(path = "/{id}")
    public Profile getProfileById(@PathVariable("id") Long id){
        return profileService.getProfileById(id);
    }

    @PostMapping
    public void createProfile(@RequestBody Profile profile){
        profileService.createProfile(profile);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteProfile(@PathVariable("id") Long id){
        profileService.deleteProfile(id);
    }
}
