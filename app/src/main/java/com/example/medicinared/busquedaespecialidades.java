package com.example.medicinared;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static android.Manifest.permission.CAMERA;

public class busquedaespecialidades extends AppCompatActivity {

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
        setContentView(R.layout.activity_busquedaespecialidades);

        List1=(ListView)findViewById(R.id.List1);

        Img=(ImageView)findViewById(R.id.imageView1);

        try {
            CargaDatos();
        } catch (IOException e) {
            e.printStackTrace();
        }

        name = "1";

        for (int ic = 0; ic < sf; ic++) {


            if (name.equals(Agenda[ic][0])) {   // Si se Cumple la Condición de Igualdad


                Sesiones[cadp][0] = Agenda[ic][0];
                Sesiones[cadp][1] = Agenda[ic][1];
                Sesiones[cadp][2] = Agenda[ic][2];
                Sesiones[cadp][3] = Agenda[ic][3];
                Sesiones[cadp][4] = Agenda[ic][4];
                Sesiones[cadp][5] = Agenda[ic][5];
                Sesiones[cadp][6] = Agenda[ic][6];
                Sesiones[cadp][7] = Agenda[ic][7];
                Sesiones[cadp][8] = Agenda[ic][8];
                Sesiones[cadp][9] = Agenda[ic][9];
                Sesiones[cadp][10] = Agenda[ic][10];
                Sesiones[cadp][11] = Agenda[ic][11];

                if( Integer.parseInt(Sesiones[cadp][10])==0){

                    Sesionesx[cadp2][0] =  Sesiones[cadp][0];
                    Sesionesx[cadp2][1] = Sesiones[cadp][1];
                    Sesionesx[cadp2][2] =    Sesiones[cadp][2];
                    Sesionesx[cadp2][3] =       Sesiones[cadp][3];
                    Sesionesx[cadp2][4] =       Sesiones[cadp][4];
                    Sesionesx[cadp2][5] =       Sesiones[cadp][5];
                    Sesionesx[cadp2][6] =       Sesiones[cadp][6];
                    Sesionesx[cadp2][7] =       Sesiones[cadp][7];
                    Sesionesx[cadp2][8] =       Sesiones[cadp][8];
                    Sesionesx[cadp2][9] =       Sesiones[cadp][9];
                    Sesionesx[cadp2][10] =       Sesiones[cadp][10];
                    Sesionesx[cadp2][11] =       Sesiones[cadp][11];


                    cadp2=cadp2+1;
                }

                cadp = cadp + 1;


            }


        }

        // CustomAdapter4 customAdapter4= new CustomAdapter4();

        //List1.setAdapter(customAdapter4);

        final CustomAdapter customAdapter = new CustomAdapter();
        List1.setAdapter(customAdapter);



        List1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent2=new Intent(busquedaespecialidades.this,listdoc.class);

