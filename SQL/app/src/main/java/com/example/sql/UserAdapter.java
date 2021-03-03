package com.example.sql;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {
    public UserAdapter(@NonNull Context context, @NonNull List<User> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        User user = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_user,parent, false);
        }

        TextView name_adapter = convertView.findViewById(R.id.name_adapter);
        TextView location_adapter = convertView.findViewById(R.id.location_adapter);
        TextView designation_adapter = convertView.findViewById(R.id.designation_adapter);

        name_adapter.setText(user.name);
        location_adapter.setText(user.location);
        designation_adapter.setText(user.designation);

        return convertView;
    }
}
