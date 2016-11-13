package com.tuacy.permission.base;

import android.support.v7.app.AppCompatActivity;

import com.tuacy.permission.packing.PermissionGen;


public class BaseActivity extends AppCompatActivity {


	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		PermissionGen.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
	}

}
