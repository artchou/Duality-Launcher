package com.graymatterapps.dualitylauncher

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat

class SettingsDrawerFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings_drawer, rootKey)
    }
}