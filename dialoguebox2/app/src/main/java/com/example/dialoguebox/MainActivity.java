package com.example.dialoguebox;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button basic, hob, sex, soc, tel, ani, mult;
    View.OnClickListener cl;
    AlertDialog.Builder dlg;
    DialogInterface.OnClickListener yes,no, yes1,no1, yes2, no2, tcom, love;
    DialogInterface.OnMultiChoiceClickListener mcl;
    String[] tele, animal;
    int choice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tele = new String[4];
        tele[0] = "KT";
        tele[1] = "LG U+";
        tele[2] = "SKT";
        tele[3] = "기타";

        animal = new String[5];
        animal[0] = "강아지";
        animal[1] = "고양이";
        animal[2] = "닭";
        animal[3] = "도마뱀";
        animal[4] = "앵무새";

        basic = (Button) findViewById(R.id.basicdbox);
        hob = (Button) findViewById(R.id.hobby);
        sex = (Button) findViewById(R.id.sexdbox);
        soc = (Button) findViewById(R.id.soccer);
        tel = (Button) findViewById(R.id.telecom);
        ani = (Button) findViewById(R.id.animal);
        mult = (Button) findViewById(R.id.multiple);

        yes = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "당신은 남성이군요!",Toast.LENGTH_SHORT).show();
            }
        };

        no = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "당신은 여성이군요!",Toast.LENGTH_SHORT).show();
            }
        };

        yes1 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "당신은 축구를 좋아하시군요!",Toast.LENGTH_SHORT).show();
            }
        };

        no1 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "당신은 축구를 좋아하지 않으시군요!",Toast.LENGTH_SHORT).show();
            }
        };

        yes2 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "당신의 최종 선택은 " + animal[choice],Toast.LENGTH_SHORT).show();
            }
        };

        no2 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "최종 선택을 안 하셨네요!!",Toast.LENGTH_SHORT).show();
            }
        };

        tcom = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "당신의 통신사는 " + tele[which],Toast.LENGTH_SHORT).show();
            }
        };

        love = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                choice = which;
                Toast.makeText(getApplicationContext(), "당신이 가장 선호하는 반려동물은 " + animal[which],Toast.LENGTH_SHORT).show();
            }
        };

        mcl = new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                Toast.makeText(getApplicationContext(), "당신의 선택은 " + animal[which] + "최종 = " + isChecked,Toast.LENGTH_SHORT).show();
            }
        };

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.basicdbox:
                        dlg = new AlertDialog.Builder(MainActivity.this);
                        dlg.setTitle("공지합니다");
                        dlg.setMessage("이번 주 중간고사는 연기되었습니다.");
                        dlg.setIcon(R.mipmap.ic_launcher);
                        dlg.show();
                        break;

                    case R.id.hobby:
                        dlg = new AlertDialog.Builder(MainActivity.this);
                        dlg.setTitle("나의 취미");
                        dlg.setMessage("저의 취미는 음악 감상입니다.");
                        dlg.setIcon(R.mipmap.ic_launcher);
                        dlg.show();
                        break;

                    case R.id.sexdbox:
                        dlg = new AlertDialog.Builder(MainActivity.this);
                        dlg.setTitle("성별 판별");
                        dlg.setMessage("당신은 남성입니까?");
                        dlg.setIcon(R.mipmap.ic_launcher);
                        dlg.setPositiveButton("예", yes);
                        dlg.setNegativeButton("아니오",no);
                        dlg.show();
                        break;

                    case R.id.soccer:
                        dlg = new AlertDialog.Builder(MainActivity.this);
                        dlg.setTitle("축구 선호도");
                        dlg.setMessage("당신은 축구를 좋아합니까?");
                        dlg.setIcon(R.mipmap.ic_launcher);
                        dlg.setPositiveButton("예", yes1);
                        dlg.setNegativeButton("아니오",no1);
                        dlg.show();
                        break;

                    case R.id.telecom:
                        dlg = new AlertDialog.Builder(MainActivity.this);
                        dlg.setTitle("당신의 통신사는?");
                        dlg.setItems(tele,tcom);
                        dlg.setIcon(R.mipmap.ic_launcher);
                        dlg.show();
                        break;

                    case R.id.animal:
                        dlg = new AlertDialog.Builder(MainActivity.this);
                        dlg.setTitle("당신이 가장 선호하는 반려동물은?");
                        dlg.setSingleChoiceItems(animal, 0, love);
                        dlg.setPositiveButton("선택 완료", yes2);
                        dlg.setNegativeButton("미선택", no2);
                        dlg.setIcon(R.mipmap.ic_launcher);
                        dlg.show();
                        break;

                    case R.id.multiple:
                        dlg = new AlertDialog.Builder(MainActivity.this);
                        dlg.setTitle("당신이 좋아하는 동물은?");
                        boolean[] init;
                        init = new boolean[5];
                        init[0] = true;
                        init[1] = true;
                        init[2] = false;
                        init[3] = false;
                        init[4] = true;
                        dlg.setMultiChoiceItems(animal, init, mcl);
                        dlg.setPositiveButton("선택 완료", yes2);
                        dlg.setNegativeButton("미선택", no2);
                        dlg.setIcon(R.mipmap.ic_launcher);
                        dlg.show();
                        break;
                }

            }
        };
        basic.setOnClickListener(cl);
        hob.setOnClickListener(cl);
        sex.setOnClickListener(cl);
        soc.setOnClickListener(cl);
        tel.setOnClickListener(cl);
        ani.setOnClickListener(cl);
        mult.setOnClickListener(cl);
    }
}