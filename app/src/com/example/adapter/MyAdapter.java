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

public class MyAdapter extends BaseAdapter{
	private Context context;
	private List<Goods> list;
	private ImageLoader imageLoader = ImageLoader.getInstance();
	DisplayImageOptions options; // DisplayImageOptions����������ͼƬ��ʾ����

	public MyAdapter(Context context, List<Goods> list) {
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
	public View getView(int position, View view, ViewGroup arg2) {

		 LayoutInflater inflater = LayoutInflater.from(context);
		 view=inflater.inflate(R.layout.good_list, null);
		 
		 TextView goods_name= (TextView) view.findViewById(R.id.goods_title);
		 TextView goods_desc= (TextView) view.findViewById(R.id.goods_desc);
		 TextView goods_price= (TextView) view.findViewById(R.id.goods_price);
		 ImageView goods_img=(ImageView) view.findViewById(R.id.goods_img);
		 
		 goods_name.setText(list.get(position).getGoods_name());
		 goods_desc.setText(list.get(position).getGoods_content());
		 goods_price.setText(list.get(position).getGoods_sale_price()+"");
		 
		 String picUrl = Util.URL+"/upload/"+list.get(position).getGoods_img();
		 //String picUrl = "http://192.168.2.25:8080/OnlineMall/images/pi6.png";
		 System.out.println("pic-->"+picUrl);
		 //String url = "http://img0.bdstatic.com/img/image/imglogo-r.png";
		 options = new DisplayImageOptions.Builder()
			.showStubImage(R.drawable.ic_stub) // ����ͼƬ�����ڼ���ʾ��ͼƬ
			.showImageForEmptyUri(R.drawable.ic_empty) // ����ͼƬUriΪ�ջ��Ǵ����ʱ����ʾ��ͼƬ
			.showImageOnFail(R.drawable.ic_error) // ����ͼƬ���ػ��������з���������ʾ��ͼƬ
			.cacheInMemory(true) // �������ص�ͼƬ�Ƿ񻺴����ڴ���
			.cacheOnDisc(true) // �������ص�ͼƬ�Ƿ񻺴���SD����
			.displayer(new RoundedBitmapDisplayer(20)) // ���ó�Բ��ͼƬ
			.build(); // �������ù���DisplayImageOption����
		 imageLoader.displayImage(picUrl, goods_img, options, null);
		
		return view;
	}
	
}
