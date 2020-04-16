package com.example.texttospeech;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    EditText t1;
    private TextToSpeech Speech;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Speech=new TextToSpeech(this,this);
        t1=findViewById(R.id.text);
        btn=findViewById(R.id.btn1);

    }

    @Override
    public void onInit(int status) {
        if(status==TextToSpeech.SUCCESS){
            int result=Speech.setLanguage(Locale.US);
            if(result==TextToSpeech.LANG_MISSING_DATA || result==TextToSpeech.LANG_NOT_SUPPORTED){
                Log.e("TTS","Lang not Supported");
                btn.setVisibility(View.GONE);

            }else{
                btn.setVisibility(View.VISIBLE);
            }
        }
        else{
            Log.e("TTS","Failed initialztn");
        }
    }

    public  void ButtonClick(View view){
        String myText=t1.getText().toString();
        Speech.speak(myText,TextToSpeech.QUEUE_FLUSH,null);


    }
}
