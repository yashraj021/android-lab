package com.example.sql;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<User> arrayOfUsers = new ArrayList<>();
    SQLiteDatabase myDataBase;
    ListView listView;
    UserAdapter adapter;

    public void saveData(View view) {
        TextView name = findViewById(R.id.name);
        TextView location = findViewById(R.id.location);
        TextView designation = findViewById(R.id.designation);

        String _name = name.getText().toString();
        String _location = location.getText().toString();
        String _designation = designation.getText().toString();

        if(_name.length() ==0 || _designation.length() == 0 || _location.length() == 0) {
            Toast.makeText(this, "Fields empty", Toast.LENGTH_SHORT);

            return;
        }

        String execution = String.format("INSERT INTO users VALUES ('%s','%s','%s')", _name, _location, _designation);

        myDataBase.execSQL(execution);

        User newUser = new User(_name, _location, _designation);

        adapter.add(newUser);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDataBase = openOrCreateDatabase("users", MODE_PRIVATE, null);

        myDataBase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, location VARCHAR, designation VARCHAR)");

        Cursor c = myDataBase.rawQuery("SELECT * FROM users", null);

        int nameIndex = c.getColumnIndex("name");
        int locationIndex = c.getColumnIndex("location");
        int designationIndex = c.getColumnIndex("designation");

        c.moveToFirst();

        adapter = new UserAdapter(this, arrayOfUsers);
        listView = (ListView) findViewById(R.id.user_view);
        listView.setAdapter(adapter);

        while(!c.isAfterLast()) {
            User _user = new User(c.getString(nameIndex), c.getString(locationIndex), c.getString(designationIndex));
            adapter.add(_user);

            c.moveToNext();
        }
    }
}