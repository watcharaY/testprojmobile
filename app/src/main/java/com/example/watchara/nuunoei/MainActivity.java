package com.example.watchara.nuunoei;

import android.app.Dialog;
import android.app.Notification;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DialogTitle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnCal;
    private TextView tvAnswer;
    private EditText edNum1,edNum2;
    private RadioGroup rg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCal =(Button) findViewById(R.id.cal_btn);
        btnCal.setOnClickListener(this);
        tvAnswer = (TextView) findViewById(R.id.tv_answer);
        edNum1 = (EditText) findViewById(R.id.num1);
        edNum2 = (EditText) findViewById(R.id.num2);
        rg = (RadioGroup) findViewById(R.id.RG);

        //////////implement hash sha1 function//////////////////////////////////////////////
        hashSHA1 sha1 = new hashSHA1();
        try {
             tvAnswer.setText(sha1.SHA1("abc"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        ////////////////////////////////////////////////////////////////////////////////////

    }

    @Override
    public void onClick(View v) {
            int a=0,b=0;
        switch (rg.getCheckedRadioButtonId()){
            case R.id.rbPlus :
                try{
                    a = Integer.parseInt(edNum1.getText().toString());
                }catch (NumberFormatException e){}
                try{
                    b = Integer.parseInt(edNum2.getText().toString());
                }catch (NumberFormatException e){}
                tvAnswer.setText("= "+ (a+b));
                break;

            case R.id.rbMinus :
                try{
                    a = Integer.parseInt(edNum1.getText().toString());
                }catch (NumberFormatException e){}
                try{
                    b = Integer.parseInt(edNum2.getText().toString());
                }catch (NumberFormatException e){}
                tvAnswer.setText("= "+ (a-b));
                break;

            case R.id.rbMultiply :
                try{
                    a = Integer.parseInt(edNum1.getText().toString());
                }catch (NumberFormatException e){}
                try{
                    b = Integer.parseInt(edNum2.getText().toString());
                }catch (NumberFormatException e){}
                tvAnswer.setText("= "+ (a*b));
                break;

            case R.id.rbDivide :
                try{
                    a = Integer.parseInt(edNum1.getText().toString());
                }catch (NumberFormatException e){}
                try{
                    b = Integer.parseInt(edNum2.getText().toString());
                }catch (NumberFormatException e){}
                tvAnswer.setText("= "+ (a/b));
                break;
        }
    }
}
