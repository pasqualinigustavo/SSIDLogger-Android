package org.zordius.ssidlogger;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.zordius.ssidlogger.application.Application;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WifiReceiver.init(this);
        new Thread() {
            @Override
            public void run() {
                syncStatus();
                bindDone();
            }
        }.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateFileStatus();
        verifyStorage();
    }

    public void bindDone() {
        // handle set logfile
//        ((EditText) findViewById(R.id.editFilename))
//                .setOnEditorActionListener(new EditText.OnEditorActionListener() {
//                    public boolean onEditorAction(TextView v, int actionId,
//                                                  KeyEvent event) {
//                        if (actionId == EditorInfo.IME_ACTION_DONE) {
//                            if (!WifiReceiver.setLogFile(v.getContext(),
//                                    ((EditText) v).getText().toString())) {
//                                syncStatus();
//                            }
//                        }
//                        return false;
//                    }
//                });

//        // handle comment
//        ((EditText) findViewById(R.id.editComment))
//                .setOnEditorActionListener(new EditText.OnEditorActionListener() {
//                    public boolean onEditorAction(TextView v, int actionId,
//                                                  KeyEvent event) {
//                        if (actionId == EditorInfo.IME_ACTION_SEND) {
//                            doComment();
//                            return true;
//                        }
//                        return false;
//                    }
//                });
    }

    public void syncStatus() {
        ((ToggleButton) findViewById(R.id.logSwitch)).setChecked(WifiReceiver
                .isEnabled(this));
        ((ToggleButton) findViewById(R.id.activeLogSwitch)).setChecked(WifiReceiver
                .activeLog);
//        ((ToggleButton) findViewById(R.id.activeSwitch)).setChecked(WifiReceiver
//                .activeScan);
//        ((ToggleButton) findViewById(R.id.frequencySwitch)).setChecked(WifiReceiver
//                .frequency == 30);

//        ((EditText) findViewById(R.id.editFilename))
//                .setText(WifiReceiver.logFile,
//                        TextView.BufferType.EDITABLE);
        setupLoggingUI();
    }

    public void setupLoggingUI() {
        boolean isLogging = ((ToggleButton) findViewById(R.id.logSwitch)).isChecked();
//        ((ToggleButton) findViewById(R.id.activeSwitch)).setEnabled(!isLogging);
//        ((ToggleButton) findViewById(R.id.frequencySwitch)).setEnabled(!isLogging);
//        ((EditText) findViewById(R.id.editFilename)).setEnabled(!isLogging);
    }

    public void updateFileStatus() {
        ((TextView) findViewById(R.id.textLSize))
                .setText(WifiReceiver.getLogSize() + "KB");
//        ((TextView) findViewById(R.id.textLFree))
//                .setText(WifiReceiver.getFreeSize() + "MB");


    }

    public void onClickLog(View v) {
        setupLoggingUI();
        WifiReceiver.toggleScan(this, ((ToggleButton) v).isChecked());
    }

    public void onClickActive(View v) {
        //WifiReceiver.toggleActive(this);
    }

    public void onClickLogActive(View v) {
        WifiReceiver.toggleLogActive(this);
    }

//    public void onClickFequency(View v) {
//        WifiReceiver.toggleLongScan(this);
//    }
//
//    public void onClickScan(View v) {
//        WifiReceiver.doScan(this);
//    }
//
//    public void doComment() {
//        EditText cmt = (EditText) findViewById(R.id.editComment);
//        WifiReceiver.writeLog("COMMENT " + cmt.getText().toString());
//        cmt.setText("", TextView.BufferType.EDITABLE);
//    }

    private boolean verifyStorage() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (!Application.isReadExternalStoragePermissionGranted(this)) {
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        Constants.READ_WRITE_EXTERNAL_STORAGE);
                return false;
            } else return true;
        } else return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case Constants.READ_WRITE_EXTERNAL_STORAGE:
//                if (grantResults != null && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    takePictureFromGallery();
//                }
                break;
        }
    }
}
