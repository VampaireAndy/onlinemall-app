package com.example.app;



//import com.parfois.asynctask.SearchAsync;
//import com.parfois.utils.PathUtils;
//import com.parfois.vmall.SearchActivity;

//import com.parfois.utils.PathUtils;
//import com.parfois.vmall.DetailActivity;
//import com.parfois.vmall.R;
//import com.parfois.vmall.SearchActivity;
//
//import com.parfois.utils.PathUtils;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
//import android.widget.AbsListView.OnScrollListener;
//import android.widget.AdapterView.OnItemClickListener;

public class SearchActivity extends Activity {
	EditText search_etword;
	ImageView search_ivchangeview, search_ivdelete, search_ivsearch;
	TextView search_ll_tv1, search_ll_tv3, search_ll_tv4;
	GridView search_gvword, search_gv;
	ListView search_lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		search_etword = (EditText) findViewById(R.id.search_etword);
		search_ivdelete = (ImageView) findViewById(R.id.search_ivdelete);
		search_ivsearch = (ImageView) findViewById(R.id.search_ivsearch);

		search_ll_tv3 = (TextView) findViewById(R.id.search_ll_tv3);
		search_ll_tv4 = (TextView) findViewById(R.id.search_ll_tv4);
		search_gvword = (GridView) findViewById(R.id.search_gvword);
		search_gv = (GridView) findViewById(R.id.search_gv);

		
		
//		search_gvword   �����ݿ��ȡ������ߵľŸ���Ʒ������  
//		��ʾ��GridView�����search_gvword����
		
		
		
		search_ivdelete.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				search_etword.setText("");
//				init();   //����޺ú�ߵĳ�ʼ������ �����������

			}
		});

		search_ivsearch.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				String str = search_etword.getText().toString().trim();

				if (str == null || "".equals(str)) {
					Toast.makeText(SearchActivity.this, "����Ϊ��,���������룡", 0).show();
					}
//					else{
				
//������Ҫ��strΪ�ؼ��֣�ȥ���ݿ����    ���ҽ������������ݴ����±ߵ�GridView���search_gv�в���ʾ

//              ��ʾ��ʽΪ
//				ͼƬ
//				����������С
//				�۸�������
//���ҽ���ԭ����ʾ��������������@+id/LinearLayout2 ����ʾ search_ll_tv3��search_ll_tv4�������
//���Բο������޸�ģ����/javaapk.com-Vmall/src/com/parfois/asynctask/SearchAsync.java�ļ����� 
//��/javaapk.com-Vmall/src/com/parfois/utils/PathUtils.java�ļ����ļ�
				
//				}

			}
		});
	}
		
		
	       
		
//������  GridView��� search_gv
//		search_gv.setOnScrollListener(new OnScrollListener() {
//			public void onScrollStateChanged(AbsListView view, int scrollState) {
//				if (flag && scrollState == OnScrollListener.SCROLL_STATE_IDLE) {
//					PathUtils.search_page++;
//					String path = PathUtils.search_0 + PathUtils.search_page
//							+ PathUtils.search_1 + PathUtils.search_item
//							+ PathUtils.search_2 + PathUtils.search_keyword;
//					new SearchAsync(SearchActivity.this, vs, sa, sagv, list,
//							false).execute(path);
//				}
//			}
//
//			public void onScroll(AbsListView view, int firstVisibleItem,
//					int visibleItemCount, int totalItemCount) {
//				flag = (totalItemCount == firstVisibleItem + visibleItemCount);
//			}
//		});
		
		
//		search_gv.setOnItemClickListener(new OnItemClickListener() {
//			public void onItemClick(AdapterView<?> parent, View view,
//					int position, long id) {
//				ImageView iv = (ImageView) view
//						.findViewById(R.id.grid_search_ivpicUrl);
//				Intent intent = new Intent(SearchActivity.this,
//						DetailActivity.class);
//				intent.putExtra("url", iv.getContentDescription().toString());
//				startActivity(intent);
//			}
//		});
		
	
	
	
	//�±�������TextView���,Ҫ������м���   
//	���search_ll_tv3���Զ�search_gv���а���������
//	���search_ll_tv4���Զ�search_gv���а��۸�����
		private void initTv() {
			search_ll_tv3.setTextColor(Color.parseColor("#666666"));
			search_ll_tv4.setTextColor(Color.parseColor("#666666"));}
		
		public void clicktv(View view) {
			initTv();
			switch (view.getId()) {
			case R.id.search_ll_tv3:
				search_ll_tv3.setTextColor(Color.parseColor("#aa0000"));
//				PathUtils.search_item = 3;
				break;
			case R.id.search_ll_tv4:
			search_ll_tv4.setTextColor(Color.parseColor("#aa0000"));
//				PathUtils.search_item = 4;
				break;
			}
		}
		
		
		
//		�����Ǹ���ʼ������     ���Ǹ���ʼ������   ���Ǹ���ʼ������ 
//			private void init() {
//				search_etword.setText(null);
//				search_ivchangeview.setVisibility(View.GONE);
//				search_ll_tv1.setText("��������");
//				search_ll_tv1.setTextColor(Color.parseColor("#666666"));
//
//				search_ll_tv3.setVisibility(View.GONE);
//				search_ll_tv4.setVisibility(View.GONE);
//				search_lv.setVisibility(View.GONE);
//				search_gv.setVisibility(View.GONE);
//				search_gvword.setVisibility(View.VISIBLE);
//				search_ll_tv1.setClickable(false);
//				initClick();
//			}
		
		
//			private void initClick() {
//				PathUtils.search_page = 1;
//				PathUtils.search_item = 1;
//		
//			}
//		
}
