package jp.kuskyst.mtg_life_counter_android

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import jp.kuskyst.mtg_life_counter_android.activity.LifeCounterActivity
import org.junit.Before

import org.junit.Test
import org.junit.Rule

class LifeCounterViewTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<LifeCounterActivity>()

    @Before
    fun setUp() {
        this.composeTestRule.onNodeWithContentDescription("reset").performClick()
    }

    @Test
    fun left_min() {
        repeat(20) {
            this.composeTestRule
                .onNodeWithContentDescription("left down")
                .performClick()
        }
        this.composeTestRule.onNodeWithText("0").assertIsDisplayed()
        repeat(9) {
            this.composeTestRule
                .onNodeWithContentDescription("left up")
                .performClick()
        }
        this.composeTestRule.onNodeWithText("9").assertIsDisplayed()
    }

    @Test
    fun right_min() {
        repeat(20) {
            this.composeTestRule
                .onNodeWithContentDescription("right down")
                .performClick()
        }
        this.composeTestRule.onNodeWithText("0").assertIsDisplayed()
        repeat(19) {
            this.composeTestRule
                .onNodeWithContentDescription("right up")
                .performClick()
        }
        this.composeTestRule.onNodeWithText("19").assertIsDisplayed()
    }

    @Test
    fun dice_start() {
        this.composeTestRule.onNode(!hasContentDescription("dice result"))
        this.composeTestRule
            .onNodeWithContentDescription("dice start")
            .performClick()
        this.composeTestRule.onNodeWithContentDescription("dice result").assertIsDisplayed()
        this.composeTestRule
            .onNodeWithContentDescription("dice start")
            .performClick()
        this.composeTestRule.onNode(!hasContentDescription("dice result"))
    }

}