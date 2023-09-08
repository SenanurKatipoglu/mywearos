/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter and
 * https://github.com/android/wear-os-samples/tree/main/ComposeAdvanced to find the most up to date
 * changes to the libraries and their usages.
 */

package com.example.mywearos.ui.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import com.example.mywearos.helper.calorie.CalorieCalculate
import com.example.mywearos.helper.counter.StepCounter
import com.example.mywearos.ui.presentation.theme.MywearosTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WearApp()
        }
    }
}

@Composable
fun WearApp() {
    MywearosTheme {
        val stepCounter = remember { StepCounter() }
        var steps = remember { 0 }
        var calories = remember { 0.0 }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Step Count: $steps",
                style = MaterialTheme.typography.caption1
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    steps = stepCounter.getTotalStep()
                    calories = CalorieCalculate.calculateStepCalorie(steps)
                }
            ) {
                Text(
                    text = "Calculate Calories",
                    modifier = Modifier.padding(start = 4.dp, end = 4.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Calories: ${calories.toBigDecimal()}",
                style = MaterialTheme.typography.caption2
            )
        }
    }
}
