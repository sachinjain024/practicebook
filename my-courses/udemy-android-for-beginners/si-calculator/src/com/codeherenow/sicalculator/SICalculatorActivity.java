/*
 * Copyright (C) 2013 Code Here Now - A subsidiary of Mobs & Geeks
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file 
 * except in compliance with the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the 
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language governing permissions and 
 * limitations under the License.
 */
package com.codeherenow.sicalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class SICalculatorActivity extends Activity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    // UI Reference Variables
    private Button calculateButton;
    private TextView outputText;
    private EditText principalValue;
    private EditText rateValue;
    private SeekBar timeSeekBar;
    private TextView timeLabel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sicalculator);

        calculateButton = (Button) findViewById(R.id.calculate_button);
        outputText = (TextView) findViewById(R.id.output_text);
        principalValue = (EditText) findViewById(R.id.principal_value);
        rateValue = (EditText) findViewById(R.id.rate_value);
        timeLabel = (TextView) findViewById(R.id.time_interval_label);
        timeSeekBar = (SeekBar) findViewById(R.id.time_years_value);

        // Set Event Listeners
        calculateButton.setOnClickListener(this);
        timeSeekBar.setOnSeekBarChangeListener(this);
	}

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        updateTimeLabel(progress);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
	public void onClick(View view) {
        double principal = Double.valueOf(principalValue.getText().toString());
        double rate = Double.valueOf(rateValue.getText().toString());
        int numYears = timeSeekBar.getProgress();
        double simpleInterest;

        if (view == calculateButton) {
            simpleInterest = getInterest(principal, rate, numYears);
            outputText.setText(getOutputMessage(principal, rate, numYears, simpleInterest));
        }
    }

    private void updateTimeLabel(int progress) {
        timeLabel.setText(progress + " year(s)");
    }

    private String getOutputMessage(double principal, double rate, int numYears, double interest) {
        return "The interest for $" + principal + " at a rate of " + rate + "% for " + numYears + " year(s) is $" + interest;
    }

    private double getInterest(double principal, double rate, int time) {
        return (principal * rate * time * 0.01);
    }
}
