
package com.example.othercock.Socket;
import android.content.Context;
import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.example.othercock.MainActivity;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class client_Socket implements Runnable {


    private BufferedReader br;
    private PrintWriter pw;
    private Socket socket;
    private String getPW;
    private Context context;
    public String line;


    PWThread pw1;

    client_Socket() {
        try {
            socket = new Socket("192.168.100.119", 9500);// ip주소 수정하세요

            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

            if (socket.isConnected()) {
                System.out.println("연결 되었습니다");
            } else if (socket.isClosed()) {
                System.out.println("연결 X");
            }

        } catch (UnknownHostException e) {
            System.out.println("서버를 찾을 수 없습니다");
            e.printStackTrace();
            System.exit(0);
        } catch (IOException e) {
            System.out.println("서버와 연결이 안되었습니다");
            e.printStackTrace();
            System.exit(0);
        }

        Thread t = new Thread(this);
        t.start();
    }


    public void setPW(String info) {
        this.getPW = info;

        pw1 = new PWThread();
        Thread t2 = new Thread(pw1);
        System.out.println("이름" + t2.getState());
        t2.start();
    }


    @Override
    public void run() {
        try {
        while (true){
            line = br.readLine();
            Intent intent = new Intent("naminsik");
            intent.putExtra("pw", line);
            LocalBroadcastManager.getInstance(MainActivity.ApplicationContext().getApplicationContext()).sendBroadcast(intent);

            if(line == null){
                System.out.println("close");
            }
        }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public class PWThread implements Runnable {

        @Override
        public void run() {
            pw.println(getPW);
            pw.flush();
        }
    }

}