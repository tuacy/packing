package com.tuacy.permission;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.tuacy.permission.base.BaseActivity;
import com.tuacy.permission.packing.PermissionFail;
import com.tuacy.permission.packing.PermissionGen;
import com.tuacy.permission.packing.PermissionSuccess;

public class MainActivity extends BaseActivity implements View.OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	private void initView() {
		Button one = (Button) findViewById(R.id.btn_permission_one);
		one.setOnClickListener(this);
		Button two = (Button) findViewById(R.id.btn_permission_two);
		two.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.btn_permission_one:
				PermissionGen.with(MainActivity.this)
							 .addRequestCode(100)
							 .permissions(
								 Manifest.permission.READ_CONTACTS,
								 Manifest.permission.RECEIVE_SMS,
								 Manifest.permission.WRITE_CONTACTS)
							 .request();
				break;
			case R.id.btn_permission_two:
				PermissionGen.needPermission(this, 200, Manifest.permission.CAMERA);
				break;
		}
	}


	@PermissionSuccess(requestCode = 100)
	public void test(){
		Log.d("tuacy", "100 success");
	}

	@PermissionFail(requestCode = 100)
	private void test2() {
		Log.d("tuacy", "100 fail");
	}

	@PermissionSuccess(requestCode = 200)
	public void openCamera(){
		Log.d("tuacy", "200 success");
	}

	@PermissionFail(requestCode = 200)
	public void failOpenCamera(){
		Log.d("tuacy", "200 fail");
	}
}
