package bangbanggokgok.com.com.com.mobile_project;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by User on 2018-06-07.
 */

public class Navigate extends Fragment implements mainMethod{
    ImageView close;
    FirebaseAuth mAuth;
    FirebaseDatabase mfirebaseDatabase;
    DatabaseReference mdatabaseReference;
    mainMethod mainMethod;
    String current_uid;
    public void setListener(mainMethod mainMethod){
        this.mainMethod = mainMethod;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mfirebaseDatabase = FirebaseDatabase.getInstance();
        mdatabaseReference = mfirebaseDatabase.getReference();
        mAuth = FirebaseAuth.getInstance();
        current_uid = mAuth.getCurrentUser().getUid().toString();
        View view = inflater.inflate(R.layout.navigate,container,false);
        close = view.findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainMethod.CloseNavigate();
            }
        });
        return view;
    }

    @Override
    public void CloseNavigate() {

    }
}
