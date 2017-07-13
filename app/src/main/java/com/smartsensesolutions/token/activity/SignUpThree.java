package com.smartsensesolutions.token.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.smartsensesolutions.token.R;

public class SignUpThree extends AppCompatActivity implements View.OnClickListener {

    private TextView txtContinue, txtOne, txtTwo, txtThree, txtFour, txtFive, txtSix, txtSeven, txtEight, txtNine, txtZero,actionBack;
    private ImageView imageIndicatorTwo, imagePinOne, imagePinTwo, imagePinThree, imagePinFour,txtBack;
    private String strPin = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_three);
        initializeControls();
    }

    public void initializeControls() {
        txtContinue = (TextView) findViewById(R.id.txt_sign_up_continue);
        txtOne = (TextView) findViewById(R.id.txt_one);
        txtTwo = (TextView) findViewById(R.id.txt_two);
        txtThree = (TextView) findViewById(R.id.txt_three);
        txtFour = (TextView) findViewById(R.id.txt_four);
        txtFive = (TextView) findViewById(R.id.txt_five);
        txtSix = (TextView) findViewById(R.id.txt_six);
        txtSeven = (TextView) findViewById(R.id.txt_seven);
        txtEight = (TextView) findViewById(R.id.txt_eight);
        txtNine = (TextView) findViewById(R.id.txt_nine);
        txtZero = (TextView) findViewById(R.id.txt_zero);
        txtBack = (ImageView) findViewById(R.id.txt_back);
        actionBack = (TextView) findViewById(R.id.sign_up_one_sign_up_back);

        imagePinOne = (ImageView) findViewById(R.id.img_pin_one);
        imagePinTwo = (ImageView) findViewById(R.id.img_pin_two);
        imagePinThree = (ImageView) findViewById(R.id.img_pin_three);
        imagePinFour = (ImageView) findViewById(R.id.img_pin_four);

        imageIndicatorTwo = (ImageView) findViewById(R.id.img_indicator_two);
        imageIndicatorTwo.setImageResource(R.drawable.ic_selected_dot);

        txtContinue.setOnClickListener(this);
        txtOne.setOnClickListener(this);
        txtTwo.setOnClickListener(this);
        txtThree.setOnClickListener(this);
        txtFour.setOnClickListener(this);
        txtFive.setOnClickListener(this);
        txtSix.setOnClickListener(this);
        txtSeven.setOnClickListener(this);
        txtEight.setOnClickListener(this);
        txtNine.setOnClickListener(this);
        txtZero.setOnClickListener(this);
        txtBack.setOnClickListener(this);
        actionBack.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txt_sign_up_continue:
                goTo(SignUpFour.class);
                break;
            case R.id.txt_one:
                validatePin(txtOne.getText().toString());
                break;
            case R.id.txt_two:
                validatePin(txtTwo.getText().toString());
                break;
            case R.id.txt_three:
                validatePin(txtThree.getText().toString());
                break;
            case R.id.txt_four:
                validatePin(txtFour.getText().toString());
                break;
            case R.id.txt_five:
                validatePin(txtFive.getText().toString());
                break;
            case R.id.txt_six:
                validatePin(txtSix.getText().toString());
                break;
            case R.id.txt_seven:
                validatePin(txtSeven.getText().toString());
                break;
            case R.id.txt_eight:
                validatePin(txtEight.getText().toString());
                break;
            case R.id.txt_nine:
                validatePin(txtNine.getText().toString());
                break;
            case R.id.txt_zero:
                validatePin(txtZero.getText().toString());
                break;
            case R.id.txt_back:
                performBack();
                break;
            case R.id.sign_up_one_sign_up_back:
                onBackPressed();
                break;
        }
    }

    public void validatePin(String numberString) {
        try {
            if (strPin.length() >= 4) {
                Toast.makeText(this, "Your PIN is 4 digit only.", Toast.LENGTH_SHORT).show();
            } else {
                strPin = strPin + numberString;
                Toast.makeText(this, strPin, Toast.LENGTH_SHORT).show();
                if (strPin.length() == 1) {
                    imagePinOne.setImageResource(R.drawable.ic_selected_dot);
                }
                if (strPin.length() == 2) {
                    imagePinTwo.setImageResource(R.drawable.ic_selected_dot);
                }
                if (strPin.length() == 3) {
                    imagePinThree.setImageResource(R.drawable.ic_selected_dot);
                }
                if (strPin.length() == 4) {
                    imagePinFour.setImageResource(R.drawable.ic_selected_dot);
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String removeLastCharacter(String s) {
        try {
            if (s == null || s.length() == 0) {
                return s;
            }
            return s.substring(0, s.length() - 1);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public void performBack() {
        try {
            if (strPin.length() == 1) {
                imagePinOne.setImageResource(R.drawable.ic_default_dot);
            }
            if (strPin.length() == 2) {
                imagePinTwo.setImageResource(R.drawable.ic_default_dot);
            }
            if (strPin.length() == 3) {
                imagePinThree.setImageResource(R.drawable.ic_default_dot);
            }
            if (strPin.length() == 4) {
                imagePinFour.setImageResource(R.drawable.ic_default_dot);
            }
            strPin = removeLastCharacter(strPin);
            Toast.makeText(this, strPin, Toast.LENGTH_SHORT).show();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goTo(Class targetClass) {
        try {
            Intent intent = new Intent(SignUpThree.this, targetClass);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}