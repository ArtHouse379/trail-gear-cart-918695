package daveriholdings.sportinggoods.trailgearcart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import daveriholdings.sportinggoods.trailgearcart.ui.composable.approot.AppRoot
import daveriholdings.sportinggoods.trailgearcart.ui.theme.TOXYEAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TOXYEAppTheme {
                AppRoot()
            }
        }
    }
}
