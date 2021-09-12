package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView gio;
    ListView list;
    TextView tv;
    Button btnOrder;
    List<Product> products;
    List<Product> products1;
    Product product,product01,product02,product03,product04,product05;
    AdapterProduct adapterProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        products = new ArrayList<>();
        products1 = new ArrayList<>();
        gio = findViewById(R.id.gio);
        list = findViewById(R.id.list);
        tv = findViewById(R.id.tv1);
        btnOrder = findViewById(R.id.btnOrder);

        product = new Product("Pizza Panda",10);
        product01 = new Product("KFC Super",10);
        product02 = new Product("Bread Eggs",10);
        product03 = new Product("Coca Cola",10);
        product04 = new Product("Chicken super ",10);
        product05 = new Product("Cup Cake",10);

        products.add(product);
        products.add(product01);
        products.add(product02);
        products.add(product03);
        products.add(product04);
        products.add(product05);

        adapterProduct = new AdapterProduct(products);
        list.setAdapter(adapterProduct);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Product product = products.get(i);
                products1.add(product);
                tv.setText(product.getGia()+"");
            }
        });
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),Receipt.class);
                intent.putExtra("Pizza",(Serializable) products1);
                startActivity(intent);
                Toast.makeText(getBaseContext(),"cảm ơn bạn đã gọi món",Toast.LENGTH_SHORT).show();
                tv.setText("");
            }
        });
    }


}