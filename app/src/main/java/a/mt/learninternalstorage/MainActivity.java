package a.mt.learninternalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvData;
    private Button btnSaveData;
    private Button btnReadData;
    private final String FileName="ManhTuong";
    private final String content="thanh mai thanh oai ha noi";

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
       btnSaveData.setOnClickListener(this);
       btnReadData.setOnClickListener(this);
    }

    private void addControls() {
        tvData=findViewById(R.id.tvData);
        btnReadData=findViewById(R.id.btnReadData);
        btnSaveData=findViewById(R.id.btnSaveData);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSaveData:
                //todo
               // SaveData();
                SaveDatabyCache();
                break;
            case R.id.btnReadData:
                //todo
                break;
            default:
                break;
        }
    }
    public void SaveDatabyCache(){
        String content = "Blog chia se kien thuc lap trinh";
        File file;
        FileOutputStream outputStream;
        try {
            file = new File(getCacheDir(), "thangcoder.com");

            outputStream = new FileOutputStream(file);
            outputStream.write(content.getBytes());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void SaveData(){
       // khoa báo
        FileOutputStream fileOutputStream=null;
        try {
            // mở luồng file để lưu file
            fileOutputStream=openFileOutput(FileName,MODE_PRIVATE);
            // ghi file
            fileOutputStream.write(content.getBytes());
           // đóng file
            fileOutputStream.close();
            Toast.makeText(this, "Đã ghi thành công", Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
