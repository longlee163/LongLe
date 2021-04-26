package com.example.longle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import java.net.FileNameMap;

public class MainActivity extends AppCompatActivity {
// Cmt liunh tinh thoi
    public static final String TAG = MainActivity.class.getSimpleName();
    //Loi null pointer exception (xem trong Logcat)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            if (savedInstanceState == null) {
                //Sử dụng LogCat
                Log.e(TAG, "Bug LongLe");
            } else {
                Log.e(TAG, "Welcom LongLe");
            }

        setContentView(R.layout.activity_main);
        button = new Button(this);
        button.setText("Long Thị Lệ");

        //den day button van chua hien thi len layout
        //Test VCS > Commit
    }
}