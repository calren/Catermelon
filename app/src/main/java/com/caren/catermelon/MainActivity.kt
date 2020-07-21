package com.caren.catermelon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

class MainActivity : AppCompatActivity() {
    val samplePost = hashMapOf(
            "description" to "SECOND!",
            "timestamp" to Calendar.getInstance().timeInMillis,
            "user" to "Caren"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Access a Cloud Firestore instance
        val db = FirebaseFirestore.getInstance()

        // Similar to a 'post' request to the {posts} endpoint
        db.collection("posts").add(samplePost).addOnSuccessListener {
            Log.i("Caren", "Added new post!")
        }

        // Similar to a 'get' request to the {posts} endpoint
        db.collection("posts").get().addOnSuccessListener {
            val posts = it.documents
            for (post in posts) {
                Log.i("Caren", "post " + post.get("description") + " " + post.get("timestamp"))
            }
        }
    }
}