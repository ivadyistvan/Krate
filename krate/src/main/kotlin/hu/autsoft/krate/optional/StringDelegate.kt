package hu.autsoft.krate.optional

import hu.autsoft.krate.Krate
import hu.autsoft.krate.util.edit
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

internal class StringDelegate(
    private val key: String,
) : ReadWriteProperty<Krate, String?> {

    override operator fun getValue(thisRef: Krate, property: KProperty<*>): String? {
        return if (!thisRef.sharedPreferences.contains(key)) {
            null
        } else {
            thisRef.sharedPreferences.getString(key, null)
        }
    }

    override operator fun setValue(thisRef: Krate, property: KProperty<*>, value: String?) {
        if (value == null) {
            thisRef.sharedPreferences.edit { remove(key) }
        } else {
            thisRef.sharedPreferences.edit { putString(key, value) }
        }
    }

}
