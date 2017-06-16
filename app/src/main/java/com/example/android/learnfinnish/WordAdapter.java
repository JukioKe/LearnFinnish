package com.example.android.learnfinnish;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class WordAdapter extends ArrayAdapter<Word> {


    public WordAdapter(Context context, ArrayList<Word> numberList) {
        super(context, 0, numberList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the Word object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.fin_word);
        // Get the version name from the current Word object and set this text on the name TextView
        if (currentWord != null) {
            nameTextView.setText(currentWord.getFinTranslation());
        }

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView numberTextView = (TextView) listItemView.findViewById(R.id.eng_word);
        // Get the version number from the current Word object and set this text on the number TextView
        if (currentWord != null) {
            numberTextView.setText(currentWord.getEngTranslation());
        }

        // Find the ImageView in the list_item.xml layout with the ID image
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.image);
        // Get the image resource ID from the current Word object and set the image to iconView
        iconView.setImageResource(currentWord.getImageResourceID());

        // Return the whole list item layout (containing 2 TextViews and an ImageView) so that it can be shown in the ListView

        return listItemView;
    }
}
