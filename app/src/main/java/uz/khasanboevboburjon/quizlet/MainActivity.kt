package uz.khasanboevboburjon.quizlet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        val startButton = findViewById<AppCompatButton>(R.id.btn_start)
        val nameText  = findViewById<EditText>(R.id.et_name)
        startButton.setOnClickListener {
            if(nameText.text.toString().trim().length<3){
             Toast.makeText(this,"Please enter correct name",Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME,nameText.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}