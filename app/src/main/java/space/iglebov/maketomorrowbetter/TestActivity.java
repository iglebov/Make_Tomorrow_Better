package space.iglebov.maketomorrowbetter;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.ImageSwitcher;

import androidx.appcompat.app.AppCompatActivity;
public class TestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startofthegame);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final ImageView imgView = findViewById(R.id.WelcomeText);
        final ImageView Tree_Growing_Up_First_Stage = findViewById(R.id.Tree_Growing_Up_First_Stage);
        final ImageView imgViewww2 = findViewById(R.id.Tree_Growing_Up_Second_Stage);
        imgViewww2.setVisibility(View.INVISIBLE);
        imgView.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imgView.setVisibility(View.GONE);
            }
        },7 * 1000);
        final CheckedTextView checkedTextView = findViewById(R.id.checked_textview);
        checkedTextView.setVisibility(View.INVISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                checkedTextView.setVisibility(View.VISIBLE);
            }
        },7 * 1000);
        checkedTextView.setOnClickListener(new View.OnClickListener(){
            private int a = 0;
            private int n = 0;
            private int k = 0;
            private int[] images = {R.drawable.tree_third_stage, R.drawable.tree_fourth_stage};
            private String[] seasons = {"Поспать более 7 часов", "Послушать любимую музыку","Начать читать новую книгу",
                    "Выйти на улицу и подышать свежим воздухом", "Позаниматься спортом", "Покушать",
                    "Отдохнуть", "Потанцевать", "Попеть"};
            @Override
            public void onClick(View v) {
                checkedTextView.toggle();
                if(checkedTextView.isChecked()) {
                    checkedTextView.setChecked(false);
                    checkedTextView.setText(seasons[n]);
                    n++;
                    a++;
                }
                if (a == 3){
                    k++;
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                        }
                    },4 * 1000);
                    checkedTextView.setVisibility(View.INVISIBLE);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            checkedTextView.setVisibility(View.VISIBLE);
                        }
                    },4 * 1000);
                } else if (a == 6){
                    k++;
                    imgViewww2.setVisibility(View.VISIBLE);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            imgViewww2.setVisibility(View.INVISIBLE);
                        }
                    },4 * 1000);
                    checkedTextView.setVisibility(View.INVISIBLE);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            checkedTextView.setVisibility(View.VISIBLE);
                        }
                    },4 * 1000);
                }
            }

        });
        Button button_back = (Button)findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    Intent intent = new Intent(TestActivity.this, MainActivity.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

    }
    //Системная кнопка - начало
    @Override
    public void onBackPressed(){
        try{
            Intent intent = new Intent(TestActivity.this, MainActivity.class);
            startActivity(intent);finish();
        }catch (Exception e){

        }
    //Системная кнопка - конец
    }
}
