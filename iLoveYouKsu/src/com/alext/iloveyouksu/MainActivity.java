package com.alext.iloveyouksu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private List<String> mLoveNotes;
	private Button mPrevButton;
	private Button mNextButton;
	private int mCurrentLoveNoteNumber;
	private TextView mTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.mCurrentLoveNoteNumber=0;
		setContentView(R.layout.activity_main);
		this.mLoveNotes = new ArrayList<String>(Arrays.asList(new String[] {
				getString(R.string.love_note_1),
				getString(R.string.love_note_2),
				getString(R.string.love_note_3) }));
		this.mTextView=(TextView)findViewById(R.id.love_text_view);
		this.mTextView.setText(this.mLoveNotes.get(0));
		this.mPrevButton=(Button)findViewById(R.id.prev_button_layout);
		this.mPrevButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mTextView.setText(mLoveNotes.get(getPreviousLoveNoteId()));
			}
		});
		this.mNextButton=(Button)findViewById(R.id.next_button);
		this.mNextButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mTextView.setText(mLoveNotes.get(getNextLoveNoteId()));	
			}
		});
	}
	private int getNextLoveNoteId(){
		if(this.mCurrentLoveNoteNumber==this.mLoveNotes.size()-1){
			this.mCurrentLoveNoteNumber=0;
		}else{
			this.mCurrentLoveNoteNumber++;
		}
		return this.mCurrentLoveNoteNumber;
	}
	
	private int getPreviousLoveNoteId(){
		if(this.mCurrentLoveNoteNumber==0){
			this.mCurrentLoveNoteNumber=this.mLoveNotes.size()-1;
		}else{
			this.mCurrentLoveNoteNumber--;
		}
		return this.mCurrentLoveNoteNumber;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}