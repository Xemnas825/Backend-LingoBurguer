package Model;

import java.util.ArrayList;

public interface iDao<E,I> {
    //Entidad, Identificador
    public int add(E bean); //Añado un elemento
    public int delete(I e); //Borro por una clave
    public int update(E bean); //Actualizar un elemento
    public ArrayList<E> findAll(E bean); //Operacion crud de leer y recuperar elementos
}
