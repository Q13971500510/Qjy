package com.example.myapplication;


import android.graphics.ColorSpace;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    private Fragment fragment1,fragment2,fragment3,fragment4;
    private LinearLayout linearLayout1,linearLayout2,linearLayout3,linearLayout4;
    private FragmentTransaction transaction;
    private ImageView img01,img02,img03,img04;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment1=new Fragment1();
        fragment2=new Fragment2();
        fragment3=new Fragment3();
        fragment4=new Fragment4();

        linearLayout1=findViewById(R.id.LinearLayout1);
        linearLayout2=findViewById(R.id.LinearLayout2);
        linearLayout3=findViewById(R.id.LinearLayout3);
        linearLayout4=findViewById(R.id.LinearLayout4);

        img01=findViewById(R.id.imageView1);
        img02=findViewById(R.id.imageView2);
        img03=findViewById(R.id.imageView3);
        img04=findViewById(R.id.imageView4);
        initFragment();
        linearLayout1.setOnClickListener(this::onClick);
        linearLayout2.setOnClickListener(this::onClick);
        linearLayout3.setOnClickListener(this::onClick);
        linearLayout4.setOnClickListener(this::onClick);
    }
    private void initFragment(){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.add(R.id.id_content, fragment1);
        transaction.add(R.id.id_content, fragment2);
        transaction.add(R.id.id_content, fragment3);
        transaction.add(R.id.id_content, fragment4);
        hideFragment(transaction);
        transaction.show(fragment1);
        transaction.commit();
    }
    public void onClick(View view){
        int i=0;
        switch (view.getId()){
            case R.id.LinearLayout1:
                showFragment(0);
                break;
            case R.id.LinearLayout2:
                showFragment(1);
                break;
            case R.id.LinearLayout3:
                showFragment(2);
                break;
            case R.id.LinearLayout4:
                showFragment(3);
                break;
            default:
                break;
        }
    }
    public void showFragment(int i){
        FragmentManager  fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        hideFragment(transaction);
        switch (i){
            case 0:
                transaction.show(fragment1);
                ResetImage();
                img01.setImageResource(R.drawable.weixin2);
                break;
            case 1:
                transaction.show(fragment2);
                ResetImage();
                img02.setImageResource(R.drawable.tongxunlu2);
                break;
            case 2:
                transaction.show(fragment3);
                ResetImage();
                img03.setImageResource(R.drawable.find2);
                break;
            case 3:
                transaction.show(fragment4);
                ResetImage();
                img04.setImageResource(R.drawable.my2);
                break;
            default:
                break;
        }
        transaction.commit();

    }
    private void hideFragment(FragmentTransaction transaction){
        transaction.hide(fragment1);
        transaction.hide(fragment2);
        transaction.hide(fragment3);
        transaction.hide(fragment4);
    }
    private void ResetImage(){
        img01.setImageResource(R.drawable.weixin);
        img02.setImageResource(R.drawable.tongxunlu);
        img03.setImageResource(R.drawable.find);
        img04.setImageResource(R.drawable.find);
    }
}