package model.servicos;

import java.util.ArrayList;
import java.util.List;
import model.entidades.Departamento;

public class departamento_Servico {
    
    public List<Departamento> findAll ()
    
            {
            List<Departamento> lista = new ArrayList<>();
            lista.add(new Departamento(1, "Livros"));
            lista.add(new Departamento(2, "Computers"));
            lista.add(new Departamento(3, "Eletronics"));
                
            return lista;
            }
    
}
