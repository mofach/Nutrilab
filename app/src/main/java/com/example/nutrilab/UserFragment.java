package com.example.nutrilab;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.nutrilab.model.ProfileResponse;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserFragment extends Fragment {
    private FloatingActionButton fabEdit;
    private TextView txtUserFullname, txtUsername, txtUserEmail, txtUserGender, txtUserDOB, txtUserAllergies, txtUserHeight, txtUserWeight;

    private void initUI(View view) {
        txtUserFullname = view.findViewById(R.id.user_fullname);
        txtUsername = view.findViewById(R.id.user_username);
        txtUserEmail = view.findViewById(R.id.user_email);
        txtUserGender = view.findViewById(R.id.user_gender);
        txtUserDOB = view.findViewById(R.id.user_dob);
        txtUserAllergies = view.findViewById(R.id.user_allergies);
        txtUserHeight = view.findViewById(R.id.user_height);
        txtUserWeight = view.findViewById(R.id.user_weight);
        fabEdit = view.findViewById(R.id.fab_edit);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);

        initUI(view);

        getUserProfile();

        fabEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EditProfilActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    private void getUserProfile() {
        String userId = SharedPrefManager.getInstance(getActivity()).getUserId();
        ApiService apiService = RetrofitClient.getApiService();
        Call<ProfileResponse> call = apiService.getProfileUser(userId);

        call.enqueue(new Callback<ProfileResponse>() {
            @Override
            public void onResponse(Call<ProfileResponse> call, Response<ProfileResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ProfileResponse.ProfileData profileData = response.body().getData();
                    txtUserFullname.setText(profileData.getUser().getName());
                    txtUsername.setText(profileData.getUser().getName());
                    txtUserEmail.setText(profileData.getUser().getEmail());
                    txtUserGender.setText(profileData.getGender());
                    txtUserDOB.setText(profileData.getDateOfBirth());
                    txtUserAllergies.setText(profileData.getAllergies());
                    txtUserWeight.setText(String.valueOf(profileData.getWeight()));
                    txtUserHeight.setText(String.valueOf(profileData.getHeight()));
                } else {
                    Toast.makeText(getActivity(), "Failed with status code: " + response.code() + " and message: " + response.message(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ProfileResponse> call, Throwable t) {
                Log.e("UserFragment", "onFailure: " + t.getMessage());
                Toast.makeText(getActivity(), "Request failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
