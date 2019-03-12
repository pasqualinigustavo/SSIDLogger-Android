package org.zordius.ssidlogger.application;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;

public class Application extends android.app.Application {

    private static Context context = null;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static String getAppVersion() throws PackageManager.NameNotFoundException {

        PackageInfo pInfo = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0);
        String version = pInfo.versionName;

        return version;
    }

    public static Context getContext() {
        return Application.context;
    }

    public static boolean isAccessFineLocationPermissionGranted(Context context) {
        int permission = ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION);

        return permission == PackageManager.PERMISSION_GRANTED;
    }

    public static boolean isAccessCoarseLocationPermissionGranted(Context context) {
        int permission = ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_COARSE_LOCATION);

        return permission == PackageManager.PERMISSION_GRANTED;
    }

    public static boolean isNetworkStatePermissionGranted(Context context) {
        int permission = ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_NETWORK_STATE);

        return permission == PackageManager.PERMISSION_GRANTED;
    }

    public static boolean isInternetPermissionGranted(Context context) {
        int permission = ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.INTERNET);

        return permission == PackageManager.PERMISSION_GRANTED;
    }

    public static boolean isCameraPermissionGranted(Context context) {
        int permission = ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.CAMERA);

        return permission == PackageManager.PERMISSION_GRANTED;
    }

    public static boolean isReadExternalStoragePermissionGranted(Context context) {
        int permission = ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.READ_EXTERNAL_STORAGE);

        return permission == PackageManager.PERMISSION_GRANTED;
    }

    public static boolean isWriteExternalStoragePermissionGranted(Context context) {
        int permission = ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);

        return permission == PackageManager.PERMISSION_GRANTED;
    }

    public static boolean isReadContactsPermissionGranted(Context context) {
        int permission = ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.READ_CONTACTS);

        return permission == PackageManager.PERMISSION_GRANTED;
    }

    public static boolean isReadSmsPermissionGranted(Context context) {
        int permission = ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.READ_SMS);

        return permission == PackageManager.PERMISSION_GRANTED;
    }

    public static boolean isReadCallsPermissionGranted(Context context) {
        int permission = ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.READ_CALL_LOG);

        return permission == PackageManager.PERMISSION_GRANTED;
    }

    public static boolean isCallPhonePermissionGranted(Context context) {
        int permission = ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.CALL_PHONE);

        return permission == PackageManager.PERMISSION_GRANTED;
    }

    public static boolean isReadPhoneStatePermissionGranted(Context context) {
        int permission = ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.READ_PHONE_STATE);

        return permission == PackageManager.PERMISSION_GRANTED;
    }
}


