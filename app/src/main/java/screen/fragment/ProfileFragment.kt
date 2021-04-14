package screen.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.firebaseauthexample.R
import kotlinx.android.synthetic.main.custom_toolbar_test_act.*

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        initAlertDialog()

        super.onViewCreated(view, savedInstanceState)
    }

    fun initAlertDialog() {
        val alertDialog = AlertDialog.Builder(context)
            .setTitle("Инструкция")
            .setMessage(
                "После нажатия кнопки 'Приступить к тесту' вы перейдете к просмотру"
                        + "\n"
                        + "видеоролика с материалом по тесту."
                        + "\n"
                        + "После просмотра видеоролика"
                        + "\n"
                        + "нажмите на кнопку 'Начать тест' и приступайте к выполнению теста"
            )
            .setPositiveButton("OK") { _, _ ->

            }.create()

        iconHelp.setOnClickListener {
            alertDialog.show()
        }
    }

}