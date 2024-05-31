package com.example.airquality;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomListAdapter extends ArrayAdapter<String> {
    private Context mContext;
    private List<String> mStrings;
    private List<String> mLocations;
    private List<Integer> mImageIds;

    public CustomListAdapter(Context context, List<String> strings, List<Integer> imageIds,List<String> locations) {
        super(context, 0, strings);
        mContext = context;
        mStrings = strings;
        mLocations = locations;
        mImageIds = imageIds;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(mContext).inflate(R.layout.list_items, parent, false);
        }

        String currentString = mStrings.get(position);
        int currentImageId = mImageIds.get(position);
        String curentLocsationString = mLocations.get(position);

        TextView textView = listItem.findViewById(R.id.name);
        ImageView imageView = listItem.findViewById(R.id.imageview);
        TextView loationTextview = listItem.findViewById(R.id.email);

        textView.setText(currentString);
        imageView.setImageResource(currentImageId);
        loationTextview.setText(curentLocsationString);

        return listItem;
    }
}
