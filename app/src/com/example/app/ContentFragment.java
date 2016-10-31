package com.example.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.adapter.ContentAdapter;
import com.example.adapter.MyAdapter;
import com.example.app.entity.Goods;
import com.example.app.entity.GoodsType;
import com.example.net.HttpCallBack;
import com.example.net.HttpTask;
import com.example.util.Util;

import android.app.DownloadManager.Request;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ContentFragment extends Fragment implements HttpCallBack{
	private List<Goods> list=new ArrayList<Goods>();
	private String goods_type;
	ListView lv;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		View view =inflater.inflate(R.layout.content, null);
		lv=(ListView) view.findViewById(R.id.content_lv);
		Bundle b = getArguments();
		goods_type = b.getString("goods_type");
		System.out.println(goods_type);
		HttpTask task = new HttpTask(getActivity());
		
		task.setCallback(ContentFragment.this);
		Map<String, String> map = new HashMap<String, String>();
		map.put("goods_type",goods_type);
		map.put("goods_style", "type_goods");
		String date = Util.getPair(map);
		System.out.println(date);
		task.execute(Util.URL+Util.findGoods,date);
		return view;
	}

	@Override
	public void callBack(String str) {
		// TODO Auto-generated method stub
		list.clear();
		try{
			JSONArray json = new JSONArray(str);
			System.out.println(json.length());
			for(int i=0;i<json.length();i++){
				JSONObject jo = json.getJSONObject(i);
				int goods_id=jo.getInt("goods_id");
				String name = (String) jo.get("goods_name");
				String content = jo.getString("goods_content");
				double price = jo.getDouble("goods_sale_price");
				String img = (String) jo.get("goods_img");
				System.out.println("-->"+name);
				Goods goods = new Goods();
				goods.setGoods_id(goods_id);
				goods.setGoods_name(name);
				goods.setGoods_content(content);
				goods.setGoods_sale_price((float) price);
				goods.setGoods_img(img);
				list.add(goods);
		}
			
		ContentAdapter adapter=new ContentAdapter(getActivity(),list);
		lv.setAdapter(adapter);
		
		} catch (JSONException e) {
			// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}

}
