package com.ducnd.mylibrary;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;

public class ManagerNetwork {

	public static String getNetworkClass(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo info = cm.getActiveNetworkInfo();
		if (info == null || !info.isConnected())
			return "-"; // not connected
		if (info.getType() == ConnectivityManager.TYPE_WIFI)
			return "WIFI";
		if (info.getType() == ConnectivityManager.TYPE_MOBILE) {
			int networkType = info.getSubtype();
			switch (networkType) {
			case TelephonyManager.NETWORK_TYPE_GPRS:
			case TelephonyManager.NETWORK_TYPE_EDGE:
			case TelephonyManager.NETWORK_TYPE_CDMA:
			case TelephonyManager.NETWORK_TYPE_1xRTT:
			case TelephonyManager.NETWORK_TYPE_IDEN: // api<8 : replace by 11
				return "2G";
			case TelephonyManager.NETWORK_TYPE_UMTS:
			case TelephonyManager.NETWORK_TYPE_EVDO_0:
			case TelephonyManager.NETWORK_TYPE_EVDO_A:
			case TelephonyManager.NETWORK_TYPE_HSDPA:
			case TelephonyManager.NETWORK_TYPE_HSUPA:
			case TelephonyManager.NETWORK_TYPE_HSPA:
			case TelephonyManager.NETWORK_TYPE_EVDO_B: // api<9 : replace by 14
			case TelephonyManager.NETWORK_TYPE_EHRPD: // api<11 : replace by 12
			case TelephonyManager.NETWORK_TYPE_HSPAP: // api<13 : replace by 15
				return "3G";
			case TelephonyManager.NETWORK_TYPE_LTE: // api<11 : replace by 13
				return "4G";
			default:
				return "?";
			}
		}
		return "?";
	}

	public static boolean isConnetNetword(Context context) {
		ConnectivityManager nInfo = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		return nInfo.getActiveNetworkInfo().isConnectedOrConnecting();
	}

	public static boolean isConnectWife(Context context) {
		ConnectivityManager conn = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		return conn.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnected();
	}

	public static boolean isConnetNetwordMobile(Context context) {
		ConnectivityManager conn = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		return conn.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
				.isConnected();
	}

	public static void openWife(Context context) {
		WifiManager wifi = (WifiManager) context
				.getSystemService(Context.WIFI_SERVICE);
		wifi.setWifiEnabled(true);
	}

	public static void closeWife(Context context) {
		WifiManager wifi = (WifiManager) context
				.getSystemService(Context.WIFI_SERVICE);
		wifi.setWifiEnabled(false);
	}
}
