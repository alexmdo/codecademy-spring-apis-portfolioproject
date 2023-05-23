package br.com.alexmdo.codecademy.portfolioproject.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User createUser(User user) {
        // Check if the display name is unique
        var existingUser = userRepository.findByDisplayName(user.getDisplayName());
        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("Display name already exists.");
        }

        return userRepository.save(user);
    }

    @Transactional
    public User updateUser(User user) {
        var existingUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new IllegalArgumentException("User not found."));

        // Check if the display name is being modified
        if (!existingUser.getDisplayName().equals(user.getDisplayName())) {
            throw new IllegalArgumentException("Cannot modify display name.");
        }

        // Update other fields
        existingUser.setCity(user.getCity());
        existingUser.setState(user.getState());
        existingUser.setZipcode(user.getZipcode());
        existingUser.setPeanutAllergyInterest(user.isPeanutAllergyInterest());
        existingUser.setEggAllergyInterest(user.isEggAllergyInterest());
        existingUser.setDairyAllergyInterest(user.isDairyAllergyInterest());

        return userRepository.save(existingUser);
    }

    public User getUserByDisplayName(String displayName) {
        return userRepository.findByDisplayName(displayName)
                .orElseThrow(() -> new IllegalArgumentException("User not found."));
    }

    public boolean doesUserExist(String displayName) {
        return userRepository.findByDisplayName(displayName).isPresent();
    }

}
