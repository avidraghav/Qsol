package utils;

import android.app.Application;

public class ConnectivityHelper extends Application {
    private static ConnectivityHelper mInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }
    public  static synchronized  ConnectivityHelper getInstance(){
        return mInstance;
    }
    public void setConnectivityListener(ConnectivityReceiver.ConnectivityReceiverListener listener){
        ConnectivityReceiver.connectivityReceiverListener = listener;
    }
}
