package screen.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.firebaseauthexample.R
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.custom_toolbar_test_act.*
import screen.model.TestModel
import screen.test.mvp.TestView
import screen.test.ui.TestAdapter

class TestFragment : Fragment(), TestView {

    private lateinit var database: FirebaseDatabase
    private lateinit var ref: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initAlertDialog()
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        database = FirebaseDatabase.getInstance()
        ref = database.getReference("users")
            .child("69SdbxXWRfUUGOBy5mth3RgrZjQ2")
            .child("Tests")
            .child("TestsInformation")

        loadData()
        super.onCreate(savedInstanceState)
    }

    fun loadData() {

        val postListener = object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {

                var list = ArrayList<String>()
                var image = ArrayList<String>()

                for (data in dataSnapshot.child("TestsImage").children) {
                    var model = data.getValue(String::class.java)
                    image.add(model as String)
                }

                for (data in dataSnapshot.child("TestsName").children) {
                    var model = data.getValue(String::class.java)
                    list.add(model as String)
                }

                val adapter = TestAdapter(list, image)

                val recyclerView: RecyclerView? = view?.findViewById(R.id.recyclerViewTestAct)
                recyclerView?.adapter = adapter
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.d("err", "${databaseError.details} - ${databaseError.message}")
            }
        }

        ref.addValueEventListener(postListener)
    }

    fun initAlertDialog() {
        val alertDialog = AlertDialog.Builder(this.view!!.context).setTitle("Инструкция").setMessage(
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






