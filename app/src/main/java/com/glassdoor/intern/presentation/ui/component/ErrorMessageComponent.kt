/*
 * Copyright (c) 2025, Glassdoor Inc.
 *
 * Licensed under the Glassdoor Inc Hiring Assessment License.
 * You may not use this file except in compliance with the License.
 * You must obtain explicit permission from Glassdoor Inc before sharing or distributing this file.
 * Mention Glassdoor Inc as the source if you use this code in any way.
 */

package com.glassdoor.intern.presentation.ui.component

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.glassdoor.intern.presentation.theme.InternTheme
import com.glassdoor.intern.utils.previewParameterProviderOf
import kotlinx.coroutines.delay

/**
 *DONE TODO: Define how long the error message will be displayed
 */
private const val SHOW_ERROR_MESSAGE_DURATION_IS_MILLIS: Long = 1000L

@Composable
internal fun ErrorMessageComponent(
    errorMessage: String?,
    hideErrorMessageAction: () -> Unit,
    modifier: Modifier = Modifier,
) = Crossfade(
    modifier = modifier,
    targetState = errorMessage,
    label = "ErrorMessageComponent",
) { state ->
    if (!state.isNullOrEmpty()) {
        /**
         *DONE TODO: Define the [background color](https://developer.android.com/jetpack/compose/modifiers#scope-safety), as well as [the color, style, and alignment](https://developer.android.com/jetpack/compose/text/style-text) of the error message
         */
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color.Gray)
                .padding(8.dp),
            text = state,
            color = Color.Black,
            fontSize = 16.sp,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center
        )

        LaunchedEffect(key1 = errorMessage) {
            delay(SHOW_ERROR_MESSAGE_DURATION_IS_MILLIS)

            /**
             * DONE TODO: Call an action that hides the error message
             */
            hideErrorMessageAction()
        }
    }
}

@Preview
@Composable
private fun ErrorMessageComponentPreview(
    @PreviewParameter(ErrorMessageComponentPreviewParameterProvider::class) errorMessage: String?
) = InternTheme {
    ErrorMessageComponent(
        errorMessage = errorMessage,
        hideErrorMessageAction = { },
    )
}

private class ErrorMessageComponentPreviewParameterProvider :
    PreviewParameterProvider<String?> by previewParameterProviderOf(null, "Error message")
