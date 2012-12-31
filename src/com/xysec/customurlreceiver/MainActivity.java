package com.xysec.customurlreceiver;
 
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
 
public class MainActivity extends Activity {
        // static counter
        private static int mCounter = 0;
   
        @Override
        protected void onResume() {            
                super.onResume();
               
                // get the text label
                TextView customURLText = (TextView) findViewById(R.id.label);
       
                // get the intent of this activity
                Intent intent = getIntent();
                Uri uri = intent.getData();
       
                // if called with an URL
                if(uri != null)
                {
                        String url = uri.toString();
                        String callback = "onResume";
                        if(MainActivity.mCounter <= 1)
                                callback = "onCreate";
                        String text = "URL(" + callback + ")='" + url + "'";           
                        customURLText.setText(text);
                }
        }
 
        /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);        
        MainActivity.mCounter++;        
    }
}