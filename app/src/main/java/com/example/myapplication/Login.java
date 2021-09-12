package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Login extends AppCompatActivity {
    EditText name,pass;
    Button login;
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^"+"(?=.*[@#$%^&+=])");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name = findViewById(R.id.edtname);
        pass = findViewById(R.id.edtpass);
        login = findViewById(R.id.btnLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkaAccount();
//                Intent intent = new Intent(getBaseContext(),MainActivity.class);
//                startActivity(intent);
//                Toast.makeText(getApplicationContext(),"Singin",Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(Login.this,MainActivity.class));
                startActivity(new Intent(Login.this,MainActivity.class));
            }

            private void checkaAccount() {
                String user = name.getText().toString();
                String password = pass.getText().toString();

                if(user.isEmpty() && password.isEmpty()){
                    Toast.makeText(Login.this,"mời bạn nhập thông tin",Toast.LENGTH_SHORT).show();
                }else if (user.length() >=8 && password.length() >=8){
                    Toast.makeText(Login.this,"đăng nhập thành công ",Toast.LENGTH_SHORT).show();
                }else if(user.length() <=8 && password.length() <=8){
                    Toast.makeText(Login.this," thông tin chưa đủ",Toast.LENGTH_SHORT).show();
                }else if(!PASSWORD_PATTERN.matcher(password).matches()){
                    Toast.makeText(Login.this," k đúng",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(Login.this," thành công",Toast.LENGTH_SHORT).show();

                }
            }
        });


    }
}