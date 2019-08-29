package com.bipin.textscanner;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;

import com.googlecode.tesseract.android.TessBaseAPI;

import static com.googlecode.tesseract.android.TessBaseAPI.OEM_TESSERACT_ONLY;

public class MyTestActivity {

    private final TessBaseAPI mTess;

    public MyTestActivity(Context context, String language) {
        mTess = new TessBaseAPI();
        final String DATA_PATH = Environment.getExternalStorageDirectory().getPath();//.getAbsolutePath() + "/com.bipin.textscanner/";
        mTess.init(DATA_PATH, language, OEM_TESSERACT_ONLY);
    }

    public String getOCRResult(Bitmap bitmap) {
        mTess.setImage(bitmap);
        return mTess.getUTF8Text();
    }

    public void onDestroy() {
        if (mTess != null) mTess.end();
    }

}
