package com.example.medicinared;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.Calendar;

public class llegada extends AppCompatActivity {

    private ListView list1;
    private Button btn2;
    private TextView Text1;
    private TextView Text2;
    private TextView T18;
    private TextView T19;
    private TextView T20;
    private TextView txt;

    private TextView Tnot1;
    private TextView Tnot2;
    private TextView Tnot3;


    private TextView Tnot11;
    private TextView Tnot12;
    private TextView Tnot13;

    private EditText Edi1;
    private EditText Edi2;
    private EditText Edi3;
    private EditText Edi4;


    private TextView TA1;
    private TextView TA2;
    private TextView TA3;
    private TextView TA4;


    private TextView TB1;
    private TextView TB2;
    private TextView TB3;
    private TextView TB4;

    private TextView TC1;
    private TextView TC2;
    private TextView TC3;
    private TextView TC4;

    private EditText Edil1;
    private EditText Edil2;
    private EditText Edil3;
    private EditText Edil4;
    private EditText Edil5;

    private ImageView Img;

    private ImageView imageView;


    // private ListView list1;
    String Origen;
    String Add;

    String Sternal[] = {"Centro Medico: Antonio Varas", "Centro Medico: Maipu"};

    String Agenda[][] = new String[1000][1000]; //Cuaidado con la capacidad de la matriz
    String Adapter[][] = new String[1000][1000]; //Cuaidado con la capacidad de la matriz
    String Persona[][] = new String[1000][20]; //Cuaidado con la capacidad de la matriz
    String Lugar[][] = new String[1000][5]; //Cuaidado con la capacidad de la matriz
    String Config[][] = new String[1000][3]; //Cuaidado con la capacidad de la matriz
    String LineaAgenda[][] = new String[1000][10];
    String LineaAgenda2[][] = new String[1000][10];
    String Bus[][] = new String[5][1];
    String Foto[][] = new String[1000][11];
    String Graba[][] = new String[1000][11];
    String Adap[][] = new String[1000][1000];

    String Medina[] = new String[2];

    String[] Lugarcito = {"Antonio Varas", "Lugar2", "Lugar3"};

    String name;

    String[] Nombres = {"Catalina Ugarte", "Cristóbal Medina", " Georg Sternal", "Joaquin Errazuriz", "Marcelo Fernandez", "Marco Alvarez", "Paulina Jaque", "Pablo Medina", "Thabatta Echaiz", "Vanessa Aracena", "Julio Hochschild"};


    int cadp;
    int caper;
    int calu;
    int calu2;
    int caconfig;
    int cafo;
    int cagraba;
    int calugar;
    String lugarchico;
    int sf;
    private String path;
    File fileImagen;

    int caso;

    String global;

    int global2;

    String julio;

    int julio2;

    String horafp;
    String minfp;

    String horaip;
    String minip;

    String h1;
    String m1;

    String h2;
    String m2;




    String diap;
    String mesp;
    String añop;
    //  String og;


    private String archivoSalida = null;
    // private String CARPETA_PRINCIPAL = "misImagenesApp/";
    private String CARPETA_IMAGEN = "imagenes/";
    //private String CARPETA_ARCHIVOS = "Agenda/";
    private String CARPETA_GRABACION = "Grabacion";

    //private String DIRECTORIO_IMAGEN = CARPETA_PRINCIPAL + CARPETA_IMAGEN;

    private String CARPETA_PRINCIPAL = "Med/misImagenesApp/";
    private String CARPETA_ARCHIVOS = "Med/Agenda/";
    private String DIRECTORIO_IMAGEN= CARPETA_PRINCIPAL+CARPETA_IMAGEN;


    private final int SELECT_PICTURE = 200;
    MediaPlayer player;
    private MediaRecorder grabacion;

    String Lugar2[][] = new String[1000][4];

    String EXTRAS;

    Calendar c;

    DatePickerDialog dpd;

    String texto;

    private EditText Edit11;

    private EditText Edit12;

    private EditText Edit13;

    private EditText Edit20;

    private TextView txt1;

    private TextView txt2;

    private TextView txt3;

    private TextView txt4;

    private TextView txt5;

    private TextView txt6;

