package com.asashka.instagrama.model;

import android.net.Uri;

public class Post {

    private Uri profile;
    private String name;
    private Uri image;

    public Post(String name) {
        this.profile = profile;
        this.name = name;
        this.image = image;
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