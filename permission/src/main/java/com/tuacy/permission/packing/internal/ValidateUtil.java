package com.tuacy.permission.packing.internal;

import android.content.pm.PackageManager;

public class ValidateUtil {

	public static boolean verifyGrants(int... grantResults) {
		for (int result : grantResults) {
			if (result != PackageManager.PERMISSION_GRANTED) {
				return false;
			}
		}
		return true;
	}
}
