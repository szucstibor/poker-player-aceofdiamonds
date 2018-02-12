package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {

    static final String VERSION = "Default Java folding player";

    static List<String> getGoodHeights() {
        List<String> goodRanks = new ArrayList<>();
        String[] ranks = { "A","K","Q","J","10" };
        for(int i = 0; i < ranks.length; i++){
            goodRanks.add(ranks[i]);
        }
        return goodRanks;
    }


    public static int betRequest(JsonElement request) {
        try{
            JsonArray requests = request.getAsJsonArray();
            JsonArray ourCards;
            String card1rank = "0";
            String card2rank = "0";
            for (JsonElement req : requests) {
                if (!req.getAsJsonObject().get("hole_cards").isJsonNull()){
                    ourCards = req.getAsJsonArray();
                    card1rank = ourCards.get(0).getAsJsonObject().get("rank").getAsString();
                    System.out.println(card1rank);
                    card2rank = ourCards.get(1).getAsJsonObject().get("rank").getAsString();
                    System.out.println(card2rank);
                    System.out.println(card2rank);
                    System.out.println(card2rank);
                    System.out.println(card2rank);
                    System.out.println(card2rank);
                    System.out.println(card2rank);
                    System.out.println(card2rank);
                    System.out.println(card2rank);
                }
            }
            if (card1rank.equals("0")){
                return 20;
            } else if (getGoodHeights().contains(card1rank) && getGoodHeights().contains(card2rank)) {
                return 1000;
            } else if (getGoodHeights().contains(card1rank) || getGoodHeights().contains(card2rank)) {
                return 500;
            } else {
                return 0;
            }

//            obj.get("");
        } catch (Exception e){
            System.out.println(e);
            System.out.println(e);
            System.out.println(e);
            System.out.println(e);
            System.out.println(e);
            System.out.println(e);
            System.out.println(e);
          return 0;
        }
    }

    public static void showdown(JsonElement game) {
    }
}
