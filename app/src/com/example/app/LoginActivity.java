package com.example.app;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.example.net.HttpCallBack;
import com.example.net.HttpTask;
import com.example.util.Util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends Activity  implements HttpCallBack{
	private EditText name, pwd;
	private Button btn;
	private String user_name ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

	setContentView(R.layout.activity_login);
	name =(EditText) findViewById(R.id.login_name_et);
	pwd =(EditText) findViewById(R.id.login_passwd_et);
	btn = (Button) findViewById(R.id.login_btn);
	btn.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			user_name = name.getText().toString().trim();
			String user_pwd = pwd.getText().toString().trim();
			Map<String, String> map = new HashMap<String , String>();
			map.put("user_login_name",user_name);
			map.put("user_login_pwd",user_pwd);
			String data = Util.getPair(map);
			HttpTask task = new HttpTask(LoginActivity.this);
			task.setCallback(LoginActivity.this);
			task.execute(Util.URL+Util.userlogin,data);
			
		}
	});
		
	}
	@Override
	public void callBack(String str) {
		// TODO Auto-generated method stub
		if(str != null){
			try {
				JSONObject json = new JSONObject(str);
				boolean flag = json.getBoolean("flag");
				//String  user_name =json.getString("user_name");
				if(flag){
					Intent intent= new Intent(LoginActivity.this,MainActivity.class);
					intent.putExtra("user_login_name",user_name);
					//startActivity(i);
					setResult(10000, intent);
					LoginActivity.this.finish();
					Toast.makeText(LoginActivity.this, "登入成功", 0).show();
				}else{
					Toast.makeText(LoginActivity.this, "登入失败", 0).show();
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
	}

	
	
}

/*import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.net.HttpTask;
import com.example.util.Util;
public class LoginActivity extends Activity implements OnClickListener  {
	
	private EditText user_name, user_login_pwd;
	private Button btn;
	@Override 
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_login);
		initWidget();

	}

	private  void initWidget() {
		btn = (Button) findViewById(R.id.login_btn);
		user_name = (EditText) findViewById(R.id.login_name_et);
		user_login_pwd = (EditText) findViewById(R.id.login_passwd_et);
		
		
		 * login.setOnClickListener(this); register.setOnClickListener(this);
		 
		user_name.setOnFocusChangeListener(new OnFocusChangeListener() {
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				// TODO Auto-generated method stub
				if (!hasFocus) {
					String ne = user_name.getText().toString().trim();
					if (user_name.length() < 4) {
						Toast.makeText(LoginActivity.this, "用户名不能小于4个字符",
								Toast.LENGTH_SHORT);

					}

				}

			}
		});
		user_login_pwd.setOnFocusChangeListener(new OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				// TODO Auto-generated method stub
				if (!hasFocus) {
					String ne = user_login_pwd.getText().toString().trim();
					if (user_login_pwd.length() < 4) {
						Toast.makeText(LoginActivity.this, "用户名不能小于4个字符",
								Toast.LENGTH_SHORT);

					}

				}

			}
		});

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {
		case R.id.login_btn:
			if (checkEdit()) {
				login();
			}
			break;

		}

	}

	private boolean checkEdit() {
		if (user_name.getText().toString().trim().equals("")) {
			Toast.makeText(LoginActivity.this, "54554545", Toast.LENGTH_SHORT).show();

		} else if (user_login_pwd.getText().toString().trim().equals("")) {
			Toast.makeText(LoginActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();

		} else {
			return true;
		}
		return false;
	}

	private void login() {

		user_name.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				String username = user_name.getText().toString().trim();
				String userpwd = user_login_pwd.getText().toString().trim();
				 Map<String, String> map = new HashMap<String,> 
				Map<String, String> map = new HashMap<String, String>();
				map.put("user+,name", username);
				map.put("userpwd", userpwd);

				String data = Util.getPair(map);
				HttpTask task = new HttpTask(LoginActivity.this);

				  task.setCallBack(Login.this); 

				// task.execute(Util.URL + Util.userlogin, data);
				task.execute(Util.URL + Util.userlogin, data);
			}
		});

	}

	
}*/