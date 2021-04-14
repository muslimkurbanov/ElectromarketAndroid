package screen.test.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.firebaseauthexample.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_test_layout.view.*
import screen.model.TestModel

class TestAdapter(
    val modelTestList: ArrayList<String>,
    val imageTestList: ArrayList<String>

) : RecyclerView.Adapter<TestAdapter.TestViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestAdapter.TestViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_test_layout, parent, false)
        return TestViewHolder(itemView)
    }

//    fun setData(testModelList: ArrayList<TestModel>) {
//        modelTestList.addAll(testModelList)
//        notifyDataSetChanged()
//    }

    override fun getItemCount(): Int {
        return modelTestList.size
    }

    override fun onBindViewHolder(holder: TestAdapter.TestViewHolder, position: Int) {
        holder.titleTextView?.text = modelTestList.get(position)
        val path = imageTestList[position]

        Picasso.get()
            .load(path)
            .resize(250, 250)
            .centerCrop()
            .into(holder.image)
    }

    class TestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titleTextView: TextView? = null
        var image: ImageView?= null
        init {
            titleTextView = itemView.titleTest
            image = itemView.imageTest
        }
    }
}