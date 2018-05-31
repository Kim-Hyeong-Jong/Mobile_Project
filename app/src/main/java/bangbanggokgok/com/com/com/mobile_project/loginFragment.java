package bangbanggokgok.com.com.com.mobile_project;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login,container,false);
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
        return view;
    }

}
