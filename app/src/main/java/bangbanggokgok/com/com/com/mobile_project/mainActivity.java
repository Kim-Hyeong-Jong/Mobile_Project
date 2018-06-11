package bangbanggokgok.com.com.com.mobile_project;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by User on 2018-06-01.
 */

public class mainActivity extends AppCompatActivity implements mainMethod{
    FrameLayout container;
    FrameLayout navigate;
    ImageView navigate_btn;
    ImageView convert;
    int change;
    FirebaseDatabase mfirebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference mdatabaseReference = mfirebaseDatabase.getReference();
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    Intent intent = getIntent();
    private String current_uid;
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
        navigate_btn = findViewById(R.id.navigate_btn);
        convert = findViewById(R.id.convert);
        final GoogleMap googleMap = new GoogleMap();
        final InfoList infoList = new InfoList();
        final Navigate navigateFragment = new Navigate();
        navigateFragment.setListener(this);
        getFragmentManager().beginTransaction().add(R.id.navigate,navigateFragment).commit();
        navigate.setVisibility(View.INVISIBLE);
        navigate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    navigate.setVisibility(View.VISIBLE);
            }
        });
        getFragmentManager().beginTransaction().add(R.id.container,googleMap).commit();
        change = 0;
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = null;
                if(change == 0){
                    fragment = infoList;
                    change = 1;
                }else{
                    fragment = googleMap;
                    change = 0;
                }
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.container,fragment).commit();
            }
        });
        current_uid = mAuth.getCurrentUser().getUid().toString();
        Toast.makeText(this,current_uid,Toast.LENGTH_LONG).show();

    }
    public void CloseNavigate(){
        navigate.setVisibility(View.INVISIBLE);
    }
}
