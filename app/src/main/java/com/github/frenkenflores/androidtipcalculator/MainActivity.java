package com.github.frenkenflores.androidtipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private TextView tvBase;
    private TextView tvSeekbar;
    private TextView tvTip;
    private TextView tvTotal;
    private EditText etBaseAmount;
    private SeekBar seekbar;
    private TextView tvTipAmount;
    private TextView tvTotalAmount;
    private TextView tvStatus;

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
        tvTotalAmount = (TextView) findViewById(R.id.tvTotalAmount);
        tvStatus = (TextView) findViewById(R.id.tvStatus);

        int initProgress = 15;
        printProgress(initProgress);
        seekbar.setProgress(initProgress);
        tvSeekbar.setText(initProgress + "%");
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.i(TAG, "onProgressChange: " + i);
                tvSeekbar.setText(i + "%");
                compute();
                printProgress(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        etBaseAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                Log.i(TAG, "Base: " + editable.toString());
                compute();
            }
        });
    }

    private void compute() {
        if (etBaseAmount.getText().toString().length() == 0) {
            return;
        }

        Float baseAmount = Float.parseFloat(etBaseAmount.getText().toString());
        Integer tipPercent = seekbar.getProgress();
        Float tipAmount = baseAmount * tipPercent / 100;
        Float totalAmount = tipAmount + baseAmount;

        tvTipAmount.setText(tipAmount + " $");
        tvTotalAmount.setText(totalAmount + " $");
    }
    private void printProgress(int progress) {
        if (progress < 10) {
            tvStatus.setText("\uD83D\uDE15");
        } else if (progress >= 10 && progress < 20) {
            tvStatus.setText("\uD83D\uDE10");
        } else {
            tvStatus.setText("\uD83D\uDE0B");
        }
    }
}