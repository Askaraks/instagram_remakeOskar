package com.asashka.instagrama.add;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.asashka.instagrama.R;
import com.asashka.instagrama.model.Post;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;


public class AddFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false);
    }

    Uri profileUri;
    Uri imageUri;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        ImageView profile = view.findViewById(R.id.profile);
        ImageView image = view.findViewById(R.id.add_image);
        EditText name = view.findViewById(R.id.fill_name);
        ImageView add = view.findViewById(R.id.add_btn);

        ActivityResultLauncher<Intent> profilePick =
                registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result ->{
                   profileUri = result.getData().getData();
                    Glide.with(this).load(profileUri).transform(new CenterCrop(),
                            new RoundedCorners(100)).into(profile);



                });
        ActivityResultLauncher<Intent> imagePick =
                registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result ->{
                   imageUri = result.getData().getData();
                    Glide.with(this).load(imageUri).into(image);
                });


        profile.setOnClickListener(view1 ->{
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            profilePick.launch(intent);


        });
        image.setOnClickListener(view2 ->{
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            imagePick.launch(intent);

        } );
        name.setOnClickListener(view3 ->{

        } );
        add.setOnClickListener(view4 ->{
            Post post = new Post(profileUri,name.getText().toString(), imageUri);

        } );

    }
}