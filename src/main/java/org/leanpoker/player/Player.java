package org.leanpoker.player;

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
        for(int i = 0, i < ranks.length, i++){
            goodRanks.add(ranks[i]);
        }
        return goodRanks;
    }


    public static int betRequest(JsonElement request) {
        JsonObject obj = request.getAsJsonObject();
        obj.get("");
        return 1000;
    }

    public static void showdown(JsonElement game) {
    }
}
