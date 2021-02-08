package com.example.stc1005.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.stc1005.MainActivity;
import com.example.stc1005.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class AuthDialog extends BottomSheetDialog {
    private Context mContext;
    private Button btn_confirmregister;
    private OnAuthListner onAuthListner;

    public void setOnAuthListner(OnAuthListner onAuthListner) {
        this.onAuthListner = onAuthListner;


    }

    public AuthDialog(@NonNull Context context, int theme) {
        super( context, theme );
        this.mContext = mContext;
    }

    public AuthDialog(@NonNull Context context, boolean cancelable, OnCancelListener cancelListener, Context mContext) {
        super( context, cancelable, cancelListener );
        this.mContext = mContext;
    }


    public AuthDialog(@NonNull Context context) {
        super( context );
        mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.dialog_auth );
        btn_confirmregister = (Button) findViewById( R.id.btn_confirmregister );
        btn_confirmregister.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onAuthListner != null){
                    onAuthListner.auth( 1 );
                }
                Toast.makeText( mContext,"회원가입이 완료되었습니다",Toast.LENGTH_SHORT ).show();

            }
        } );
    }
    public interface OnAuthListner{

        void auth(int k);
    }
}



