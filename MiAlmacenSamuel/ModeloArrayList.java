
/**
 * Implementa la parte de Modelo de Datow
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.Iterator;

public class ModeloArrayList extends ModeloAbs
{
    private ArrayList <Producto> lista;
    
    public ModeloArrayList()
    {
       lista=new ArrayList <Producto>();
    }

    // Implementar los metodos abstractos de ModeloAbs
    public boolean insertarProducto ( Producto p){
        
        return  lista.add(p);
    }
 
    public boolean borrarProducto ( int codigo ){
          /* Iterator<Producto> nombreIterator = lista.iterator();
           nombreIterator = lista.iterator();
            while(nombreIterator.hasNext()){
                Integer elemento = nombreIterator.next().codigo;
                if( elemento == codigo)
                nombreIterator.remove();    
        
            }*/
        for ( Producto prod : lista ) {
            if(prod.codigo==codigo){
               lista.remove(prod);
               return true;
            }
        }
        return false;
    }
    
    public Producto buscarProducto ( int codigo) {
      for ( Producto prod : lista ) {
            if(prod.codigo==codigo){
            return prod;         
            }
            }
      return null;
    }

    
    public void listarProductos (){
        for ( Producto prod : lista ) {
           System.out.println(prod.toString());
            }
    }
    
    public boolean modificarProducto (Producto nuevo){
        return true;
    }
    
    
}    
