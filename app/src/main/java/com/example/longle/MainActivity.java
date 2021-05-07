package com.example.longle;
//
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {
// Cmt liunh tinh thoi
//    public static final String TAG = MainActivity.class.getSimpleName();
    //Loi null pointer exception (xem trong Logcat)
//    Button button;
    ListView l1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//            if (savedInstanceState == null) {
//                //Sử dụng LogCat
//                Log.e(TAG, "Bug LongLe");
//            } else {
//                Log.e(TAG, "Welcom LongLe");
//            }
//
        setContentView(R.layout.activity_main);
//        button = new Button(this);
//        button.setText("Long Thị Lệ");

        //den day button van chua hien thi len layout
        //Test VCS > Commit

        l1 =(ListView)findViewById(R.id.listView);
    }
    public void get(View v){
        Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null,null,null,null);
        startManagingCursor(cursor);

        String[] from = {ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER,
                ContactsContract.CommonDataKinds.Phone._ID};
//        int to = {android.R.id.text1, android.R.id.text2};
        int[] to = {android.R.id.text1, android.R.id.text2};
//        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(android.R.layout.simple_list_item_2,
//                cursor,from,to);
        SimpleCursorAdapter simpleCursorAdapter=new SimpleCursorAdapter(getApplicationContext(),android.R.layout.simple_expandable_list_item_2,cursor,from, to);
        l1.setAdapter(simpleCursorAdapter);
        l1.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

    }
}

//// XIN CAP QUYEN DOC DANH BA

//import android.database.Cursor;
//import android.net.Uri;
//import android.provider.ContactsContract;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import java.util.ArrayList;
//import java.util.HashSet;

//import android.Manifest;
//import android.content.pm.PackageManager;
//import android.app.Activity;
//import android.os.Bundle;
//
//import android.widget.Toast;
//
//import androidx.core.app.ActivityCompat;
//import androidx.core.content.ContextCompat;
//
//public class MainActivity extends Activity {
//
//    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 1;
//    private static final int READ_CONTACTS_CODE = 1;
////    private static final int READ_CONTACTS_CODE = ;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState)
//    {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
//                != PackageManager.PERMISSION_GRANTED)
//        {
//            ActivityCompat.requestPermissions(this,
//                    new String[]{Manifest.permission.READ_CONTACTS},
//                    READ_CONTACTS_CODE);
//        }
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
//        switch (requestCode) {
//            case READ_CONTACTS_CODE:
//            {
//                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    Toast.makeText(getApplicationContext(), "Contacts permission granted", Toast.LENGTH_SHORT).show();
//                }
//                else
//                {
//                    Toast.makeText(getApplicationContext(), "Contacts permission denied", Toast.LENGTH_SHORT).show();
//                }
//                return;
//            }
//        }
//    }
//}
//public class MainActivity extends AppCompatActivity {
//    private ArrayList<ContactSync2> getAllContacts() {
//        Set<ContactSync> syncContactSet = new HashSet<>();
//        Set<ContactSync2> syncContactSet2 = new HashSet<>();
//        ArrayList<ContactSync2> contactSync2ArrayList = new ArrayList<>();
//        Cursor cursor = null;
//        try {
//            Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
//            String selection = ContactsContract.Contacts.HAS_PHONE_NUMBER;
//            cursor = context.getContentResolver().query(uri, new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone._ID, ContactsContract.Contacts._ID, "data2"}, selection, null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC");
//            cursor.moveToFirst();
//            while (cursor.isAfterLast() == false) {
//
//                int phoneContactID = cursor.getInt(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone._ID));
//                int contactID = cursor.getInt(cursor.getColumnIndex(ContactsContract.Contacts._ID));
//                int type = cursor.getInt(cursor
//                        .getColumnIndex("data2"));
//                String typeText = "";
//                switch (type) {
//                    case ContactsContract.CommonDataKinds.Phone.TYPE_HOME:
//                        typeText = "home";
//                        break;
//                    case ContactsContract.CommonDataKinds.Phone.TYPE_WORK:
//                        typeText = "work";
//                        break;
//                    case ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE:
//                        typeText = "main";
//                        break;
//                    case ContactsContract.CommonDataKinds.Phone.TYPE_WORK_MOBILE:
//                        typeText = "workmobile";
//                        break;
//                    case ContactsContract.CommonDataKinds.Phone.TYPE_MAIN:
//                        typeText = "main";
//                        break;
//                    default:
//                        typeText = "other";
//                        break;
//                }
//                String contactNumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
//                String contactName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
//                ContactSync contactSync = new ContactSync(contactName, contactNumber, typeText, contactID);
//                contactSync.setTypePhone(type);
//                syncContactSet.add(contactSync);
//                ContactSync2 contact_model = new ContactSync2(
//                        contactName, contactNumber, typeText,
//                        "");
//                contact_model.updateData(contactSync);
//                syncContactSet2.add(contact_model);// Finally add
//                cursor.moveToNext();
//            }
//            cursor.close();
//            cursor = null;
//        } catch (Exception e) {
//            if (cursor != null) {
//                cursor.close();
//                cursor = null;
//            }
//        }
//        if (syncContactSet2 != null) {
//            contactSync2ArrayList.addAll(syncContactSet2);
//        }
//        return contactSync2ArrayList;
//
//    }
//}