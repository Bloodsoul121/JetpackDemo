package com.blood.jetpackdemo.datastore

import androidx.datastore.core.Serializer
import cn.zzw.datastore.UserPreferences
import java.io.InputStream
import java.io.OutputStream

object UserPreferencesSerializer : Serializer<UserPreferences> {

    override val defaultValue: UserPreferences
        get() = UserPreferences.getDefaultInstance()

    override fun readFrom(input: InputStream): UserPreferences {
        return UserPreferences.parseFrom(input)
    }

    override fun writeTo(t: UserPreferences, output: OutputStream) = t.writeTo(output)

}