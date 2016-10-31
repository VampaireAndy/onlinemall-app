package com.example.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.app.entity.Goods;
import com.example.net.HttpCallBack;
import com.example.net.HttpTask;
import com.example.util.Util;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;

public class DetailActivity extends Activity implements HttpCallBack {

	@SuppressWarnings("deprecation")
	//private Gallery gallery;
	private ImageView iv;
	private ListView lv;
	private TextView detail_price;
	private TextView detail_tv1;
	private TextView detail_yuexiao;
	private int goods_id;
	private ImageLoader imageLoader = ImageLoader.getInstance();
	DisplayImageOptions options; 
	//private int[] img = new int[]{R.drawable.pi2,R.drawable.pi3,R.drawable.pi4,R.drawable.pi5,R.drawable.pi6};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		
		//gallery = (Gallery) findViewById(R.id.detail_gallery);
		//gallery.setSelection(img.length/2);
		
		iv = (ImageView) findViewById(R.id.detail_iv);
		lv = (ListView) findViewById(R.id.detail_lv);
		detail_price=(TextView) findViewById(R.id.detail_price);
		detail_tv1=(TextView) findViewById(R.id.detail_tv1);
		detail_yuexiao=(TextView) findViewById(R.id.detail_yuexiao);
		
		Intent intent=getIntent();
		goods_id=intent.getIntExtra("goods_id",0);
		System.out.println(goods_id);
		HttpTask task = new HttpTask(DetailActivity.this);
		task.setCallback(DetailActivity.this);
		
		
		Map<String, String> map1 = new HashMap<String, String>();
		
		map1.put("goods_style", "single_goods");
		map1.put("goods_id", goods_id+"");
		String date = Util.getPair(map1);
		System.out.println(date);
		task.execute(Util.URL+Util.findGoods,date);
		
		//设置图片更换的动画效果
		//gallery.setAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
		//gallery.setAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
		
		
		/*List<Map<String,Object>> data = new ArrayList<Map<String,Object>>();
		
		for(int i=0;i<img.length;i++){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("gallery_img", img[i]);
			data.add(map);
		}*/
		
		//SimpleAdapter gallert_adapter = new SimpleAdapter(DetailActivity.this, data, R.layout.detail_gallery, new String[]{"gallery_img"}, new int[]{R.id.detail_gallery_img});
		//gallery.setAdapter(gallert_adapter);
		
		/*
		 * 
		 * 商品评论
		 */
		String[] lv_list = {"这里的衣服很漂亮，下次再来。","还不错，老板人很好，下次还会来的","买给女朋友的，跪不跪搓衣板就看它了","快递慢的要死，垃圾东西","老婆很喜欢"};
		ArrayAdapter<String> listview_adapter = new ArrayAdapter<String>(DetailActivity.this, android.R.layout.simple_list_item_1, lv_list );
		lv.setAdapter(listview_adapter);
		
	}
	@Override
	public void callBack(String str) {
		// TODO Auto-generated method stub
		try {
			//JSONArray json = new JSONArray(str);
			//System.out.println(json.length());
			Goods goods = new Goods();
			//System.out.println(json.length());
			//for(int i=0;i<json.length();i++){
				JSONObject jo = new JSONObject(str);
				System.out.println(str);
				String name = (String) jo.get("goods_name");
				String content = jo.getString("goods_content");
				double price = jo.getDouble("goods_sale_price");
				String goods_img = (String) jo.get("goods_img");
				int goods_buy_count=jo.getInt("goods_buy_count");
				goods.setGoods_name(name);
				goods.setGoods_content(content);
				goods.setGoods_sale_price((float) price);
				goods.setGoods_img(goods_img);
				goods.setGoods_buy_count(goods_buy_count);
				//img[i]=goods.getGoods_img();
				String picUri = Util.URL+"/upload/"+goods.getGoods_img();
				 String url = "http://img0.bdstatic.com/img/image/imglogo-r.png";
				 options = new DisplayImageOptions.Builder()
					.showStubImage(R.drawable.ic_stub) // 设置图片下载期间显示的图片
					.showImageForEmptyUri(R.drawable.ic_empty) // 设置图片Uri为空或是错误的时候显示的图片
					.showImageOnFail(R.drawable.ic_error) // 设置图片加载或解码过程中发生错误显示的图片
					.cacheInMemory(true) // 设置下载的图片是否缓存在内存中
					.cacheOnDisc(true) // 设置下载的图片是否缓存在SD卡中
					.displayer(new RoundedBitmapDisplayer(20)) // 设置成圆角图片
					.build(); // 创建配置过得DisplayImageOption对象
				 imageLoader.displayImage(picUri, iv, options, null);
			//}
			detail_price.setText("$"+goods.getGoods_sale_price()+"");
			detail_tv1.setText(goods.getGoods_content());
			detail_yuexiao.setText("月销"+goods.getGoods_buy_count()+"笔");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
