package com.hw.samplesms;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    Button  buttonSend;
    EditText textPhoneNumber;
    TextView  textSMS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         buttonSend = (Button) findViewById(R.id.buttonSend);
         textPhoneNumber = (EditText) findViewById(R.id.editTextPhoneNo);
         textSMS = (EditText) findViewById(R.id.editTextSMS);
        buttonSend.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                String phoneNo = textPhoneNumber.getText().toString();
                String sms = textSMS.getText().toString();

                try {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNo, null, sms, null, null);
                    Toast.makeText(getApplicationContext(), "SMS Sent!",
                            Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),
                            "SMS faild, please try again later!",
                            Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }

            }
        });
    }
}