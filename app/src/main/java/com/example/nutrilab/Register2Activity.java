package com.example.nutrilab;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.app.DatePickerDialog;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.nutrilab.model.CreateProfileRequest;
import com.example.nutrilab.model.CreateProfileResponse;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register2Activity extends AppCompatActivity {
    private Spinner spinnerBloodtypes, spinnerGender;
    private EditText editTextBirthDate, regAllergies, regWeight, regHeight;
    private Button btnRegis2;
    private Calendar calendar;

    private void initUI() {
        spinnerBloodtypes = findViewById(R.id.bloodtypes);
        editTextBirthDate = findViewById(R.id.editText_birth_date);
        spinnerGender = findViewById(R.id.gender);
        regAllergies = findViewById(R.id.reg_allergies);
        regWeight = findViewById(R.id.reg_weight);
        regHeight = findViewById(R.id.reg_height);
        btnRegis2 = findViewById(R.id.btn_regis2);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
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

        btnRegis2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userId = SharedPrefManager.getInstance(Register2Activity.this).getUserId();
                String gender = spinnerGender.getSelectedItem().toString();
                String dateOfBirth = editTextBirthDate.getText().toString();
                String allergies = regAllergies.getText().toString();
                float weight = Float.parseFloat(regWeight.getText().toString());
                float height = Float.parseFloat(regHeight.getText().toString());

                createProfile(userId, gender, dateOfBirth, allergies, weight, height);
            }
        });
    }

    private void createProfile(String userId, String gender, String dateOfBirth, String allergies, float weight, float height) {
        ApiService apiService = RetrofitClient.getApiService();
        CreateProfileRequest createProfileRequest = new CreateProfileRequest(userId, gender, dateOfBirth, allergies, weight, height);

        Call<CreateProfileResponse> call = apiService.createProfile(createProfileRequest);
        call.enqueue(new Callback<CreateProfileResponse>() {
            @Override
            public void onResponse(Call<CreateProfileResponse> call, Response<CreateProfileResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    CreateProfileResponse createProfileResponse = response.body();
                    if (createProfileResponse.getStatus() == 200) {
                        Toast.makeText(Register2Activity.this, "Profile created successful!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Register2Activity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(Register2Activity.this, createProfileResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    try {
                        String errorMessage = response.errorBody().string();
                        Toast.makeText(Register2Activity.this, "Login failed: " + errorMessage, Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(Register2Activity.this, "Login failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<CreateProfileResponse> call, Throwable t) {
                Toast.makeText(Register2Activity.this, "An error occurred: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showDatePickerDialog() {
        calendar = Calendar.getInstance();

        // Inisialisasi batas tahun
        int minYear = calendar.get(Calendar.YEAR) - 60;
        int maxYear = calendar.get(Calendar.YEAR) - 7;

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                Register2Activity.this,
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
