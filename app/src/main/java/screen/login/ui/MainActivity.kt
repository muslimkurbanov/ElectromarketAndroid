package screen.login.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.firebaseauthexample.R
import kotlinx.android.synthetic.main.activity_main.*
import screen.registration.ui.RegistrationActivity
import screen.test.ui.TestActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registrationBtnMainAct.setOnClickListener {
            val intentToRegistrationAct = Intent(this, RegistrationActivity::class.java)
            startActivity(intentToRegistrationAct)
        }

        logInBtnMainAct.setOnClickListener {
            val intentToTestAct = Intent(this, TestActivity::class.java)
            startActivity(intentToTestAct)
        }
    }
}