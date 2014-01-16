// Hangman two-play game
// Created By Kathryn Dew and Amber James
// Completed on 1/14/2014

package com.example.hangman;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.view.View;
import android.text.TextUtils;

public class StartpageActivity extends Activity implements OnClickListener{

	// Global Variables
	EditText word;		// Word that player 2 is trying to guess
	EditText hint;		// Hint about what 'word' is
	Button btnGo;		// 'Go' button
	TextView error;		// TextView to display any errors
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startpage);
        
        // Finds the text boxes and button in activity_startpage.xml and defines them
        word = (EditText) findViewById(R.id.word);
        hint = (EditText) findViewById(R.id.hint);
        btnGo = (Button) findViewById(R.id.btnGo);
        error = (TextView) findViewById(R.id.error);
        
        // Sets a listener for the enter button
	   	btnGo.setOnClickListener((OnClickListener) this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.startpage, menu);
        return true;
    }
    
    public void onClick(View view) {
    	// Local Variables
    	//string _word;
    	//string _hint;
    	
    	// Display error if 'word' is not exactly 6 characters in length
    	if (word.getText().length() != 6) {
    		error.setText("Error: Word must be 6 characters");
    		return;
    	}
    	
    	// Display error if 'hint' is empty
    	if (TextUtils.isEmpty(hint.getText().toString())) {
    		error.setText("Error: Hint cannot be empty");
    		return;
    	}
    	
    	// Link to GuessPage.java
    	Button button = (Button) findViewById(R.id.btnGo);
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(StartpageActivity.this, com.example.hangman.GuessPage.class);
				startActivity(intent);
			}
		});
		
	
    }
}
