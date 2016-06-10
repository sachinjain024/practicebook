package me.blunderboy.examples;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class PhoneCallActivity extends Activity implements View.OnClickListener {

    private Button makeCallButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_call);

        makeCallButton = (Button) findViewById(R.id.make_call_button);

        makeCallButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == makeCallButton) {
            // Create a new Phone Call Intent and start the new activity (Some random number)
            Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:+91 9212013423"));
            startActivity(callIntent);
        }
    }
}