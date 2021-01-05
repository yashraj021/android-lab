 package com.example.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.w3c.dom.Text;

import java.util.ArrayList;

 public class MainActivity extends AppCompatActivity {

     ArrayList<User> arrayOfUsers = new ArrayList<User>();

     SQLiteDatabase myDatabase;

     ListView listView;

     UsersAdapter adapter;

     public void saveData(View view) {
         TextView name = (TextView) findViewById(R.id.nameField);
         TextView location = (TextView) findViewById(R.id.locationField);
         TextView designation = (TextView) findViewById(R.id.designationField);

         if(
             name.getText().toString().length() == 0 ||
             location.getText().toString().length() == 0 ||
             designation.getText().toString().length() == 0
         ) {
             Toast.makeText(this, "Fields empty!!", Toast.LENGTH_SHORT).show();

             return;
         }

         myDatabase.execSQL(
                 String.format(
                         "INSERT INTO users VALUES('%s','%s','%s')",
                         name.getText().toString(),
                         designation.getText().toString(),
                         location.getText().toString()
                 )
         );


             User newUser = new User(
                     name.getText().toString(),
                     designation.getText().toString(),
                     location.getText().toString()
             );
             adapter.add(newUser);

     }

     public void clearData(View view) {
         myDatabase.execSQL("DROP TABLE users");
         myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, designation VARCHAR, location VARCHAR)");
         adapter.clear();
     }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDatabase = openOrCreateDatabase("users", MODE_PRIVATE, null);

        myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, designation VARCHAR, location VARCHAR)");

        Cursor c = myDatabase.rawQuery("SELECT * FROM users", null);

        int nameIndex = c.getColumnIndex("name");
        int locationIndex = c.getColumnIndex("location");
        int designationIndex = c.getColumnIndex("designation");

        c.moveToFirst();

        adapter = new UsersAdapter(this, arrayOfUsers);
        listView = (ListView) findViewById(R.id.user_view);
        listView.setAdapter(adapter);

        while(!c.isAfterLast()) {

            User newUser = new User(c.getString(nameIndex), c.getString(designationIndex), c.getString(locationIndex));
            adapter.add(newUser);

            c.moveToNext();
        }

    }
}