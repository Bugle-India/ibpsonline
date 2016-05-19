package buglecs.mypc.bugletest.webviewUtils;

import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by aishwarya.kumar on 20/05/16.
 */
public class WebClient extends WebViewClient {

    WebClientEventHandler handler;

    public void registerEventHanlder(WebClientEventHandler handler) {
        this.handler = handler;
    }

    public void deregisterEventHandlers() {
        this.handler = null;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        view.loadUrl("javascript:var btn = document.createElement(\"BUTTON\");" +                   //Creating a button in the page
                " var t = document.createTextNode(\"JS To Android\"); btn.appendChild(t); " +       //naming the button
                "document.body.appendChild(btn).onclick=function() {Android.myFunc()}");            //adding the JS Bridge Func to the button
        if (handler != null) {
            handler.onPageFinishedCallback();
        }
        //show webview
        view.setVisibility(View.VISIBLE);
    }
}
