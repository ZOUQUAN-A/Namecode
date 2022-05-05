package UTSSG.ZQDesigned.Namecode;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("SetTextI18n")
    public void button2_Onclick(View view) throws UnsupportedEncodingException {
        EditText name = findViewById(R.id.name);
        String nameStr = name.getText().toString();
        
        if(TextUtils.isEmpty(nameStr)) {//判断
            Toast.makeText(this, "请输入内容！", Toast.LENGTH_SHORT).show();
            new AlertDialog.Builder(MainActivity.this).setTitle("提示")//设置对话框标题
                    .setMessage("请输入内容！")//设置显示的内容
                    .setNegativeButton("返回", null)
                    .setIcon(android.R.drawable.ic_dialog_alert)//设置图标
                    .show();//在按键响应事件中显示此对话框
            return;
        }
        
        TextView result = findViewById(R.id.output);
        byte[] codeBit = nameStr.getBytes("gb2312");// 获取汉字的字节数组
        if(codeBit.length%2==0) {//判断
                    StringBuilder sb = new StringBuilder();
                    for (byte codeBit_tmp:codeBit) {
                        codeBit_tmp -= 160;
                        
                        if (codeBit_tmp < 0) {
                            Toast.makeText(this, "您输入的内容不合法！", Toast.LENGTH_SHORT).show();
                            new AlertDialog.Builder(MainActivity.this).setTitle("提示")//设置对话框标题
                                    .setMessage("您输入的内容不合法！")//设置显示的内容
                                    .setNegativeButton("返回", (dialog, which) -> {
                                    })
                                    .setIcon(android.R.drawable.ic_dialog_alert)//设置对话框图标
                                    .show();//在按键响应事件中显示此对话框
                            return;
                        } else if (codeBit_tmp <= 10) {
                            sb.append(0);
                        }
                        sb.append(codeBit_tmp);
                    }
                    Toast.makeText(this, "正在查询......", Toast.LENGTH_SHORT).show();
                    result.setText(nameStr+"\n↓↓转换结果↓↓\n"+(sb.toString().replaceAll(".{4}", "$0 ")));
        }else{
            Toast.makeText(this, "您输入的内容不合法！", Toast.LENGTH_SHORT).show();
            new AlertDialog.Builder(MainActivity.this).setTitle("提示")//设置对话框标题
                    .setMessage("您输入的内容不合法！")//设置显示的内容
                    .setNegativeButton("返回", null)
                    .setIcon(android.R.drawable.ic_dialog_alert)//设置对话框图标
                    .show();//在按键响应事件中显示此对话框
        }

        }
        public void button1_Onclick(View view) {
            startActivity(new Intent(MainActivity.this,DonateActivity.class));
        }
    }