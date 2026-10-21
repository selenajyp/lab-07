package com.example.lab_7

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DriversTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>() // access MainActivity

    @Test
    fun navigate_to_drivers_add_driver_clear_drivers_and_return_home() {
        //Verify that you can properly go from the HomeScreen to the DriversScreen
        composeTestRule
            .onNodeWithTag("driverButton")
            .performClick()
        // verify drivers screen
        composeTestRule
            .onNodeWithText("Drivers Screen")
            .assertExists()
        //Verify that you can properly add at least one driver, and if that driver is properly displayed
        // enter driver
        composeTestRule
            .onNodeWithTag("driverInput")
            .performTextInput("yuki")

        // add driver
        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        // verify driver appears
        composeTestRule
            .onNodeWithText("yuki")
            .assertExists()
        //Verify that you can properly clear the driver(s) from the list
        composeTestRule
            .onNodeWithTag("clearButton")
            .performClick()
        // verify driver list is empty
        composeTestRule
            .onNodeWithText("yuki")
            .assertDoesNotExist()
        //Verify that the back button takes you back to the HomeScreen
        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }

}