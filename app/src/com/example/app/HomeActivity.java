package com.example.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.adapter.MyAdapter;
import com.example.app.entity.Goods;
import com.example.net.HttpCallBack;
import com.example.net.HttpTask;
import com.example.util.Util;

import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;



public class HomeActivity extends Fragment implements HttpCallBack{

	private GridView gv;
	 List<Goods> list = new ArrayList<Goods>();
	MyAdapter adapter;
	
	public ImageView imageView;
	//public Animation animation1;
	public boolean juage = true;
	public int images[] = new int[] { R.drawable.imgshow_2, R.drawable.inmshow_1,
			R.drawable.imgshow_3, R.drawable.imgshow_4, R.drawable.imgshow_5 };
	public int count = 0;
	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.activity_home, null);
		gv = (GridView) view.findViewById(R.id.search_gvword);
		
		imageView = (ImageView) view.findViewById(R.id.iv1);
		handler.postDelayed(runnable, 1000); // 定时器
		
		
		
		
		HttpTask task = new HttpTask(getActivity());
		task.setCallback(HomeActivity.this);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("goods_style", "all_goods");
		String date = Util.getPair(map);
		task.execute(Util.URL+Util.findGoods,date);
		
		
		
		
//		adapter = new  MyAdapter(getActivity(), list);
//		
//		gv.setAdapter(adapter);
		
		gv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				
				Intent intent = new Intent(getActivity(),DetailActivity.class);
				intent.putExtra("goods_id", list.get(arg2).getGoods_id());
				startActivity(intent);
				
			}
		});
		
		return view;
	}
	
	public Handler handler = new Handler();

	public Runnable runnable = new Runnable() {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			AnimationSet animationSet1 = new AnimationSet(true);
			
			TranslateAnimation ta = new TranslateAnimation(0, 50f, 0, 0);

			ta.setDuration(0);// 动画持续时间

			animationSet1.addAnimation(ta);

			animationSet1.setFillAfter(true);

			imageView.setBackgroundResource(images[count % 5]);

			count++;

			if (juage)
				handler.postDelayed(runnable, 3000);
		}
	};

	public void onPause() {
		juage = false;
		super.onPause();
	}

	@Override
	public void callBack(String str) {
		// TODO Auto-generated method stub
		try {
			JSONArray json = new JSONArray(str);
			for(int i=0;i<json.length();i++){
				JSONObject jo = json.getJSONObject(i);
				int id = jo.getInt("goods_id");
				String name = (String) jo.get("goods_name");
				String content = jo.getString("goods_content");
				double price = jo.getDouble("goods_sale_price");
				String img = (String) jo.get("goods_img");
				Goods goods = new Goods();
				goods.setGoods_id(id);
				goods.setGoods_name(name);
				goods.setGoods_content(content);
				goods.setGoods_sale_price((float) price);
				goods.setGoods_img(img);
				
				list.add(goods);
			}
			
			adapter = new  MyAdapter(getActivity(), list);
			
			gv.setAdapter(adapter);
			
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
