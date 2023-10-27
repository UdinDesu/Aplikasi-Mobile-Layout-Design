package com.example.acara_12;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class RelativeLayout extends AppCompatActivity {

    DatePickerDialog picker;
    EditText eText;
    Button btnGet, btnClear;
    TextView tvw;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed(); // Memanggil fungsi kembali saat tombol panah kembali ditekan
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout);
        getSupportActionBar().setTitle("Relative Layout");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        tvw = (TextView)findViewById(R.id.textview1);
        eText = (EditText)findViewById(R.id.editText1);
        eText.setInputType(InputType.TYPE_NULL);
        btnClear = findViewById(R.id.clear);

        eText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int Year = cldr.get(Calendar.YEAR);

                //date picker dialog
                picker = new DatePickerDialog(RelativeLayout.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int monthofYear, int dayofMonth) {
                                eText.setText(dayofMonth + "/" + (monthofYear+1) + "/" + year);
                            }
                        }, Year, month, day);
                picker.show();
            }
        });
        btnGet=(Button)findViewById(R.id.button1);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvw.setText("Selected Date : "+eText.getText());
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eText.setText(null);
                tvw.setText(null);
            }
        });

    }
}