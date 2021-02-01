package utils;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Url;

public class DatesheetsApiHandler {
    public static  final String BASE_URL ="https://secret-wave-90209.herokuapp.com/products/";

    public interface DemoInterface{
        @GET
        Call<DatesheetsApiModel> getMessage(@Url String url);
    }
    private static DemoInterface demoInterface=null;

    public  static DemoInterface getDemoInterface(){

        if(demoInterface==null){

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            demoInterface =retrofit.create(DemoInterface.class);
        }
        return demoInterface;
    }
}

