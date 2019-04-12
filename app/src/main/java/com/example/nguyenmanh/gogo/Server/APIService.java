package com.example.nguyenmanh.gogo.Server;

public class APIService {
    private static String base_url = "https://aphrodisiac-fires.000webhostapp.com/server/";

    public static Dataservice getService(){
        return APIRetrofitClient.getClient(base_url).create(Dataservice.class);
    }
}
