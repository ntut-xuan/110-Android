package com.example.a109590031_hw10_2;

import android.content.Context;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.loader.content.AsyncTaskLoader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class URLLoader extends AsyncTaskLoader<String> {
    /**
     * @deprecated
     */

    private final String urlString;

    public URLLoader(Context context, String url) {
        super(context);
        this.urlString = url;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public String loadInBackground() {
        String content = "";
        try {
            Document document = Jsoup.connect(urlString).get();
            content = document.html();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

}
