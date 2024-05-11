import java.util.*;
public class Dijkstra
{
 public  int distancia[] = new int[10];
 public  int costo[][] = new int[10][10];
 
 public void calc(int n,int s)
 {
  int flag[] = new int[n+1];
  int i,posmin=1,k,c,minimo;
  
  for(i=1;i<=n;i++)
  {  
      flag[i]=0; 
      this.distancia[i]=this.costo[s][i]; 
  }
  c=2;
  while(c<=n)
  {
   minimo=99;
   for(k=1;k<=n;k++)
   { 
          if(this.distancia[k]<minimo && flag[k]!=1)
       {
        minimo=this.distancia[i];
        posmin=k;
       }
      } 
            flag[posmin]=1;
      c++;
      for(k=1;k<=n;k++){
       if(this.distancia[posmin]+this.costo[posmin][k] <  this.distancia[k] && flag[k]!=1 )
       this.distancia[k]=this.distancia[posmin]+this.costo[posmin][k];
   }   
  } 
  
 }
 public static void main(String args[])
 {
  int nodo,fuente,i,j;
  Scanner in = new Scanner(System.in);
  System.out.println("Por favor, ingresa el número de nodos \n");
  nodo = in.nextInt();
  Dijkstra d = new Dijkstra();
  System.out.println("Ingresa los pesos de la matriz de costos separados con espacios: \n");
        for(i=1;i<=nodo;i++)
          for(j=1;j<=nodo;j++)
          {
            d.costo[i][j]=in.nextInt();
            if(d.costo[i][j]==0)
              d.costo[i][j]=999;
          }
  System.out.println("Vértice de origen :\n");
  fuente=in.nextInt();
  
  d.calc(nodo,fuente);
  System.out.println("El camino más corto desde la fuente \t"+fuente+"\t a todos los demás vértices son : \n");
        for(i=1;i<=nodo;i++)
          if(i!=fuente)
  System.out.println("fuente :"+fuente+"\t destino :"+i+"\t el costoo minimo es :"+d.distancia[i]+"\t");
        
  
 } 
}