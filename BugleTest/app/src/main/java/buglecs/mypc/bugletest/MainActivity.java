package buglecs.mypc.bugletest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import buglecs.mypc.bugletest.webviewUtils.WebAppInterface;
import buglecs.mypc.bugletest.webviewUtils.WebClient;
import buglecs.mypc.bugletest.webviewUtils.WebClientEventHandler;

public class MainActivity extends AppCompatActivity implements WebClientEventHandler {
    private WebView webView;
    private WebClient client;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView) findViewById(R.id.wv);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        client = new WebClient();
        client.registerEventHanlder(this);
        webView.setWebViewClient(client);

        webView.addJavascriptInterface(new WebAppInterface(this), "Android");
        webView.loadUrl("http://ibpsonlinetest.com/TakeTheTest/");
    }
    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }
        else {
            client.deregisterEventHandlers();
            super.onBackPressed();
        }

    }

    @Override
    public void onPageFinishedCallback() {
        //hide loading image
        ImageView imgLoading = (ImageView)findViewById(R.id.imgloader);
        imgLoading.setVisibility(View.GONE);
        findViewById(R.id.loadingPanel).setVisibility(View.GONE);
    }
}
