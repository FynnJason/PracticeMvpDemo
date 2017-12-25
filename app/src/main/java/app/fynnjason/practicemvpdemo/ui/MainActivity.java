package app.fynnjason.practicemvpdemo.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import app.fynnjason.practicemvpdemo.R;
import app.fynnjason.practicemvpdemo.ui.LoginActivity;

/**
 * 两种情景MVP模式
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.tv_login_demo).setOnClickListener(this);
        findViewById(R.id.tv_list_demo).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_login_demo:
                startActivity(new Intent(this,LoginActivity.class));
                break;
            case R.id.tv_list_demo:
                startActivity(new Intent(this,ListActivity.class));
                break;
        }
    }
}
