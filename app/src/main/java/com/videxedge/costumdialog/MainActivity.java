package com.videxedge.costumdialog;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    AlertDialog.Builder adb;
    LinearLayout linlay;

    final String[] colors={"Red","Green","Blue"};
    int[] color=new int[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linlay = (LinearLayout) findViewById(R.id.linlay);

    }

    public void btn1(View view) {

        color = new int[]{0, 0, 0};

        adb = new AlertDialog.Builder(this);
        adb.setCancelable(false);
        adb.setTitle("List of colors - one choice");
        adb.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                color[which]=255;
                linlay.setBackgroundColor(Color.rgb(color[0],color[1],color[2]));
            }
        });
        adb.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        adb.setNegativeButton("Reset", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                linlay.setBackgroundColor(Color.WHITE);
            }
        });

        AlertDialog ad = adb.create();
        ad.show();
    }

    public void btn2(View view) {

        color = new int[]{0, 0, 0};

        adb = new AlertDialog.Builder(this);
        adb.setCancelable(false);
        adb.setTitle("List of colors - multi choice");
        adb.setMultiChoiceItems(colors, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked) color[which]=255;
                else if (color[which]==255) color[which]=0;
                linlay.setBackgroundColor(Color.rgb(color[0],color[1],color[2]));

            }
        });
        adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        adb.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        adb.setNegativeButton("Reset", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                linlay.setBackgroundColor(Color.WHITE);
            }
        });

        AlertDialog ad=adb.create();
        ad.show();
    }

    public void btn3(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setCancelable(false);
        adb.setTitle("TextView Widget");
        final TextView tV=new TextView(this);
        adb.setView(tV);
        tV.setText("Just a message...");
        adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog ad=adb.create();
        ad.show();
    }

    public void btn4(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setCancelable(false);
        adb.setTitle("EditText Widget");
        final EditText eT=new EditText(this);
        eT.setHint("Type text here");
        adb.setView(eT);
        adb.setPositiveButton("Copy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = eT.getText().toString();
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
            }
        });
        adb.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog ad=adb.create();
        ad.show();
    }
}
