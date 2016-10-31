package com.example.adapter;

import java.util.List;

import com.example.app.R;
import com.example.app.entity.Goods;
import com.example.util.Util;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ContentAdapter extends BaseAdapter {
	private Context context;// 上下文
	private List<Goods> list;
	private ImageLoader imageLoader = ImageLoader.getInstance();
	DisplayImageOptions options;

	public ContentAdapter(Context context, List<Goods> list) {
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
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		// 找布局 item.xml LayoutInflater布局渲染器
		LayoutInflater inflater = LayoutInflater.from(context);// 加载上下文
		// LayoutInflater.inflate(XmlPullParser parser, ViewGroup root
		convertView = inflater.inflate(R.layout.menu_fragment_item, null);

		// 找组件 item里的组件

		TextView tv = (TextView) convertView.findViewById(R.id.menu_fragement_item_tv1);// 找文本框
		ImageView iv = (ImageView) convertView.findViewById(R.id.menu_fragement_item_iv);
		
		// 往组件装配数据 图片和文字
		String picUrl = Util.URL+"/upload/"+list.get(position).getGoods_img();
		 //String url = "http://img0.bdstatic.com/img/image/imglogo-r.png";
		 options = new DisplayImageOptions.Builder()
			.showStubImage(R.drawable.ic_stub) // 设置图片下载期间显示的图片
			.showImageForEmptyUri(R.drawable.ic_empty) // 设置图片Uri为空或是错误的时候显示的图片
			.showImageOnFail(R.drawable.ic_error) // 设置图片加载或解码过程中发生错误显示的图片
			.cacheInMemory(true) // 设置下载的图片是否缓存在内存中
			.cacheOnDisc(true) // 设置下载的图片是否缓存在SD卡中
			.displayer(new RoundedBitmapDisplayer(20)) // 设置成圆角图片
			.build(); // 创建配置过得DisplayImageOption对象
		 imageLoader.displayImage(picUrl, iv, options, null);
		
		tv.setText(list.get(position).getGoods_name());// 获取对象里文本并放进了文本框
		
		return convertView;
	}

}
