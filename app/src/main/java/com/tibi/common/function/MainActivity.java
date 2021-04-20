package com.tibi.common.function;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tibi.common.function.lib.module.discount.MyDiscountActivity;
import com.tibi.common.function.lib.module.ticket.CollarTicketActivity;
import com.tibi.common.function.lib.util.UIHelper;

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
                UIHelper.toCollarTicket(MainActivity.this,"934543","prod_antubang");
            }
        });
        btnDiscount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIHelper.toMyDiscount(MainActivity.this,"934543","prod_antubang");
            }
        });
    }
}
