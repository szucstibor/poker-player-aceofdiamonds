package org.leanpoker.player;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Map;

public class Player {

    static final String VERSION = "Default Java folding player";

    public static int betRequest(JsonElement request) {
        try{
            JsonArray requests = request.getAsJsonArray("request");
            List<> ourCards = new ArrayList();
            for (JsonElement request : requests) {
                if (request.getAsJsonObject().get("hole_cards") != []){
                    ourCards.add(request.getAsJsonObject().get("hole_cards"));
                }
            }
            obj.get("");
        } catch (Exeption e){
          return 999;
        }
        return 1000;
    }

    public static void showdown(JsonElement game) {
    }
}
