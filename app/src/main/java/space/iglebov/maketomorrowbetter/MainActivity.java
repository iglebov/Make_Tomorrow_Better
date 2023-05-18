package space.iglebov.maketomorrowbetter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;
import android.content.SharedPreferences;

public class MainActivity extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
        final int level = save.getInt("Level", 0);

        Button button_start = (Button)findViewById(R.id.button_start);
        button_start.setOnClickListener(v -> {
            try {
                Intent intent = new Intent(MainActivity.this, FirstStageActivity.class);
                startActivity(intent);
                overridePendingTransition(0,0);
                finish();
            } catch (Exception e) {
                // Empty
            }
        });

        Button button_continue = (Button)findViewById(R.id.button_continue);
        button_continue.setOnClickListener(v -> {
            switch(level) {
                case 0:
                    try {
                        Intent intent = new Intent(MainActivity.this, FirstStageActivity.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        finish();
                    } catch (Exception e) {
                        // Empty
                    }
                    break;
                case 1:
                    try {
                        Intent intent = new Intent(MainActivity.this, SecondStageActivity.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        finish();
                    } catch (Exception e) {
                        // Empty
                    }
                    break;
                case 2:
                    try {
                        Intent intent = new Intent(MainActivity.this, ThirdStageActivity.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        finish();
                    } catch (Exception e) {
                        // Empty
                    }
                    break;
                case 3:
                    try {
                        Intent intent = new Intent(MainActivity.this, FourthStageActivity.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        finish();
                    } catch (Exception e) {
                        // Empty
                    }
                    break;
                case 4:
                    try {
                        Intent intent = new Intent(MainActivity.this, FifthStageActivity.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        finish();
                    } catch (Exception e) {
                        // Empty
                    }
                    break;
                case 5:
                    try {
                            Intent intent = new Intent(MainActivity.this, SixthStageActivity.class);
                            startActivity(intent);
                            overridePendingTransition(0,0);
                            finish();
                    } catch (Exception e) {
                        // Empty
                    }
                    break;
                case 6:
                    try {
                        Intent intent = new Intent(MainActivity.this, SeventhStageActivity.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        finish();
                    } catch (Exception e) {
                        // Empty
                    }
                    break;
            }
        });
        Button button_newgame = (Button)findViewById(R.id.button_newgame);
        button_newgame.setOnClickListener(v -> {
            try {
                SharedPreferences save1 = getSharedPreferences("Save", MODE_PRIVATE);
                SharedPreferences.Editor editor = save1.edit();
                editor.putInt("Level", 0);
                editor.apply();
                Intent intent = new Intent(MainActivity.this, FirstStageActivity.class);
                startActivity(intent);
                overridePendingTransition(0,0);
                finish();
            } catch (Exception e) {
                // Empty
            }
        });
        switch(level) {
            case 0: case 7:
                button_start.setVisibility(View.VISIBLE);
                button_continue.setVisibility(View.GONE);
                button_newgame.setVisibility(View.GONE);
                break;
            case 1: case 2: case 3: case 4: case 5: case 6:
                button_start.setVisibility(View.GONE);
                button_continue.setVisibility(View.VISIBLE);
                button_newgame.setVisibility(View.VISIBLE);
                break;
        }
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        } else {
            backToast = Toast.makeText(getBaseContext(),"Нажмите ещё раз чтобы выйти", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
}
