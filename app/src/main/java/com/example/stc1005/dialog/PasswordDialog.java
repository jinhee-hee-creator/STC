package com.example.stc1005.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.stc1005.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class PasswordDialog extends BottomSheetDialog {
    private Context mContext;
    private Button register;
    private OnPasswordListner onPasswordListner;
  //  EditText e2, e3;

public void setOnPasswordListner(OnPasswordListner onPasswordListner){
    this.onPasswordListner = onPasswordListner;

}
    public PasswordDialog(@NonNull Context context, int theme) {
        super( context, theme );
        this.mContext = mContext;
    }

    public PasswordDialog(@NonNull Context context, boolean cancelable, OnCancelListener cancelListener, Context mContext) {
        super( context, cancelable, cancelListener );
        this.mContext = mContext;
    }


    public PasswordDialog(@NonNull Context context) {
        super( context );
        mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_password );

     //   e2 = findViewById( R.id.et_pass );
       // e3 = findViewById( R.id.et_cpass );
        register = findViewById( R.id.btn_register );
        register.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onPasswordListner != null){
                    onPasswordListner.password( 1 );
                }
                Toast.makeText( mContext, "비밀번호가 설정되었습니다", Toast.LENGTH_SHORT ).show();
            }
        } );
    }


    public interface OnPasswordListner{
        void password(int l);
    }
}
