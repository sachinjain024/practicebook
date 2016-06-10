package me.blunderboy.examples;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;


public class SimpleActivity extends Activity {

    private TextView welcomeUserTextView;
    private TextView requestlySuffixTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_layout);

        Resources resources = getResources();

        welcomeUserTextView = (TextView) findViewById(R.id.welcome_user_textview);

        String welcomeUserString = getString(R.string.hello_user);
        welcomeUserString = String.format(welcomeUserString, "Sachin");

        welcomeUserTextView.setText(welcomeUserString);
        welcomeUserTextView.setTextColor(resources.getColor(R.color.green));

        // Using Html Tags on Android Views
        requestlySuffixTextView = (TextView) findViewById(R.id.textView_requestly_suffix);
        requestlySuffixTextView.setText(Html.fromHtml(getString(R.string.requestly_suffix_markyp)));
    }
}
