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
public class CrudServiceVendor {
    public String createVendor(Vendor vendor) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        System.out.println("We are in createVendor");
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("Vendor").document(vendor.getEmail()).set(vendor);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }



    public Vendor getVendor(String id) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("Vendor").document(id);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();

        Vendor vendor;
        if (document.exists()) {
            vendor = document.toObject(Vendor.class);
            System.out.println("we are here in getIVendor truth check");
           // System.out.println("\n Item name = " + item.getName()+"\n Item id = " + item.getItemId() + "\nItem prep time = " + item.getPrepTime() + "\n Item price = "+item.getPrice());

            return vendor;
        }
        return null;
    }

    public String deleteVendor(String id) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection("Vendor").document(id).delete();
        return "Successfully deleted" + id;
    }

    public String updateVendor(Vendor vendor) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("Vendor").document(vendor.getEmail()).set(vendor);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }
}
