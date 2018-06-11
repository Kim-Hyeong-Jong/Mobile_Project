package bangbanggokgok.com.com.com.mobile_project;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by User on 2018-05-23.
 */

public class loginFragment extends Fragment {
    public void setCreate(OnCreateClickListener listener){this.listener = listener;}
    public interface OnCreateClickListener{
        public void CreateSelected();

    }
    private OnCreateClickListener listener;
    private String id;
    private String password;
    private EditText login_txt;
    private EditText create_txt;
    private Button login;
    private Button create;
    public Activity activity;
    public FirebaseAuth mAuth;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        activity = getActivity();
        View view = inflater.inflate(R.layout.login,container,false);
        mAuth = FirebaseAuth.getInstance();
        login_txt = view.findViewById(R.id.email);
        create_txt = view.findViewById(R.id.password);
        login = view.findViewById(R.id.login);
        create = view.findViewById(R.id.create);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.CreateSelected();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mAuth.signInWithEmailAndPassword(login_txt.getText().toString(),create_txt.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(activity,"로그인 성공",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(activity,mainActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(activity,"로그인 실패",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        return view;
    }

}
