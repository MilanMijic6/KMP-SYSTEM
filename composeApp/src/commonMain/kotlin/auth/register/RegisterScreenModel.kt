package auth.register

data class RegisterScreenModel(
    var email: String,
    var password: String,
    var name: String,
    var role: String,
    var errorMsg: String
)

fun setInitState(): RegisterScreenModel = RegisterScreenModel(
    email = "",
    password = "",
    name = "",
    role = "",
    errorMsg = ""
)