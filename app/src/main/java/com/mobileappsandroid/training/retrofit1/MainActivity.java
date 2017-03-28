package com.mobileappsandroid.training.retrofit1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView tV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tV = (TextView) findViewById(R.id.textView);

        RContr rC = new RContr();
        rC.start(3);
        rC.setA(this);
    }

    public void write2TV(String s)
    {
        tV.setText(s);
    }

}
