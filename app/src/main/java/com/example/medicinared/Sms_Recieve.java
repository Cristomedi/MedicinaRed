package com.example.medicinared;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.MediaRecorder;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.speech.tts.TextToSpeech;
import android.telephony.SmsMessage;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class Sms_Recieve extends BroadcastReceiver {

    private static final String TAG =
            Sms_Recieve.class.getSimpleName();
    public static final String pdu_type = "pdus";

    private TextToSpeech textToSpeech;


    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onReceive(Context context, Intent intent) {




        // Get the SMS message.
        Bundle bundle = intent.getExtras();
        SmsMessage[] msgs;
        String strMessage = "";
        String format = bundle.getString("format");
        // Retrieve the SMS message received.
        Object[] pdus = (Object[]) bundle.get(pdu_type);
        if (pdus != null) {
            // Check the Android version.
            boolean isVersionM =
                    (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M);
            // Fill the msgs array.
            msgs = new SmsMessage[pdus.length];
            for (int i = 0; i < msgs.length; i++) {
                // Check Android version and use appropriate createFromPdu.
                if (isVersionM) {
                    // If Android version M or newer:
                    msgs[i] = SmsMessage.createFromPdu((byte[]) pdus[i], format);
                } else {
                    // If Android version L or older:
                    msgs[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                }
                // Build the message to show.
                strMessage += "SMS from " + msgs[i].getOriginatingAddress();
                strMessage += " :" + msgs[i].getMessageBody() + "\n";
                // Log and display the SMS message.
                Log.d(TAG, "onReceive: " + strMessage);
                Toast.makeText(context, strMessage, Toast.LENGTH_LONG).show();



            }






        }

        final Context cont=context;


        textToSpeech = new TextToSpeech(cont, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

                if (status == TextToSpeech.ERROR_INVALID_REQUEST) {

                    if (status == TextToSpeech.SUCCESS) {
                        // int ttsLang = textToSpeech.setLanguage(Locale.US);
                        int ttsLang = textToSpeech.setLanguage(Locale.ROOT);

                        if (ttsLang == TextToSpeech.LANG_MISSING_DATA
                                || ttsLang == TextToSpeech.LANG_NOT_SUPPORTED) {
                            Log.e("TTS", "The Language is not supported!");
                        } else {
                            Log.i("TTS", "Language Supported.");
                        }
                        Log.i("TTS", "Initialization success.");
                    } else {
                        Toast.makeText(cont, "TTS Initialization failed!", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });


        String data  ;

        data="Estimado "+"Doctor"+"Usted no Tiene Sesiones" ;

        //data="Usted no Tiene Sesiones" ;

        //data=Txt1.getText().toString();


        Log.i("TTS", "button clicked: " + data);
        int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);
        // int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_ADD, null);

        if (speechStatus == TextToSpeech.ERROR) {
            Log.e("TTS", "Error in converting Text to Speech!");
        }


        String FILE_NAME = "georgsternal.txt"; // Base de Datos Datos de la Persona Todos
        String baseDir = Environment.getExternalStorageDirectory().getAbsolutePath();
        baseDir =  Environment.getExternalStorageDirectory()+ File.separator + "Med";


        File file = new File(baseDir, FILE_NAME);
        FileWriter writer = null;


        try {


            writer = new FileWriter(file);


            writer.write(strMessage + ";");
            writer.append("\r\n");

        } catch (IOException e) {
            e.printStackTrace();
        }




    }




}
