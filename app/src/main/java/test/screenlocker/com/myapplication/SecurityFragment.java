package test.screenlocker.com.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SecurityFragment extends Fragment {
    private static final String STARTING_TEXT = "Four Buttons Bottom Navigation";

    public SecurityFragment() {
    }

    public static SecurityFragment newInstance() {
        Bundle args = new Bundle();
        SecurityFragment sampleFragment = new SecurityFragment();
        sampleFragment.setArguments(args);
        return sampleFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_security, container, false);



    } }