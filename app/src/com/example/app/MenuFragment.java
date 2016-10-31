package com.example.app;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.app.entity.GoodsType;
import com.example.net.HttpCallBack;
import com.example.net.HttpTask;
import com.example.util.Util;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class MenuFragment extends Fragment implements HttpCallBack{
	
	private ListView lv;
	private Fragment fragment;
	View view;
	List<String> goodsTypes=new ArrayList<String>();
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
	
		view = inflater.inflate(R.layout.menu_fragment, null);
		lv=(ListView) view.findViewById(R.id.menu_fragm_lv1);
		Map<String, String> map = new HashMap<String, String>();
		map.put("goods_type", "");
		String date = Util.getPair(map);
		
		HttpTask task = new HttpTask(getActivity());
		task.setCallback(MenuFragment.this);
		task.execute(Util.URL+Util.findGoodsType,date);
		
		
		
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				fragment=new ContentFragment();
				
				Adapter adapter=arg0.getAdapter();

				setFragment(fragment,adapter.getItem(arg2).toString());
				
				
			}
		});
		return view;
	}
	
	public void callBack(String str) {
		// TODO Auto-generated method stub
	
				try {
					JSONArray json = new JSONArray(str);
					for(int i=0;i<json.length();i++){
						JSONObject jo = json.getJSONObject(i);
						int  goods_type_id = (Integer) jo.get("goods_type_id");
						String type = jo.getString("type");
						int goods_sex = (Integer) jo.get("goods_sex");
						String goods_img = (String) jo.get("goods_img");
						GoodsType goodsType = new GoodsType();
						goodsType.setGoods_type_id(goods_type_id);
						goodsType.setType(type);
						goodsType.setGoods_sex(goods_sex);
						goodsType.setGoods_img(goods_img);
						goodsTypes.add(goodsType.getType());
					}
					
					ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, goodsTypes);
					lv.setAdapter(adapter);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
				}
			
	}
	private void setFragment(Fragment fragment,String goods_type) {

		// 在Activity中操作Fragment，需要获取fragmentManage
		FragmentManager fm = getFragmentManager();

		// 开启一个事务
		FragmentTransaction transaction = fm.beginTransaction();

		Bundle b = new Bundle();
		b.putString("goods_type",goods_type);
		fragment.setArguments(b);
		
		// 使用另一fragment替换当前的fragment
		transaction.replace(R.id.style_frame_layout, fragment);

		// 提交事务
		transaction.commit();
	}
}
