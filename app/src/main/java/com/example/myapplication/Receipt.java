package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class Receipt extends AppCompatActivity {
    ListView lvhoadon;
    ImageView img2;
    TextView tv1;
    List<Product> products;
    int price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

        img2 = findViewById(R.id.img2);
        tv1 = findViewById(R.id.tv);
        lvhoadon = findViewById(R.id.lvHoadon);

        Intent intent = getIntent();
        products =(List<Product>) intent.getSerializableExtra("Pizza");

        for (int i = 0;i<products.size();i++){
            price += products.get(i).getGia();
        }
            tv1.setText(price+"$");
            AdapterProduct adapterProduct = new AdapterProduct(products);
            lvhoadon.setAdapter(adapterProduct);

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),MainActivity.class);
                startActivity(intent);
            }
        });

    }
}