package com.example.alertdialog;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity
{
    private Button bt1,bt2,bt3,bt4,bt5,bt6,bt7;
    private AlertDialog dialog;
    private TextView textView;
    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text1);
        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        bt3 = (Button) findViewById(R.id.bt3);
        bt4 = (Button) findViewById(R.id.bt4);
        bt5 = (Button) findViewById(R.id.bt5);
        bt6 = (Button) findViewById(R.id.bt6);
        bt7 = (Button) findViewById(R.id.bt7);

        View.OnClickListener listener = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                switch (v.getId()){
                    case R.id.bt1:
                        dialog1();
                        break;
                    case R.id.bt2:
                        dialog2();
                        break;
                    case R.id.bt3:
                        dialog3();
                        break;
                    case R.id.bt4:
                        dialog4();
                        break;
                    case R.id.bt5:
                        dialog5();
                        break;
                    case R.id.bt6:
                        dialog6();
                        break;
                    case R.id.bt7:
                        dialog7();
                        break;
            }
        }


            private void dialog2() {
                dialog = new AlertDialog.Builder(MainActivity.this).create();
                dialog.setTitle("调查");
                dialog.setMessage("你平时忙吗?");
                dialog.setIcon(android.R.drawable.ic_dialog_info);
                DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String str = "";
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:
                                str = "平时很忙";
                                break;
                            case DialogInterface.BUTTON_NEGATIVE:
                                str = "平时轻松";
                                break;
                            case DialogInterface.BUTTON_NEUTRAL:
                                str = "平时一般";
                                break;
                        }
                        textView.setText(str);
                    }
                };
                dialog.setButton(DialogInterface.BUTTON_POSITIVE,"忙碌",listener);
                dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"不忙",listener);
                dialog.setButton(DialogInterface.BUTTON_NEUTRAL,"一般",listener);
                dialog.show();
            }
            private void dialog3() {
                dialog = new AlertDialog.Builder(MainActivity.this).create();
                dialog.setTitle("请输入");
                dialog.setMessage("你平时忙吗");
                dialog.setIcon(android.R.drawable.ic_dialog_info);
                final EditText editText = new EditText(MainActivity.this);
                dialog.setView(editText);
                DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        textView.setText("输入的是"+editText.getText().toString());
                    }
                };
                dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
                dialog.show();
            }
            private void dialog4() {
                final String item[] = new String[] {"北京","上海","广州"};
                final boolean bSelect[] = new boolean[item.length];
                DialogInterface.OnMultiChoiceClickListener mlistener = new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        bSelect[which] = isChecked;
                    }
                };
                builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMultiChoiceItems(item,null,mlistener);
                dialog = builder.create();
                dialog.setTitle("复选框");
                DialogInterface.OnClickListener listener =new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String str = "";
                        for(int i=0;i<bSelect.length;i++){
                            if(bSelect[i]){
                                str = str + "\n" +item[i];
                            }
                        }
                        textView.setText(str);
                    }
                };
                dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
                dialog.show();
            }
            private void dialog5() {
            final String item[] = new String[]{"北京","上海","广州"};
            final boolean bSelect[] = new boolean[item.length];
            DialogInterface.OnClickListener mlistener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    for (int i = 0;i<bSelect.length;i++){
                        bSelect[i] =false;
                        bSelect[which] =true;
                    }

                }
            };
            builder = new AlertDialog.Builder(MainActivity.this);
            builder.setSingleChoiceItems(item,-1,mlistener);
            dialog = builder.create();
            dialog.setTitle("单选框");
            DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String str = "";
                    for (int i = 0; i <bSelect.length;i++){
                        if (bSelect[i]){
                            str = str +"\n"+item[i];
                        }
                    }textView.setText(str);
                }
                ;                };
            dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
            dialog.show();
        }
            private void dialog6() {
                final String item[] = new String[]{"北京","上海","广州"};
                final boolean bSelect[] = new boolean[item.length];
                DialogInterface.OnClickListener mlistener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String str ="你选择了:"+item[which];
                        textView.setText(str);
                    }
                };
                builder = new AlertDialog.Builder(MainActivity.this);
                builder.setItems(item,mlistener);
                dialog = builder.create();
                dialog.setTitle("列表框");
                DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                };
                dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listener);
                dialog.show();
            }
            private void dialog7() {
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.diydialog,null);
                final EditText editText = (EditText) layout.findViewById(R.id.edit);
                dialog = new AlertDialog.Builder(MainActivity.this).create();
                dialog.setTitle("自定义布局");
                dialog.setView(layout);
                DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        textView.setText("输入的是："+editText.getText().toString());
                    }
                };
                dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
                dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listener);
                dialog.show();
            }
            private void dialog1() {
            dialog = new AlertDialog.Builder(MainActivity.this).create();
            dialog.setTitle("提示");
            dialog.setMessage("确定退出吗?");
            dialog.setIcon(android.R.drawable.ic_dialog_alert);
            DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if(which == DialogInterface.BUTTON_POSITIVE){
                        dialog.dismiss();
                        //关闭当前活动
                        MainActivity.this.finish();
                    }else if(which == DialogInterface.BUTTON_NEGATIVE)
                        dialog.dismiss();
                }
            };
            dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
            dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listener);
            dialog.show();
        }
        };
        bt1.setOnClickListener(listener);
        bt2.setOnClickListener(listener);
        bt3.setOnClickListener(listener);
        bt4.setOnClickListener(listener);
        bt5.setOnClickListener(listener);
        bt6.setOnClickListener(listener);
        bt7.setOnClickListener(listener);
    }
}
