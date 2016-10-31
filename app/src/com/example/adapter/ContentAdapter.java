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
	private Context context;// ������
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

		// �Ҳ��� item.xml LayoutInflater������Ⱦ��
		LayoutInflater inflater = LayoutInflater.from(context);// ����������
		// LayoutInflater.inflate(XmlPullParser parser, ViewGroup root
		convertView = inflater.inflate(R.layout.menu_fragment_item, null);

		// ����� item������

		TextView tv = (TextView) convertView.findViewById(R.id.menu_fragement_item_tv1);// ���ı���
		ImageView iv = (ImageView) convertView.findViewById(R.id.menu_fragement_item_iv);
		
		// �����װ������ ͼƬ������
		String picUrl = Util.URL+"/upload/"+list.get(position).getGoods_img();
		 //String url = "http://img0.bdstatic.com/img/image/imglogo-r.png";
		 options = new DisplayImageOptions.Builder()
			.showStubImage(R.drawable.ic_stub) // ����ͼƬ�����ڼ���ʾ��ͼƬ
			.showImageForEmptyUri(R.drawable.ic_empty) // ����ͼƬUriΪ�ջ��Ǵ����ʱ����ʾ��ͼƬ
			.showImageOnFail(R.drawable.ic_error) // ����ͼƬ���ػ��������з���������ʾ��ͼƬ
			.cacheInMemory(true) // �������ص�ͼƬ�Ƿ񻺴����ڴ���
			.cacheOnDisc(true) // �������ص�ͼƬ�Ƿ񻺴���SD����
			.displayer(new RoundedBitmapDisplayer(20)) // ���ó�Բ��ͼƬ
			.build(); // �������ù���DisplayImageOption����
		 imageLoader.displayImage(picUrl, iv, options, null);
		
		tv.setText(list.get(position).getGoods_name());// ��ȡ�������ı����Ž����ı���
		
		return convertView;
	}

}
