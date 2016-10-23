package test.screenlocker.com.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ThemeFregment extends Fragment {
    private static final String STARTING_TEXT = "Four Buttons Bottom Navigation";

    public ThemeFregment() {
    }

    public static ThemeFregment newInstance() {
        Bundle args = new Bundle();
        ThemeFregment sampleFragment = new ThemeFregment();
        sampleFragment.setArguments(args);
        return sampleFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fregment_theme, container, false);



    } }