/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persona;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author huangho
 */
public class Persona {
    
    //Sexo por defecto. cONSTANTE
    private final static char SEXO_DF='H';
    
    //pESO por debajo del ideal. Constante
    public static final int PESO_BAJO=-1;
    
    //Peso ideal. Constante
    public static final int PESO_IDEAL=0;
    
    //Peso porencima del ideal
    public static final int PESO_ALTO=1;
    
    //Attribs
    private String nombre;
    private int edad;
    private String DNI;
    private char sexo;
    private double peso;
    private double altura;
    
    //Constructor
    public Persona(String nombre, int edad, char sexo, double peso, double altura){
        this.nombre=nombre;
        this.edad=edad;
        this.peso=peso;
        this.altura=altura;        
        this.sexo=sexo;
        //comprobar Sexo();
        //obtenerDNI();
    }
    public Persona(String nombre, int edad, char sexo){
        this(nombre,edad,sexo,0,0);
    }
    public Persona(){
        this("",0,SEXO_DF,0,0);
    }
    
    //Métodos 
    /**
     * obtener/validar DNI
     */
    private void obtenerDNI(){
        final int div=23;
        
        int numero = (int)Math.floor(Math.random()*(10000000-10000000)+10000000);
        //...
        int resto=numero-(numero/div*div);
        
        //Letra
        char letra=obtenerLetra(resto);
        //Asignamos a la variable
        DNI=Integer.toString(numero)+letra;
    }
    
    private char obtenerLetra(int numero){
        char letra[]={'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
        return letra[numero];
    }
    
    //Merods de modificación de atributos
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public void setEdad(int edad){
        this.edad=edad;
    }
    
    public void setPeso(double peso){
        this.peso=peso;
    }
    
    public void setAltura(double altura){
        this.altura=altura;
    }
    
    public void setSexo(char sexo){
        this.sexo=sexo;
    }
    
    /**
     * Mayor de edad
     */
    public boolean esMayorDeEdad() {
        boolean mayor = false;
        if (edad >= 18) {
            mayor = true;
        }
        return mayor;
    }
    /**
     * Calcular el IMC
     */
public int IMC(){
    double pesoPonderado=peso/(Math.pow(altura, 2));
    
    if (pesoPonderado>=20 && pesoPonderado<=25){
        return PESO_IDEAL;
    }else if (pesoPonderado<20){
        return PESO_BAJO;
    }else{
        return PESO_ALTO;
    }
}

public String toString(){
    String sexo;
    if (this.sexo=='H'){
        sexo="hombre";
    }else{
        sexo="mujer";
    }
    return "Información:n"
            +"Nombre: " + nombre + "n";
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("n");
        sc.useLocale(Locale.US);
         
        //Introducimos los datos
        System.out.println("Introduce el nombre");
        String nombre = sc.next();
 
        System.out.println("Introduce la edad");
        int edad = sc.nextInt();
 
        System.out.println("Introduce el sexo");
        char sexo = sc.next().charAt(0);
 
        System.out.println("Introduce el peso");
        double peso = sc.nextDouble();
 
        System.out.println("Introduce la altura");
        double altura = sc.nextDouble();
 
        //Creamos objetos con cada constructor
        Persona persona1 = new Persona();
        Persona persona2 = new Persona(nombre, edad, sexo);
        Persona persona3 = new Persona(nombre, edad, sexo, peso, altura);
 
        //Los datos que no esten completos los insertamos con los metodos set
        persona1.setNombre("Gala Rodríguez");
        persona1.setEdad(32);
        persona1.setSexo('M');
        persona1.setPeso(61.3);
        persona1.setAltura(1.67);
 
        persona2.setPeso(95.2);
        persona2.setAltura(1.88);
 
        //Usamos metodos para realizar la misma accion para cada objeto
        System.out.println("Persona1");
        MensajePeso(persona1);
        MayorDeEdad(persona1);
        System.out.println(persona1.toString());
 
        System.out.println("Persona2");
        MensajePeso(persona2);
        MayorDeEdad(persona2);
        System.out.println(persona2.toString());
 
        System.out.println("Persona3");
        MensajePeso(persona3);
        MayorDeEdad(persona3);
        System.out.println(persona3.toString());
    }
    
    public static void MensajePeso(Persona p) {
        int IMC = p.IMC();
        switch (IMC) {
            case Persona.PESO_IDEAL:
                System.out.println("La persona esta en su peso ideal");
                break;
            case Persona.PESO_BAJO:
                System.out.println("La persona esta por debajo de su peso ideal");
                break;
            case Persona.PESO_ALTO:
                System.out.println("La persona esta por encima de su peso ideal");
                break;
        }
        
    }
     
    public static void MayorDeEdad(Persona p) {
 
        if (p.esMayorDeEdad()) {
            System.out.println("La persona es mayor de edad");
        } else {
            System.out.println("La persona no es mayor de edad");
        }
    }
    
}
