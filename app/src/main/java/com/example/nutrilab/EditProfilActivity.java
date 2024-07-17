package com.example.nutrilab;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.Nullable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.nutrilab.model.EditProfileRequest;
import com.example.nutrilab.model.EditProfileResponse;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditProfilActivity extends AppCompatActivity {
    private Spinner spinnerBloodtypes, spinnerGender;
    private EditText editTextBirthDate, editAllergies, editWeight, editHeight;
    private Calendar calendar;
    private Button btnEdit;
    private void initUI() {
        spinnerBloodtypes = findViewById(R.id.bloodtypes);
        editTextBirthDate = findViewById(R.id.editText_birth_date);
        spinnerGender = findViewById(R.id.edit_gender);
        editAllergies = findViewById(R.id.edit_allergies);
        editWeight = findViewById(R.id.edit_weight);
        editHeight = findViewById(R.id.edit_height);
        btnEdit = findViewById(R.id.btn_edit);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofil);
        initUI();

        editTextBirthDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        ArrayAdapter<CharSequence> bloodtypesAdapter = ArrayAdapter.createFromResource(this,
                R.array.bloodtypes_array, android.R.layout.simple_spinner_item);
        bloodtypesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBloodtypes.setAdapter(bloodtypesAdapter);

        ArrayAdapter<CharSequence> genderAdapter = ArrayAdapter.createFromResource(this,
                R.array.gender_array, android.R.layout.simple_spinner_item);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGender.setAdapter(genderAdapter);

        // Temukan ImageView di layout
        ImageView profileImageView = findViewById(R.id.img_profile);

        // Gunakan Glide untuk memuat gambar dengan transformasi bulat
        Glide.with(this)
                .load(R.drawable.baseline_account_circle_24) // Ganti dengan URL atau sumber gambar yang sesuai
                .apply(RequestOptions.circleCropTransform())
                .into(profileImageView);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editProfile();
            }
        });

    }

    private void editProfile() {
        String userId = SharedPrefManager.getInstance(this).getUserId();
        String gender = spinnerGender.getSelectedItem().toString();
        String dateOfBirth = editTextBirthDate.getText().toString();
        String allergies = editAllergies.getText().toString();
        float weight = Float.parseFloat(editWeight.getText().toString());
        float height = Float.parseFloat(editHeight.getText().toString());

        EditProfileRequest editProfileRequest = new EditProfileRequest(gender, dateOfBirth, allergies, weight, height);
        ApiService apiService = RetrofitClient.getApiService();
        Call<EditProfileResponse> call = apiService.editProfile(userId, editProfileRequest);

        call.enqueue(new Callback<EditProfileResponse>() {
            @Override
            public void onResponse(Call<EditProfileResponse> call, Response<EditProfileResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    EditProfileResponse editProfileResponse = response.body();
                    if (editProfileResponse.getStatus() == 200) {
                        Toast.makeText(EditProfilActivity.this, "Profile updated successfully!", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(EditProfilActivity.this, MainActivity.class);
                        intent.putExtra("fragment", "UserFragment");
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(EditProfilActivity.this, editProfileResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    try {
                        String errorMessage = response.errorBody().string();
                        Toast.makeText(EditProfilActivity.this, "Profile update failed: " + errorMessage, Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(EditProfilActivity.this, "Profile update failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<EditProfileResponse> call, Throwable t) {
                Toast.makeText(EditProfilActivity.this, "An error occurred: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showDatePickerDialog() {
        calendar = Calendar.getInstance();

        // Inisialisasi batas tahun
        int minYear = calendar.get(Calendar.YEAR) - 60;
        int maxYear = calendar.get(Calendar.YEAR) - 7;

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                EditProfilActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, monthOfYear);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        updateLabel();
                    }
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );

        // Set batas minimal dan maksimal tanggal
        Calendar minDate = Calendar.getInstance();
        minDate.set(Calendar.YEAR, minYear);
        datePickerDialog.getDatePicker().setMinDate(minDate.getTimeInMillis());

        Calendar maxDate = Calendar.getInstance();
        maxDate.set(Calendar.YEAR, maxYear);
        datePickerDialog.getDatePicker().setMaxDate(maxDate.getTimeInMillis());

        datePickerDialog.show();
    }

    private void updateLabel() {
        // Format tanggal sesuai dengan bahasa pada handphone
        String myFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.getDefault());
        editTextBirthDate.setText(sdf.format(calendar.getTime()));
    }

}
