package hu.autsoft.krate.optional

import hu.autsoft.krate.Krate
import hu.autsoft.krate.util.edit
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

internal class LongDelegate(
    private val key: String,
) : ReadWriteProperty<Krate, Long?> {

    override operator fun getValue(thisRef: Krate, property: KProperty<*>): Long? {
        return if (!thisRef.sharedPreferences.contains(key)) {
            null
        } else {
            thisRef.sharedPreferences.getLong(key, 0L)
        }
    }

    override operator fun setValue(thisRef: Krate, property: KProperty<*>, value: Long?) {
        if (value == null) {
            thisRef.sharedPreferences.edit { remove(key) }
        } else {
            thisRef.sharedPreferences.edit { putLong(key, value) }
        }
    }

}
