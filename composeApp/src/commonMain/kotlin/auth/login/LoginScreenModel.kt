package auth.login

data class LoginScreenModel(
    var email: String,
    var password: String,
    var errorMsg: String
)

fun setInitState(): LoginScreenModel = LoginScreenModel(
    email = "",
    password = "",
    errorMsg = ""
)