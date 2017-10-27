package com.example.administrator.bluealert;

import android.app.NotificationManager;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    public static  DataControler dataControler = new DataControler();
    TextView uid_txv,pw_txv;
    AlertDialog.Builder dialog;
    private String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        dialogCreate();
        logging();
    }

    private void logging() {
        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG,"Token:"+token);
        dataControler.setToken(token);

        class Logging extends MySQL_Logging{
           protected void onPostExecute(String result){
               try {
                   JSONObject jresult = new JSONObject(result);
                   if (jresult.getString("uid").equals("-1")){
                       dialog.show();
                   }else{
                       dataControler.setUid(jresult.getString("uid"));
                       dataControler.setPassword(jresult.getString("password"));
                       uid_txv.setText(dataControler.getUid());
                       pw_txv.setText(dataControler.getPassword());
                   }
               } catch (JSONException e) {
                   e.printStackTrace();
               }
           }
        }
        new Logging().execute();
    }
    private void dialogCreate() {
        final EditText editText = new EditText(this);
        editText.setHint("請輸入簡易密碼");
        editText.setMaxWidth(100);
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);
        dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("請設置認證密碼").setPositiveButton("確定",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dataControler.setPassword(editText.getText().toString());
                new MySQL_Regist(uid_txv,pw_txv).execute(dataControler.getPassword());
            }
        }).setView(editText).setCancelable(false);
    }


    private void findView() {
        uid_txv = (TextView) findViewById(R.id.uid_txv);
        pw_txv = (TextView) findViewById(R.id.pw_txv);
    }
}
