public class Elemento{
    private String nombre;
    private String[] debilidades;
    private String[] fortalezas;

    public Elemento(String nombre, String[] debilidades, String[] fortalezas) {
        this.nombre = nombre;
        this.debilidades = debilidades;
        this.fortalezas = fortalezas;
    } 

    @Override
    public String toString() {
        return nombre;
    }

    public String getNombre() {
        return nombre;
    }
    public String[] getDebilidades() {
        return debilidades;
    }
    public String[] getFortalezas() {
        return fortalezas;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDebilidades(String[] debilidades) {
        this.debilidades = debilidades;
    }
    public void setFortalezas(String[] fortalezas) {
        this.fortalezas = fortalezas;
    }
}