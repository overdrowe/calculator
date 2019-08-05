package com.example.calculator;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FirstNumBlockFragment.OnFragmentInteractionListener {

    TextView editText;
    TextView answer;

    SharedPreferences sPref;
    final String SAVED_TEXT = "saved_text";
    private String appStyle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sPref = getSharedPreferences("MyPref", MODE_PRIVATE);
        appStyle = sPref.getString(SAVED_TEXT, "");

        switch (appStyle) {
            case "AppTheme": setTheme(R.style.AppTheme);Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
                break;
            case "LightTheme": setTheme(R.style.LightTheme);Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
                break;
            case "ColorThemeOne": setTheme(R.style.ColorThemeOne);Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "Default", Toast.LENGTH_SHORT).show();
                break;
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        answer = findViewById(R.id.answer);

        editText.setMaxLines(1);
        answer.setMaxLines(1);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

//        mainLayout = findViewById(R.id.mainLayout);

        FirstNumBlockFragment fragment = new FirstNumBlockFragment();
        fragment.setOnFragmentInteractionListener(this);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.add(R.id.numContainer, fragment).commit();
    }

    @Override
    public void closeActivity() {
        this.finish();
    }

    @Override
    public void onAnswerChanged(String answer) {
        this.answer.setText(answer);
    }

    @Override
    public void onEditTextChanged(String editText) {
        this.editText.setText(editText);
    }

    /*@SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) {
            return;
        }
        int color = data.getIntExtra("color", 0);
        Window window = this.getWindow();
        switch (color) {
            case 0:
                window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
                mainLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                for (Button button : buttons_numb)
                    button.setBackground(getDrawable(R.drawable.button_numbers));
                for (Button button : buttons_foo)
                    button.setBackground(getDrawable(R.drawable.button_foo));
                for (ImageButton button : buttons_foo2)
                    button.setBackground(getDrawable(R.drawable.button_foo));
                break;

            case 1:
                window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark1));
                mainLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary1));
                for (Button button : buttons_numb)
                    button.setBackground(getDrawable(R.drawable.button_numbers1));
                for (Button button : buttons_foo)
                    button.setBackground(getDrawable(R.drawable.button_foo1));
                for (ImageButton button : buttons_foo2)
                    button.setBackground(getDrawable(R.drawable.button_foo1));
                break;
            case 2:
                window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark2));
                mainLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary2));
                for (Button button : buttons_numb)
                    button.setBackground(getDrawable(R.drawable.button_numbers2));
                for (Button button : buttons_foo)
                    button.setBackground(getDrawable(R.drawable.button_foo2));
                for (ImageButton button : buttons_foo2)
                    button.setBackground(getDrawable(R.drawable.button_foo2));
                break;
            case 3:
                window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark3));
                mainLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary3));
                for (Button button : buttons_numb)
                    button.setBackground(getDrawable(R.drawable.button_numbers3));
                for (Button button : buttons_foo)
                    button.setBackground(getDrawable(R.drawable.button_foo3));
                for (ImageButton button : buttons_foo2)
                    button.setBackground(getDrawable(R.drawable.button_foo3));
                break;
        }
    }*/
}
