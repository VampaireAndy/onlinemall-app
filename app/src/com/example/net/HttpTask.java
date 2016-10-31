package com.example.net;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

public class HttpTask extends AsyncTask<String, Void, Void>{
	private String response;//������Ӧ���ַ���
	private HttpCallBack callBack;//�ص��ӿ� 
	private HttpHelper httphelper;//�������Ӧ�ķ�װ����
	private ProgressDialog dialog = null;//�������Ի��� ��ʾ����
	
	public HttpTask(Context context){
		super();
		httphelper=new HttpHelper();
		dialog=ProgressDialog.show(context, "��ʾ", "���ڼ��غ�̨����", true, true);
	}
  
	 public void setCallback(HttpCallBack callBack){
		 
		 this.callBack=callBack;
	 }
	 /**
	  * ��ʱ���� ������������
	  * ... ����0-N������
	  */
	@Override
	protected Void doInBackground(String... params) {
		// TODO Auto-generated method stub
		if(params.length>1){
			//������
			response = httphelper.postPage(params[0],params[1]);
		}else {
			//��������
			response= httphelper.postPage(params[0], null);
		}
		
		return null;
	}

	 @Override
	protected void onPostExecute(Void result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		
		//ȡ�����ݣ��Ի�����ʧ
		dialog.dismiss();
		
		if(callBack!=null){
			callBack.callBack(response);
		}
	}
}
