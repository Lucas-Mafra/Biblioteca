package classes

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot

class DataBase {

    private val db = FirebaseFirestore.getInstance()

    fun incluir(collection: String, document : String, data: Any) :Task<*>{
        val task = db.collection(collection).document(document).set(data)
        return task
    }
    fun consultar(collection: String, document : String): Task<DocumentSnapshot>? {

        val returnDocument = db.collection(collection).document(document).get()
        return returnDocument
    }
    fun consultar(collection: String): Task<QuerySnapshot>? {

        val task = db.collection(collection).get()
        return task
    }

}