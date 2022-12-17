package com.asashka.instagrama;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.asashka.instagrama.model.Post;

public class GalleryFragment extends Fragment {

    ImageView imageView;
    ImageView imageView1;
    Button button;
    EditText editText;
    Uri image;
    Uri image1;

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);


        imageView = view.findViewById(R.id.profile);
        imageView1 = view.findViewById(R.id.add_image);
        button = view.findViewById(R.id.add_btn);
        editText = view.findViewById(R.id.fill_name);


        imageView.setOnClickListener(view1 -> {
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivityForResult(intent, 2);
        });
        imageView1.setOnClickListener(view1 -> {
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivityForResult(intent, 1);
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Post post = new Post(image, editText.getText().toString(), image1);
                System.out.println(post);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            if (requestCode == 2) {
                image = data.getData();
                imageView.setImageURI(image);
            }
            if (requestCode == 1) {
                image1 = data.getData();
                imageView1.setImageURI(image1);
            }

        }
    }

}