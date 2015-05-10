package com.leanote.berial.notificationdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by berial on 15/5/8.
 */
public class NewsDetailActivity extends AppCompatActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		TextView textView = new TextView(this);
		textView.setText("新闻详情");
		setContentView(textView);
	}
}
