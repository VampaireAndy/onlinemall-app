package com.example.adapter;

import java.util.List;

import com.example.app.DetailActivity;
import com.example.app.R;
import com.example.app.entity.Goods;
import com.example.util.Util;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class HotAdapter extends BaseAdapter{

	private Context context;
	private List<Goods> list;
	private ImageLoader imageLoader = ImageLoader.getInstance();
	DisplayImageOptions options; // DisplayImageOptions是用于设置图片显示的类
	
	public HotAdapter(Context context, List<Goods> list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View view, ViewGroup arg2) {
		// TODO Auto-generated method stub
		LayoutInflater inflater= LayoutInflater.from(context);
		view = inflater.inflate(R.layout.hot_item, null);
		ImageView hot_iv = (ImageView) view.findViewById(R.id.hot_item_img);
		TextView hot_name = (TextView) view.findViewById(R.id.hot_item_name);
		TextView hot_desc = (TextView) view.findViewById(R.id.hot_item_desc);
		TextView hot_price = (TextView) view.findViewById(R.id.hot_item_price);
		Button hot_purchase = (Button) view.findViewById(R.id.hot_item_purchase);//????
		hot_name.setText(list.get(arg0).getGoods_name());
		hot_desc.setText(list.get(arg0).getGoods_content());
		String price = String.valueOf(list.get(arg0).getGoods_sale_price());
		hot_price.setText(price);
		
		
		String picUrl = Util.URL+"/upload/"+list.get(arg0).getGoods_img();
		 //String url = "http://img0.bdstatic.com/img/image/imglogo-r.png";
		 options = new DisplayImageOptions.Builder()
			.showStubImage(R.drawable.ic_stub) // 设置图片下载期间显示的图片
			.showImageForEmptyUri(R.drawable.ic_empty) // 设置图片Uri为空或是错误的时候显示的图片
			.showImageOnFail(R.drawable.ic_error) // 设置图片加载或解码过程中发生错误显示的图片
			.cacheInMemory(true) // 设置下载的图片是否缓存在内存中
			.cacheOnDisc(true) // 设置下载的图片是否缓存在SD卡中
			.displayer(new RoundedBitmapDisplayer(20)) // 设置成圆角图片
			.build(); // 创建配置过得DisplayImageOption对象
		 imageLoader.displayImage(picUrl, hot_iv, options, null);
		
		return view;
	}

}
