package com.palak.palakarora_comp304_lab3;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;


public class CustomTextView extends androidx.appcompat.widget.AppCompatTextView {
    String showLongDate;
    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.CustomTextView,
                0, 0);

        try {
            String showLongDate = a.getString(R.styleable.CustomTextView_longDate);
        } finally {
            a.recycle();
        }
    }

    public boolean islongDate() {
        return showLongDate=="longDate";
    }

    public void setlongDate(String longDate) {
        showLongDate = longDate;
        invalidate();
        requestLayout();
    }
}