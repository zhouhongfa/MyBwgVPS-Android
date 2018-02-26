package com.fg716.fragement

import android.os.Bundle
import android.preference.PreferenceFragment
import com.fg716.R

class VpsSetupPrefFragment:PreferenceFragment(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.pref_vps_config)
    }
}