package hu.autsoft.krateexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hu.autsoft.krateexample.databinding.ActivityExampleBinding
import hu.autsoft.krateexample.krates.ExampleCustomKrate
import hu.autsoft.krateexample.krates.ExampleSettings
import hu.autsoft.krateexample.krates.ExampleSimpleKrate

class ExampleActivity : AppCompatActivity() {

    companion object {
        const val KEY_KRATE_TYPE = "KEY_KRATE_TYPE"
        const val TYPE_SIMPLE = "TYPE_SIMPLE"
        const val TYPE_CUSTOM = "TYPE_CUSTOM"
    }

    lateinit var exampleSettings: ExampleSettings

    private lateinit var binding: ActivityExampleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        when (intent.getStringExtra(KEY_KRATE_TYPE)) {
            TYPE_SIMPLE -> {
                exampleSettings = ExampleSimpleKrate(this)
                title = "Simple Krate"
            }
            TYPE_CUSTOM -> {
                exampleSettings = ExampleCustomKrate(this)
                title = "Custom Krate"
            }
            else -> throw IllegalArgumentException("Invalid Krate type in Intent")
        }
    }

    override fun onResume() {
        super.onResume()

        binding.booleanPreference.isChecked = exampleSettings.exampleBoolean
        binding.floatPreferenceInput.setText(exampleSettings.exampleFloat.toString())
        binding.intPreferenceInput.setText(exampleSettings.exampleInt.toString())
        binding.longPreferenceInput.setText(exampleSettings.exampleLong.toString())
        binding.stringPreferenceInput.setText(exampleSettings.exampleString)
        binding.stringSetPreferenceInput.setText(exampleSettings.exampleStringSet.joinToString(separator = ", "))
    }

    override fun onPause() {
        super.onPause()

        exampleSettings.exampleBoolean = binding.booleanPreference.isChecked
        exampleSettings.exampleFloat = binding.floatPreferenceInput.text.toString().toFloat()
        exampleSettings.exampleInt = binding.intPreferenceInput.text.toString().toInt()
        exampleSettings.exampleLong = binding.longPreferenceInput.text.toString().toLong()
        exampleSettings.exampleString = binding.stringPreferenceInput.text.toString()
        exampleSettings.exampleStringSet =
            binding.stringSetPreferenceInput.text.toString().split(",").map(String::trim).toSet()
    }

}
