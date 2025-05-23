package com.siri.taxi.ui.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.siri.data.TransportType
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.RadioButton
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.siri.data.transportPrices

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransportSelectionBottomSheet(
    selectedType: TransportType?,
    onTypeSelected: (TransportType) -> Unit,
    onConfirm: () -> Unit
) {
    val sheetState = rememberModalBottomSheetState()
    ModalBottomSheet(
        onDismissRequest = {},
        sheetState = sheetState
    ) {
        Column(Modifier.padding(16.dp)) {
            Text("Select vehicles", fontWeight = FontWeight.Bold)

            TransportType.values().forEach { type ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                        .clickable { onTypeSelected(type) },
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFEFEFEF)) // สีพื้นหลังอ่อน ๆ
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {
                        Text("${type.displayName} (${transportPrices[type] ?: "N/A"})")

                        Spacer(modifier = Modifier.width(8.dp))

                        Image(
                            painter = painterResource(id = type.iconRes),
                            contentDescription = type.displayName,
                            modifier = Modifier.size(24.dp)
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        RadioButton(selected = selectedType == type, onClick = { onTypeSelected(type) })
                    }
                }
            }

            Button(
                onClick = onConfirm,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Submit")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TransportSelectionBottomSheetPreview() {
    // จำลอง state ไว้เพื่อทดสอบ preview
    var selected by remember { mutableStateOf<TransportType?>(TransportType.MOTORBIKE) }

    TransportSelectionBottomSheet(
        selectedType = selected,
        onTypeSelected = { selected = it },
        onConfirm = { /* preview ไม่มี action จริง */ }
    )
}

