package com.example.administrator.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Button bt1=(Button)findViewById(R.id.bt1);
        //bt1.setOnClickListener(new View.OnClickListener() {
        //    @Override
        ///  public void onClick(View view) {
        //      Intent intent=new Intent(MainActivity.this,fragmentFragment.class);
        //     startActivity(intent);
        //   }
        //  }

        //);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
          //  private  int abcd=0;
            @Override
            public void run() {

                startLoginActivity();

            }
        },3000);
    }
    void startLoginActivity()
    {
        Intent itnt=new Intent(this,Login_Activity.class);
        startActivity(itnt);
        finish();
    }
}
