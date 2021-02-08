package com.example.stc1005;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.stc1005.dialog.AgreeDialog;
import com.example.stc1005.dialog.AuthDialog;
import com.example.stc1005.dialog.PasswordDialog;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MainActivity extends AppCompatActivity {

    Button buttonShow;
    Button buttonShare;
    AgreeDialog agreeDialog;
    PasswordDialog passwordDialog;
    AuthDialog authDialog;
   // BottomSheetDialog bottomSheetDialog2;
    //BottomSheetDialog bottomSheetDialog3;

    // buttonshow --> showDialog1
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        buttonShow = (Button) findViewById( R.id.buttonShow );

        buttonShow.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog1();
            }
        } );
    }

    /////// 함수 showDialog1함수 설명 ///////
    public void showDialog1() {
//bottomSheetDialog
        agreeDialog = new AgreeDialog( MainActivity.this);


        //showDialog1함수에서 1.첫번째 다이얼로그가 inflate되고
//        View bottomSheetView = LayoutInflater.from( getApplicationContext() )
//                .inflate( R.layout.activity_agree,
//                        (RelativeLayout) findViewById( R.id.bottomSheetContainer )
//                );
//
//
//        //showDialog1함수에서 2. buttonShare를 눌렀을때 일어나는 일 - 토스트 메시지 + 다이올로그 사라지기 + 두번째 다이얼로그 나오기
//        bottomSheetView.findViewById( R.id.buttonShare ).setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText( getApplicationContext(), "동의하셨습니다", Toast.LENGTH_SHORT ).show();
//                //dissmissDialog함수는 아래에
//                dissmissDialog1();
//                //showDialog2함수 설명도 아래에
//                showDialog2();
//
//            }
//        } );
//        bottomSheetDialog.setContentView( bottomSheetView );
        //   BottomSheetBehavior.from(bottomSheetView).setState(BottomSheetBehavior.STATE_EXPANDED);
        agreeDialog.setOnAgreeListner( new AgreeDialog.OnAgreeListner() {
            @Override
            public void agree(int i) {
              dissmissDialog1();
              showDialog2();
//
            }
        } );
        agreeDialog.show();
    }

    public void showDialog2() {
        passwordDialog = new PasswordDialog(MainActivity.this);

//        bottomSheetDialog2 = new BottomSheetDialog( MainActivity.this, R.style.BottomSheetDialogTheme );
//
//        View bottomSheetView = LayoutInflater.from( getApplicationContext() )
//                .inflate( R.layout.activity_password,
//                        (RelativeLayout) findViewById( R.id.bottomSheetContainer_password )
//                );
//
//
//        bottomSheetView.findViewById( R.id.registergister ).setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText( MainActivity.this, "비밀번호가 설정되었습니다", Toast.LENGTH_SHORT ).show();
//
//                dissmissDialog2();
//                showDialog3();
//
//            }
//        } );
//        bottomSheetDialog2.setContentView( bottomSheetView );
        //   BottomSheetBehavior.from(bottomSheetView).setState(BottomSheetBehavior.STATE_EXPANDED);
       // bottomSheetDialog2.show();
        passwordDialog.setOnPasswordListner( new PasswordDialog.OnPasswordListner() {
            @Override
            public void password(int l) {
                dissmissDialog2();
                showDialog3();
            }
        } );
        passwordDialog.show();
    }

    public void showDialog3() {

        authDialog = new AuthDialog(MainActivity.this);
//        bottomSheetDialog3 = new BottomSheetDialog( MainActivity.this, R.style.BottomSheetDialogTheme );
//        View bottomSheetView = LayoutInflater.from( getApplicationContext() )
//                .inflate (R.layout.dialog_auth,
//                        (RelativeLayout) findViewById( R.id.bottomSheetContainer_auth )
//                );
//                bottomSheetView.findViewById( R.id.btn_register ).setOnClickListener( new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText( MainActivity.this,"회원가입이 완료되었습니다" ,Toast.LENGTH_SHORT).show();
//                        dissmissDialog3();
//                    }
//                } );
//                bottomSheetDialog3.setContentView( bottomSheetView );
//                bottomSheetDialog3.show();
        authDialog.setOnAuthListner( new AuthDialog.OnAuthListner() {
            @Override
            public void auth(int k) {
                dissmissDialog3();
            }
        } );
        authDialog.show();

    }

    public void dissmissDialog1() {
        if (agreeDialog != null && agreeDialog.isShowing()) {
            agreeDialog.dismiss();
        }

    }

    public void dissmissDialog2() {
        if (passwordDialog != null && passwordDialog.isShowing()) {
            passwordDialog.dismiss();
        }
    }

    public void dissmissDialog3() {
        if (authDialog != null && authDialog.isShowing()) {
            authDialog.dismiss();
        }
    }
//
//
}

//객체지향 : 함수를 만들어서 다른데서 불러와서 사용