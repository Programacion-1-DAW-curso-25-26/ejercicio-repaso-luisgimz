import java.util.*;

public class Inventario {

    public Inventario() {
    }

    private ArrayList<ProductoInformatico> productos = new ArrayList<>();

    public ArrayList<ProductoInformatico> getProductos() {
        return productos;
    }

    @Override
    public String toString() {
        return "Inventario{" +
                "productos=" + productos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventario that = (Inventario) o;
        return Objects.equals(productos, that.productos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productos);
    }

    public void setProductos(ArrayList<ProductoInformatico> productos) {
        this.productos = productos;
    }

    public boolean eliminarPorCodigo(String codigo){
        Iterator<ProductoInformatico> it = productos.iterator();
        while (it.hasNext()){
            ProductoInformatico a = it.next();
            if (a.getCodigo().equals(codigo)){
                it.remove();
                return true;
            }
        }

        return false;
    }


    public void listarTodos() {
        for (ProductoInformatico producto: productos){
            System.out.println(producto);
        }
    }

    public void listarSinStock() {
        for (ProductoInformatico producto: productos){
           if (producto.getStock()==0){
               System.out.println(producto);
           }

        }
    }

    public boolean agregarProducto(ProductoInformatico p) {
        if (productos.contains(p)){
            return false;
        } else {
            productos.add(p);
            return true;
        }

    }

    public List<ProductoInformatico> buscarPorNombre(String nombre) {
        List<ProductoInformatico> lista = new ArrayList<>();
        for (ProductoInformatico producto: productos){
            if (producto.getNombre().equals(nombre)){
                lista.add(producto);
            }

        }
        return lista;
    }

    public List<ProductoInformatico> buscarPorCategoria(String cat) {
        List<ProductoInformatico> lista = new ArrayList<>();
        for (ProductoInformatico producto: productos){
            if (producto.getCategoria().equals(cat)){
                lista.add(producto);
            }

        }
        return lista;
    }

    public List<ProductoInformatico> buscarPorPrecio(double min, double max) {

        List<ProductoInformatico> lista = new ArrayList<>();
        for (ProductoInformatico producto: productos){
            if (producto.getPrecio() >= min && producto.getPrecio() <= max){
                lista.add(producto);
            } else {
                System.out.println("no se ha encontrado");
            }
        }
        return lista;

    }

    public boolean incrementarStock(String cod, int c) {
        for (ProductoInformatico producto: productos){
            if (producto.getCodigo().equals(cod)){
                producto.setStock(producto.getStock()+c);
                return true;
            }
        }
        return false;
    }

    public boolean decrementarStock(String cod, int c) {
        for (ProductoInformatico producto: productos){
            if (producto.getCodigo().equals(cod)){
                if (producto.getStock()>=c){
                    producto.setStock(producto.getStock()-c);
                    return true;
                }
            }
        }
        return false;
    }

    public List<ProductoInformatico> ordenarPorPrecioAsc() {
        ArrayList<ProductoInformatico> clonOrdenado = new ArrayList<>(productos);
        Collections.sort(clonOrdenado, Comparator.comparingDouble(ProductoInformatico::getPrecio));
        return clonOrdenado;
    }
}