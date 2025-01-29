package com.example.batterychargerv3

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.batterychargerv3.databinding.ActivityMainBinding
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var isNightMode = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup Toolbar
        setSupportActionBar(binding.toolbar)

        // Setup Spinners
        setupSpinners()

        binding.buttonCalculate.setOnClickListener {
            calculateChargingTime()
        }

        binding.buttonShare.setOnClickListener {
            shareResult()
        }

        binding.buttonThemeToggle.setOnClickListener {
            toggleTheme()
        }

        binding.buttonHistory.setOnClickListener {
            startActivity(Intent(this, HistoryActivity::class.java))
        }

        binding.buttonHelp.setOnClickListener {
            startActivity(Intent(this, HelpActivity::class.java))
        }
    }

    private fun setupSpinners() {
        // Charging Current Spinner
        val chargingCurrentOptions = arrayOf("8A", "10A", "16A")
        val chargingCurrentAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, chargingCurrentOptions)
        chargingCurrentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerChargingCurrent.adapter = chargingCurrentAdapter

        // Input Voltage Spinner
        val inputVoltageOptions = arrayOf("110V", "220V")
        val inputVoltageAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, inputVoltageOptions)
        inputVoltageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerInputVoltage.adapter = inputVoltageAdapter
    }

    private fun calculateChargingTime() {
        // Get input values
        val batteryCapacityStr = binding.editTextBatteryCapacity.text.toString()
        val currentChargeStr = binding.editTextCurrentCharge.text.toString()
        val chargingCurrentStr = binding.spinnerChargingCurrent.selectedItem.toString()
        val inputVoltageStr = binding.spinnerInputVoltage.selectedItem.toString()

        // Input validation
        if (batteryCapacityStr.isEmpty() || currentChargeStr.isEmpty()) {
            Toast.makeText(this, R.string.empty_fields_error, Toast.LENGTH_SHORT).show()
            return
        }

        val batteryCapacity = batteryCapacityStr.toDoubleOrNull()
        val currentCharge = currentChargeStr.toDoubleOrNull()

        if (batteryCapacity == null || currentCharge == null) {
            Toast.makeText(this, R.string.invalid_number_error, Toast.LENGTH_SHORT).show()
            return
        }

        if (currentCharge > 100.0 || currentCharge < 0.0) {
            Toast.makeText(this, R.string.invalid_charge_percentage, Toast.LENGTH_SHORT).show()
            return
        }

        // Extract values from spinners
        val chargingCurrent = chargingCurrentStr.replace("A", "").toDouble()
        val inputVoltage = inputVoltageStr.replace("V", "").toDouble()

        // Calculations
        val nominalPower = (inputVoltage * chargingCurrent) / 1000.0
        val toCharge = ((100.0 - currentCharge) * batteryCapacity) / 100.0
        val chargingTime = toCharge / nominalPower

        // Format the result
        val decimalFormat = DecimalFormat("#.##")
        val result = decimalFormat.format(chargingTime)

        // Display the result
        binding.textViewResult.text = getString(R.string.result_text, result)
    }

    private fun shareResult() {
        val resultText = binding.textViewResult.text.toString()
        if (resultText.isNotEmpty()) {
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, resultText)
                type = "text/plain"
            }
            startActivity(Intent.createChooser(shareIntent, "Compartilhar via"))
        } else {
            Toast.makeText(this, "Nenhum resultado para compartilhar", Toast.LENGTH_SHORT).show()
        }
    }

    private fun toggleTheme() {
        isNightMode = !isNightMode
        AppCompatDelegate.setDefaultNightMode(
            if (isNightMode) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO
        )
        binding.buttonThemeToggle.setImageResource(
            if (isNightMode) R.drawable.ic_moon else R.drawable.ic_sun
        )
    }
}