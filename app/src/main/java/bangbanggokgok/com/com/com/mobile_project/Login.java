package bangbanggokgok.com.com.com.mobile_project;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class Login extends AppCompatActivity implements loginFragment.OnCreateClickListener{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);

        if(findViewById(R.id.login_main) != null){
            if(savedInstanceState != null){
                return;
            }
            final loginFragment loginFragment = new loginFragment();
            loginFragment.setCreate(this);
            getSupportFragmentManager().beginTransaction().add(R.id.login_main, loginFragment).commit();
        }

    }

    @Override
    public void CreateSelected() {
        createFragment newFragment = new createFragment();
        newFragment.setListener(this);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.login_main,newFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


}

