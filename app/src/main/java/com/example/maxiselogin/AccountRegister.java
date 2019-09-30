package com.example.maxiselogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountRegister extends Fragment {
    Button btnRegister;
    EditText email, password, fname, lname, dob;
    ImageView facebookSignUp, googleSignUp;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registration_screen,container,false);
        btnRegister = view.findViewById(R.id.btnRegister);
        email = view.findViewById(R.id.editEmail);
        password = view.findViewById(R.id.editPassword);
        fname = view.findViewById(R.id.editFirstName);
        lname = view.findViewById(R.id.editlastName);
        dob = view.findViewById(R.id.editDateOfBirth);
        facebookSignUp = view.findViewById(R.id.signUpFB);
        googleSignUp = view.findViewById(R.id.signUpGoogle);

        facebookSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                facebookSignInClick(view);
            }
        });

        googleSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                googleSignInClick(view);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Check for not empty
                //Check for user account - Not implemented yet
                //Check for password - Not implemented yet
                String emailText = email.getText().toString().trim();
                String passText = password.getText().toString().trim();
                String fText = fname.getText().toString().trim();
                String lText = lname.getText().toString().trim();
                String dobText = dob.getText().toString().trim();
                //If any fields are empty, display error
                if(emailText.equals("") || passText.equals("") || fText.equals("") || lText.equals("") || dobText.equals("")){
                    if(emailText.equals("")){
                        Toast.makeText(getActivity(), "Empty Fields", Toast.LENGTH_SHORT).show();
                        email.setError("Empty");
                    }
                    if(passText.equals("")){
                        Toast.makeText(getActivity(), "Empty Fields", Toast.LENGTH_SHORT).show();
                        password.setError("Empty");
                    }
                    if(fText.equals("")){
                        Toast.makeText(getActivity(), "Empty Fields", Toast.LENGTH_SHORT).show();
                        fname.setError("Empty");
                    }
                    if(lText.equals("")){
                        Toast.makeText(getActivity(), "Empty Fields", Toast.LENGTH_SHORT).show();
                        lname.setError("Empty");
                    }
                    if(dobText.equals("")){
                        Toast.makeText(getActivity(), "Empty Fields", Toast.LENGTH_SHORT).show();
                        dob.setError("Empty");
                    }
                }
                else{
                    boolean errors = false;
                    //Check Date of birth is correct
                    if(isThisDateValid(dobText, "dd/MM/yyyy") == false) {
                        dob.setError("Invalid Format (dd/mm/yyyy)");
                        errors = true;
                    }
                    if(fText.length() < 3 || fText.length() > 30){
                        fname.setError("First name must be greater than 3 and less than 30 characters");
                        errors = true;
                    }
                    if(lText.length() < 1 || lText.length() > 30){
                        lname.setError("Last name must be greater than 1 and less than 30 characters");
                        errors = true;
                    }
                    if(isValidEmailAddress(emailText) == false){
                        email.setError("Invalid Format (example@mail.com)");
                        errors = true;
                    }
                    if(passText.length() < 8){
                        password.setError("Password must be > 8 characters");
                        errors = true;
                    }

                    if(errors == false){
                        Toast.makeText(getActivity(), "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getActivity(), LoginScreenActivity.class);
                        startActivity(i);
                    }

                }
            }
        });

        return view;
    }

    public boolean isThisDateValid(String dateToValidate, String dateFromat){

        if(dateToValidate == null){
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
        sdf.setLenient(false);

        try {

            //if not valid, it will throw ParseException
            Date date = sdf.parse(dateToValidate);
            System.out.println(date);

        } catch (ParseException e) {

            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean isValidEmailAddress(String email) {
        // Email Regex java
        String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";

        // static Pattern object, since pattern is fixed
        Pattern pattern;

        // non-static Matcher object because it's created from the input String
        Matcher matcher;

        // initialize the Pattern object
        pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);


        /**
         * This method validates the input email address with EMAIL_REGEX pattern
         *
         * @param email
         * @return boolean
         */
            matcher = pattern.matcher(email);
            if(matcher.matches() == true){
                return true;
            }else {
                return false;
            }
    }

    public void facebookSignInClick(View view) {
        Toast.makeText(getActivity(), "Facebook Signup", Toast.LENGTH_SHORT).show();
    }
    public void googleSignInClick(View view) {
        Toast.makeText(getActivity(), "Google Signup", Toast.LENGTH_SHORT).show();
    }
}
