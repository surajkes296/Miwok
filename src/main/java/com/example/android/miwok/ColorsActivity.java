package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    static MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("red", "weṭeṭṭi",R.drawable.color_red,R.raw.color_red));
        words.add(new Word("mustard yellow", "chiwiiṭә",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));
        words.add(new Word("dusty yellow", "ṭopiisә",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        words.add(new Word("green", "chokokki",R.drawable.color_green,R.raw.color_green));
        words.add(new Word("brown", "ṭakaakki",R.drawable.color_brown,R.raw.color_brown));
        words.add(new Word("gray", "ṭopoppi",R.drawable.color_gray,R.raw.color_gray));
        words.add(new Word("black", "kululli",R.drawable.color_black,R.raw.color_black));
        words.add(new Word("white", "kelelli",R.drawable.color_white,R.raw.color_white));

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        WordAdapter itemsAdapter =
                new WordAdapter(this, words,R.color.category_colors);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);


        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word wObject = words.get(position);
                player = MediaPlayer.create(ColorsActivity.this, wObject.getAudioResourceId());
                player.start();
                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Toast.makeText(ColorsActivity.this,"Pronunciation is over",Toast.LENGTH_SHORT).show();
                    }
                });
                /* write you handling code like...
                  String st = "sdcard/";
                  File f = new File(st+o.toString());
                // do whatever u want to do with 'f' File object
                 */
            }
        });
        /*LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);

        // Create a variable to keep track of the current index position
        int index = 0;

        // Keep looping until we've reached the end of the list (which means keep looping
        // as long as the current index position is less than the length of the list)
        while (index < words.size()) {
            // Create a new TextView
            TextView wordView = new TextView(this);

            // Set the text to be word at the current index
            wordView.setText(words.get(index));

            // Add this TextView as another child to the root view of this layout
            rootView.addView(wordView);

            // Increment the index variable by 1
            index++;
        }*/
    }
}
