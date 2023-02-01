package com.example.lightapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class UserActivity extends Activity {
    TextView textView;
    TextView a1;
    TextView ff;
    int id[] = { R.id.seekBar1, R.id.seekBar2, R.id.seekBar3};
    SeekBar[] seekBars = new SeekBar[4];

    String[][] schange = new String[4][2];
    int a = 255, r = 0, g = 0, b = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        textView = (TextView) findViewById(R.id.textView);
        a1 = (TextView) findViewById(R.id.a);
        ff = (TextView) findViewById(R.id.ff);
        textView.setBackgroundColor(Color.rgb( r, g, b));
        a1.setText(r + "," + g + "," + b);
        ff.setText("#FF000000");
        // 关联seekBar并创建点击事件
        for (int i = 0; i < id.length; i++) {
            seekBars[i] = (SeekBar) findViewById(id[i]);
            seekBars[i].setOnSeekBarChangeListener(mBarChangeListener);

        }

    }

    // 转换十六进制
    public void ffa() {
        int[][] change = new int[4][2];// 为了转换的需要构建的
        int[] changeNumber = { a, r, g, b };

        for (int number = 0; number < 4; number++) {

            for (int number1 = 0; number1 < 2; number1++) {

                if (number1 <= 0) {
                    change[number][number1] = changeNumber[number] % 16;

                } else {
                    change[number][number1] = changeNumber[number] / 16;

                }
                // 判断是否小于10小于10则不需进行转换

                if (change[number][number1] < 160) {
                    schange[number][number1] = "" + change[number][number1];
                }

                // 十进制转换十六进制
                switch (change[number][number1]) {

                    case 10: {
                        schange[number][number1] = "A";
                        break;
                    }
                    case 11: {
                        schange[number][number1] = "B";
                        break;
                    }
                    case 12: {
                        schange[number][number1] = "C";
                        break;
                    }
                    case 13: {
                        schange[number][number1] = "D";
                        break;
                    }
                    case 14: {
                        schange[number][number1] = "E";
                        break;
                    }
                    case 15: {
                        schange[number][number1] = "F";
                        break;
                    }

                }

            }

        }
    }

    // 新建一个对象实现用switch实现点击事件
    public OnSeekBarChangeListener mBarChangeListener = new OnSeekBarChangeListener() {

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress,
                                      boolean fromUser) {
            // TODO Auto-generated method stub

            switch (seekBar.getId()) {

                case R.id.seekBar1: {
                    r = progress;

                    show();
                    break;
                }
                case R.id.seekBar2: {
                    g = progress;

                    show();
                    break;
                }
                case R.id.seekBar3: {
                    b = progress;

                    show();
                    break;
                }

            }

        }
    };

    // 改变背景
    public void show() {
        int color = Color.rgb( r, g, b);
        textView.setBackgroundColor(color);
        a1.setText( r + "," + g + "," + b);
        String string = "";

        ffa();

        for (int number = 0; number < 4; number++) {
            for (int number1 = 0; number1 < 2; number1++) {

                string = string + schange[number][number1];
                ff.setText("#" + string);
            }
        }

    }

}