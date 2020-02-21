package com.example.caculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.model.caculate;
import  com.example.model.history;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText expresion;
    TextView view_result;
    history history=new history();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expresion=findViewById(R.id.expression);
        expresion.setCursorVisible(false);
        view_result=findViewById(R.id.view_result);
        findViewById(R.id.zero).setOnClickListener(this);
        findViewById(R.id.one).setOnClickListener(this);
        findViewById(R.id.two).setOnClickListener(this);
        findViewById(R.id.three).setOnClickListener(this);
        findViewById(R.id.four).setOnClickListener(this);
        findViewById(R.id.five).setOnClickListener(this);
        findViewById(R.id.six).setOnClickListener(this);
        findViewById(R.id.seven).setOnClickListener(this);
        findViewById(R.id.eight).setOnClickListener(this);
        findViewById(R.id.nine).setOnClickListener(this);
        findViewById(R.id.sqrt).setOnClickListener(this);
        findViewById(R.id.leftBracket).setOnClickListener(this);
        findViewById(R.id.rightBracket).setOnClickListener(this);
        findViewById(R.id.multiply).setOnClickListener(this);
        findViewById(R.id.divide).setOnClickListener(this);
        findViewById(R.id.add).setOnClickListener(this);
        findViewById(R.id.sub).setOnClickListener(this);
        findViewById(R.id.clear_all).setOnClickListener(this);
        findViewById(R.id.percent).setOnClickListener(this);
        findViewById(R.id.pi).setOnClickListener(this);
        findViewById(R.id.cancel).setOnClickListener(this);
        findViewById(R.id.square).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expresion.setText(expresion.getText().toString().concat("^2"));
            }
        });
        findViewById(R.id.reversed_sign).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (history.get()!=Double.MAX_VALUE && expresion.getText().toString().equals("")){
                    expresion.setText(""+(-history.get()));
                }
            }
        });
        findViewById(R.id.ans).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=expresion.getText().toString();
                if (!s.equals(""))
                if (s.charAt(s.length()-1)>='0' && s.charAt(s.length()-1)<='9') s="";
                if (history.get().isNaN()) expresion.setText(s);
                else expresion.setText(s+history.get());
            }
        });
        findViewById(R.id.point).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expresion.setText(expresion.getText().toString().concat("."));
            }
        });
        findViewById(R.id.result).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caculate c=new caculate();
                Double r=c.tinh_expression(expresion.getText().toString());
                if (r!=Double.MAX_VALUE) {
                    expresion.setText("");
                    if (Math.abs(r-Math.round(r))==0) view_result.setText(Math.round(r)+"");
                    else view_result.setText(r + "");
                    history.add(r);
                }
            }
        });
        findViewById(R.id.backspace).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=expresion.getText().toString();
                Log.e("a",s);
                if (!s.equals("")){
                    s=s.substring(0,s.length()-1);
                    expresion.setText(s);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        int view=v.getId();
        String textValue=expresion.getText().toString();
        switch (view){
            case R.id.zero:
                expresion.setText(textValue.concat("0"));break;
            case R.id.one:
                expresion.setText(textValue.concat("1"));break;
            case R.id.two:
                expresion.setText(textValue.concat("2"));break;
            case R.id.three:
                expresion.setText(textValue.concat("3"));break;
            case  R.id.four:
                expresion.setText(textValue.concat("4"));break;
            case R.id.five:
                expresion.setText(textValue.concat("5"));break;
            case R.id.six:
                expresion.setText(textValue.concat("6"));break;
            case R.id.seven:
                expresion.setText(textValue.concat("7"));break;
            case R.id.eight:
                expresion.setText(textValue.concat("8"));break;
            case R.id.nine:
                expresion.setText(textValue.concat("9"));break;
            case R.id.sqrt:
                expresion.setText(textValue.concat("√"));break;
            case R.id.leftBracket:
                expresion.setText(textValue.concat("("));break;
            case R.id.rightBracket:
                expresion.setText(textValue.concat(")"));break;
            case R.id.multiply:
                expresion.setText(textValue.concat("*"));break;
            case R.id.divide:
                expresion.setText(textValue.concat("/"));break;
            case R.id.add:
                expresion.setText(textValue.concat("+"));break;
            case R.id.sub:
                expresion.setText(textValue.concat("-"));break;
            case R.id.clear_all:
                expresion.setText("");view_result.setText("");break;
            case R.id.percent:
                expresion.setText(textValue.concat("%"));break;
            case R.id.pi:
                expresion.setText(textValue.concat("π"));break;
            case R.id.cancel:
                System.exit(0);break;
        }
    }
}
