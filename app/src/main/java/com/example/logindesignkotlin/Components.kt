package com.example.logindesignkotlin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Components {

    @Composable
    fun getIcon(){
        Box(Modifier.fillMaxWidth(), Alignment.Center) {
            androidx.compose.material.Icon(painter = painterResource(id = R.drawable.ic_img_logo), contentDescription = null, tint = colorResource(
                id = R.color.white
            ), modifier =
            Modifier.padding(horizontal = Dp(0F), vertical = dimensionResource(id = R.dimen._72))
            )
        }
    }
    @Composable
    fun setText(text:String){
        Text(text = text,
            color = colorResource(id = R.color.white),
            fontSize = 18.sp,
            modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen._16))
        )
    }
    @Composable
    fun getEditField(label: String) {
        var visPassword by remember { mutableStateOf(false) }
        var text by remember { mutableStateOf(TextFieldValue("")) }
        var txtEmail = stringResource(id = R.string.email);
        var txtPassword = stringResource(id = R.string.password);
        var icon : @Composable (() -> Unit)? = null;
        var keyboardType : KeyboardType = KeyboardType.Text;
        if(label == txtEmail){
            icon = {Icon(Icons.Default.Person, contentDescription = null)}
            keyboardType = KeyboardType.Email;
        }else if(label == txtPassword){
            icon = {Icon(Icons.Default.Lock, contentDescription = null)}
            keyboardType = KeyboardType.Password;
        }
        TextField(
            visualTransformation = if (!visPassword && label == txtPassword) PasswordVisualTransformation() else VisualTransformation.None ,
            leadingIcon = icon,
            label = {Text(label)},
            trailingIcon = { IconButton(onClick = {visPassword = !visPassword}) {
                Icon(painter =
                if(visPassword) painterResource(id = R.drawable.ic_check_circle)
                else painterResource(id = R.drawable.ic_check_circle_outline
                ), contentDescription = null)
            }},
            value = text,
            shape = RoundedCornerShape(20.dp),
            onValueChange = {newText -> text = newText},
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            textStyle = TextStyle( fontSize = 14.sp),
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = ImeAction.Next),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )
    }
    @Composable
    fun getbtns(){
        Box(Modifier.padding(top =  dimensionResource(id = R.dimen.pdd_btn_top))) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Button(
                    colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.m_dark_color)),
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                ) {
                    Text(text = stringResource(id = R.string.login), color = colorResource(id = R.color.white))
                }
                Box(Modifier.height(8.dp))
                Button(
                    colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.white)),
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)) {
                    Text(text = stringResource(id = R.string.log_up), color = colorResource(id = R.color.m_dark_color))
                }
            }
        }
    }
}