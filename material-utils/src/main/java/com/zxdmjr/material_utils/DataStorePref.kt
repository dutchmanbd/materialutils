package com.zxdmjr.material_utils

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.*
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class DataStorePref(context: Context) {

    private val dataStore: DataStore<Preferences> = context.createDataStore(
        name = "${context.packageName}.DataStorePref"
    )

    fun read(key: String, defValue: String) = dataStore.data
        .catch { exception->
            if(exception is NullPointerException){
                emit(emptyPreferences())
            } else{
                throw exception
            }
        }
        .map {preferences ->
        preferences[preferencesKey<String>(key)] ?: defValue
    }

    suspend fun write(key: String, value: String){
        dataStore.edit { preferences ->
           preferences[preferencesKey<String>(key)] = value
        }
    }



    fun read(key: String, defValue: Boolean) =
        dataStore.data
            .catch { exception->
                if(exception is NullPointerException){
                    emit(emptyPreferences())
                } else{
                    throw exception
                }
            }
            .map {preferences ->
            preferences[preferencesKey<Boolean>(key)] ?: defValue
        }

    suspend fun write(key: String, value: Boolean){
        dataStore.edit { preferences ->
            preferences[preferencesKey<Boolean>(key)] = value
        }
    }

    fun read(key: String, defValue: Int) =
        dataStore.data
            .catch { exception->
                if(exception is NullPointerException){
                    emit(emptyPreferences())
                } else{
                    throw exception
                }
            }
            .map {preferences ->
            preferences[preferencesKey<Int>(key)] ?: defValue
        }

    suspend fun write(key: String, value: Int){
        dataStore.edit { preferences ->
            preferences[preferencesKey<Int>(key)] = value
        }
    }

    fun read(key: String, defValue: Long) =
        dataStore.data
            .catch { exception->
                if(exception is NullPointerException){
                    emit(emptyPreferences())
                } else{
                    throw exception
                }
            }
            .map {preferences ->
            preferences[preferencesKey<Long>(key)] ?: defValue
        }

    suspend fun write(key: String, value: Long){
        dataStore.edit { preferences ->
            preferences[preferencesKey<Long>(key)] = value
        }
    }


    fun read(key: String, defValue: Float) =
        dataStore.data
            .catch { exception->
                if(exception is NullPointerException){
                    emit(emptyPreferences())
                } else{
                    throw exception
                }
            }
            .map {preferences ->
            preferences[preferencesKey<Float>(key)] ?: defValue
        }

    suspend fun write(key: String, value: Float){
        dataStore.edit { preferences ->
            preferences[preferencesKey<Float>(key)] = value
        }
    }

    suspend fun <T> remove(key: Preferences.Key<T>){
        dataStore.edit {preferences ->
            preferences.remove(key)
        }
    }

    suspend fun clear(){
        dataStore.edit {
            it.clear()
        }
    }

}