package com.github.dipakkr.insidegu.Fragment;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.github.dipakkr.insidegu.R;

/**
 * Created by deepak on 22-01-2017.
 */

public class SettingFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_setting);
    }
}
