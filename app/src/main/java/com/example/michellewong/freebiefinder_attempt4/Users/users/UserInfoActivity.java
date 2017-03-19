package com.example.michellewong.freebiefinder_attempt4.Users.users;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.michellewong.freebiefinder_attempt4.R;

import org.w3c.dom.Text;

public class UserInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        String s = getIntent().getStringExtra("Info");
        TextView tv = (TextView)findViewById(R.id.user_info);
        tv.setText(s);


    }
}