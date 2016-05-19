package buglecs.mypc.bugletest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    ImageView imgLoading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView) findViewById(R.id.wv);
        imgLoading = (ImageView)findViewById(R.id.imgloader);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url) {
                //hide loading image
                imgLoading.setVisibility(View.GONE);
                findViewById(R.id.loadingPanel).setVisibility(View.GONE);
                //show webview
                webView.setVisibility(View.VISIBLE);
            }

        });
        webView.loadUrl("http://ibpsonlinetest.com/TakeTheTest/");
    }
  @Override
public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }
        else
            super.onBackPressed();

    }
}
