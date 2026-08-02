package com.ofumi.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {

        HeaderSection()

        SummarySection()

        ArticleSection()

        DailyActionSection()

    }

}

@Composable
private fun HeaderSection() {

    Column {

        Text(
            text = "📬 御文",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "2026.08.01",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "AIは書くから働くへ",
            style = MaterialTheme.typography.headlineSmall
        )

    }

}

@Composable
private fun SummarySection() {

    Text(
        text = """
AI活用は、
ツール導入から
仕事の再設計へ。
        """.trimIndent()
    )

}

@Composable
private fun ArticleSection() {

    Column {

        Text(
            "今日読む3本",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(12.dp))

        ArticleCard("🆕", "AIレビュー運用")

        Spacer(modifier = Modifier.height(8.dp))

        ArticleCard("🔄", "Kotlin 2.2")

        Spacer(modifier = Modifier.height(8.dp))

        ArticleCard("🌍", "Android Studio")

    }

}

@Composable
private fun ArticleCard(
    badge: String,
    title: String
) {

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {

        Text(
            text = "$badge  $title",
            modifier = Modifier.padding(16.dp)
        )

    }

}

@Composable
private fun DailyActionSection() {

    Column {

        Text(
            "今日の一歩",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            "次のPRでAIにレビュー観点を聞いてみる。"
        )

    }

}