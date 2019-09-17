package com.example.mylayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.security.PublicKey;

/**
 * author : ZhiG
 * e-mail : 1120121044@163.com
 * date   : 2019/9/1614:17
 * desc   :
 * package: Myp:
 */

public class MylayUp extends View {

    private float mHeight;
    private float mWidth;
    private int mRingColor;
    private float mRingWidth;
    private int mCircleColor;
    private float mTextSize;
    private int mTextColor;
    private int mStartAngle;
    private int mSweepAngle;
    private Paint mCirclePaint;
    private Paint mTextPaint;
    private float mDy;
    private String mProgress;
    private Paint mSweepPaint;
    private float mRadius;
    private float mCenterXY;
    private RectF mRecf;

    public MylayUp(Context context) {
        super(context);
    }

    public MylayUp(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.MylayUp);
        if (ta != null) {
            //获取属性
            mHeight = ta.getDimension(R.styleable.MylayUp_android_layout_height, 200);
            mWidth = ta.getDimension(R.styleable.MylayUp_android_layout_width, 200);
            mRingColor = ta.getColor(R.styleable.MylayUp_ringColor, 0);
            mRingWidth = ta.getDimension(R.styleable.MylayUp_ringWidth, 10);
            mCircleColor = ta.getColor(R.styleable.MylayUp_circleColor, 0);
            mTextSize = ta.getDimension(R.styleable.MylayUp_android_textsize, 16);
            mTextColor = ta.getColor(R.styleable.MylayUp_android_textColor, 0);
            mStartAngle = ta.getInteger(R.styleable.MylayUp_startAngle, -90);
            mSweepAngle = ta.getInteger(R.styleable.MylayUp_sweepAngle, 0);
            ta.recycle();
        }
        mCirclePaint = new Paint();
        mCirclePaint.setColor(mCircleColor);
        mCirclePaint.setAntiAlias(true);


        mTextPaint = new Paint();
        mTextPaint.setColor(mTextColor);
        mTextPaint.setTextSize(mTextSize);
        mTextPaint.setTextAlign(Paint.Align.CENTER);


        Paint.FontMetrics fontMetrics = mTextPaint.getFontMetrics();
        float v1 = fontMetrics.descent - fontMetrics.ascent;
        mDy = v1 / 2 - fontMetrics.descent;
        float v = mSweepAngle * 1.0f / 360 * 100;
        mProgress = (int) v + " %";
        mSweepPaint = new Paint();
        mSweepPaint.setAntiAlias(true);
        mSweepPaint.setColor(mRingColor);
        mSweepPaint.setStyle(Paint.Style.STROKE);


    }

    public MylayUp(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int max = (int) Math.max(mWidth, mHeight);
        setMeasuredDimension(max, max);
        mRadius = max * 1.0f / 4;
        mCenterXY = max * 1.0f / 2;
        float v = max * 0.9f;
        mRecf = new RectF(max * 0.1f, max * 0.1f, v, v);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(mCenterXY, mCenterXY, mRadius, mCirclePaint);
        canvas.drawText(mProgress, mCenterXY, mCenterXY + mDy, mTextPaint);
        canvas.drawArc(mRecf, mStartAngle, mSweepAngle, false, mSweepPaint);

    }

    public void setProgress(int progress) {
        mSweepAngle = (int) (progress * 3.6f);
        mProgress = progress + " %";
        invalidate();
    }

}
