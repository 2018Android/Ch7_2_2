package com.example.admin.ch7_2_2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = (TextView) findViewById(R.id.txv_result); //找到txv_result元件，指定給output
        LinearLayout layout = (LinearLayout)findViewById(R.id.linear); //找到linear元件，指定給layout
        registerForContextMenu(layout); //註冊ContextMenu
    }

    public  void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("選擇按鈕的背景顏色"); //設定menu的title
        getMenuInflater().inflate(R.menu.contextmenu, menu);
    }

    public  boolean onContextItemSelected(MenuItem item){
        Button btn = (Button) findViewById(R.id.button); //找到button元件，指定給btn
        switch (item.getItemId()){
            case R.id.cmenu_red: //選擇紅色，則按鈕顏色變為紅色
                btn.setBackgroundColor(Color.RED);
                break;
            case R.id.cmenu_yellow: //選擇黃色，則按鈕顏色變為黃色
                btn.setBackgroundColor(Color.YELLOW);
                break;
            case R.id.cmenu_green: //選擇綠色，則按鈕顏色變為綠色
                btn.setBackgroundColor(Color.GREEN);
                break;
        }
        return super.onContextItemSelected(item);
    }
    //將選項選單綁定至畫面中
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    //處理工具列選單的選項
    public boolean onOptionsItemSelected(MenuItem item){
        int tmp;
        double result;
        EditText txtTemp = (EditText) findViewById(R.id.edt_value); //找到edt_value元件，指定給txtTemp
        Button btn = (Button) findViewById(R.id.button); //找到button元件，指定給btn
        switch (item.getItemId()){
            case R.id.toF: //轉華氏溫度
                tmp = Integer.parseInt(txtTemp.getText().toString()); //將整數轉換成文字
                result = (9.0*tmp)/5.0+32.0; //攝氏轉華氏的公式
                output.setText("華氏溫度："+result);
                break;
            case R.id.toC: //轉攝氏溫度
                tmp = Integer.parseInt(txtTemp.getText().toString()); //將整數轉換成文字
                result = (5.0/9.0)*(tmp-32.0); //華氏轉攝氏的公式
                output.setText("攝氏溫度："+result);
                break;
            case R.id.subMenu: //點選子選單，output顯示子選單
                output.setText("子選單");
                break;
            case R.id.subItem1: //點選子項目1，output顯示子項目1
                output.setText("子項目1");
                break;
            case R.id.subItem2: //點選子項目2，output顯示子項目2
                output.setText("子項目2");
                break;
            case R.id.menu_red: //點紅色的radiobutton，Button顯示相對應的顏色-紅色
                if(item.isChecked()) {
                    item.setChecked(false);
                }else {
                    item.setChecked(true);
                }
                btn.setBackgroundColor(Color.RED);
                return true;
            case R.id.menu_yellow: //點黃色的radiobutton，Button顯示相對應的顏色-黃色
                if(item.isChecked()) {
                    item.setChecked(false);
                }else {
                    item.setChecked(true);
                }
                btn.setBackgroundColor(Color.YELLOW);
                return true;
            case R.id.menu_green: //點綠色的radiobutton，Button顯示相對應的顏色-綠色
                if(item.isChecked()) {
                    item.setChecked(false);
                }else {
                    item.setChecked(true);
                }
                btn.setBackgroundColor(Color.GREEN);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