                startActivity(intent2);



            }
        });



        Img.setVisibility(View.INVISIBLE);

        //Edi = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView2);

        //final String Nombre2[] = new String[cadp2];

       // for(int i10=0;i10<cadp2;i10++){

         //   Nombre2[i10]= Sesionesx[i10][5];
       // }

        //final ArrayAdapter<String> adapter=new ArrayAdapter<String>(busquedaespecialidades.this,R.layout.support_simple_spinner_dropdown_item,Nombre2);
       // Edi.setAdapter(adapter);

       // Edi.setOnClickListener(new View.OnClickListener() {
           // @Override
           // public void onClick(View v) {

             //   String s[] =new String [] { Edi.getText().toString()};

              //  int k=10-1;


               // k=cadp2-1;

                //int i1;

                //i1=0;

                //s[0]=Integer.toString(i1);

                //while(i1<=k){


                   // s[0]=Edi.getText().toString();

                   // if (s[0].equals(Nombre2[i1])) {
                        //  Toast.makeText(getApplicationContext(), "paso" + Integer.toString(i1), Toast.LENGTH_SHORT).show();
                        // que iguale el edittext con la matriz y en encuentra la posicion y despues haga el adapter hacer eso
                     //   final CustomAdapter3 customAdapter2= new CustomAdapter3();
                      //  listview.setAdapter(customAdapter2);
                      //  def=i1;
                       // djulito=1;
                   // }

                    //i1=i1+1;

               // }


      //      }
       // });

       // if(validaPermisos()){

            //Toast.makeText(getApplicationContext(), " Sternal", Toast.LENGTH_SHORT).show();
            //silos permisos estan activo haga algo

       // }else{


       // }






    }

   // private boolean validaPermisos() {

     //   if(Build.VERSION.SDK_INT<Build.VERSION_CODES.M){

       //     return true;

       // }

       // else {

         //   if ((checkSelfPermission(CAMERA) == PackageManager.PERMISSION_GRANTED) ) {

           //     return true;

           // } else {

                //if((shouldShowRequestPermissionRationale(CAMERA)) || (shouldShowRequestPermissionRationale(WRITE_EXTERNAL_STORAGE)){

               // cargarDialogoRecomendacion();

           // }

        //}
        //return true;

        //} //else{



        //requestPermissions(new String[](WRITE_EXTERNAL_STORAGE,CAMERA),100);
        //ActivityCompat.requestPermissions(MainActivity.this,new String[]{(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) ,(android.Manifest.permission.CAMERA)},100);

        //}



       // return false;
   // }

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


            view=getLayoutInflater().inflate(R.layout.activity_linearadap22,null);

            // CircleImageView circleImageView=(CircleImageView)view.findViewById(R.id.circle2);
            TextView Txt11=(TextView)view.findViewById(R.id.textView8);
            ImageView Img1=(ImageView)view.findViewById(R.id.imageView);
            //TextView Txt12=(TextView)view.findViewById(R.id.textView6);
            //TextView Txt13=(TextView)view.findViewById(R.id.textView7);


            //Picasso.get().load(Imagenes[i]).into(circleImageView);
            Txt11.setText(Nombres[i]);
            Img1.setImageResource(Imagenes[i]);

            //Txt12.setText(Secciones[i]);
            //Txt13.setText(i+ "/03/2019");

            return view;
        }
    }

    class CustomAdapter extends BaseAdapter {
        // public CustomAdapter() {
        //   super();
        //}

        @Override
        public int getCount() {


            //return cadp;
            return cadp2;
            //return caper;
        }

        @Override
        public Object getItem(int i) {
            return i;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup parent) {


            view = getLayoutInflater().inflate(R.layout.activity_listado, null);

            // CircleImageView circleImageView=(CircleImageView)view.findViewById(R.id.circle2);
            TextView Txt11 = (TextView) view.findViewById(R.id.textViewli5);
            TextView Txt12 = (TextView) view.findViewById(R.id.textViewli6);
            TextView Txt13 = (TextView) view.findViewById(R.id.textViewli7);
            TextView Txt14 = (TextView) view.findViewById(R.id.textViewli8);

            //if(Persona[i][19].equals("A")) {


            //Picasso.get().load(Imagenes[i]).into(circleImageView);
            int aux = i + 1;
            Txt11.setText("Seccion:" + aux);
            Txt11.setText("Especialidad");
            Txt13.setText("8");


            Txt14.setText("Cantidad de Especialistas");

            //Toast.makeText(getApplicationContext(),name+" "+ Integer.toString(sf),LENGTH_SHORT).show();

            //  for(int ic=0;ic<sf;ic++){


            // String fechita =Agenda[i][1]+"/"+Agenda[i][2]+"/"+Agenda[i][3];

            //if(name.equals(Agenda[i][0])){

            // Toast.makeText(getApplicationContext(),"Reconocio las Fechas",LENGTH_SHORT).show();


            // txt16.setText("Lugar:  "+Lugar[ic][1]);
            //txt17.setText(Lugar[ic][2]+" -  "+Lugar[ic][3]);
            //nombrecito = Sesiones[i][5];
            //fechita = Sesiones[i][1] + "/" + Sesiones[i][2] + "/" + Sesiones[i][3];
            //Txt12.setText(nombrecito);

            //Txt13.setText(fechita);

            nombrecito = Sesionesx[i][5];
            fechita = Sesionesx[i][1] + "/" + Sesionesx[i][2] + "/" + Sesionesx[i][3];
            Txt12.setText(nombrecito);
            //Txt13.setText(i + "/03/2019");
            Txt13.setText(fechita);

            Txt13.setText("8");

            //   }

            //cadp=cadp+1;


            //  }


            //  }


            //Txt12.setText(detalles[i]);


            return view;
        }


    }

    class CustomAdapter3 extends BaseAdapter {
        // public CustomAdapter() {
        //   super();
        //}

        @Override
        public int getCount() {


            //return cadp;
            return 1;
            //return caper;
        }

        @Override
        public Object getItem(int i) {
            return i;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup parent) {


            view = getLayoutInflater().inflate(R.layout.activity_listado, null);

            // CircleImageView circleImageView=(CircleImageView)view.findViewById(R.id.circle2);
            TextView Txt11 = (TextView) view.findViewById(R.id.textViewli5);
            TextView Txt12 = (TextView) view.findViewById(R.id.textViewli6);
            TextView Txt13 = (TextView) view.findViewById(R.id.textViewli7);
            TextView Txt14 = (TextView) view.findViewById(R.id.textViewli8);

            //if(Persona[i][19].equals("A")) {


            //Picasso.get().load(Imagenes[i]).into(circleImageView);
            i=def;
            int aux = i + 1;
            Txt11.setText("Seccion:" + aux);

            Txt11.setText("Especialidad");

            Txt14.setText("Cantidad de Especialistas");

            //Toast.makeText(getApplicationContext(),name+" "+ Integer.toString(sf),LENGTH_SHORT).show();

            //  for(int ic=0;ic<sf;ic++){


            // String fechita =Agenda[i][1]+"/"+Agenda[i][2]+"/"+Agenda[i][3];

            //if(name.equals(Agenda[i][0])){

            // Toast.makeText(getApplicationContext(),"Reconocio las Fechas",LENGTH_SHORT).show();


            // txt16.setText("Lugar:  "+Lugar[ic][1]);
            //txt17.setText(Lugar[ic][2]+" -  "+Lugar[ic][3]);
            //nombrecito = Sesiones[i][5];
            //fechita = Sesiones[i][1] + "/" + Sesiones[i][2] + "/" + Sesiones[i][3];
            //Txt12.setText(nombrecito);

            //Txt13.setText(fechita);

            nombrecito = Sesionesx[i][5];
            fechita = Sesionesx[i][1] + "/" + Sesionesx[i][2] + "/" + Sesionesx[i][3];
            Txt12.setText(nombrecito);
            //Txt13.setText(i + "/03/2019");
            Txt13.setText(fechita);

            //   }

            //cadp=cadp+1;


            //  }


            //  }


            //Txt12.setText(detalles[i]);


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

        List<String> listado6= new ArrayList<String>();
        String linea6;
        String linea61;
        String FILE_NAME6="config.txt"; // Base de Datos Datos de la Persona Todos
        String baseDir6= Environment.getExternalStorageDirectory()+File.separator+CARPETA_ARCHIVOS;
        File file6= new File(baseDir6,FILE_NAME6);
        FileReader fReader6= new FileReader(file6);
        InputStream is6= new FileInputStream(file6);
        BufferedReader reader6=new BufferedReader(fReader6);


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
                Persona[caper][20] = linea1.split(";")[20];
                Persona[caper][21] = linea1.split(";")[21];
                Persona[caper][22] = linea1.split(";")[22];
                Persona[caper][23] = linea1.split(";")[23];



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

            //Toast.makeText(getApplicationContext(), Integer.toString(c), LENGTH_SHORT).show();

            String Base[][] = new String[c][12];

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
                listado2.add(linea3.split(";")[10]);
                listado2.add(linea3.split(";")[11]);
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
                Agenda[i][10] = Base[i][10];
                Agenda[i][11] = Base[i][11];
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

            //Toast.makeText(getApplicationContext(),Integer.toString(sf) , LENGTH_SHORT).show();

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



                Lugar[calu][0] = linea5.split(";")[0];
                Lugar[calu][1] = linea5.split(";")[1];
                Lugar[calu][2] = linea5.split(";")[2];
                Lugar[calu][3] = linea5.split(";")[3];



                calu = calu + 1;


            }
        }

        if(is6!=null){


            caconfig=0;

            while((linea6=reader6.readLine())!=null){

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

                Config[caconfig][0] =linea6.split(";")[0];
                Config[caconfig][1] =linea6.split(";")[1];
                Config[caconfig][2] =linea6.split(";")[2];


                //Toast.makeText(getApplicationContext(),"Bucle"+ linea5.split(";")[1], Toast.LENGTH_SHORT).show();
                // Toast.makeText(getApplicationContext(),"Bucle:  "+ linea5.split(";")[1], Toast.LENGTH_SHORT).show();

                //Persona[caper][1] =linea1.split(";")[1];
                //Persona[caper][2] =linea1.split(";")[2];
                //Persona[caper][3] =linea1.split(";")[3];



                caconfig=caconfig+1;



            }
        }


    }
}
