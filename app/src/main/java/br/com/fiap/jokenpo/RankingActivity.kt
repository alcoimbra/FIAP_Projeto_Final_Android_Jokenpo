package br.com.fiap.jokenpo

import android.app.DownloadManager
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import br.com.fiap.jokenpo.databinding.ActivityRankingBinding
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

class RankingActivity : AppCompatActivity {
    private lateinit var binding: ActivityRankingBinding
    private val listRanking = ArrayList<String>()
    private val database = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRankingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.listRanking.add("Aguarde...")
        binding.listview.adapter = ArrayAdapter<String>(this, R.layout.simple_list_item_1, listRanking)

        this.getRanking()
    }


    private fun getRanking() {
        this.listRanking.clear()

        database.collection("ranking")
            .orderBy("pontuacao", DownloadManager.Query.Direction.DESCENDING)
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    this.listRanking.add(document.data.get("nome").toString() + ": " + document.data.get("pontuacao").toString())
                }

                binding.listview.adapter = ArrayAdapter<String>(this, R.layout.simple_list_item_1, this.listRanking)
            }
            .addOnFailureListener { exception  ->
                Log.w(TAG, "Error getting documents : $exception")
            }
    }

}