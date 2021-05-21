package com.example.finalprojectcs443;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    /*
    * if i had more time i would allow more webview aswell as allow to user to pick the websites.
    * */

    private String url1;
    private String url2;
    private String search_iteam; // item user has enter

    private final String urlSearch1 = "https://www.amazon.com/s?k=";
    private final String urlSearch2 = "https://www.walmart.com/search/?query=";

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView webView = (WebView) findViewById(R.id.webView);
        WebView webView1 = (WebView) findViewById(R.id.webView2);

        // handle links
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new Callback());
        //webView.getSettings().set
        // again for second webview
        WebSettings webSettings1 = webView1.getSettings();
        webSettings1.setJavaScriptEnabled(true);
        //webView1.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING);
        // should work
        webView1.setWebViewClient(new Callback());

        setWebview();
        setClick();

    }

    void setWebview() {

        WebView webView = (WebView) findViewById(R.id.webView); // first one
        webView.loadUrl("https://www.amazon.com/");

        // 2nd webview

        WebView webView2 = (WebView) findViewById(R.id.webView2);
        webView2.loadUrl("https://www.walmart.com/");

    }

    public void setClick(){
        // got it working now need to update the webpages.

        Button button = (Button) findViewById(R.id.button);
        EditText editText = (EditText) findViewById(R.id.editText);

        WebView webView = (WebView) findViewById(R.id.webView); // first one
        WebView webView2 = (WebView) findViewById(R.id.webView2); // 2nd one

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search_iteam = editText.getText().toString();
                if(search_iteam != null){
                    url1 = urlSearch1+search_iteam;
                    url2 = urlSearch2+search_iteam;
                    webView.loadUrl(url1);
                    webView2.loadUrl(url2);

                }
                else{
                    // do nothing
                    editText.setText("Something went wrong sorry");
                }
                //testing = "hello";
               // testing = testing + " " + search_iteam;
                //editText.setText(testing);
            }
        });
    }

    /*
    public void setClick2(){

        Button button = (Button) findViewById(R.id.button4);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // go to the 2nd activity

            }
        });

    }
     */

    private class Callback extends WebViewClient{
        @Override
        public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
            return false;
        }
    }
} // last }