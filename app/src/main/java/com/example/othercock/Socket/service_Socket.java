package com.example.othercock.Socket;

import static android.app.PendingIntent.FLAG_IMMUTABLE;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;

import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.example.othercock.MainActivity;
import com.example.othercock.R;

public class service_Socket extends Service implements Runnable{
    public static final String CHANNEL_ID = "SocketServiceChannel";
    public client_Socket client_socket;
    Intent intent;
    Context context;

    @Override
    public void onCreate(){

        Thread t = new Thread(this);
        t.start();


        super.onCreate();
    }




    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }


    @Override public int onStartCommand(Intent intent, int flags, int startId) {
         this.intent =  intent;


       String input = intent.getStringExtra("inputExtra"); //인텐트 값
        // 안드로이드 O버전 이상에서는 알림창을 띄워야 포그라운드 사용 가능
        createNotificationChannel();
        Intent notificationIntent = new Intent(this, MainActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, FLAG_IMMUTABLE);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Foreground Service")
                .setContentText(input)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pendingIntent) .build();

            startForeground(1, notification);



            //Login Activity -> service -> Server
            Thread send = new Thread(new Send(intent));
            send.start();

            //Server -> Service(brodcast) -> Activity(brodcast receiver)

        if(client_socket.line != null) {
            sendMessage();
        }



//        Intent i = new Intent(this,RegisterActivity.class);
//        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(i);

        return START_NOT_STICKY;
    }

    private void sendMessage() {

         if(client_socket.line != null) {
             Intent intent = new Intent("naminsik");
             intent.putExtra("pw", client_socket.line);
             LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
         }
    }

    @Override
    public void run() {
        System.out.println("클라이언트 실행");
        client_socket =  new client_Socket();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel serviceChannel = new NotificationChannel(
                    CHANNEL_ID,
                    "Foreground Service Channel",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            NotificationManager manager = getSystemService(NotificationManager.class);
            assert manager != null;
            manager.createNotificationChannel(serviceChannel);


        }
    }




    public class Send implements Runnable{

        private Intent intent;


        public Send(Intent intent){
            this.intent = intent;

        }

        @Override
        public void run() {
            String getPW = intent.getStringExtra("pw");
            System.out.println("여기는 get Pw 되냐?"+getPW);

            if(getPW != null) {
                try{
                    client_socket.setPW(getPW);
                } catch (Exception e ){
                    System.out.println("이거오류");
                }
                System.out.println(getPW);
            }
        }
    }

}