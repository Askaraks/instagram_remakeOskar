package com.asashka.instagrama.model;

import android.net.Uri;

public class Post {

    private Uri profile;
    private String name;
    private Uri image;

    public Post(Uri profileUri, String name, Uri imageUri) {
        this.profile = profileUri;
        this.name = name;
        this.image = imageUri;
    }

    public Uri getProfile() {
        return profile;
    }

    public String getName() {
        return name;
    }

    public Uri getImage() {
        return image;
    }
}