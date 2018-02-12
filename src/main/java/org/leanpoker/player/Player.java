package org.leanpoker.player;

import com.google.gson.*;

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
            JsonObject object = request.getAsJsonObject();
            JsonArray jarray = object.getAsJsonArray("players");
            JsonObject ourPlayer = jarray.get(2).getAsJsonObject();
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ezazgeciobject" + object);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ezazgecijarray" + jarray);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ezazgeciasd" + ourPlayer);
            String card1rank = "0";
            String card2rank = "0";

            JsonArray ourCards = ourPlayer.get("hole_cards").getAsJsonArray();
            System.out.println(ourCards);

            JsonElement card1 = ourCards.get(0);
            JsonElement card2 = ourCards.get(1);

            System.out.println("____________________________________________________________________");
            System.out.println(ourCards);
            Map result1 = new Gson().fromJson(card1, Map.class);
            System.out.println(result1.get("rank"));
            Map result2 = new Gson().fromJson(card2, Map.class);
            System.out.println(result2.get("rank"));

            String rank1 = (String) result1.get("rank");
            String rank2 = (String) result2.get("rank");

            /*for (JsonElement req : jarray) {
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
            }*/

            if (getGoodHeights().contains(rank1) && getGoodHeights().contains(rank2) && rank1.equals(rank2)) {
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
