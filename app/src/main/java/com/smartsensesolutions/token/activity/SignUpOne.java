package com.smartsensesolutions.token.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.smartsensesolutions.token.R;
import com.smartsensesolutions.token.config.ConfigCommonClass;

@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
public class SignUpOne extends AppCompatActivity implements View.OnClickListener {

    private TextView txtContinue, txtEmailError, txtPasswordError, txtRePasswordError, actionBack;
    private EditText edEmail, edPassword, edRePassword;
    private ImageView imageIndicatorOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_one);

        initializeControls();
    }


    public void initializeControls() {
        txtContinue = (TextView) findViewById(R.id.txt_sign_up_continue);
        edEmail = (EditText) findViewById(R.id.ed_email);
        edPassword = (EditText) findViewById(R.id.ed_password);
        edRePassword = (EditText) findViewById(R.id.ed_repeat_password);
        txtEmailError = (TextView) findViewById(R.id.txt_email_error);
        txtPasswordError = (TextView) findViewById(R.id.txt_password_error);
        txtRePasswordError = (TextView) findViewById(R.id.txt_re_password_error);
        imageIndicatorOne = (ImageView) findViewById(R.id.img_indicator_one);
        imageIndicatorOne.setImageResource(R.drawable.ic_selected_dot);
        actionBack = (TextView) findViewById(R.id.sign_up_one_sign_up_back);

        actionBack.setOnClickListener(this);
        txtContinue.setOnClickListener(this);


        edEmail.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                hideErrorText(txtEmailError);
                try {
                    if (android.util.Patterns.EMAIL_ADDRESS.matcher(ConfigCommonClass.getEditTextValue(edEmail).trim()).matches()) {
                        edEmail.setBackground(getResources().getDrawable(R.drawable.edittext_selected_border));
                        edEmail.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_done, 0);
                    } else {
                        edEmail.setBackground(getResources().getDrawable(R.drawable.edittext_border));
                        edEmail.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }

                    makeContinueButtonEnable();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        edPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                hideErrorText(txtPasswordError);
                try {
                    if (!ConfigCommonClass.getEditTextValue(edPassword).isEmpty()) {
                        edPassword.setBackground(getResources().getDrawable(R.drawable.edittext_selected_border));
                        edPassword.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_done, 0);
                    } else {
                        edPassword.setBackground(getResources().getDrawable(R.drawable.edittext_border));
                        edPassword.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }

                    makeContinueButtonEnable();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        edRePassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                hideErrorText(txtRePasswordError);
                try {
                    if (comparePassword(ConfigCommonClass.getEditTextValue(edPassword), ConfigCommonClass.getEditTextValue(edRePassword))) {
                        edRePassword.setBackground(getResources().getDrawable(R.drawable.edittext_selected_border));
                        edRePassword.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_done, 0);
                    } else {
                        edRePassword.setBackground(getResources().getDrawable(R.drawable.edittext_border));
                        edRePassword.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    makeContinueButtonEnable();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }

    public void makeContinueButtonEnable() {
        try {
            if (!ConfigCommonClass.getEditTextValue(edEmail).trim().isEmpty()
                    && !ConfigCommonClass.getEditTextValue(edPassword).isEmpty()
                    && !ConfigCommonClass.getEditTextValue(edRePassword).isEmpty()
                    && android.util.Patterns.EMAIL_ADDRESS.matcher(ConfigCommonClass.getEditTextValue(edEmail).trim()).matches()
                    && comparePassword(ConfigCommonClass.getEditTextValue(edPassword), ConfigCommonClass.getEditTextValue(edRePassword))) {
                txtContinue.setBackground(getResources().getDrawable(R.drawable.continue_orange_border));
            } else {
                txtContinue.setBackground(getResources().getDrawable(R.drawable.continue_border));
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
                validateSingUp();
                break;
            case R.id.sign_up_one_sign_up_back:
                onBackPressed();
                break;
        }
    }

    public void validateSingUp() {
        try {
            if (!ConfigCommonClass.getEditTextValue(edEmail).trim().isEmpty()
                    && !ConfigCommonClass.getEditTextValue(edPassword).isEmpty()
                    && !ConfigCommonClass.getEditTextValue(edRePassword).isEmpty()
                    && android.util.Patterns.EMAIL_ADDRESS.matcher(ConfigCommonClass.getEditTextValue(edEmail).trim()).matches()
                    && comparePassword(ConfigCommonClass.getEditTextValue(edPassword), ConfigCommonClass.getEditTextValue(edRePassword))) {
                goTo(SignUpTwo.class);
            } else {
                if (ConfigCommonClass.getEditTextValue(edEmail).trim().isEmpty()) {
                    popUpError(txtEmailError, getString(R.string.email_empty_error));
                } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(ConfigCommonClass.getEditTextValue(edEmail).trim()).matches()) {
                    popUpError(txtEmailError, getString(R.string.email_valid_error));
                }
                if (ConfigCommonClass.getEditTextValue(edPassword).isEmpty()) {
                    popUpError(txtPasswordError, getString(R.string.password_empty_error));
                }
                if (ConfigCommonClass.getEditTextValue(edRePassword).isEmpty()) {
                    popUpError(txtRePasswordError, getString(R.string.re_password_empty_error));
                }
                if (!comparePassword(ConfigCommonClass.getEditTextValue(edPassword), ConfigCommonClass.getEditTextValue(edRePassword))) {
                    popUpError(txtRePasswordError, getString(R.string.password_match_error));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void popUpError(TextView textView, String error_text) {
        try {
            textView.setVisibility(View.VISIBLE);
            textView.setText(error_text);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void hideErrorText(TextView textView) {
        try {
            textView.setVisibility(View.GONE);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean comparePassword(String password, String repeatPassword) {
        try {
            if (password.equals(repeatPassword)) {
                return true;
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void goTo(Class targetClass) {
        try {
            Intent intent = new Intent(SignUpOne.this, targetClass);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
