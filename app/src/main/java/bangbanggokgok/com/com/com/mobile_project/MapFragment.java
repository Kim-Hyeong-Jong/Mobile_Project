package bangbanggokgok.com.com.com.mobile_project;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;




/**
 * Created by User on 2018-06-07.
 */

public class MapFragment extends Fragment  {

    private Activity root;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.googlemap,container,false);
        root = getActivity();

        return view;
    }

}
