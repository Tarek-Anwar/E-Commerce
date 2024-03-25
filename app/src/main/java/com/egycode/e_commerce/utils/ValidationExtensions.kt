package com.egycode.e_commerce.utils


fun String.isValidEmail() : Boolean{
    return android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
}
fun String.isValidPassword() : Boolean{
    val passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$"
    return this.matches(passwordRegex.toRegex())
}