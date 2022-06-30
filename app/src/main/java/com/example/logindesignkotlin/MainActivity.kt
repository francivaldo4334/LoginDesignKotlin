package com.example.logindesignkotlin
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource

class MainActivity : ComponentActivity() {
    val component = Components();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            onContent();
        }

    }
    @Composable
    private fun onContent(){
        Scaffold(
            content = {
                Box(
                    modifier = Modifier.background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                colorResource(id = R.color.m_primary_color),
                                colorResource(id = R.color.m_secundary_color)
                            )
                        )
                    )
                ) {
                    Column(
                        Modifier
                            .padding(horizontal = dimensionResource(id = R.dimen._32))
                            .fillMaxSize()
                            .verticalScroll(state = ScrollState(0))
                    ) {

                        component.getIcon()
                        component.setText(getString(R.string.email))
                        component.getEditField(label = stringResource(id = R.string.email),)
                        component.setText(getString(R.string.password))
                        component.getEditField(label = stringResource(id = R.string.password))
                        component.getbtns()

                    }
                }
            }
        );
    }
}
