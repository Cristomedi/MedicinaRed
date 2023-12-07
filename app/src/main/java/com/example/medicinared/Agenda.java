package com.example.medicinared;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import de.hdodenhof.circleimageview.CircleImageView;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Vibrator;
import android.speech.tts.TextToSpeech;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import static android.view.View.INVISIBLE;
import static android.widget.Toast.LENGTH_SHORT;

public class Agenda extends AppCompatActivity {


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


    private ListView list1;
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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        setTitle(" 💉 " + " Medicine");

        setTitle("Medicos a Domicilio");

        try {
            CargaDatos();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // try {
        //   Cargafoto();
        //} catch (IOException e) {
        //  e.printStackTrace();
        //}

        //setotrosdatos();

        // builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
        //  @Override
        //  public void onClick(DialogInterface dialog, int which) {

        //Intent i= new Intent(getContext(),lanzamiento.class);

        //Bundle miBundle= new Bundle();
        //miBundle.putString("nombre",x.toString());
        //i.putExtra("s1","Texto de Prueba");
        //startActivity(i);


        //  }
        //   });


        // builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
        //  @Override
        // public void onClick(DialogInterface dialog, int i) {


        // }
        // });

        String Sternal[] = {"Foto1", "Foto2"};

        //Toast.makeText(getContext(), Integer.toString(largo), LENGTH_SHORT).show();
        list1 = (ListView) findViewById(R.id.list20);
        final CustomAdapter2 customAdapter2 = new CustomAdapter2();
        list1.setAdapter(customAdapter2);
        // final CustomAdapter20 customAdapter = new CustomAdapter20();
        //list1.setAdapter(customAdapter);

        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent2=new Intent(Agenda.this,Doctor.class);

                startActivity(intent2);


            }
        });





    }

    class CustomAdapter2 extends BaseAdapter {


        // public CustomAdapter() {
        //   super();
        //}

        @Override
        public int getCount() {
            //return Imagenes.length;
            //  int largo = Integer.parseInt(global) + 1;
            //return 2;
            return caper;  // Cantidad
        }

        @Override
        public Object getItem(int i) {
            // ACa
            return i;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup parent) {

            //i=8;
            view = getLayoutInflater().inflate(R.layout.activity_adapter_pacientes, null);

            CircleImageView circleImageView = (CircleImageView) view.findViewById(R.id.circlepa2);
            TextView Txt1 = (TextView) view.findViewById(R.id.textViewp25);
            TextView Txt11 = (TextView) view.findViewById(R.id.textViewp26);

            Txt11 = (TextView) view.findViewById(R.id.textViewp26);
            TextView Txt22 = (TextView) view.findViewById(R.id.textViewp27);


            String s;
            // s=Integer.toString(i+1);
            s = Persona[i][0];

            String Foto = s + ".jpg";
            //  Foto ="Lugar"+s + ".jpg";
            // Circle=(CircleImageView) findViewById(R.id.circle1);
            String Path = Environment.getExternalStorageDirectory() + File.separator + DIRECTORIO_IMAGEN + File.separator + Foto;
            Path = "file://" + Path + "";

            Picasso.get().load(Path).into(circleImageView);


            //Picasso.get().load(Imagenes[i]).into(circleImageView);
            // Txt1.setText(Nombres[i]);
            Txt1.setText(Persona[i][1] + " " + Persona[i][2]);
            Txt11.setText("05/04/2019");
            Txt11.setText("");
            Txt22.setVisibility(INVISIBLE);

            //  Txt1.setText(Lugarcito[i]);
            //    Txt11.setText(""); // Aca van las Fechas
            //   Txt22.setText(""); // Aca van las Fechas

            //Mediano[i]=Nombres[j];


            return view;

        }
    }






    private void CargaDatos() throws IOException {

        //  List<String> listado= new ArrayList<String>();
        //  String linea;
        //  String FILE_NAME="sternal.txt"; // Base de Datos Sesión que con la Agenda
        //  String baseDir= Environment.getExternalStorageDirectory().getAbsolutePath();
        //  File file= new File(baseDir,FILE_NAME);
        //  FileReader fReader= new FileReader(file);
        //  InputStream is= new FileInputStream(file);
        //   BufferedReader reader=new BufferedReader(fReader);


        List<String> listado1 = new ArrayList<String>();
        String linea1;
        String linea11;
        String FILE_NAME1 = "persona1.txt"; // Base de Datos Datos de la Persona Todos
        String baseDir1 = Environment.getExternalStorageDirectory().getAbsolutePath();
        baseDir1 = Environment.getExternalStorageDirectory()+ File.separator + "Med";
        File file1 = new File(baseDir1, FILE_NAME1);
        FileReader fReader1 = new FileReader(file1);
        InputStream is1 = new FileInputStream(file1);
        BufferedReader reader1 = new BufferedReader(fReader1);
        String FILE_NAME11 = "persona1.txt"; // Base de Datos Datos de la Persona Todos
        String baseDir11 = Environment.getExternalStorageDirectory().getAbsolutePath();
        baseDir11 =  Environment.getExternalStorageDirectory()+ File.separator + "Med";
        File file11 = new File(baseDir11, FILE_NAME11);
        FileReader fReader11 = new FileReader(file11);
        InputStream is11 = new FileInputStream(file11);
        BufferedReader reader11 = new BufferedReader(fReader11);

        //esto es para SDCARD


        List<String> listado2 = new ArrayList<String>();
        String linea2;
        String linea3;
        // String FILE_NAME2="prueba.txt"; // Base de Datos para probar los Algoritmos
        String FILE_NAME2 = "agenda.txt"; // Base de Datos para probar los Algoritmos
        String baseDir2 = Environment.getExternalStorageDirectory() + File.separator + CARPETA_ARCHIVOS;
        // String Path= Environment.getExternalStorageDirectory()+ File.separator+DIRECTORIO_IMAGEN+File.separator+Foto;
        File file2 = new File(baseDir2, FILE_NAME2);
        FileReader fReader2 = new FileReader(file2);
        InputStream is2 = new FileInputStream(file2);
        BufferedReader reader2 = new BufferedReader(fReader2);
        String baseDir3 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + CARPETA_ARCHIVOS;

        File file3 = new File(baseDir3, FILE_NAME2);
        FileReader fReader3 = new FileReader(file3);
        InputStream is3 = new FileInputStream(file3);
        BufferedReader reader3 = new BufferedReader(fReader3);


        List<String> listado5 = new ArrayList<String>();
        String linea5;
        String linea51;
        String FILE_NAME5 = "config2.txt"; // Base de Datos Datos de la Persona Todos
        String baseDir5 = Environment.getExternalStorageDirectory() + File.separator + CARPETA_ARCHIVOS;
        File file5 = new File(baseDir5, FILE_NAME5);
        FileReader fReader5 = new FileReader(file5);
        InputStream is5 = new FileInputStream(file5);
        BufferedReader reader5 = new BufferedReader(fReader5);

        List<String> listado6 = new ArrayList<String>();
        String linea6;
        String linea61;
        String FILE_NAME6 = "config.txt"; // Base de Datos Datos de la Persona Todos
        String baseDir6 = Environment.getExternalStorageDirectory() + File.separator + CARPETA_ARCHIVOS;
        File file6 = new File(baseDir6, FILE_NAME6);
        FileReader fReader6 = new FileReader(file6);
        InputStream is6 = new FileInputStream(file6);
        BufferedReader reader6 = new BufferedReader(fReader6);

        List<String> listado7 = new ArrayList<String>();
        String linea7;
        String linea71;
        String FILE_NAME7 = "graba.txt"; // Base de Datos Datos de la Persona Todos
        String baseDir7 = Environment.getExternalStorageDirectory() + File.separator + CARPETA_ARCHIVOS;
        File file7 = new File(baseDir7, FILE_NAME7);
        FileReader fReader7 = new FileReader(file7);
        InputStream is7 = new FileInputStream(file7);
        BufferedReader reader7 = new BufferedReader(fReader7);

        List<String> listado8 = new ArrayList<String>();
        String linea8;
        String linea81;
        String FILE_NAME8 = "foto.txt"; // Base de Datos Datos de la Persona Todos
        String baseDir8 = Environment.getExternalStorageDirectory() + File.separator + CARPETA_ARCHIVOS;
        File file8 = new File(baseDir8, FILE_NAME8);
        FileReader fReader8 = new FileReader(file8);
        InputStream is8 = new FileInputStream(file8);
        BufferedReader reader8 = new BufferedReader(fReader8);

        List<String> listado9 = new ArrayList<String>();
        String linea9;
        String linea91;
        String FILE_NAME9 = "config3.txt"; // Base de Datos Datos de la Persona Todos
        String baseDir9 = Environment.getExternalStorageDirectory() + File.separator + CARPETA_ARCHIVOS;
        File file9 = new File(baseDir9, FILE_NAME9);
        FileReader fReader9 = new FileReader(file9);
        InputStream is9 = new FileInputStream(file9);
        BufferedReader reader9 = new BufferedReader(fReader9);


        // esto es para leer texto interno
        //List<String> listado= new ArrayList<String>();
        //String linea;
        //InputStream is=this.getResources().openRawResource(R.raw.agenda);
        //BufferedReader reader=new BufferedReader(new InputStreamReader(is));

        //esto es par leer texto interno


        // if(is!=null){
        //   while((linea=reader.readLine())!=null){

        //     int c;

        //   c=Integer.parseInt(linea.split(";")[0]);

        // if(c==2) {

        //   listado.add(linea.split(";")[1]+ " : " + linea.split(";")[5]);//+ ":" //+ linea.split(";")[5]);
        // int j=Integer.parseInt(linea.split(";")[0]);

        //  if(j==4) {

        //    Toast.makeText(getApplicationContext(), linea.split(";")[2], Toast.LENGTH_SHORT).show();

        // }

        // k=j;
        // }
        // }
        //}

        if (is1 != null) {


            caper = 0;

            while ((linea1 = reader1.readLine()) != null) {

                //int c;

                //c=Integer.parseInt(linea1.split(";")[0]);

                //if(c==3) {

                //  listado1.add(linea1.split(";")[1] + "  " + linea1.split(";")[0]);
                // int j=Integer.parseInt(linea.split(";")[0]);

                //  if(j==4) {

                //    Toast.makeText(getApplicationContext(), linea.split(";")[2], Toast.LENGTH_SHORT).show();

                // }

                // k=j;
                //}

                Persona[caper][0] = linea1.split(";")[0];
                Persona[caper][1] = linea1.split(";")[1];
                Persona[caper][2] = linea1.split(";")[2];
                Persona[caper][3] = linea1.split(";")[3];
                Persona[caper][4] = linea1.split(";")[4];
                Persona[caper][5] = linea1.split(";")[5];
                Persona[caper][6] = linea1.split(";")[6];
                Persona[caper][7] = linea1.split(";")[7];
                Persona[caper][8] = linea1.split(";")[8];
                Persona[caper][9] = linea1.split(";")[9];
                Persona[caper][10] = linea1.split(";")[10];
                Persona[caper][11] = linea1.split(";")[11];
                Persona[caper][12] = linea1.split(";")[12];
                Persona[caper][13] = linea1.split(";")[13];
                Persona[caper][14] = linea1.split(";")[14];
                Persona[caper][15] = linea1.split(";")[15];
                Persona[caper][16] = linea1.split(";")[16];
                Persona[caper][17] = linea1.split(";")[17];
                Persona[caper][18] = linea1.split(";")[18];
                Persona[caper][19] = linea1.split(";")[19];


                caper = caper + 1;


            }
        }

        if (is2 != null) {


            int c;
            c = 0;


            while ((linea2 = reader2.readLine()) != null) {


                c = c + 1;


                //c=c-1;

                // if(c==3) {

                //Base [c-1][0]=linea2.split(";")[0];
                //Base [c-1][1]=linea2.split(";")[1];
                //Base [c-1][2]=linea2.split(";")[2];


                // int j=Integer.parseInt(linea.split(";")[0]);

                //  if(j==4) {

                //    Toast.makeText(getApplicationContext(), linea.split(";")[2], Toast.LENGTH_SHORT).show();

                // }

                // k=j;
                // }


            }

            //Toast.makeText(getContext(), Integer.toString(c), Toast.LENGTH_SHORT).show();

            String Base[][] = new String[c][10];

            sf = 1;

            while ((linea3 = reader3.readLine()) != null) {


                //String pim=Integer.toString(s);

                listado2.clear();
                listado2.add(linea3.split(";")[0]);
                listado2.add(linea3.split(";")[1]);
                listado2.add(linea3.split(";")[2]);
                listado2.add(linea3.split(";")[3]);
                listado2.add(linea3.split(";")[4]);
                listado2.add(linea3.split(";")[5]);
                listado2.add(linea3.split(";")[6]);
                listado2.add(linea3.split(";")[7]);
                listado2.add(linea3.split(";")[8]);
                listado2.add(linea3.split(";")[9]);
                Base[sf - 1] = listado2.toArray(new String[listado2.size()]);
                sf = sf + 1;

                //
                //c=0;

                //Toast.makeText(getApplicationContext(), Integer.toString(s), Toast.LENGTH_SHORT).show();
                //c=c-1;

                // if(c==3) {

                //Base [c][0]=linea2.split(";")[0];
                //Base [c][1]=linea2.split(";")[1];
                //Base [c][2]=linea2.split(";")[2];


                // int j=Integer.parseInt(linea.split(";")[0]);

                //  if(j==4) {

                //    Toast.makeText(getApplicationContext(), linea.split(";")[2], Toast.LENGTH_SHORT).show();

                // }

                // k=j;
                // }


                //  Toast.makeText(getApplicationContext(),"Paso",Toast.LENGTH_SHORT).show();


            }


            sf = sf - 1;
            String s1 = Base[0][1];
            String s2 = Base[1][2];

            for (int i = 0; i < sf; i++) {

                Agenda[i][0] = Base[i][0];
                Agenda[i][1] = Base[i][1];
                Agenda[i][2] = Base[i][2];
                Agenda[i][3] = Base[i][3];
                Agenda[i][4] = Base[i][4];
                Agenda[i][5] = Base[i][5];
                Agenda[i][6] = Base[i][6];
                Agenda[i][7] = Base[i][7];
                Agenda[i][8] = Base[i][8];
                Agenda[i][9] = Base[i][9];
            }

            // Base.length;
            int p = Integer.parseInt(Agenda[4][0]);

            // linea1.

            //reader1.reset();

            if (is1 != null) {


                while ((linea11 = reader11.readLine()) != null) {

                    // Toast.makeText(getApplicationContext(), "paso", Toast.LENGTH_SHORT).show();
                    int c1;

                    c1 = Integer.parseInt(linea11.split(";")[0]);

                    if (c1 == p) {

                        name = linea11.split(";")[1] + " " + linea11.split(";")[2];
                        //name="Sternal";
                        // int j=Integer.parseInt(linea.split(";")[0]);

                        //  if(j==4) {


                        // }

                        // k=j;
                    }


                }
            }

            //String s="Sternal";
            //Base [0][2]="Sternal3";

            //Toast.makeText(getContext(),Integer.toString(sf) ,Toast.LENGTH_SHORT).show();

            // Toast.makeText(getApplicationContext(),fechag + "aviso" ,Toast.LENGTH_SHORT).show();

            // Toast.makeText(getApplicationContext(),name+" "+Agenda[4][1]+"/"+ Agenda[4][2]+"/"+Agenda[4][3],Toast.LENGTH_SHORT).show();


        }

        //String s=Integer.toString(k);
        //Toast.makeText(getApplicationContext(),s, Toast.LENGTH_SHORT).show();
        // is.close();
        // String datos[]=listado.toArray(new String[listado.size()]);
        //datos[0]="ster1";
        //datos[1]="ster2";
        String datos1[] = listado1.toArray(new String[listado1.size()]);

        //while ()

        String sternal[] = {"Sternal1", "Sternal2"};

        //  Toast.makeText(getApplicationContext(),datos1[0],Toast.LENGTH_SHORT).show();


        // ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, datos); //queda pendiente

        // Toast.makeText(this, "Sternal", Toast.LENGTH_SHORT).show();
        // List1 = (ListView) findViewById(R.id.l1);
        // List1.setAdapter(adapter);

        if (is5 != null) {


            calu = 0;

            while ((linea5 = reader5.readLine()) != null) {

                //int c;

                //c=Integer.parseInt(linea1.split(";")[0]);

                //if(c==3) {

                //  listado1.add(linea1.split(";")[1] + "  " + linea1.split(";")[0]);
                // int j=Integer.parseInt(linea.split(";")[0]);

                //  if(j==4) {

                //    Toast.makeText(getApplicationContext(), linea.split(";")[2], Toast.LENGTH_SHORT).show();

                // }

                // k=j;
                //}

                Lugar[calu][0] = linea5.split(";")[0];
                Lugar[calu][1] = linea5.split(";")[1];
                Lugar[calu][2] = linea5.split(";")[2];
                Lugar[calu][3] = linea5.split(";")[3];

                //Toast.makeText(getApplicationContext(),"Bucle"+ linea5.split(";")[1], Toast.LENGTH_SHORT).show();
                // Toast.makeText(getApplicationContext(),"Bucle:  "+ linea5.split(";")[1], Toast.LENGTH_SHORT).show();

                //Persona[caper][1] =linea1.split(";")[1];
                //Persona[caper][2] =linea1.split(";")[2];
                //Persona[caper][3] =linea1.split(";")[3];


                calu = calu + 1;


            }


        }

        if (is6 != null) {


            caconfig = 0;

            while ((linea6 = reader6.readLine()) != null) {

                //int c;

                //c=Integer.parseInt(linea1.split(";")[0]);

                //if(c==3) {

                //  listado1.add(linea1.split(";")[1] + "  " + linea1.split(";")[0]);
                // int j=Integer.parseInt(linea.split(";")[0]);

                //  if(j==4) {

                //    Toast.makeText(getApplicationContext(), linea.split(";")[2], Toast.LENGTH_SHORT).show();

                // }

                // k=j;
                //}

                Config[caconfig][0] = linea6.split(";")[0];
                Config[caconfig][1] = linea6.split(";")[1];
                Config[caconfig][2] = linea6.split(";")[2];


                //Toast.makeText(getApplicationContext(),"Bucle"+ linea5.split(";")[1], Toast.LENGTH_SHORT).show();
                // Toast.makeText(getApplicationContext(),"Bucle:  "+ linea5.split(";")[1], Toast.LENGTH_SHORT).show();

                //Persona[caper][1] =linea1.split(";")[1];
                //Persona[caper][2] =linea1.split(";")[2];
                //Persona[caper][3] =linea1.split(";")[3];


                caconfig = caconfig + 1;


            }
        }

        if (is7 != null) {


            cagraba = 0;

            while ((linea7 = reader7.readLine()) != null) {

                //int c;

                //c=Integer.parseInt(linea1.split(";")[0]);

                //if(c==3) {

                //  listado1.add(linea1.split(";")[1] + "  " + linea1.split(";")[0]);
                // int j=Integer.parseInt(linea.split(";")[0]);

                //  if(j==4) {

                //    Toast.makeText(getApplicationContext(), linea.split(";")[2], Toast.LENGTH_SHORT).show();

                // }

                // k=j;
                //}

                Graba[cagraba][0] = linea7.split(";")[0];
                Graba[cagraba][1] = linea7.split(";")[1];
                Graba[cagraba][2] = linea7.split(";")[2];
                Graba[cagraba][3] = linea7.split(";")[3];
                Graba[cagraba][4] = linea7.split(";")[4];
                Graba[cagraba][5] = linea7.split(";")[5];
                Graba[cagraba][6] = linea7.split(";")[6];
                Graba[cagraba][7] = linea7.split(";")[7];
                Graba[cagraba][8] = linea7.split(";")[8];
                Graba[cagraba][9] = linea7.split(";")[9];


                //Toast.makeText(getApplicationContext(),"Bucle"+ linea5.split(";")[1], Toast.LENGTH_SHORT).show();
                // Toast.makeText(getApplicationContext(),"Bucle:  "+ linea5.split(";")[1], Toast.LENGTH_SHORT).show();

                //Persona[caper][1] =linea1.split(";")[1];
                //Persona[caper][2] =linea1.split(";")[2];
                //Persona[caper][3] =linea1.split(";")[3];


                cagraba = cagraba + 1;


            }
        }

        if (is8 != null) {


            cafo = 0;

            while ((linea8 = reader8.readLine()) != null) {

                //int c;

                //c=Integer.parseInt(linea1.split(";")[0]);

                //if(c==3) {

                //  listado1.add(linea1.split(";")[1] + "  " + linea1.split(";")[0]);
                // int j=Integer.parseInt(linea.split(";")[0]);

                //  if(j==4) {

                //    Toast.makeText(getApplicationContext(), linea.split(";")[2], Toast.LENGTH_SHORT).show();

                // }

                // k=j;
                //}

                Foto[cafo][0] = linea8.split(";")[0];
                Foto[cafo][1] = linea8.split(";")[1];
                Foto[cafo][2] = linea8.split(";")[2];
                Foto[cafo][3] = linea8.split(";")[3];
                Foto[cafo][4] = linea8.split(";")[4];
                Foto[cafo][5] = linea8.split(";")[5];
                Foto[cafo][6] = linea8.split(";")[6];
                Foto[cafo][7] = linea8.split(";")[7];
                Foto[cafo][8] = linea8.split(";")[8];
                Foto[cafo][9] = linea8.split(";")[9];


                //Toast.makeText(getApplicationContext(),"Bucle"+ linea5.split(";")[1], Toast.LENGTH_SHORT).show();
                // Toast.makeText(getApplicationContext(),"Bucle:  "+ linea5.split(";")[1], Toast.LENGTH_SHORT).show();

                //Persona[caper][1] =linea1.split(";")[1];
                //Persona[caper][2] =linea1.split(";")[2];
                //Persona[caper][3] =linea1.split(";")[3];


                cafo = cafo + 1;


            }
        }

        if (is9 != null) {


            calu2 = 0;

            while ((linea9 = reader9.readLine()) != null) {

                //int c;

                //c=Integer.parseInt(linea1.split(";")[0]);

                //if(c==3) {

                //  listado1.add(linea1.split(";")[1] + "  " + linea1.split(";")[0]);
                // int j=Integer.parseInt(linea.split(";")[0]);

                //  if(j==4) {

                //    Toast.makeText(getApplicationContext(), linea.split(";")[2], Toast.LENGTH_SHORT).show();

                // }

                // k=j;
                //}

                Lugar2[calu2][0] = linea9.split(";")[0];
                Lugar2[calu2][1] = linea9.split(";")[1];
                Lugar2[calu2][2] = linea9.split(";")[2];
                Lugar2[calu2][3] = linea9.split(";")[3];


                //Toast.makeText(getApplicationContext(),"Bucle"+ linea5.split(";")[1], Toast.LENGTH_SHORT).show();
                // Toast.makeText(getApplicationContext(),"Bucle:  "+ linea5.split(";")[1], Toast.LENGTH_SHORT).show();

                //Persona[caper][1] =linea1.split(";")[1];
                //Persona[caper][2] =linea1.split(";")[2];
                //Persona[caper][3] =linea1.split(";")[3];


                calu2 = calu2 + 1;


            }
        }


    }




}
