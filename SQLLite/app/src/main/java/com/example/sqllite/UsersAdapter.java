package com.example.sqllite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class UsersAdapter extends ArrayAdapter<User> {
    public UsersAdapter(Context context, ArrayList<User> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        User user = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_user, parent, false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView designation = (TextView) convertView.findViewById(R.id.designation);
        TextView location = (TextView) convertView.findViewById(R.id.location);

        name.setText(user.name);
        designation.setText(user.designation);
        location.setText(user.location);

        return convertView;
    }
}
