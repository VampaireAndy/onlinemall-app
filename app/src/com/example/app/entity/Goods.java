package com.example.app.entity;
/**
 * 商品
 * @author Administrator
 *
 */
public class Goods {
	private int goods_id;				//	商品ID
	
	private String goods_type;			//	商品类别
	
	private String goods_name;			//	商品名称
	
	private int goods_number;			//	商品剩余数量
	
	private String goods_business;		//	商品商家
	
	private float goods_sale_price;		//	商品销售价格
	
	private float goods_store_price;	//	商品进货价格
	
	private int goods_buy_count;		//	商品购买数量
	
	private String goods_img;			//	商品图片
	
	private String goods_content;		//	商品描述

	
	
	public Goods() {
		super();
	}

	public Goods( String goods_type, String goods_name,
			int goods_number, String goods_business, float goods_sale_price,
			float goods_store_price, int goods_buy_count, String goods_img,
			String goods_content) {
		super();
		this.goods_type = goods_type;
		this.goods_name = goods_name;
		this.goods_number = goods_number;
		this.goods_business = goods_business;
		this.goods_sale_price = goods_sale_price;
		this.goods_store_price = goods_store_price;
		this.goods_buy_count = goods_buy_count;
		this.goods_img = goods_img;
		this.goods_content = goods_content;
	}

	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public String getGoods_type() {
		return goods_type;
	}

	public void setGoods_type(String goods_type) {
		this.goods_type = goods_type;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public int getGoods_number() {
		return goods_number;
	}

	public void setGoods_number(int goods_number) {
		this.goods_number = goods_number;
	}

	public String getGoods_business() {
		return goods_business;
	}

	public void setGoods_business(String goods_business) {
		this.goods_business = goods_business;
	}

	public float getGoods_sale_price() {
		return goods_sale_price;
	}

	public void setGoods_sale_price(float goods_sale_price) {
		this.goods_sale_price = goods_sale_price;
	}

	public float getGoods_store_price() {
		return goods_store_price;
	}

	public void setGoods_store_price(float goods_store_price) {
		this.goods_store_price = goods_store_price;
	}

	public int getGoods_buy_count() {
		return goods_buy_count;
	}

	public void setGoods_buy_count(int goods_buy_count) {
		this.goods_buy_count = goods_buy_count;
	}

	public String getGoods_img() {
		return goods_img;
	}

	public void setGoods_img(String goods_img) {
		this.goods_img = goods_img;
	}

	public String getGoods_content() {
		return goods_content;
	}

	public void setGoods_content(String goods_content) {
		this.goods_content = goods_content;
	}

	

}
