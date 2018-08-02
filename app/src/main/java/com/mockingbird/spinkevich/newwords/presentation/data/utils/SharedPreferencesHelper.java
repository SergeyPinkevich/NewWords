package com.mockingbird.spinkevich.newwords.presentation.data.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Inject;

public class SharedPreferencesHelper {

    public static final String FILE_NAME = "translate_direction";
    public static final String FROM_LANG = "from";
    public static final String TO_LANG = "to";

    private SharedPreferences preferences;

    @Inject
    public SharedPreferencesHelper(Context context) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void writeInSharedPreference(String key, String value) {
        preferences.edit().putString(key, value).apply();
    }

    public String readFromSharedPreference(String key) {
        if (key.equals(FROM_LANG)) {
            return preferences.getString(key, "English");
        } else {
            return preferences.getString(key, "Russian");
        }
    }
}
