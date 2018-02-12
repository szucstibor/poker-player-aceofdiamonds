package org.leanpoker.player;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Player {

    static final String VERSION = "Default Java folding player";

    static List<String> getGoodHeights() {
        List<String> goodRanks = new ArrayList<>();
        String[] ranks = {"A", "K", "Q", "J", "10"};
        for (int i = 0; i < ranks.length; i++) {
            goodRanks.add(ranks[i]);
        }
        return goodRanks;
    }


    public static int betRequest(JsonElement request) {
        try {
            JsonObject object = request.getAsJsonObject();
            JsonArray jarray = object.getAsJsonArray("players");
            JsonObject ourPlayer = jarray.get(2).getAsJsonObject();

            System.out.println("OBJECT++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + object);
            System.out.println("JARRAY++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + jarray);
            System.out.println("OUR PLAYER++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + ourPlayer);

            JsonArray ourCards = ourPlayer.get("hole_cards").getAsJsonArray();
            System.out.println(ourCards);

            JsonElement card1 = ourCards.get(0);
            JsonElement card2 = ourCards.get(1);

            System.out.println("OUR CARDS____________________________________________________________________");
            System.out.println(ourCards);
            Map card1Map = new Gson().fromJson(card1, Map.class);
            System.out.println(card1Map.get("rank"));
            Map card2Map = new Gson().fromJson(card2, Map.class);
            System.out.println(card2Map.get("rank"));

            String card1Rank = (String) card1Map.get("rank");
            String card2Rank = (String) card2Map.get("rank");

            if (getGoodHeights().contains(card1Rank) && getGoodHeights().contains(card2Rank) && card1Rank.equals(card2Rank)) {
                return 500;
            } else if (getGoodHeights().contains(card1Rank) || getGoodHeights().contains(card2Rank)) {
                System.out.println("It could have been good");
                return 0;
            } else {
                return 0;
            }
        } catch (Exception e) {
            System.out.println("EXCEPTION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + e);
            return 0;
        }
    }

    public static void showdown(JsonElement game) {
    }
}
