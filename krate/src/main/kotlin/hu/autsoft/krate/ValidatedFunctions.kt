@file:Suppress("RedundantVisibilityModifier")

package hu.autsoft.krate

import hu.autsoft.krate.validated.ValidatedPreferenceDelegate
import hu.autsoft.krate.default.FloatDelegateWithDefault
import hu.autsoft.krate.default.IntDelegateWithDefault
import hu.autsoft.krate.default.LongDelegateWithDefault
import hu.autsoft.krate.default.StringDelegateWithDefault
import hu.autsoft.krate.default.StringSetDelegateWithDefault
import hu.autsoft.krate.optional.FloatDelegate
import hu.autsoft.krate.optional.IntDelegate
import hu.autsoft.krate.optional.LongDelegate
import hu.autsoft.krate.optional.StringDelegate
import hu.autsoft.krate.optional.StringSetDelegate
import kotlin.properties.ReadWriteProperty

/**
 * Creates a validated, optional preference of type [Float] with the given [key].
 *
 * If a value being set to this preference returns `false` when checked by [isValid],
 * an [IllegalArgumentException] will be thrown.
 */
public fun Krate.floatPref(key: String, isValid: (Float?) -> Boolean): ReadWriteProperty<Krate, Float?> {
    return ValidatedPreferenceDelegate(FloatDelegate(key), isValid)
}

/**
 * Creates a validated, non-optional preference of type [Float] with the given [key].
 *
 * If a value being set to this preference returns `false` when checked by [isValid],
 * an [IllegalArgumentException] will be thrown.
 */
public fun Krate.floatPref(key: String, default: Float, isValid: (Float) -> Boolean): ReadWriteProperty<Krate, Float> {
    return ValidatedPreferenceDelegate(FloatDelegateWithDefault(key, default), isValid)
}

/**
 * Creates a validated, optional preference of type [Int] with the given [key].
 *
 * If a value being set to this preference returns `false` when checked by [isValid],
 * an [IllegalArgumentException] will be thrown.
 */
public fun Krate.intPref(key: String, isValid: (Int?) -> Boolean): ReadWriteProperty<Krate, Int?> {
    return ValidatedPreferenceDelegate(IntDelegate(key), isValid)
}

/**
 * Creates a validated, non-optional preference of type [Int] with the given [key].
 *
 * If a value being set to this preference returns `false` when checked by [isValid],
 * an [IllegalArgumentException] will be thrown.
 */
public fun Krate.intPref(key: String, default: Int, isValid: (Int) -> Boolean): ReadWriteProperty<Krate, Int> {
    return ValidatedPreferenceDelegate(IntDelegateWithDefault(key, default), isValid)
}

/**
 * Creates a validated, optional preference of type [Long] with the given [key].
 *
 * If a value being set to this preference returns `false` when checked by [isValid],
 * an [IllegalArgumentException] will be thrown.
 */
public fun Krate.longPref(key: String, isValid: (Long?) -> Boolean): ReadWriteProperty<Krate, Long?> {
    return ValidatedPreferenceDelegate(LongDelegate(key), isValid)
}

/**
 * Creates a validated, non-optional preference of type [Long] with the given [key].
 *
 * If a value being set to this preference returns `false` when checked by [isValid],
 * an [IllegalArgumentException] will be thrown.
 */
public fun Krate.longPref(key: String, defaultValue: Long, isValid: (Long) -> Boolean): ReadWriteProperty<Krate, Long> {
    return ValidatedPreferenceDelegate(LongDelegateWithDefault(key, defaultValue), isValid)
}

/**
 * Creates a validated, optional preference of type [String] with the given [key].
 *
 * If a value being set to this preference returns `false` when checked by [isValid],
 * an [IllegalArgumentException] will be thrown.
 */
public fun Krate.stringPref(key: String, isValid: (String?) -> Boolean): ReadWriteProperty<Krate, String?> {
    return ValidatedPreferenceDelegate(StringDelegate(key), isValid)
}

/**
 * Creates a validated, non-optional preference of type [String] with the given [key].
 *
 * If a value being set to this preference returns `false` when checked by [isValid],
 * an [IllegalArgumentException] will be thrown.
 */
public fun Krate.stringPref(key: String, default: String, isValid: (String) -> Boolean): ReadWriteProperty<Krate, String> {
    return ValidatedPreferenceDelegate(StringDelegateWithDefault(key, default), isValid)
}

/**
 * Creates a validated, optional preference of type Set<String> with the given [key].
 *
 * If a value being set to this preference returns `false` when checked by [isValid],
 * an [IllegalArgumentException] will be thrown.
 */
public fun Krate.stringSetPref(key: String, isValid: (Set<String>?) -> Boolean): ReadWriteProperty<Krate, Set<String>?> {
    return ValidatedPreferenceDelegate(StringSetDelegate(key), isValid)
}

/**
 * Creates a validated, non-optional preference of type Set<String> with the given [key].
 *
 * If a value being set to this preference returns `false` when checked by [isValid],
 * an [IllegalArgumentException] will be thrown.
 */
public fun Krate.stringSetPref(key: String, defaultValue: Set<String>, isValid: (Set<String>) -> Boolean): ReadWriteProperty<Krate, Set<String>> {
    return ValidatedPreferenceDelegate(StringSetDelegateWithDefault(key, defaultValue), isValid)
}