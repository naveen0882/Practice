/*
 * Click `Run` to execute the snippet below!
 */

/* 
Your previous Plain Text content is preserved below:

// Step 1)
//
// Imagine an Airbnb-like vacation rental service, where users in different cities can exchange their apartment with 
// another user for a week. Each user compiles a wishlist of the apartments they like. These wishlists are ordered, 
// so the top apartment on a wishlist is that user's first choice for where they would like to spend a vacation. 
// You will be asked to write part of the code that will help an algorithm find pairs of users who would like to 
// swap with each other.
//
// Given a set of users, each with an *ordered* wishlist of other users' apartments:
//
// a's wishlist: c d
// b's wishlist: d a c
// c's wishlist: a b
// d's wishlist: c a b
// e's wishlist: c a b
//
// The first user in each wishlist is the user's first-choice for whose apartment they would like to swap into.
// Write a function called hasMutualFirstChoice() which takes a username and returns true if that user and 
// another user are each other's first choice, and otherwise returns false.
//
// hasMutualFirstChoice('a') // true (a and c)
// hasMutualFirstChoice('b') // false (b's first choice does not *mutually* consider b as their first choice)
//
// Then expand the base case beyond just "first" choices, to include all "mutually ranked choices". Write another 
// function which takes a username and an option called "rank" to indicate the wishlist rank to query on. If given 
// a rank of 0, you should check for a first choice pair, as before. If given 1, you should check for a pair of 
// users who are each others' second-choice. Call your new function hasMutualPairForRank() and when done, 
// refactor hasMutualFirstChoice() to depend on your new function.
//
// hasMutualPairForRank('a', 0) // true (a and c)
// hasMutualPairForRank('a', 1) // true (a and d are mutually each others' second-choice)

====================================================================================

// Step 2)
//
// Every wishlist entry in the network is either "mutually ranked" or "not mutually ranked" depending on 
// the rank the other user gives that user's apartment in return.
//
// The most common operation in the network is incrementing the rank of a single wishlist entry on a single 
// user. This swaps the entry with the entry above it in that user's list. Imagine that, when this occurs, 
// the system must recompute the "mutually-ranked-ness" of any pairings that may have changed.
//
// Write a function that takes a username and a rank representing the entry whose rank is being bumped up.
// Return an array of the users whose pairings with the given user *would* gain or lose mutually-ranked 
// status as a result of the change, if it were to take place. Call your function changedPairings()
//
// a's wishlist: c d
// b's wishlist: d a c
// c's wishlist: a b
// d's wishlist: c a b
//
// // if d's second choice becomes their first choice, a and d will no longer be a mutually ranked pair
// changedPairings('d', 1) // returns ['a']
//
// // if b's third choice becomes their second choice, c and b will become a mutually ranked pair (mutual 
// second-choices)
// changedPairings('b', 2) // returns ['c']
//
// // if b's second choice becomes their first choice, no mutually-ranked pairings are affected
// changedPairings('b', 1) // returns []
//
*/
package udemy;

import java.io.*;
import java.util.*;

class Tests {
  public static Map<String, String[]> data () {
    Map<String, String[]> data = new HashMap<String, String[]>();
    data.put("a", new String[] {"c", "d"});
    data.put("b", new String[] {"d", "a", "c"});
    data.put("c", new String[] {"a", "b"});
    data.put("d", new String[] {"c", "a", "b"});
    return data;
  }

  public static void assertEqual(boolean actual, boolean expected) {
    if (expected == actual) {
      System.out.println("PASSED");
    } else {
      throw new AssertionError(
        "Expected:\n  " + expected + 
        "\nActual:\n  " + actual + 
        "\n");
    }
  }
  
  public static void assertEqual(String[] actual, String expected[]) {
    if (!String.join(",", expected).equals(String.join(",", actual))) {
      throw new AssertionError(
        "Expected:\n  " + String.join(",", expected) + 
        "\nActual:\n  " + String.join(",", actual) + 
        "\n");
    }
    System.out.println("PASSED");
  }
  
  public static void testHasMutualFirstChoice() {
    assertEqual(new Stripe(data()).hasMutualFirstChoice("a"), true);
    assertEqual(new Stripe(data()).hasMutualFirstChoice("b"), false);
  }
  
  public static void testHasMutualPairForRank() {
    assertEqual(new Stripe(data()).hasMutualPairForRank("a", 0), true);
    assertEqual(new Stripe(data()).hasMutualPairForRank("a", 1), true);
  }
  
  public static void testChangedPairings() {
    // if d's second choice becomes their first choice, a and d 
    // will no longer be a mutually ranked pair
    assertEqual(new Stripe(data()).changedPairings("d", 1), new String[]{"a"});

    // if b's third choice becomes their second choice, c and b 
    // will become a mutually ranked pair (mutual second-choices)
    assertEqual(new Stripe(data()).changedPairings("b", 2), new String[]{"c"});

    // if b's second choice becomes their first choice, no 
    // mutually-ranked pairings are affected
    assertEqual(new Stripe(data()).changedPairings("b", 1), new String[]{});
  }
}


class Stripe {
  
  Map<String, String[]> data;
  public Stripe(Map<String, String[]> data) {
    this.data = data;
  }
  
  public boolean hasMutualFirstChoice(String username) {
     /*if (username == null || username.isEmpty()) {
      return false;
    }
    
    int index = 0;
    
    String[] wishList = data.get(username);
    
    if (wishList == null || wishList.length == 0) {
      return false;
    }
    
    String[] pairedUserWishList = data.get(wishList[index]);
    
    if (pairedUserWishList == null || pairedUserWishList.length == 0) {
      return false;
    }
    
    if(username.equals(pairedUserWishList[index])) {
      return true;
    }
    
    return false; */
    
    return hasMutualPairForRank(username, 0);
  }
  
  public boolean hasMutualPairForRank(String username, int rank) {
    if (username == null || username.isEmpty()) {
      return false;
    }
    
    String[] wishList = data.get(username);
    
    if (wishList == null || wishList.length < rank) {
      return false;
    }
    
    String[] pairedUserWishList = data.get(wishList[rank]);
    
    if (pairedUserWishList == null || pairedUserWishList.length < rank) {
      return false;
    }
    
    if(username.equals(pairedUserWishList[rank])) {
      return true;
    }
    
    return false;
  }
  
  public String[] changedPairings(String username, int rank) {
    String[] affectedPairs = new String[2];
    String[] wishList = data.get(username);
    
    if (wishList == null) {
      return affectedPairs;
    }
    
    String[] pairedUserWishList = data.get(wishList[rank]);
    
    if(username.equals(pairedUserWishList[rank])) {
      affectedPairs[0] = pairedUserWishList[rank];
    }
    
    String temp = wishList[rank-1];
    wishList[rank-1] = wishList[rank];
    wishList[rank] = temp;
    
    String[] wishList2 = data.get(username);
    
    if (wishList == null) {
      return affectedPairs;
    }
    
    String[] pairedUserWishList2 = data.get(wishList2[rank]);
    
    if(username.equals(pairedUserWishList2[rank])) {
      affectedPairs[1] = pairedUserWishList2[rank];
    }
    
    return affectedPairs;  
    
  }

  
  public static void main(String[] args) {
    Tests.testHasMutualFirstChoice();
    Tests.testHasMutualPairForRank();
    // Tests.testChangedPairings();
  }
}


 
