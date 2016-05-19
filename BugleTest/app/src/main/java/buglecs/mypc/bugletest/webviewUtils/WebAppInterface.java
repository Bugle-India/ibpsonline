package buglecs.mypc.bugletest.webviewUtils;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Created by aishwarya.kumar on 20/05/16.
 */
public class WebAppInterface {
    Context mContext;

    /** Instantiate the interface and set the context */
    public WebAppInterface(Context c) {
        mContext = c;
    }

    /** Show a toast from the web page */
    @JavascriptInterface
    public void myFunc() {
        Toast.makeText(mContext, "Call any method here instead of showing toast", Toast.LENGTH_LONG).show();
    }
}
