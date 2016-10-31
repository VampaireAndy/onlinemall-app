package com.example.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.adapter.HotAdapter;
import com.example.app.entity.Goods;
import com.example.net.HttpCallBack;
import com.example.net.HttpTask;
import com.example.util.Util;

import android.os.Bundle;
import android.content.Intent;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;


public class HotActivity extends Fragment implements HttpCallBack{
	
	private List<Goods> list;
	private ListView hot_lv;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.activity_hot, null);
		hot_lv = (ListView) view.findViewById(R.id.hot_lv);
		
		HttpTask task = new HttpTask(getActivity());
		task.setCallback(HotActivity.this);
		Map<String, String> map = new HashMap<String, String>();
		map.put("goods_style","");
		String data = Util.getPair(map);
		task.execute(Util.URL+Util.findGoods,data);
		
		list = new ArrayList<Goods>();
		
		
		hot_lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Toast.makeText(getActivity(), "text", 0).show();
				Intent intent = new Intent(getActivity(),DetailActivity.class);
				intent.putExtra("goods_id", list.get(arg2).getGoods_id());
				startActivity(intent);
			}
		});
		
		return view;
	}
	@Override
	public void callBack(String str) {
		// TODO Auto-generated method stub
		try {
			JSONArray ja = new JSONArray(str);
			for(int i=0;i<ja.length();i++){
				JSONObject jo = ja.getJSONObject(i);
				int id = jo.getInt("goods_id");
				//System.out.println(jo.getString("goods_name"));
				Goods goods = new Goods();
				goods.setGoods_id(id);
				goods.setGoods_img(jo.getString("goods_img"));
				goods.setGoods_name(jo.getString("goods_name"));
				goods.setGoods_sale_price((float)jo.getDouble("goods_sale_price"));
				goods.setGoods_content(jo.getString("goods_content"));
				list.add(goods);
			}
			HotAdapter adapter = new HotAdapter(getActivity(),list);
			hot_lv.setAdapter(adapter);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
