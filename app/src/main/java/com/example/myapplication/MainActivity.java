package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.os.Bundle;


        public class MainActivity extends Activity implements View.OnTouchListener {

            private ImageView mImageView;
            private ViewGroup mMoveLayout;
            private int mX;
            private int mY;

            @Override
            public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);


                mMoveLayout = (ViewGroup) findViewById(R.id.move);
                mImageView = (ImageView) mMoveLayout.findViewById(R.id.ImageView);


                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(300, 300);
                mImageView.setLayoutParams(layoutParams);
                mImageView.setOnTouchListener(this);
            }
            public boolean onTouch(View view, MotionEvent event) {
                final int X = (int) event.getRawX();
                final int Y = (int) event.getRawY();

                switch (event.getAction() & MotionEvent.ACTION_MASK) {

                    case MotionEvent.ACTION_DOWN:
                        RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                        mX = X - lParams.leftMargin;
                        mY = Y - lParams.topMargin;
                        break;

                    case MotionEvent.ACTION_MOVE:
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view
                                .getLayoutParams();
                        layoutParams.leftMargin = X - mX;
                        layoutParams.topMargin = Y - mY;
                        layoutParams.rightMargin = -250;
                        layoutParams.bottomMargin = -250;
                        view.setLayoutParams(layoutParams);
                        break;
                }
                return true;
            }
        }


