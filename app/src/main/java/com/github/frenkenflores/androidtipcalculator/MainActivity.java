package com.github.frenkenflores.androidtipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    private TextView tvBase;
    private TextView tvSeekbar;
    private TextView tvTip;
    private TextView tvTotal;
    private EditText etBaseAmount;
    private SeekBar seekbar;
    private TextView tvTipAmount;
    private TextView tvTotalAmount;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvBase = (TextView) findViewById(R.id.tvBase);
        tvSeekbar = (TextView) findViewById(R.id.tvSeekbar);
        tvTip = (TextView) findViewById(R.id.tvTip);
        tvTotal = (TextView) findViewById(R.id.tvTotal);
        etBaseAmount = (EditText) findViewById(R.id.etBaseAmount);
        seekbar = (SeekBar) findViewById(R.id.seekBar);
        tvTipAmount = (TextView) findViewById(R.id.tvTipAmount);
        tvTotalAmount = (TextView) findViewById(R.id.tvTipAmount);

        int initProgress = 15;
        seekbar.setProgress(initProgress);
        tvSeekbar.setText(initProgress + "%");
        seekbar.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        Log.i(TAG, "onProgressChange: " + i);
        tvSeekbar.setText(i + "%");
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {}

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {}
}