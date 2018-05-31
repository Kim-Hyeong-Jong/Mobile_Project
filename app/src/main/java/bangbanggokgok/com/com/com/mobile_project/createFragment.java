package bangbanggokgok.com.com.com.mobile_project;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by User on 2018-05-23.
 */

public class createFragment extends Fragment {
    Activity root;
    private FirebaseAuth mAuth;
    private FirebaseDatabase mfirebaseDatabase;
    private DatabaseReference mdatabaseReference;
    EditText name;
    EditText e_mail;
    EditText password;
    TextView t_name;
    TextView t_email;
    TextView t_password;
    Button create;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.create,container,false);
        mAuth = FirebaseAuth.getInstance();
        mfirebaseDatabase = FirebaseDatabase.getInstance();
        mdatabaseReference = mfirebaseDatabase.getReference();
        root = getActivity();
        name = view.findViewById(R.id.edit_name);
        e_mail = view.findViewById(R.id.edit_email);
        password = view.findViewById(R.id.edit_password);
        t_name = view.findViewById(R.id.create_name);
        t_email = view.findViewById(R.id.create_email);
        t_password = view.findViewById(R.id.create_password);
        create = view.findViewById(R.id.create_button);
        create.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mAuth.createUserWithEmailAndPassword(e_mail.getText().toString(),password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(root,"회원가입이 완료되었습니다.",Toast.LENGTH_SHORT).show();
                            UserDTO user = new UserDTO(name.getText().toString(),e_mail.getText().toString());
                            mdatabaseReference.child("Users").push().setValue(user);
                            loginFragment newFragment = new loginFragment();
                            FragmentManager fm = getFragmentManager();
                            FragmentTransaction fragmentTransaction = fm.beginTransaction();
                            fragmentTransaction.replace(R.id.login_main,newFragment);
                            fragmentTransaction.addToBackStack(null);
                            fragmentTransaction.commit();
                        }else{
                            Toast.makeText(root,"회원가입에 실패하였습니다.",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        return view;
    }
}
