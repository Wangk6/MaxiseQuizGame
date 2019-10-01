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

import com.example.maxiselogin.R;

public class AccountLogin extends Fragment {
    Button btnLogin;
    EditText loginEmail, loginPassword;
    ImageView facebookLogin, googleLogin;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login_screen,container,false);
        btnLogin = view.findViewById(R.id.btnLogin);
        loginEmail = view.findViewById(R.id.editLoginEmail);
        loginPassword = view.findViewById(R.id.editLoginPassword);
        facebookLogin = view.findViewById(R.id.loginFB);
        googleLogin = view.findViewById(R.id.loginGoogle);

        //Facebook Login is clicked
        facebookLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                facebookSignInClick(view);
            }
        });
        //Google Login is clicked
        googleLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                googleSignInClick(view);
            }
        });

        //Login Button is clicked
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Check for not empty
                //Check for user account - Not implemented yet
                //Check for password - Not implemented yet
                String emailText = loginEmail.getText().toString().trim();
                String passText = loginPassword.getText().toString().trim();
                if(passText.equals("") && emailText.equals("")){
                    Toast.makeText(getActivity(), "Empty Fields", Toast.LENGTH_SHORT).show();
                    loginEmail.setError("Empty");
                    loginPassword.setError("Empty");
                }
                else if(emailText.equals("")){
                    Toast.makeText(getActivity(), "Empty Fields", Toast.LENGTH_SHORT).show();
                    loginEmail.setError("Empty");
                }
                else if(passText.equals("")){
                    Toast.makeText(getActivity(), "Empty Fields", Toast.LENGTH_SHORT).show();
                    loginPassword.setError("Empty");
                }
                else{
                    //Check for existing user
                        //Check for matching password
                            //Log in and switch activity
                    Toast.makeText(getActivity(), "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getActivity(), empty_loggedin_activity.class);
                    startActivity(i);
                }
            }
        });
        return view;
    }


    //When user clicks register check for values to pass into login
    public void updateText(String type, String msg){
        if(type == "KEY_EMAIL"){
            loginEmail.getText().clear();
            loginEmail.setText(msg);
        }
        else if(type == "KEY_PASSWORD"){
            loginPassword.getText().clear();
            loginPassword.setText(msg);
        }
    }

    public void facebookSignInClick(View view) {
        Toast.makeText(getActivity(), "Facebook Login", Toast.LENGTH_SHORT).show();
    }
    public void googleSignInClick(View view) {
        Toast.makeText(getActivity(), "Google Login", Toast.LENGTH_SHORT).show();
    }

}
