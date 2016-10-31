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

		
		
//		search_gvword   从数据库获取销量最高的九个商品的名字  
//		显示在GridView组件的search_gvword表中
		
		
		
		search_ivdelete.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				search_etword.setText("");
//				init();   //如果修好后边的初始化函数 这个语句才能用

			}
		});

		search_ivsearch.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				String str = search_etword.getText().toString().trim();

				if (str == null || "".equals(str)) {
					Toast.makeText(SearchActivity.this, "输入为空,请重新输入！", 0).show();
					}
//					else{
				
//在这里要以str为关键字，去数据库检索    并且将检索出的数据传到下边的GridView组件search_gv中并显示

//              显示格式为
//				图片
//				详情字体稍小
//				价格字体大点
//并且将在原来显示“热门搜索”的@+id/LinearLayout2 上显示 search_ll_tv3和search_ll_tv4两个组件
//可以参考或者修改模板中/javaapk.com-Vmall/src/com/parfois/asynctask/SearchAsync.java文件功能 
//和/javaapk.com-Vmall/src/com/parfois/utils/PathUtils.java文件等文件
				
//				}

			}
		});
	}
		
		
	       
		
//下面是  GridView组件 search_gv
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
		
	
	
	
	//下边是两个TextView组件,要对其进行监听   
//	点击search_ll_tv3可以对search_gv进行按销量排序
//	点击search_ll_tv4可以对search_gv进行按价格排序
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
		
		
		
//		下面是个初始化函数     面是个初始化函数   面是个初始化函数 
//			private void init() {
//				search_etword.setText(null);
//				search_ivchangeview.setVisibility(View.GONE);
//				search_ll_tv1.setText("热门搜索");
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
