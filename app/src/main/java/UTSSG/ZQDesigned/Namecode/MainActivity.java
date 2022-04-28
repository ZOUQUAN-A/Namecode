package UTSSG.ZQDesigned.Namecode;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("SetTextI18n")
    public void button2_Onclick(View view) {
        EditText name = findViewById(R.id.name);
        TextView result = findViewById(R.id.output);
        String nameStr = name.getText().toString();
        byte[] codeBit = nameStr.getBytes();// 获取汉字的字节数组
/*        if(codeBit.length>2) {//判断
            Toast.makeText(this, "禁止转换多个字！", Toast.LENGTH_SHORT).show();
            return;
        }else if(codeBit.length<2){//判断
            Toast.makeText(this, "禁您输入的不是汉字！", Toast.LENGTH_SHORT).show();
            return;
        }else {
            codeBit[0]-=160;//提取区位码
            codeBit[1]-=160;
        }*/
            result.setText(nameStr+"--转换结果-->"+(codeBit[0])+(codeBit[1]));
            //输出汉字转区位码拼接结果
            //你--转换为区位码-->3667
        }

}
