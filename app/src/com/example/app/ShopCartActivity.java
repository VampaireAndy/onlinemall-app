package com.example.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ShopCartActivity extends Activity {
	private Button btn;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shopcar);
		
		btn=(Button) findViewById(R.id.cart_btn);
		btn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent=new Intent();
				intent.setClass(ShopCartActivity.this, MainActivity.class);
				startActivity(intent);
			}
		});
		
	}

	
}
