package com.example.medicinared;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.util.Calendar;

public class listdoc extends AppCompatActivity {

    private ListView List2;

    private TextView mTextMessage;
    private ListView List1;
    private ImageView Img;
    int [] Imagenes={R.mipmap.catalinaugarte, R.mipmap.cmedina,R.mipmap.gsternal,R.mipmap.joaquinerrazuriz,R.mipmap.marcelofernandez,R.mipmap.marcoalvarez,R.mipmap.paulinajaque,R.mipmap.pmedina,R.mipmap.thabatta,R.mipmap.vanessaaracena};
    String [] Nombres= {"Catalina Ugarte","Cristóbal Medina"," Georg Sternal","Joaquin Errazuriz","Marcelo Fernandez","Marco Alvarez","Paulina Jaque","Pablo Medina","Thabatta Echaiz","Vanessa Aracena"};
    TextView Txt1;
    TextView Txt11;
    TextView Txt12;
    TextView Txt13;


    TextView Txt15;
    TextView Txt16;
    TextView Txt17;

    TextView Txt18;
    TextView Txt19;


    String[] detalles = new String[]{"Trauma de la Infancia", "Trauma de la Mujer", " Peleas Con Papas", "Problema com la Abuela", "Bajando la Ansiedad", "Superación de Traumas", "Superando Peleas", "Aprendiendo a Relacionarse", "Terapia con Mujeres", "Temas Sexuales"};
    String[] Enfermedad = {"Depresión", "TOC", " Sociopatia", "Esquizofrenia", "Depresión", "Stress", "Depresión", "TOC", "Sana", "Depresión"};
    ListView listview;


    ImageView Img1;

    ImageView Img2;

    ImageView Img3;

    ImageView Img4;

    ImageView Img5;

    ImageView img4;

    ImageView img5;

    ImageView img6;


    Calendar c;
    DatePickerDialog dpd;
    Calendar c1;
    DatePickerDialog dpd1;
    String Name;
    TextView Txt14;
    AutoCompleteTextView Edi;
    EditText Edi2;
    private String archivoSalida = null;
    //private String CARPETA_PRINCIPAL = "misImagenesApp/";
    private String CARPETA_IMAGEN = "imagenes";
    //private String CARPETA_ARCHIVOS = "Agenda/";

    // private String DIRECTORIO_IMAGEN = CARPETA_PRINCIPAL + CARPETA_IMAGEN;

    private String CARPETA_PRINCIPAL = "Med/misImagenesApp/";
    private String CARPETA_ARCHIVOS = "Med/Agenda/";
    private String DIRECTORIO_IMAGEN= CARPETA_PRINCIPAL+CARPETA_IMAGEN;

    private String path;

    private final int PHOTO_CODE = 100;

    private static final int COD_SELECCIONA = 10;
    private static final int COD_FOTO = 20;
    File fileImagen;
    Bitmap bitmap;


    //int [] Imagenes={R.mipmap.catalinaugarte, R.mipmap.cmedina,R.mipmap.gsternal,R.mipmap.joaquinerrazuriz,R.mipmap.marcelofernandez,R.mipmap.marcoalvarez,R.mipmap.paulinajaque,R.mipmap.pmedina,R.mipmap.thabatta,R.mipmap.vanessaaracena};
    String[] Sexo = {"Femenino", "Masculino", "Masculino", "Masculino", "Masculino", "Masculino", "Femenino", "Masculino", "Femenino", "Femenino", "Femenino", "Femenino", "Femenino", "Femenino"};

    String Agenda[][] = new String[1000][1000]; //Cuaidado con la capacidad de la matriz
    String Adapter[][] = new String[1000][1000]; //Cuaidado con la capacidad de la matriz
    String Persona[][] = new String[1000][24]; //Cuaidado con la capacidad de la matriz
    String Lugar[][] = new String[1000][4]; //Cuaidado con la capacidad de la matriz
    String Sesiones[][] = new String[1000][12]; //Cuaidado con la capacidad de la matriz
    String Sesionesx[][] = new String[1000][12]; //Cuaidado con la capacidad de la matriz

    String Sesiones1[][] = new String[1000][10]; //Cuaidado con la capacidad de la matriz
    String Sesiones2[][] = new String[1000][10]; //Cuaidado con la capacidad de la matriz|

    //String Sesiones

    String LineaAgenda[][] = new String[1][10];


    String name;
    String nombrecito;
    String fechita;
    int sf;
    String julito;
    int djulito;


    private TextToSpeech textToSpeech;


    int cadp;
    int cadp2;
    int caper;
    int calu;
    int julio;
    int def;


    int gro;
    String lugarchico;
    String fecha[] = new String[1];

    //int julito;

    String textito;

    int PersonaAux[] = new int[1000]; //Cuaidado con la capacidad de la matriz

    String Copio[] = new String[2];

    String Config [][]=new String[1000][3];

    int caconfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listdoc);

        List2=(ListView)findViewById(R.id.List2);


        CustomAdapter4 customAdapter4= new CustomAdapter4();

        List2.setAdapter(customAdapter4);

        List2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent2=new Intent(listdoc.this,doctor2.class);

                startActivity(intent2);



            }
        });

    }

    class CustomAdapter4 extends BaseAdapter {

        // public CustomAdapter() {
        //   super();
        //}

        @Override
        public int getCount() {
            return Imagenes.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup parent) {


            view=getLayoutInflater().inflate(R.layout.activity_lineardap33,null);

            // CircleImageView circleImageView=(CircleImageView)view.findViewById(R.id.circle2);
            TextView Txt11=(TextView)view.findViewById(R.id.textViewa8);
            TextView Txt12=(TextView)view.findViewById(R.id.textViewa9);
            TextView Txt13=(TextView)view.findViewById(R.id.textViewa10);
            ImageView Img1=(ImageView)view.findViewById(R.id.imageViewa);
            //TextView Txt12=(TextView)view.findViewById(R.id.textView6);
            //TextView Txt13=(TextView)view.findViewById(R.id.textView7);


            //Picasso.get().load(Imagenes[i]).into(circleImageView);
            Txt11.setText(Nombres[i]);
            Txt12.setText("Especialidad:" +" Psicología" );
            Txt13.setText("Genero:"+" Hombre");
            Img1.setImageResource(Imagenes[i]);

            //Txt12.setText(Secciones[i]);
            //Txt13.setText(i+ "/03/2019");

            return view;
        }
    }
}
