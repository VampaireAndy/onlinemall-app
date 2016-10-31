package com.example.app.entity;
/**
 * 商品类别
 * @author Administrator
 *
 */
public class GoodsType {
	private int goods_type_id;	//	商品类别ID

	private String type;		//	商品类别

	private int goods_sex;
	
	private String goods_img;
	
	
	public int getGoods_sex() {
		return goods_sex;
	}

	public void setGoods_sex(int goods_sex) {
		this.goods_sex = goods_sex;
	}

	public GoodsType() {
		super();
	}

	

	public GoodsType(String type, int goods_sex, String goods_img) {
		super();
		this.type = type;
		this.goods_sex = goods_sex;
		this.goods_img = goods_img;
	}

	public String getGoods_img() {
		return goods_img;
	}

	public void setGoods_img(String goods_img) {
		this.goods_img = goods_img;
	}

	public int getGoods_type_id() {
		return goods_type_id;
	}

	public void setGoods_type_id(int goods_type_id) {
		this.goods_type_id = goods_type_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
	
}
