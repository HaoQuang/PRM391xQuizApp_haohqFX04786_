package funix.prm.prm391xquizapp_haohqfx04786;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import funix.prm.prm391x_quizapp_haohqfx04786.R;


public class StartQuiz extends AppCompatActivity {

    Button buttonStart,buttonEnd;
    EditText editText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);

        buttonStart = findViewById(R.id.btnStart);
        buttonEnd = findViewById(R.id.btnEnd);
        editText=findViewById(R.id.inputName);

        //bắt sự kiện click vào nút start
        buttonStart.setOnClickListener(new View.OnClickListener() {

            //chuyển sang activity quiz khi click
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartQuiz.this, MainActivity.class);
                //lấy họ tên người dùng qua intent
                intent.putExtra("info",editText.getText().toString());
                startActivity(intent);

            }
        });

        //bắt sự kiện khi click vào nút end
        buttonEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    //Hàm hiển thị dialog
    public void showDialog() {
        //Đặt nội dung và bắt sự kiện click
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Bạn muốn thoát ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //click vào nút back
                onBackPressed();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //bỏ qua hộp thoại
                dialog.dismiss();
            }
        });
        //tạo và hiện dialog
        AlertDialog alertDialog =builder.create();
        alertDialog.show();
    }
}
