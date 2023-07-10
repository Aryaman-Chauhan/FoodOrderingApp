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
public class CrudServiceItem {
    public String createItem(Item item) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        System.out.println("We are in createItem");
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("Item").document(item.getItemId()).set(item);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public Item getItem(String id) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("Item").document(id);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();

        Item item;
        if (document.exists()) {
            item = document.toObject(Item.class);
            System.out.println("we are here in getItem truth check");
            System.out.println("\n Item name = " + item.getName()+"\n Item id = " + item.getItemId() + "\nItem prep time = " + item.getPrepTime() + "\n Item price = "+item.getPrice());

            return item;
        }
        return null;
    }

    public String deleteItem(String id) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection("Item").document(id).delete();
        return "Successfully deleted" + id;
    }

    public String updateItem(Item item) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("Item").document(item.getItemId()).set(item);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }
}
