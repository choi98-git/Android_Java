package com.example.shop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    ListView  myview;
    ArrayList<MyItem>  mylist;
    MyAdapter  adapter;

    class MyItem {
        int icon;
        String  text;
        int  price;

        MyItem(int ic, String te, int pr) {
            icon = ic;
            text = te;
            price = pr;
        }
    }

    class MyAdapter extends BaseAdapter {
        Context  ctx;
        MyAdapter(Context c) {
            ctx = c;
        }
        @Override
        public int getCount() {
            return  mylist.size();
        }
        @Override
        public Object getItem(int position) {
            return  mylist.get(position);
        }
        @Override
        public long getItemId(int position) {
            return  position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView img;
            TextView  tv;
            EditText  pr;

            if(convertView == null){
                convertView = ((LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE)).inflate(R.layout.myitem,
                        parent, false);
            }

            img = (ImageView)convertView.findViewById(R.id.myimage);
            tv = (TextView)convertView.findViewById(R.id.mytext);
            pr = (EditText)convertView.findViewById(R.id.myprice);


            img.setImageResource(mylist.get(position).icon);
            tv.setText(mylist.get(position).text);
            pr.setText("가격: " + mylist.get(position).price );

            return convertView;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mylist = new ArrayList<MyItem>();
        MyItem  item;
        item = new MyItem(R.drawable.ic_baseline_tv_24, "TV", 750000);
        mylist.add(item);
        item = new MyItem(R.drawable.ic_baseline_phone_android_24, "스마트폰", 850000);
        mylist.add(item);
        item = new MyItem(R.drawable.ic_baseline_mouse_24, "마우스", 35000);
        mylist.add(item);

        adapter = new MyAdapter(this);
        myview = (ListView) findViewById(R.id.listview);
        myview.setAdapter(adapter);
    }
}
