
/**
 * Write a description of class ModeloHaspMap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
public class ModeloHashMap extends ModeloAbs
{
    private HashMap <Integer,Producto> lista;
    
    public ModeloHashMap()
    {
       lista=new HashMap  <Integer,Producto>();
    }

    // Implementar los metodos abstractos de ModeloAbs
    public boolean insertarProducto ( Producto p){
         lista.put(p.codigo , p);
         return true;
        
    }
 
    public boolean borrarProducto ( int codigo ){
            lista.remove(codigo);
            return true;
    }
    
    public Producto buscarProducto ( int codigo) {
     return lista.get(codigo);
    }

    
    public void listarProductos (){
        for (Entry<Integer, Producto> prod : lista.entrySet()) {
	   System.out.println(prod.toString());
	}
    }
    
    public boolean modificarProducto (Producto nuevo){
        return true;
    }
    
    
}
