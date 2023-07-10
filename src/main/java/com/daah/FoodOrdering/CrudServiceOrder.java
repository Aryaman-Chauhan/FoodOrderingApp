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
public class CrudServiceOrder {
    public String createOrder(Order order) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        System.out.println("We are in createOrder");
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("Order").document(order.getOrderId()).set(order);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }



    public Order getOrder(String id) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("Order").document(id);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();

        Order order;
        if (document.exists()) {
            order = document.toObject(Order.class);
            System.out.println("we are here in getIVendor truth check");
            // System.out.println("\n Item name = " + item.getName()+"\n Item id = " + item.getItemId() + "\nItem prep time = " + item.getPrepTime() + "\n Item price = "+item.getPrice());

            return order;
        }
        return null;
    }

    public String deleteOrder(String id) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection("Order").document(id).delete();
        return "Successfully deleted" + id;
    }

    public String updateOrder(Order order) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("Order").document(order.getOrderId()).set(order);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }
}
