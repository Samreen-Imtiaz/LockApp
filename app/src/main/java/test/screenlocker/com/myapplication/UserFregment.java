package test.screenlocker.com.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserFregment extends Fragment {
    private static final String STARTING_TEXT = "Four Buttons Bottom Navigation";
    private EditText etEmailAddrss;
    private EditText etPhoneNumber;
    private Button btnSubmit, btnclear;
    SharedPreferences pref;
    public static final String mypreference = "mypref";
   public static final String Number = "numberKey";
    public static final String Email = "emailKey";


    public UserFregment() {
    }

    public static UserFregment newInstance() {
        Bundle args = new Bundle();
        UserFregment sampleFragment = new UserFregment();
        sampleFragment.setArguments(args);
        return sampleFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);


        ////////////////////////////////////////////////////////////
    /*    pref = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
        if (pref.contains(Number)) {
            etPhoneNumber.setText(pref.getString(Number, ""));
        }
        if (pref.contains(Email)) {
            etEmailAddrss.setText(pref.getString(Email, ""));

        }*/
        ////////////////////////////////////////////////////////////


        etEmailAddrss= (EditText) view.findViewById(R.id.editText5);
        etEmailAddrss.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                Validate_profile.isEmailAddress(etEmailAddrss, true);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });

        etPhoneNumber= (EditText) view.findViewById(R.id.editText4);
        etPhoneNumber.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                Validate_profile.isPhoneNumber(etPhoneNumber, false);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });

        btnclear = (Button) view.findViewById(R.id.button3);
        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etEmailAddrss.setText("");
                etPhoneNumber.setText("");
            }
        });


        btnSubmit = (Button) view.findViewById(R.id.button2);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                Validation class will check the error and display the error on respective fields
                but it won't resist the form submission, so we need to check again before submit
                 */

                if ( checkValidation () )
                {
                    ////////////////////////////////////////////////////////
                 /*  String n = etPhoneNumber.getText().toString();
                    String e = etEmailAddrss.getText().toString();
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString(Number, n);
                    editor.putString(Email, e);
                    editor.commit();*/
                    //////////////////////////////////////
                    submitForm();
                }
                else
                    Toast.makeText(getActivity(), "Please fill the fields properly!", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }

    private void submitForm() {
        // Submit your form here. your form is valid
        //  Toast.makeText(this, "Profile Created!", Toast.LENGTH_LONG).show();
        Toast.makeText(getActivity(), "Profile Created!", Toast.LENGTH_SHORT).show();
    }

    private boolean checkValidation() {
        boolean ret = true;

        if (!Validate_profile.isEmailAddress(etEmailAddrss, true)) ret = false;
        if (!Validate_profile.isPhoneNumber(etPhoneNumber, true)) ret = false;

        return ret;
    }}