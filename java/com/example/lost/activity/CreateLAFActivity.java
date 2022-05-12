package com.example.lost.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.example.lost.R;
import com.example.lost.entity.LostAndFound;
import com.example.lost.sqlite.DAOService;
import com.example.lost.utils.ToastUtils;
import com.example.lost.utils.Utils;
import com.google.android.material.textfield.TextInputLayout;

public class CreateLAFActivity extends MyBaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_botany);
        
        findViewById(R.id.save_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str1 = ((EditText) findViewById(R.id.edit_1)).getText().toString().trim();
                String str2 = ((EditText) findViewById(R.id.edit_2)).getText().toString().trim();
                String str3 = ((EditText) findViewById(R.id.edit_3)).getText().toString().trim();
                String str4 = ((EditText) findViewById(R.id.edit_4)).getText().toString().trim();
                String str5 = ((EditText) findViewById(R.id.edit_5)).getText().toString().trim();
                if (TextUtils.isEmpty(str1) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)
                || TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5) ) {
                    ToastUtils.showShortToast(getApplicationContext(), "info is empty");
                } else {
                    // 插入失物信息
                    LostAndFound botany = new LostAndFound();
                    botany.setName(str1);
                    botany.setPhone(str2);
                    botany.setDesc(str3);
                    botany.setDate(str4);
                    botany.setLocation(str5);
                    DAOService.getInstance().insertHealthInfo(botany);
                    // 社团关系表里加入一条人员 就是创建者
                    ToastUtils.showShortToast(getApplicationContext(), "insert success");
                    setResult(-1);
                    finish();
                }
            }
        });
    }
}
