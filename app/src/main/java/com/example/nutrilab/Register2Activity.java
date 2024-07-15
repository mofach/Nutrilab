package com.example.nutrilab;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.app.DatePickerDialog;
import android.widget.DatePicker;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Register2Activity extends AppCompatActivity {
    private Spinner spinnerBloodtypes, spinnerGender;
    private EditText editTextBirthDate;
    private Calendar calendar;

    private void initUI() {
        spinnerBloodtypes = findViewById(R.id.bloodtypes);
        editTextBirthDate = findViewById(R.id.editText_birth_date);
        spinnerGender = findViewById(R.id.gender);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        initUI();

        // Inisialisasi DatePickerDialog saat editBirthdate diklik
        editTextBirthDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        // Bloodtypes
        ArrayAdapter<CharSequence> bloodtypesAdapter = ArrayAdapter.createFromResource(this,
                R.array.bloodtypes_array, android.R.layout.simple_spinner_item);
        bloodtypesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBloodtypes.setAdapter(bloodtypesAdapter);

        // Gender
        ArrayAdapter<CharSequence> genderAdapter = ArrayAdapter.createFromResource(this,
                R.array.gender_array, android.R.layout.simple_spinner_item);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGender.setAdapter(genderAdapter);
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
        String myFormat = "d MMMM yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.getDefault());
        editTextBirthDate.setText(sdf.format(calendar.getTime()));
    }
}
