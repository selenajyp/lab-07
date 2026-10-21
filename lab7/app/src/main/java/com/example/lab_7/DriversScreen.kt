package com.example.lab_7

import android.R.attr.onClick
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DriversScreen(navController: NavController) {
    var driver by remember {
        mutableStateOf("")
    }

    var drivers = remember {
        mutableStateListOf<String>()
    }
    Column (
        modifier=Modifier.fillMaxSize().padding(16.dp)
    ){
        //There should be a button to return to the HomeScreen
        Button(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier.testTag("backButton") // for testing
        ) {
            Text("Back")
        }

        Spacer(modifier = Modifier.height(16.dp))
        //There should be text indicating that it's the DriversScreen (i.e., "FormulaZero Drivers")
        Text(
            text="Drivers Screen",
            fontSize=30.sp
        )

        Spacer(modifier = Modifier.height(16.dp))
        //There should be a text field and a button to add drivers
        Row (
            modifier=Modifier.fillMaxWidth(),
            horizontalArrangement= Arrangement.SpaceBetween
        ){
            //text field to add drivers
            TextField(
                value=driver,
                onValueChange={
                    driver=it //update driver to new value
                },
                label={
                    Text("Driver")
                },
                modifier=Modifier.testTag("driverInput") //for testing
            )

            Spacer(modifier = Modifier.height(8.dp))

            //button to add driver
            Button(
                onClick = {
                    if(driver.isNotBlank()){
                        drivers.add(driver)
                        driver=""
                    }
                },
                modifier = Modifier.testTag("addDriverButton") // for testing
            ) {
                Text("Add")
            }
        }
        // drivers added will be displayed in a list format
        LazyColumn {
            items(drivers) { race ->
                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = race,
                    fontSize = 24.sp
                )
            }
        }
        //There should be a button to clear all drivers displayed
        Button(
            onClick = {
                drivers.clear()
            },
            modifier = Modifier.testTag("clearButton") // for testing
        ) {
            Text("Clear")
        }

    }
}
