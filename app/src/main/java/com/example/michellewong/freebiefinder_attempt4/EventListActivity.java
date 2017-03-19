package com.example.michellewong.freebiefinder_attempt4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class EventListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        String e = getIntent().getStringExtra("Email");
        User user = UserManager.getOurInstance().getUser(e);
        List<Attraction.Type> pref = user.getCategories();
        String str = "";
        for (Attraction.Type p : pref) {
            switch (p) {
                case ARTS:
                    str = str + "Arts ";
                    break;
                case BUSINESS:
                    str = str + "Business ";
                    break;
                case FOOD:
                    str = str + "Food ";
                    break;
                case HEALTH:
                    str = str + "Health ";
                    break;
                case TECH:
                    str = str + "Tech ";
                    break;
                case OTHER:
                    str = str + "Other ";
                    break;
                case SPORTS:
                    str = str + "Sports ";
                    break;
                case SOCIAL:
                    str = str + "Social ";
                    break;
                case GAME:
                    str = str + "Game ";
                    break;
                default:
                    System.out.println("Invalid Type");
                    break;
            }
            str = str + " ";
        }
        TextView tv = (TextView)findViewById(R.id.pref_list);
        tv.setText(str);
    }
}
