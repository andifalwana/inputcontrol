package com.example.inputcontrol;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import java.util.Calendar;
public class input_page extends AppCompatActivity implements View.OnClickListener {
    Button btn_date;
    EditText text_date;
    private int mYear, mMonth, mDay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_input_page);

        btn_date = findViewById(R.id.btn_date);
        text_date = findViewById(R.id.text_date);

        btn_date.setOnClickListener(this);
    }
    @Override
    public  void  onClick(View v) {
        if (v == btn_date) {
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    text_date.setText(dayOfMonth + "-" + (month + 1) + "-" + year);
                }
            }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
    }
}