package com.rayzhang.android.rzalbum.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Ray on 2017/2/11.
 */

/**
 * 打勾圖
 */
public class RZCheckView extends View {
    private Paint mPaint;
    private Path mPath;

    public RZCheckView(Context context) {
        this(context, null);
    }

    public RZCheckView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RZCheckView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public RZCheckView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setDither(true);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setColor(Color.WHITE);
        mPaint.setStrokeWidth(5f);

        mPath = new Path();
        setBackgroundColor(Color.argb(128, 0, 0, 0));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float pieceW = getWidth() / 6;
        float pieceH = getHeight() / 6;
        float centerW = pieceW * 3;
        float centerH = pieceH * 4;

        mPath.moveTo(centerW, centerH);
        mPath.lineTo(pieceW * 2, pieceH * 3);
        mPath.moveTo(centerW, centerH);
        mPath.lineTo(pieceW * 4.5f, pieceH * 2);
        canvas.drawPath(mPath, mPaint);
    }
}