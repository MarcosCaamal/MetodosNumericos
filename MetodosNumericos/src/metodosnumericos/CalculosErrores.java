
package metodosnumericos;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class CalculosErrores {
    double valorVerdadero, valorAproximado;
    int opcion, cifras;//op=1 truncar, op=2 redondear;
    CalculosErrores(double verdadero, double aproximado, int op, int ncifras){
        this.opcion=op;
        this.cifras=ncifras;
        this.valorVerdadero=verdadero;
        this.valorAproximado=aproximado;
        
    }
   public double calcularErrorAbsoluto(){
       double resultado;
       resultado=valorVerdadero-valorAproximado;
       resultado=Math.abs(resultado);
       if(opcion==1){
           double truncado;
           truncado=truncar(resultado);
           return truncado;
       }
       else if(opcion==2){
           double redondeo;
           redondeo=redondear(resultado);
           return redondeo;
       
       }else if(opcion==0)
       return resultado;
       return resultado;
   }
   public double calcularErrorRelativo(){
       double absoluto=calcularErrorAbsoluto();
       double resultado=(absoluto/Math.abs(valorVerdadero));
       if(opcion==1){
           double truncado;
           truncado=truncar(resultado);
           return truncado;
       }
       else if(opcion==2){
           double redondeo;
           redondeo=redondear(resultado);
           return redondeo;
       
       }else if(opcion==0)
       return resultado;
       return resultado;
   
   }
   public double calcularErrorRelativoPorcentual(){
       double resultado=calcularErrorRelativo()*100;
       if(opcion==1){
           double truncado;
           truncado=truncar(resultado);
           return truncado;
       }
       else if(opcion==2){
           double redondeo;
           redondeo=redondear(resultado);
           return redondeo;
       
       }else if(opcion==0)
       return resultado;
       return resultado;
      
   
   }
   public double truncar(double numero){
   double truncado = new BigDecimal(numero)
                                    .setScale(cifras, RoundingMode.DOWN).doubleValue();
   return truncado;
   }
   public double redondear(double numero){
   
    double parteEntera, resultado;
        resultado = numero;
        parteEntera = Math.floor(resultado);//la función floor nos permite obtener solo la parte entera de un número decimal
        resultado=(resultado-parteEntera)*Math.pow(10, cifras);//al valor inicial le restamos la parte entera y los multiplicamos con el valor de 10 ala para convertir los decimales a redondear a enteros
        resultado=Math.round(resultado);// redondeamos el número tomando en cuenta el primer decimal del número
        resultado=(resultado/Math.pow(10, cifras))+parteEntera;//el resultado sale de la suma de: la división del número redondeado de 10 elevado a la n y su parte entera 
        return resultado;
   
   }
}