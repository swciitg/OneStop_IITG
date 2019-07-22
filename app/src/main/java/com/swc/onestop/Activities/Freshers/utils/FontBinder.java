package com.swc.onestop.Activities.Freshers.utils;


import android.content.res.AssetManager;
import androidx.databinding.BindingAdapter;
import android.graphics.Typeface;
import android.widget.TextView;


public class FontBinder {

    @BindingAdapter("bind:font")
    public static void setTypeface(TextView textView, String fontName) {
        final AssetManager assets = textView.getContext().getAssets();
        textView.setTypeface(Typeface.createFromAsset(assets, "fonts/" + fontName));
    }

}
