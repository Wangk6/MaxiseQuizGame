package com.example.maxiselogin;

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

        facebookLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                facebookSignInClick(view);
            }
        });

        googleLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                googleSignInClick(view);
            }
        });

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
                    Toast.makeText(getActivity(), "Login Successful", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

    public void facebookSignInClick(View view) {
        Toast.makeText(getActivity(), "Facebook Login", Toast.LENGTH_SHORT).show();
    }
    public void googleSignInClick(View view) {
        Toast.makeText(getActivity(), "Google Login", Toast.LENGTH_SHORT).show();
    }

}
