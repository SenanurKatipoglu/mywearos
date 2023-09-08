package com.example.mywearos.helper.calorie

import com.example.mywearos.helper.Constant

/**
 * Created by KATIPOGLU on 1.07.2023.
 */

object CalorieCalculate {

    fun calculateStepCalorie(step: Int): Double {
        return (step.toDouble().times(Constant.STEP_CALORIE.value))
    }

}