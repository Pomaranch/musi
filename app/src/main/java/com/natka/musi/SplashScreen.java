package com.natka.musi;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends Activity {

    ImageView vinyl;
    Animation anim = null;
    TextView app_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        vinyl = (ImageView)findViewById(R.id.vinyl);

        anim = AnimationUtils.loadAnimation(this, R.anim.rotate);

        app_name = (TextView)findViewById(R.id.app_name);
        app_name.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/androidnation.ttf"));

        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent intent = new Intent(SplashScreen.this,MainActivity.class);
                    startActivity(intent);
                   // overridePendingTransition(R.anim.a_alpha,R.anim.alpha);

                }
            }
        };
        timerThread.start();
        vinyl.startAnimation(anim);
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
        //overridePendingTransition(R.anim.a_alpha,R.anim.alpha);

    }

}