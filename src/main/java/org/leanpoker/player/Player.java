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
        List<HashMap<String, String>> goodCardCombinations = new ArrayList<>();
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
                    card2rank = ourCards.get(1).getAsJsonObject().get("rank").getAsString();
                }
            }
            if (!card1rank.equals("0")){
                return 420;
            } else{
                return 430;
            }
//            obj.get("");
        } catch (Exception e){
          return 400;
        }
        return 1000;
    }

    public static void showdown(JsonElement game) {
    }
}
