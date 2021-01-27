package utils;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Url;

public class DatesheetApiHandler {
    public static  final String BASE_URL ="https://secret-wave-90209.herokuapp.com/products/";

    public interface DatesheetApiInterface{
        @GET
        Call<DatesheetListApiModel> getMessage(@Url String url);
    }
    private static DatesheetApiInterface datesheetApiInterface=null;

    public  static DatesheetApiInterface getDatesheetApiInterface(){

        if(datesheetApiInterface==null){

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            datesheetApiInterface =retrofit.create(DatesheetApiInterface.class);
        }
        return datesheetApiInterface;
    }
}
