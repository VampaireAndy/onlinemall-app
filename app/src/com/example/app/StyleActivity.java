package com.example.app;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class StyleActivity extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.activity_style, null);
		
		Fragment menuFragment = new MenuFragment();
		FragmentManager fm = getFragmentManager();
		// ����һ������
		FragmentTransaction transaction = fm.beginTransaction();
		// ʹ����һfragment�滻��ǰ��fragment
		transaction.replace(R.id.style_menu, menuFragment);
		// �ύ����
		transaction.commit();
		return view;
	}
	
}
