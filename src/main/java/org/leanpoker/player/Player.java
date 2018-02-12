package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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
            System.out.println("1");
            System.out.println("1");
            System.out.println("1");
            JsonObject object = request.getAsJsonObject();
            JsonArray jarray = object.getAsJsonArray("players");
            JsonObject asd = jarray.get(0).getAsJsonObject();
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ezazgeciobject" + object);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ezazgecijarray" + jarray);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ezazgeciasd" + asd);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ezazgeci" + object);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ezazgeci" + object);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ezazgeci" + object);
            JsonArray ourCards;
            String card1rank = "0";
            String card2rank = "0";
            for (JsonElement req : jarray) {
                if (req.getAsJsonObject().get("hole_cards") != null){
                    ourCards = req.getAsJsonArray();
                    card1rank = ourCards.get(0).getAsJsonObject().get("rank").getAsString();
                    System.out.println(card1rank);
                    card2rank = ourCards.get(1).getAsJsonObject().get("rank").getAsString();
                    System.out.println("ertzdghj" + card2rank);
                    System.out.println("ertzdghj" + card2rank);
                    System.out.println("ertzdghj" + card2rank);
                    System.out.println("ertzdghj" + card2rank);
                    System.out.println("ertzdghj" + card2rank);
                    System.out.println("ertzdghj" + card2rank);
                    System.out.println("ertzdghj" + card2rank);
                    System.out.println("ertzdghj" + card2rank);
                    System.out.println("ertzdghj" + card2rank);
                }
            }
            if (card1rank.equals("0")){
                return 1;
            } else if (getGoodHeights().contains(card1rank) && getGoodHeights().contains(card2rank) && card1rank.equals(card2rank)) {
                return 500;
            /*} else if (getGoodHeights().contains(card1rank) && getGoodHeights().contains(card2rank)) {
                return 20;
            } else if (getGoodHeights().contains(card1rank) || getGoodHeights().contains(card2rank)) {
                return 30;*/
            } else {
                return 0;
            }

//            obj.get("");
        } catch (Exception e){
        System.out.println("exception" + e);
        System.out.println("exception" + e);
        System.out.println("exception" + e);
        System.out.println("exception" + e);
        System.out.println("exception" + e);
        System.out.println("exception" + e);
          return 0;
        }
    }

    public static void showdown(JsonElement game) {
    }
}
