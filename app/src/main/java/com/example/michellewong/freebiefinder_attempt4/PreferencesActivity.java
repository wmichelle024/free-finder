package com.example.michellewong.freebiefinder_attempt4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.LinkedList;
import java.util.List;

public class PreferencesActivity extends AppCompatActivity {

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
        String name = getIntent().getStringExtra("Name");
        String email = getIntent().getStringExtra("Email");

        TextView tv = (TextView) findViewById(R.id.username_txt);

        tv.setText(name);
        user = new User(email);
        user.setEmail(email);
        user.setName(name);
    }

    public void onButtonClick(View v) {
        List<Attraction.Type> c = new LinkedList<Attraction.Type>();
        int check[] = {R.id.cbArt, R.id.cbBusiness, R.id.cbFood, R.id.cbTech, R.id.cbSports, R.id.cbGame, R.id.cbSocial, R.id.cbOther, R.id.cbHealth};
        if (v.getId() == R.id.Bcomplete){
            for (int i = 0; i < check.length; i++) {
                if(((CheckBox)findViewById(check[i])).isChecked()) {
                    switch(check[i]) {
                        case R.id.cbArt:
                            c.add(Attraction.Type.ARTS);
                            break;
                        case R.id.cbBusiness:
                            c.add(Attraction.Type.BUSINESS);
                            break;
                        case R.id.cbFood:
                            c.add(Attraction.Type.FOOD);
                            break;
                        case R.id.cbGame:
                            c.add(Attraction.Type.GAME);
                            break;
                        case R.id.cbSports:
                            c.add(Attraction.Type.SPORTS);
                            break;
                        case R.id.cbTech:
                            c.add(Attraction.Type.TECH);
                            break;
                        case R.id.cbHealth:
                            c.add(Attraction.Type.HEALTH);
                            break;
                        case R.id.cbOther:
                            c.add(Attraction.Type.OTHER);
                            break;
                        case R.id.cbSocial:
                            c.add(Attraction.Type.SOCIAL);
                            break;
                        default:
                            break;
                    }
                }
            }
            for (Attraction.Type i: c) {
                user.addCategory(i);
            }
            Gson gson = new Gson();
            String b = gson.toJson(user);

            String info = user.toString();
            Intent a = new Intent(PreferencesActivity.this,UserInfoActivity.class);
            a.putExtra("Info", info);
            startActivity(a);
        }
    }


}

