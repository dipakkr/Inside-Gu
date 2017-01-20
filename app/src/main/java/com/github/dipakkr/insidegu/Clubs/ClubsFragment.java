package com.github.dipakkr.insidegu.Clubs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.dipakkr.insidegu.R;

/**
 * Created by deepak on 20-01-2017.
 */

public class ClubsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.clubs_fragment,container,false);
        return view;
    }
}
