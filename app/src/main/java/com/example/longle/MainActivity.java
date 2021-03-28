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
        if (savedInstanceState == null){
            Log.e(TAG, "Bug LongLe");
        }
        else {
            Log.e(TAG, "Welcom LongLe");
        }
        setContentView(R.layout.activity_main);
        button = new Button(this);
        //dong nay loi neu chua khoi tao
        button.setText("Ahihi Loi roi");
        //den day button van chua hien thi len layout
        //Test VCS > Commit
    }
}