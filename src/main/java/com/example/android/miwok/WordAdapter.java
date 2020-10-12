package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    private int mColor_cateogory;
    public WordAdapter(Activity context, ArrayList<Word> word,int color_category) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, word);
        mColor_cateogory=color_category;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miworkTextView = (TextView) listItemView.findViewById(R.id.miworok_text);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        miworkTextView.setText(currentWord.getMiwokTranslation());


        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView dafaultTextView = (TextView) listItemView.findViewById(R.id.default_text);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        dafaultTextView.setText(currentWord.getDefaultTranslation());

        // Return the whole list item layout (containing 2 TextViews and an ImageView) so that it can be shown in the ListView
        //Find the imageview in the list_item.xml
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        if(currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getGetImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        }
        else{
            imageView.setVisibility(View.GONE);
        }


        //set color for each category
        View color=listItemView.findViewById(R.id.text_container);
        color.setBackgroundColor(ContextCompat.getColor(getContext(),mColor_cateogory));
        return listItemView;
    }

}

