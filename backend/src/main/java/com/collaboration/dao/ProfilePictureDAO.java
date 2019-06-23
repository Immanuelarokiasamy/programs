package com.collaboration.dao;

import com.collaboration.model.ProfilePicture;

public interface ProfilePictureDAO {
public boolean save(ProfilePicture profilePicture);
public ProfilePicture getProfilePicture(String username);
}
