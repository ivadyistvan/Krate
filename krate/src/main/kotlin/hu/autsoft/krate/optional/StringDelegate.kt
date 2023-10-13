package hu.autsoft.krate.optional

import hu.autsoft.krate.Krate
import hu.autsoft.krate.base.KeyedKrateProperty
import hu.autsoft.krate.base.KeyedKratePropertyProvider
import hu.autsoft.krate.util.edit
import kotlin.reflect.KProperty

internal class StringDelegate(
    override val key: String,
) : KeyedKrateProperty<String?> {
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

internal class StringDelegateProvider(
    val key: String?,
) : KeyedKratePropertyProvider<String?> {
    override fun provideDelegate(thisRef: Krate, property: KProperty<*>): StringDelegate {
        return StringDelegate(key ?: property.name)
    }
}
