package com.example.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;


public class MainActivity extends FragmentActivity implements OnClickListener {

	private TextView home,hot,style,me;
	private ImageView ivSearch,ivShop;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		home = (TextView) findViewById(R.id.main_home);
		hot = (TextView) findViewById(R.id.main_hot);
		style = (TextView) findViewById(R.id.main_style);
		me = (TextView) findViewById(R.id.main_me);
		
		home.setOnClickListener(this);
		hot.setOnClickListener(this);
		style.setOnClickListener(this);
		me.setOnClickListener(this);
		
		Fragment fragment1 = new HomeActivity();
		setFrag(fragment1);
		
		ivSearch = (ImageView) findViewById(R.id.main_ivsearch);
		ivShop = (ImageView) findViewById(R.id.main_ivshop);
		
		ivSearch.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,SearchActivity.class);
				startActivity(intent);
			}
		});
		
		ivShop.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(MainActivity.this,ShopCartActivity.class);
						startActivity(intent);
					}
				});

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.main_home:
			Fragment fragment1 = new HomeActivity();
			setFrag(fragment1);
			break;
		case R.id.main_hot:
			Fragment fragment2 = new HotActivity();
			setFrag(fragment2);
					break;
		case R.id.main_style:
			Fragment fragment3 = new StyleActivity();
			setFrag(fragment3);
			break;
		case R.id.main_me:
			Fragment fragment4 = new MeActivity();
			setFrag(fragment4);
			break;
		

		
		}
	}
	public void setFrag(Fragment fragment){
	FragmentManager manage = getSupportFragmentManager();
		
		FragmentTransaction transaction = manage.beginTransaction();
		
		
		transaction.replace(R.id.main_fram_layout, fragment);
		transaction.commit();
	}
}
