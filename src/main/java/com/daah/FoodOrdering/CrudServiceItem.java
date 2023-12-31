package com.daah.FoodOrdering;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

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

    public ModelAndView getItemQuery(String vendorEmail) throws ExecutionException, InterruptedException {
        int i = 0;
        String[] array = new String[4];
        System.out.println("In query section");
        Firestore dbFirestore = FirestoreClient.getFirestore();
        CollectionReference itemQuery = dbFirestore.collection("Item");
        Query query = itemQuery.whereEqualTo("type", "Sweet");
        ApiFuture<QuerySnapshot> querySnapshot = query.get();
        System.out.println("In Last query section");
        ModelAndView mv = new ModelAndView();

        for (DocumentSnapshot document : querySnapshot.get().getDocuments())
        {System.out.println(document.getId());
            mv.addObject("send"+String.valueOf(i),document.getId());
            i++;
          //  System.out.println("Value of i =" + i+ "Value of document.getId" + document.getId());
    }
return mv;
           /*for(int j=0;j<=i;j++)
            System.out.println(array[j]);
        ModelAndView mv = new ModelAndView("hometest");
        mv.addObject("array",array);
        return mv;*/
    }
    /* public void getItemQuery() throws ExecutionException, InterruptedException {
        System.out.println("In query section");
        Firestore dbFirestore = FirestoreClient.getFirestore();
        CollectionReference itemQuery = dbFirestore.collection("Item");
        Query query = itemQuery.whereEqualTo("type","Sweet");
        ApiFuture<QuerySnapshot> querySnapshot = query.get();
        System.out.println("In Last query section");

       for(DocumentSnapshot document : querySnapshot.get().getDocuments())
           System.out.println(document.getId());

    }*/
}
