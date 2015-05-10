package com.leanote.berial.notificationdemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class MainActivity extends AppCompatActivity {

	private static final int NOTIFICATION_ID = 0;

	private NotificationManager manager;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

		findViewById(android.R.id.button1).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
				builder.setSmallIcon(R.mipmap.ic_launcher);//最为重要的一个参数，如果不设置，通知不会出现在状态栏中。
				builder.setTicker("状态栏提示文字");
//				builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.avatar));//设置状态栏下拉后显示的图标
				builder.setContentTitle("通知标题");
				builder.setContentText("通知内容");
//				builder.setContentInfo("通知额外信息");
//				builder.setWhen(System.currentTimeMillis());//当前通知的时间，有的手机貌似不设置就不显示
				builder.setDefaults(Notification.DEFAULT_ALL);
				builder.setAutoCancel(true);//点击通知后，通知消失

//				NotificationCompat.InboxStyle style = new NotificationCompat.InboxStyle();
//				style.addLine("hello");
//				style.addLine("notification");
//				style.addLine("style");
//				builder.setStyle(style);


				//				RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.custom_notification_layout);
//				remoteViews.setTextViewText(android.R.id.title, "自定义布局中的文字");
//				remoteViews.setImageViewResource(android.R.id.icon, R.mipmap.ic_launcher);
//				builder.setContent(remoteViews);

				Context context = MainActivity.this;
				Intent intent = new Intent(context, NewsDetailActivity.class);
				PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent,
						PendingIntent.FLAG_ONE_SHOT);
				builder.setContentIntent(pendingIntent);

				manager.notify(NOTIFICATION_ID, builder.build());
			}
		});

		findViewById(android.R.id.button2).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
				builder.setSmallIcon(R.mipmap.ic_launcher);//最为重要的一个参数，如果不设置，通知不会出现在状态栏中。
				builder.setTicker("状态栏更新消息");
				builder.setContentTitle("更新了通知标题");
				manager.notify(NOTIFICATION_ID, builder.build());
			}
		});

		findViewById(android.R.id.button3).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				manager.cancel(NOTIFICATION_ID);
			}
		});
	}

}
