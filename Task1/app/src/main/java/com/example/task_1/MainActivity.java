package com.example.task_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextToSpeech t1;
    EditText e1,e2;
    Button b1;
    String s1,s2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.emailTextLogin);
        e2=findViewById(R.id.passwordTextLogin);
        b1=findViewById(R.id.submitLoginButton);

        t1= new TextToSpeech(getApplicationContext(),new TextToSpeech.OnInitListener(){
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                }
            }
        }
        );

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                if(s1.contentEquals("Test1") && s2.contentEquals("Test@1")){
                    Toast.makeText(MainActivity.this, "Login", Toast.LENGTH_SHORT).show();
                    t1.speak("Login Successfully",TextToSpeech.QUEUE_FLUSH,null);
                }else {
                    Toast.makeText(MainActivity.this, "Not login", Toast.LENGTH_SHORT).show();
                    t1.speak("Email or Password is Wrong",TextToSpeech.QUEUE_FLUSH,null);
                }
                }
            });

    }

}