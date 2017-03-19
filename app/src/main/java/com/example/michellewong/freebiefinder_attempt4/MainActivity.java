package com.example.michellewong.freebiefinder_attempt4;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener {

    private GoogleApiClient googleApiClient;
    private SignInButton SignIn;
    private Button SignOut;
    private static final int REQ_CODE = 9001;
    String Name = "";
    String Email = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SignIn = (SignInButton) findViewById(R.id.signInButton);
        SignOut = (Button)findViewById(R.id.signOut);
        SignIn.setOnClickListener(this);
        SignOut.setOnClickListener(this);
        GoogleSignInOptions signInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this,this).addApi(Auth.GOOGLE_SIGN_IN_API,signInOptions).build();

        if (Name != "") {
            SignIn.setVisibility(View.GONE);
        }
        else SignOut.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.signInButton) {
            signIn();
        }
        if (v.getId() == R.id.signOut) {
            signOut();
        }

    }

    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    private void signIn() {
        Intent i = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        startActivityForResult(i, REQ_CODE);

    }

    private void signOut() {
        Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull Status status) {
                choosePref(false);
                TextView tv = (TextView)findViewById(R.id.account_name);
                tv.setText("");
            }
        });

    }

    private void handleResult(GoogleSignInResult result) {
        if (result.isSuccess()) {
            GoogleSignInAccount account = result.getSignInAccount();
            Name = account.getDisplayName();
            Email = account.getEmail();
            choosePref(true);

        }
        else choosePref(false);

    }

    private void choosePref(boolean isLogin) {
        TextView tv = (TextView)findViewById(R.id.account_name);
        if (isLogin) {
            tv.setText(Name);
            SignIn.setVisibility(View.GONE);
            SignOut.setVisibility(View.VISIBLE);
            Intent i = new Intent(MainActivity.this, PreferencesActivity.class);
            i.putExtra("Name", Name);
            i.putExtra("Email", Email);
            startActivity(i);
        }
        else {
            SignIn.setVisibility(View.VISIBLE);
            SignOut.setVisibility(View.GONE);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == REQ_CODE) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleResult(result);
        }
    }


}
