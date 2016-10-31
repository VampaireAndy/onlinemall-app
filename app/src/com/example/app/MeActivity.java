package com.example.app;

import android.os.Bundle;
import android.content.Intent;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MeActivity extends Fragment {

	private ImageView login_btn;
	private TextView show_user_name;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.activity_me, null);
		login_btn = (ImageView) view.findViewById(R.id.imageView1);
		show_user_name = (TextView) view.findViewById(R.id.textView1);
		login_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new  Intent(getActivity(),LoginActivity.class);
				//startActivity(intent);
				
				startActivityForResult(intent, 10086);
			}
		});
		return view;
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode == 10086 && resultCode == 10000){
			String name = data.getStringExtra("user_login_name");
			System.out.println(name);
			login_btn.setVisibility(1);
			show_user_name.setText(name);
		}
	}

}