    private TextView txt7;

    private TextView txt8;

    private TextView txt9;

    private TextView txt10;

    private TextView txt12;

    private TextView txt11;

    private TextView txt13;

    private TextView txt14;

    private TextView txt15;

    private TextView txt16;

    private ImageView img1;

    private ImageButton img2;

    private ImageButton img3;

    private ImageButton img4;

    private ImageButton img5;

    private ImageButton img6;

    private CheckBox check1;

    private CheckBox check2;





    private Switch swt1;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llegada);

        //private TextView txt1;

       // private TextView txt2;

       // private TextView txt3;

       // private TextView txt4;

       // private TextView txt5;

       // private TextView txt6;

       // private TextView txt7;

       // private TextView txt8;

     //   private TextView txt9;

       // private TextView txt10;

       // private TextView txt11;

       // private Switch swt1;

        txt1=(TextView)findViewById(R.id.textViewfi7);

        txt2=(TextView)findViewById(R.id.textViewfi15);

        txt3=(TextView)findViewById(R.id.textViewfi16);

        txt4=(TextView)findViewById(R.id.textViewfi17);

        txt5=(TextView)findViewById(R.id.textViewfi18);

        txt6=(TextView)findViewById(R.id.textViewfi19);

        txt7=(TextView)findViewById(R.id.textViewfi20);

        txt8=(TextView)findViewById(R.id.textViewfi21);

        txt9=(TextView)findViewById(R.id.textViewfi41);


        txt10=(TextView)findViewById(R.id.textViewfi26);

        txt11=(TextView)findViewById(R.id.textView20);

        txt13=(TextView)findViewById(R.id.textView18);

        txt14=(TextView)findViewById(R.id.textViewfi25);

        txt15=(TextView)findViewById(R.id.textViewficha1);

        txt16=(TextView)findViewById(R.id.textViewficha3);

        img1=(ImageView)findViewById(R.id.imageView4);

        img2=(ImageButton)findViewById(R.id.imageButtonfi7);

        img3=(ImageButton)findViewById(R.id.imageButtonfi8);

        img4=(ImageButton)findViewById(R.id.imageButtonficha5);

        img5=(ImageButton)findViewById(R.id.imageButtonficha2);

        img6=(ImageButton)findViewById(R.id.imageButtonficha4);

        check1=(CheckBox) findViewById(R.id.checkBox);

        check2=(CheckBox) findViewById(R.id.checkBox2);



        swt1=(Switch)findViewById(R.id.switch1);

        Edit20=(EditText) findViewById(R.id.editText2);

        btn2=(Button) findViewById(R.id.button5);

        txt5.setVisibility(View.INVISIBLE);

        txt6.setVisibility(View.INVISIBLE);

        txt7.setVisibility(View.INVISIBLE);

        txt8.setVisibility(View.INVISIBLE);

        txt9.setVisibility(View.INVISIBLE);

        txt10.setVisibility(View.INVISIBLE);

        txt11.setVisibility(View.INVISIBLE);

        txt13.setVisibility(View.INVISIBLE);

        txt14.setText("Descripción de Sintomas");

        txt15.setVisibility(View.INVISIBLE);

        txt16.setVisibility(View.INVISIBLE);

        swt1.setVisibility(View.INVISIBLE);

        Edit20.setVisibility(View.INVISIBLE);

        img1.setVisibility(View.INVISIBLE);

        img2.setVisibility(View.INVISIBLE);

        img3.setVisibility(View.INVISIBLE);

        img4.setVisibility(View.INVISIBLE);

        img5.setVisibility(View.INVISIBLE);

        img6.setVisibility(View.INVISIBLE);


       // btn2.setVisibility(View.INVISIBLE);

        btn2.setText("Solicitar");


        txt1.setText("Dr(a):"+"  Georg Sternal");

        txt2.setText("Especialidad:"+"  Sicología");

        txt3.setText("Genero:"+" Masculino");

        txt4.setText("Edad:"+"  40");

        check1.setVisibility(View.INVISIBLE);

        check2.setVisibility(View.INVISIBLE);



        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"Solicitado",Toast.LENGTH_LONG).show();

            }
        });








    }
}
