package com.example.mywearos.helper.counter

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener

/**
 * Created by KATIPOGLU on 1.07.2023.
 */
class StepCounter : SensorEventListener{

    private var stepCounter = 0

     fun getTotalStep() : Int {
        return stepCounter
    }

    override fun onSensorChanged(event: SensorEvent?) {
        event?.let {
            if (event.sensor.type == Sensor.TYPE_STEP_COUNTER){
                val calculationStep = event.values[0].toInt()
                stepCounter += calculationStep
            }
        }

    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        TODO("Not yet implemented")
    }

}