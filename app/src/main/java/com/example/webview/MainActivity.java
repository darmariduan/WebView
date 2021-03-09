package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.Browser;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //deklarasi variabel
    private WebView frameWeb;
    private ImageButton btn01, btn02, btn03, btn04;
    private static String URL_WEB1 ="https://www.google.com/";
    private static String URL_WEB2 ="https://www.dicoding.com/";
    private static String URL_WEB3 ="https://developer.android.com/";
    private static String URL_WEB4 ="https://stmikroyal.ac.id/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //initial
        btn01 = findViewById(R.id.btn_menu1);
        btn02 = findViewById(R.id.btn_menu2);
        btn03 = findViewById(R.id.btn_menu3);
        btn04 = findViewById(R.id.btn_menu4);

        frameWeb = findViewById(R.id.frame_web);
        frameWeb.getSettings().getJavaScriptEnabled();
        frameWeb.loadUrl(URL_WEB1);
        frameWeb.setWebViewClient(new MyBrowser());
        frameWeb.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        //aksi klik untuk button
        btn01.setOnClickListener(this);
        btn02.setOnClickListener(this);
        btn03.setOnClickListener(this);
        btn04.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
if (v.getId() == R.id.btn_menu1){
    //ketika button 1 di klik
    frameWeb.loadUrl(URL_WEB1);
} else if (v.getId() == R.id.btn_menu2) {
    //ketika button 2 di klik
    frameWeb.loadUrl(URL_WEB2);
}else if (v.getId() == R.id.btn_menu3) {
    //ketika button 3 di klik
    frameWeb.loadUrl(URL_WEB3);
}else if (v.getId() == R.id.btn_menu4){
            //ketika button 4 di klik
            frameWeb.loadUrl(URL_WEB4);
        }
    }

    private class MyBrowser extends WebViewClient{
        //fungsi mybrowser
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String request) {
            frameWeb.loadUrl(request);
            return true;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && frameWeb.canGoBack()){
            frameWeb.goBack();
            return true;
        }else{
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }


}