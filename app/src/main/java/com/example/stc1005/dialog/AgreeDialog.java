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

public class AgreeDialog extends BottomSheetDialog {
    //1.필드선언
    private Context mContext;
    private Button buttonShare;
    private OnAgreeListner onAgreeListner;
    //여기서 컨트롤 o / alt insert
    //이거 생성자 - AgreeDialog 클래스를 만들었으니까 생성자 필요
//2.생성자

    public void setOnAgreeListner(OnAgreeListner onAgreeListner){
        this.onAgreeListner = onAgreeListner;
    }
    public AgreeDialog(@NonNull Context context, int theme) {
        super( context, theme );
        this.mContext = mContext;
    }

    public AgreeDialog(@NonNull Context context, boolean cancelable, OnCancelListener cancelListener, Context mContext) {
        super( context, cancelable, cancelListener );
        this.mContext = mContext;
    }


    public AgreeDialog(@NonNull Context context) {
        super( context );
        mContext = context;
    }

    //3. 메서드
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_agree );
        buttonShare = findViewById( R.id.buttonShare );
        buttonShare.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onAgreeListner != null){
                    onAgreeListner.agree(1);
                }
                Toast.makeText( mContext, "동의하셨습니다", Toast.LENGTH_SHORT ).show();


            }
        } );
    }

     public interface OnAgreeListner{
        void agree(int i);
    }
}

