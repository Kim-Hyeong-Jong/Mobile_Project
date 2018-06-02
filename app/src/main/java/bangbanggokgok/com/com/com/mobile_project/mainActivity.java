package bangbanggokgok.com.com.com.mobile_project;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

/**
 * Created by User on 2018-06-01.
 */

public class mainActivity extends AppCompatActivity{
    FrameLayout container;
    FrameLayout navigate;
    @Override
    public void onBackPressed() {
        //뒤로가기 막기
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        container = findViewById(R.id.container);
        navigate = findViewById(R.id.navigate);

    }
}
