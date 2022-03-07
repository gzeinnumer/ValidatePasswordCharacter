package com.gzeinnumer.validatepasswordcharacter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "sdfasfagfasfasf";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: "+isValidPassword("123456"));         //false
        Log.d(TAG, "onCreate: "+isValidPassword("abcdef"));         //false
        Log.d(TAG, "onCreate: "+isValidPassword("abcdef123456"));   //false
        Log.d(TAG, "onCreate: "+isValidPassword("Abcdef123456"));   //true
        Log.d(TAG, "onCreate: "+isValidPassword("123456Abcdef"));   //true
    }

    public boolean isValidPassword(final String password) {
        Pattern pattern;
        Matcher matcher;
//        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();
    }
}