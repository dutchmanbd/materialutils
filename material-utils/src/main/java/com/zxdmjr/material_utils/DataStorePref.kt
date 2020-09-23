package com.zxdmjr.material_utils

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.*
import kotlinx.coroutines.flow.map

class DataStorePref(context: Context) {

    private val dataStore: DataStore<Preferences> = context.createDataStore(
        name = "${context.packageName}.DataStorePref"
    )

    fun read(key: String, defValue: String) = dataStore.data.map {preferences ->
        preferences[preferencesKey<String>(key)] ?: defValue
    }

    suspend fun write(key: String, value: String){
        dataStore.edit { preferences ->
           preferences[preferencesKey<String>(key)] = value
        }
    }

    fun read(key: String, defValue: Boolean) =
        dataStore.data.map {preferences ->
            preferences[preferencesKey<Boolean>(key)] ?: defValue
        }

    suspend fun write(key: String, value: Boolean){
        dataStore.edit { preferences ->
            preferences[preferencesKey<Boolean>(key)] = value
        }
    }

    fun read(key: String, defValue: Int) =
        dataStore.data.map {preferences ->
            preferences[preferencesKey<Int>(key)] ?: defValue
        }

    suspend fun write(key: String, value: Int){
        dataStore.edit { preferences ->
            preferences[preferencesKey<Int>(key)] = value
        }
    }

    fun read(key: String, defValue: Long) =
        dataStore.data.map {preferences ->
            preferences[preferencesKey<Long>(key)] ?: defValue
        }

    suspend fun write(key: String, value: Long){
        dataStore.edit { preferences ->
            preferences[preferencesKey<Long>(key)] = value
        }
    }


    fun read(key: String, defValue: Float) =
        dataStore.data.map {preferences ->
            preferences[preferencesKey<Float>(key)] ?: defValue
        }

    suspend fun write(key: String, value: Float){
        dataStore.edit { preferences ->
            preferences[preferencesKey<Float>(key)] = value
        }
    }

    fun read(key: String, defValue: Double) =
        dataStore.data.map {preferences ->
            preferences[preferencesKey<Double>(key)] ?: defValue
        }

    suspend fun write(key: String, value: Double){
        dataStore.edit { preferences ->
            preferences[preferencesKey<Double>(key)] = value
        }
    }

    suspend fun remove(key: String){
        dataStore.edit {preferences->
            preferences.remove(preferencesKey(key))
        }
    }

    suspend fun clear(){
        dataStore.edit {preferences->
            preferences.clear()
        }
    }
}