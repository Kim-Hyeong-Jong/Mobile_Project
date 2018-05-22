package bangbanggokgok.com.com.com.mobile_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        if(findViewById(R.id.login_main) != null){
            if(savedInstanceState != null){
                return;
            }
            final Bundle args = new Bundle();
            final loginFragment loginFragment = new loginFragment();
            loginFragment.setArguments(getIntent().getExtras());
            getFragmentManager().beginTransaction().add(R.id.login_main, loginFragment).commit();
        }

    }
    public void CreatSelected(){

    }

}

