package com.dhl.screencapture;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.MailTo;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class ScreenCapture_AppActivity extends Activity {
    private RelativeLayout mLayout = null;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
    	mLayout = (RelativeLayout)findViewById(R.id.linearMain);
    	mLayout.setDrawingCacheEnabled(true);
    	
    	mLayout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				getBasicData();
			}
		});
    }
    
    private void getBasicData(){

    	File root = Environment.getExternalStorageDirectory();
    	File file = new File(root, "screen.png");
    	
    	Bitmap b = mLayout.getDrawingCache();

    	
    	FileOutputStream fos = null;
    	
    	try {
			fos = new FileOutputStream(file);
			if( fos != null){
				b.compress(Bitmap.CompressFormat.PNG, 90, fos);
				fos.flush();
//				fos.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}