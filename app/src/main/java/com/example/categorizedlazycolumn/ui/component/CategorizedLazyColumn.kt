@file:OptIn(ExperimentalFoundationApi::class, ExperimentalFoundationApi::class)

package com.example.categorizedlazycolumn.ui.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.categorizedlazycolumn.model.ContactCategory
import com.example.categorizedlazycolumn.utils.Instance

@Composable
fun CategorizedLazyColumn(category: List<ContactCategory>, modifier: Modifier = Modifier) {
    LazyColumn(modifier) {
        category.forEach { category ->
            stickyHeader {
                CategorizedHeader(text = category.name)
            }
            items(category.item) { text ->
                CategorizedItems(text = text)
            }
        }
    }

}

@Preview(showSystemUi = true)
@Composable
fun CategorizedLazyColumnPreview() {
    val nameList = Instance.names.map {
        ContactCategory(name = it.key.toString(), item = it.value)
    }
    CategorizedLazyColumn(category = nameList)
}

