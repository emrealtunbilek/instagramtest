package com.emrealtunbilek.instagramtest.utils;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * Created by Emre on 13.02.2018.
 */

public class SqaureImageView extends AppCompatImageView {

    public SqaureImageView(Context context) {
        super(context);
    }

    public SqaureImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SqaureImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
}