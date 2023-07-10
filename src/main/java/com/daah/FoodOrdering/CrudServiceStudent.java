package com.daah.FoodOrdering;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class CrudServiceStudent {
    public String createStudent(Student stud) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("Student").document(stud.getEmail()).set(stud);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public Student getStudent(String id) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("Student").document(id);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();

        Student stud;
        if (document.exists()) {
            stud = document.toObject(Student.class);
            System.out.println("we are here in get student truth check");
            System.out.println("\n Item name = " + stud.getName()+"\n Item id = ");
            return stud;
            //return item;
        }
        return null;
    }




    public String deleteStudent(String id) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection("Student").document(id).delete();
        return "Successfully deleted" + id;
    }

    public String updateStudent(Student stud){
        return "";
    }
}
