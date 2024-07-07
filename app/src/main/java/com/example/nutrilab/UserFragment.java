package com.example.nutrilab;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class UserFragment extends Fragment {
    private FloatingActionButton fabEdit;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);

        // Inisialisasi floating action button
        fabEdit = view.findViewById(R.id.fab_edit);

        // Set onClickListener untuk fabEdit
        fabEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aksi yang dilakukan saat fabEdit diklik
                Intent intent = new Intent(getActivity(), EditProfilActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
