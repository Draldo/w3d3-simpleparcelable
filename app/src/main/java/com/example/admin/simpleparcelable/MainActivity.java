package com.example.admin.simpleparcelable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String NUMBER_KEY = "number";
    public static final String STUDENT_KEY_PARCEL = "student";
    private static final String TAG = "MainTAG_";
    private String jsonString = "[{\"name\":\"Juan\",\"age\":20,\"grade\":8.1},{\"name\":\"Miguel\",\"age\":23,\"grade\":8.3},{\"name\":\"Roberto\",\"age\":39,\"grade\":9.3},{\"name\":\"Luis\",\"age\":19,\"grade\":6.9},{\"name\":\"Gaudencio\",\"age\":25,\"grade\":4.3}]";
    private EditText mEditText;
    private ImageView mImageview;
    private ArrayList<Student> students;
    private ArrayList<String> array;
    private ListView mListview;
    private ArrayAdapter<String> adapter;
    private static final String[] img = new String[]{"http://goo.gl/Jy4clk","http://goo.gl/7Wa3Tv","http://goo.gl/AzrjpX","http://goo.gl/HlF9o7","https://goo.gl/BmIp1G"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gson gson = new GsonBuilder().create();
        Type listType = new TypeToken<List<Student>>() {}.getType();

        array = new ArrayList<String>();
        mListview = (ListView) findViewById(R.id.a_main_list);

        students = gson.fromJson(jsonString, listType);
        for(Student std: students){
            String text = std.name + " " + std.age + " " + std.grade;
            array.add(text);
        }
        Log.d(TAG, "onCreate: " + array);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array);
        mListview.setAdapter(adapter);

        mImageview = (ImageView) findViewById(R.id.imageview_item);

        mListview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String[] str = adapter.getItem(position).split(" ");
                Toast.makeText(view.getContext(), str[0], Toast.LENGTH_SHORT).show();
                if(mImageview!=null) {
                    Picasso
                            .with(view.getContext())
                            .load(img[position])
                            .fit()
                            .into(mImageview);
                }
            }
        });

    }

    public void doMagic(View view) {
        mEditText = (EditText) findViewById(R.id.a_main_et);
        int num = Integer.parseInt(mEditText.getText().toString());
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(NUMBER_KEY,num);
        intent.putExtra(STUDENT_KEY_PARCEL, students.get(num));
        startActivity(intent);
    }
}
