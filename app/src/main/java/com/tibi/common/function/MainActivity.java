package com.tibi.common.function;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tibi.common.function.lib.util.UIModuleHelper;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @butterknife.BindView(R.id.btn_bug)
    Button btnBug;
    @butterknife.BindView(R.id.btn_discount)
    Button btnDiscount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        butterknife.ButterKnife.bind(this);
        btnBug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIModuleHelper.toCollarTicket(MainActivity.this,"938292","prod_antubang");
            }
        });
        btnDiscount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIModuleHelper.toMyDiscount(MainActivity.this,"938213","prod_antubang");
            }
        });
    }
}
