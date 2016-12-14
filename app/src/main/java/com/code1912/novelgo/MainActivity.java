package com.code1912.novelgo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.findViewById(R.id.iconics_tag_id).setOnTouchListener((e,m)->{
			return  true;
		});
		DataBindingUtil.setContentView(this,R.layout.activity_main);
	}
}
