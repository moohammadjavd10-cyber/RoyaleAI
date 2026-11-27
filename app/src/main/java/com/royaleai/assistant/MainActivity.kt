package com.royaleai.assistant

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.*

class MainActivity : Activity() {

    private lateinit var chatLayout: LinearLayout
    private lateinit var input: EditText
    private val white = Color.WHITE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = LinearLayout(this)
        root.orientation = LinearLayout.VERTICAL
        root.setPadding(20, 20, 20, 20)
        root.setBackgroundColor(Color.rgb(20, 25, 40))

        val title = TextView(this)
        title.text = "Royale AI"
        title.textSize = 28f
        title.setTextColor(white)
        title.gravity = Gravity.CENTER
        root.addView(title)

        val scroll = ScrollView(this)
        chatLayout = LinearLayout(this)
        chatLayout.orientation = LinearLayout.VERTICAL
        chatLayout.setPadding(8, 20, 8, 20)

        scroll.addView(chatLayout)
        root.addView(scroll, LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, 0, 1f
        ))

        val bottom = LinearLayout(this)
        bottom.orientation = LinearLayout.HORIZONTAL

        input = EditText(this)
        input.hint = "پیامت رو بنویس..."
        input.setTextColor(white)
        input.setHintTextColor(Color.LTGRAY)
        input.setSingleLine(true)

        bottom.addView(input, LinearLayout.LayoutParams(
            0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f
        ))

        val send = Button(this)
        send.text = "ارسال"
        bottom.addView(send)

        send.setOnClickListener {
            val message = input.text.toString().trim()
            if (message.isNotEmpty()) {
                addMessage("شما: $message")
                addMessage("Royale AI: پیام شما دریافت شد! اتصال هوش مصنوعی در مرحله بعد اضافه می‌شود.")
                input.text.clear()
            }
        }

        root.addView(bottom)
        setContentView(root)

        addMessage("سلام! به Royale AI خوش آمدی.")
    }

    private fun addMessage(message: String) {
        val text = TextView(this)
        text.text = message
        text.textSize = 17f
        text.setTextColor(white)
        text.setPadding(12, 12, 12, 12)
        chatLayout.addView(text)
    }
}
