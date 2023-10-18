package com.example.dicegame1;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {


    public static final int REQUEST_CODE_MAIN=100;
    public static final int REQUEST_CODE_SIGNUP=101;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button button=findViewById(R.id.button);


        Button button2=findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),signup.class);
                startActivityForResult(intent,REQUEST_CODE_SIGNUP);

            }
        });

    }


    //id가 button 인 Sign in 버튼의 onClick에 login을 써줌.
//로그인 함수
    public void login(View v){
        EditText editText=findViewById(R.id.editText);
        EditText editText2=findViewById(R.id.editText2);


//회원가입창에서 받은 데이터를 여기에 넘겨줌
        Intent receiveIntent=getIntent();
        String id=receiveIntent.getStringExtra("userid");
        String pw=receiveIntent.getStringExtra("userpw");
        String name=receiveIntent.getStringExtra("username");

        String userid=editText.getText().toString();
        String userpw=editText2.getText().toString();

//아이디 비밀번호 일치일때는 메인 화면에 진입. 불일치시 토스트 메시지.
        if(userid.equals(id)){
            if(userpw.equals(pw)){
                Log.d("Successful Login:","id="+userid+",  pw="+userpw);
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);

                Toast.makeText(this,name+"님 안녕하세요.",Toast.LENGTH_SHORT).show();
                startActivityForResult(intent,REQUEST_CODE_MAIN);
            }
            else{
                Toast.makeText(getApplicationContext(),"아이디 혹은 비밀번호가 일치하지 않습니다",Toast.LENGTH_SHORT).show();
            }

        }
        else{
            Toast.makeText(getApplicationContext(),"아이디 혹은 비밀번호가 일치하지 않습니다",Toast.LENGTH_SHORT).show();
        }

    }


}