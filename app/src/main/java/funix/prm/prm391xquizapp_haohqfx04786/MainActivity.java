package funix.prm.prm391xquizapp_haohqfx04786;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import funix.prm.prm391x_quizapp_haohqfx04786.R;

public class MainActivity extends AppCompatActivity {
    Button btnPoint, btnSubmit,buttonCountDown;
    RadioGroup radioGroup1, radioGroup5, radioGroup9;
    EditText editTextQues2, editTextQues4, editTextQues6, editTextQues8, editTextQues10;
    CheckBox checkBoxQues3_1,checkBoxQues3_2, checkBoxQues3_3, checkBoxQues3_4, checkBoxQues7_1, checkBoxQues7_2, checkBoxQues7_3, checkBoxQues7_4;
    int question1, question2, question3, question4, question5, question6_1,question6_2, question7, question8, question9, question10;
    CountDownTimer Timer;
    TextView textName;
    String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //gọi hàm lấy ID
        getViewId();

        //ẩn thanh actionbar
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();

        //lấy thông tin tên bằng intent
        Intent intent = getIntent();
        name =intent.getStringExtra("info");
        textName.setText("Name: "+name);

        //Sự kiện khi bấm nút submit
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Đã gửi kết quả.", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        //sự kiện khi bấm nút checkPoint
        this.btnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //gọi đến hàm kiểm tra
                checkQuizAndAnswer();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        //Đặt giới hạn thời gian 1 phút
        buttonCountDown=findViewById(R.id.count_down);
        Timer = new CountDownTimer(60000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                buttonCountDown.setText("Time: "+ millisUntilFinished / 1000);
            }

            //kiểm tra đáp án và kết thúc Activity
            @Override
            public void onFinish() {
                buttonCountDown.setText("Hết giờ");
                checkQuizAndAnswer();
                finish();
            }
        }.start();
    }

    //Chấm điểm
    public void checkQuizAndAnswer() {
        question1 = checkAnswerRadio(radioGroup1, "DNA");
        question2 = checkAnswerInputText(editTextQues2,"Vulcanizing");
        question3 = checkAnswerCheckBox(checkBoxQues3_1,checkBoxQues3_3,checkBoxQues3_2,checkBoxQues3_4);
        question4 = checkAnswerInputText(editTextQues4,"Gravity");
        question5 = checkAnswerRadio(radioGroup5, "Pine trees");
        question6_1 = checkAnswerInputText(editTextQues6,"Clouds");
        question6_2 = checkAnswerInputText(editTextQues6,"Cloud");
        question7 = checkAnswerCheckBox(checkBoxQues7_3,checkBoxQues7_4,checkBoxQues7_1,checkBoxQues7_2);
        question8 = checkAnswerInputText(editTextQues8, "Wrist");
        question9 = checkAnswerRadio(radioGroup9, "Stalagmites");
        question10 = checkAnswerInputText(editTextQues10,"Smelting");

        //Hiển thị điểm
        int sum =question1+question2+question3+question4+question5+question6_1+question6_2+question7+question8+question9+question10;
        if (sum==0)//nếu không đúng câu nào
            Toast.makeText(MainActivity.this,"Bạn chưa đúng câu nào !",Toast.LENGTH_LONG).show();
        else if (sum<10)
            Toast.makeText(MainActivity.this,"Score: "+sum+"/10",Toast.LENGTH_LONG).show();
        else //nếu đúng
            Toast.makeText(MainActivity.this,"Score: "+sum+"/10"+"\nCongratulations "+name ,Toast.LENGTH_LONG).show();
    }

    /*Kiểm tra đáp án đúng hay sai và cho điểm*/

    //dạng nút radio
    public int checkAnswerRadio(RadioGroup radioGroup, String correctAnswer) {
        int radio_check = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(radio_check);
        if (radioButton != null) {
            if (radioButton.getText().equals(correctAnswer))
                return 1;
        }
        return 0;
    }
    //dạng text
    public int checkAnswerInputText(EditText editText, String correctAnswer) {

        if (editText.getText().toString().toLowerCase().equals(correctAnswer.toLowerCase())){
            return 1;}
        return 0;
    }
    //dạng checkbox
    public int checkAnswerCheckBox(CheckBox checkBoxTrue1,CheckBox checkBoxTrue2,CheckBox checkBoxFalse1,CheckBox checkBoxFalse2) {
        if (!checkBoxFalse1.isChecked()&&!checkBoxFalse2.isChecked()&&checkBoxTrue2.isChecked()&&checkBoxTrue1.isChecked())
            return 1;
        return 0;
    }

    //lấy Id của từng view
    public void getViewId() {
        textName=findViewById(R.id.name);
        btnPoint = findViewById(R.id.btnCheckP);
        btnSubmit = (Button) findViewById(R.id.btnsubmit);
        radioGroup1 = findViewById(R.id.radio_group_1);
        radioGroup5 = findViewById(R.id.radio_group_5);
        radioGroup9 = findViewById(R.id.radio_group_9);
        editTextQues2 = findViewById(R.id.answer2);
        editTextQues4 = findViewById(R.id.answer4);
        editTextQues6 = findViewById(R.id.answer6);
        editTextQues8 = findViewById(R.id.answer8);
        editTextQues10 = findViewById(R.id.answer10);
        checkBoxQues3_1 = (CheckBox)findViewById(R.id.ans3_1);
        checkBoxQues3_2 = (CheckBox)findViewById(R.id.ans3_2);
        checkBoxQues3_3 = (CheckBox)findViewById(R.id.ans3_3);
        checkBoxQues3_4 = (CheckBox)findViewById(R.id.ans3_4);
        checkBoxQues7_1 = (CheckBox)findViewById(R.id.anw7_1);
        checkBoxQues7_2 = (CheckBox)findViewById(R.id.anw7_2);
        checkBoxQues7_3 = (CheckBox)findViewById(R.id.anw7_3);
        checkBoxQues7_4 = (CheckBox)findViewById(R.id.anw7_4);
    }
}
