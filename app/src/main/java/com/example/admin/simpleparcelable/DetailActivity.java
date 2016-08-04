package com.example.admin.simpleparcelable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private TextView mTextview;
    private TextView mStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mTextview = (TextView) findViewById(R.id.detai_textview);
        mStudent = (TextView) findViewById(R.id.detail_student);


        int number = getIntent().getIntExtra(MainActivity.NUMBER_KEY,-1);
        Student student = getIntent().getParcelableExtra(MainActivity.STUDENT_KEY_PARCEL);

        mTextview.setText(String.valueOf(number));
        mStudent.setText(student.toString());
    }
}
