package org.umn.servisin.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.umn.servisin.datas.AuthRepository
import org.umn.servisin.model.User
import org.umn.servisin.navigation.Screen
import org.umn.servisin.ui.theme.splashGradientBrush

@Composable
fun SignUp(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

//    validasi error
    var usernameError by remember { mutableStateOf(false) }
    var emailError by remember { mutableStateOf(false) }
    var phoneError by remember { mutableStateOf(false) }
    var passwordError by remember { mutableStateOf(false) }
    var confirmPasswordError by remember { mutableStateOf(false) }

//    state untuk pesan error
    var generalErrorMsg by remember { mutableStateOf<String?>(null) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(splashGradientBrush),
        contentAlignment = Alignment.TopStart
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 90.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = "Logo",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Sign Up",
                style = MaterialTheme.typography.titleLarge.copy(
                    color = MaterialTheme.colorScheme.primary
                )
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "Daftar Untuk Memulai",
                style = MaterialTheme.typography.titleMedium.copy(
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.8f)
                )
            )
        }

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.75f)
                .align(Alignment.BottomCenter),
            shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
            color = MaterialTheme.colorScheme.surface
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 28.dp, vertical = 36.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Ready To Service",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        color = MaterialTheme.colorScheme.primary,
                        textAlign = TextAlign.Center
                    )
                )

                Spacer(modifier = Modifier.height(24.dp))

//                tampilkan teks error
                if (generalErrorMsg != null) {
                    Text(
                        text = generalErrorMsg!!,
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                }

//                username input
                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it; usernameError = false; generalErrorMsg = null },
                    placeholder = { Text(text = "Username", style = MaterialTheme.typography.bodySmall) },
                    leadingIcon = { Icon(Icons.Default.Person, contentDescription = null, tint = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f)) },
                    isError = usernameError,
                    supportingText = { if (usernameError) Text("Username wajib diisi", color = MaterialTheme.colorScheme.error) },
                    textStyle = MaterialTheme.typography.bodySmall,
                    shape = RoundedCornerShape(12.dp),
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(4.dp))

//                email input
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it; emailError = false; generalErrorMsg = null },
                    placeholder = { Text(text = "Email", style = MaterialTheme.typography.bodySmall) },
                    leadingIcon = { Icon(Icons.Default.Email, contentDescription = null, tint = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f)) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    isError = emailError,
                    supportingText = { if (emailError) Text("Email tidak boleh kosong / format salah", color = MaterialTheme.colorScheme.error) },
                    textStyle = MaterialTheme.typography.bodySmall,
                    shape = RoundedCornerShape(12.dp),
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(4.dp))

//                phone input
                OutlinedTextField(
                    value = phone,
                    onValueChange = { phone = it; phoneError = false; generalErrorMsg = null },
                    placeholder = { Text(text = "Nomor HP", style = MaterialTheme.typography.bodySmall) },
                    leadingIcon = { Icon(Icons.Default.Phone, contentDescription = null, tint = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f)) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    isError = phoneError,
                    supportingText = { if (phoneError) Text("Nomor HP wajib diisi", color = MaterialTheme.colorScheme.error) },
                    textStyle = MaterialTheme.typography.bodySmall,
                    shape = RoundedCornerShape(12.dp),
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(4.dp))

//                password input
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it; passwordError = false },
                    placeholder = { Text(text = "Password", style = MaterialTheme.typography.bodySmall) },
                    leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null, tint = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f)) },
                    isError = passwordError,
                    supportingText = { if (passwordError) Text("Password minimal 6 karakter", color = MaterialTheme.colorScheme.error) },
                    textStyle = MaterialTheme.typography.bodySmall,
                    visualTransformation = PasswordVisualTransformation(),
                    shape = RoundedCornerShape(12.dp),
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(4.dp))

//                confirm passowrd
                OutlinedTextField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it; confirmPasswordError = false },
                    placeholder = { Text(text = "Confirm Password", style = MaterialTheme.typography.bodySmall) },
                    leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null, tint = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f)) },
                    isError = confirmPasswordError,
                    supportingText = { if (confirmPasswordError) Text("Password tidak sama", color = MaterialTheme.colorScheme.error) },
                    textStyle = MaterialTheme.typography.bodySmall,
                    visualTransformation = PasswordVisualTransformation(),
                    shape = RoundedCornerShape(12.dp),
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(12.dp))

//                register button
                Button(
                    onClick = {
                        var isValid = true
                        if (username.isBlank()) { usernameError = true; isValid = false }
                        if (email.isBlank() || !email.contains("@")) { emailError = true; isValid = false }
                        if (phone.isBlank()) { phoneError = true; isValid = false }
                        if (password.length < 6) { passwordError = true; isValid = false }
                        if (confirmPassword != password || confirmPassword.isBlank()) { confirmPasswordError = true; isValid = false }

                        if (isValid) {
                            val newUser = User(username, email, phone, password)
                            val isSuccess = AuthRepository.registerUser(newUser)

                            if (isSuccess) {
                                // Berhasil daftar, arahkan ke Login
                                navController.navigate(Screen.Login.route) {
                                    popUpTo(Screen.Signup.route) { inclusive = true }
                                }
                            } else {
                                generalErrorMsg = "Email atau Nomor HP sudah terdaftar!"
                            }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp)
                ) {
                    Text(
                        text = "Daftar",
                        style = MaterialTheme.typography.labelLarge.copy(
                            color = MaterialTheme.colorScheme.surface
                        )
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Sudah punya akun? ",
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.7f)
                        )
                    )
                    TextButton(onClick = { navController.popBackStack() }) {
                        Text(
                            text = "Masuk",
                            style = MaterialTheme.typography.bodySmall.copy(
                                color = MaterialTheme.colorScheme.primary
                            )
                        )
                    }
                }
            }
        }
    }
}