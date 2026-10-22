package org.umn.servisin.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.umn.servisin.datas.AuthRepository
import org.umn.servisin.navigation.Screen
import org.umn.servisin.ui.theme.mainGradientBrush
import org.umn.servisin.ui.theme.splashGradientBrush
import org.umn.servisin.ui.theme.ServisinTheme
import androidx.navigation.compose.rememberNavController
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.compose.foundation.clickable
import androidx.compose.ui.platform.LocalContext
import java.util.Calendar
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import coil.compose.AsyncImage
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.windowInsetsPadding
@Composable
fun BookingPlan(navController: NavController) {

    var selectedDate by remember { mutableStateOf("") }
    var startTime by remember { mutableStateOf("") }
    var endTime by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var notes by remember { mutableStateOf("") }
    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }
    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        selectedImageUri = uri
    }

    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(mainGradientBrush)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = 48.dp,
                    start = 20.dp,
                    end = 20.dp,
                    bottom = 20.dp
                )
                .windowInsetsPadding(WindowInsets.navigationBars)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                IconButton(
                    onClick = {
                        navController.popBackStack()
                    },
                    modifier = Modifier
                        .size(40.dp)
                        .background(
                            Color.White.copy(alpha = 0.6f),
                            shape = CircleShape
                        )
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }

                Text(
                    text = "Booking Plan",
                    style = MaterialTheme.typography.titleSmall.copy(
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f)
                )

                Spacer(modifier = Modifier.size(40.dp))
            }

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(14.dp),
                contentPadding = PaddingValues(bottom = 20.dp),
                modifier = Modifier.fillMaxSize().weight(1f)
            ) {

                item {
                    // DATE
                    Text(
                        text = "Date",
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.padding(bottom = 4.dp)
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .background(
                                Color.LightGray.copy(alpha = 0.75f),
                                RoundedCornerShape(12.dp)
                            )
                            .clickable {

                                val calendar = Calendar.getInstance()

                                DatePickerDialog(
                                    context,
                                    { _, year, month, dayOfMonth ->

                                        selectedDate =
                                            "%02d/%02d/%04d".format(
                                                dayOfMonth,
                                                month + 1,
                                                year
                                            )

                                    },
                                    calendar.get(Calendar.YEAR),
                                    calendar.get(Calendar.MONTH),
                                    calendar.get(Calendar.DAY_OF_MONTH)
                                ).show()
                            }
                            .padding(horizontal = 14.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {

                        Text(
                            text = if (selectedDate.isEmpty())
                                "Select Date"
                            else
                                selectedDate,

                            style = MaterialTheme.typography.bodySmall.copy(
                                color = Color.DarkGray.copy(alpha = 0.8f)
                            )
                        )
                    }
                    // TIME

                    Spacer(modifier = Modifier.height(14.dp))

                    Text(
                        text = "Time",
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.padding(bottom = 4.dp)
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {

                        // START TIME

                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(48.dp)
                                .background(
                                    Color.LightGray.copy(alpha = 0.75f),
                                    RoundedCornerShape(12.dp)
                                )
                                .clickable {

                                    val calendar = Calendar.getInstance()

                                    TimePickerDialog(
                                        context,
                                        { _, hour, minute ->

                                            startTime =
                                                "%02d:%02d".format(
                                                    hour,
                                                    minute
                                                )

                                        },
                                        calendar.get(Calendar.HOUR_OF_DAY),
                                        calendar.get(Calendar.MINUTE),
                                        true
                                    ).show()
                                }
                                .padding(horizontal = 14.dp),
                            contentAlignment = Alignment.CenterStart
                        ) {

                            Text(
                                text = if (startTime.isEmpty())
                                    "Start Time"
                                else
                                    startTime,

                                style = MaterialTheme.typography.bodySmall.copy(
                                    color = Color.DarkGray.copy(alpha = 0.8f)
                                )
                            )
                        }


                        // END TIME

                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(48.dp)
                                .background(
                                    Color.LightGray.copy(alpha = 0.75f),
                                    RoundedCornerShape(12.dp)
                                )
                                .clickable {

                                    val calendar = Calendar.getInstance()

                                    TimePickerDialog(
                                        context,
                                        { _, hour, minute ->

                                            endTime =
                                                "%02d:%02d".format(
                                                    hour,
                                                    minute
                                                )

                                        },
                                        calendar.get(Calendar.HOUR_OF_DAY),
                                        calendar.get(Calendar.MINUTE),
                                        true
                                    ).show()
                                }
                                .padding(horizontal = 14.dp),
                            contentAlignment = Alignment.CenterStart
                        ) {

                            Text(
                                text = if (endTime.isEmpty())
                                    "End Time"
                                else
                                    endTime,

                                style = MaterialTheme.typography.bodySmall.copy(
                                    color = Color.DarkGray.copy(alpha = 0.8f)
                                )
                            )
                        }
                    }

                    // ADDRESS

                    Spacer(modifier = Modifier.height(14.dp))

                    Text(
                        text = "Address",
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.padding(bottom = 4.dp)
                    )

                    OutlinedTextField(
                        value = address,
                        onValueChange = {
                            address = it
                        },
                        placeholder = {
                            Text(
                                text = "Enter your address",
                                style = MaterialTheme.typography.bodySmall
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        shape = RoundedCornerShape(12.dp),
                        singleLine = true,
                        textStyle = MaterialTheme.typography.bodySmall,
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedContainerColor = Color.LightGray.copy(alpha = 0.75f),
                            focusedContainerColor = Color.LightGray.copy(alpha = 0.75f)
                        )
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    Text(
                        text = "Photo",
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.padding(bottom = 4.dp)
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .background(
                                Color.LightGray.copy(alpha = 0.75f),
                                RoundedCornerShape(12.dp)
                            )
                            .clickable {
                                imagePicker.launch("image/*")
                            },
                        contentAlignment = Alignment.Center
                    ) {

                        if (selectedImageUri == null) {

                            Text(
                                text = "Add Photo",
                                style = MaterialTheme.typography.bodySmall.copy(
                                    color = Color.DarkGray.copy(alpha = 0.7f)
                                )
                            )

                        } else {

                            AsyncImage(
                                model = selectedImageUri,
                                contentDescription = "Selected photo",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )
                        }
                    }

                    // NOTES

                    Spacer(modifier = Modifier.height(14.dp))

                    Text(
                        text = "Notes",
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.padding(bottom = 4.dp)
                    )

                    OutlinedTextField(
                        value = notes,
                        onValueChange = {
                            notes = it
                        },
                        placeholder = {
                            Text(
                                text = "Add notes",
                                style = MaterialTheme.typography.bodySmall
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp),
                        shape = RoundedCornerShape(12.dp),
                        textStyle = MaterialTheme.typography.bodySmall,
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedContainerColor =
                                Color.LightGray.copy(alpha = 0.75f),

                            focusedContainerColor =
                                Color.LightGray.copy(alpha = 0.75f)
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            Button(
                onClick = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor =
                        MaterialTheme.colorScheme.primary
                ),
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {

                Text(
                    text = "Book Now",
                    style = MaterialTheme.typography.labelLarge.copy(
                        color = MaterialTheme.colorScheme.surface,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}