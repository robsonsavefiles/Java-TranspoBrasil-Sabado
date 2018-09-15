package br.com.globalcode.dao;
import br.com.globalcode.model.Funcionario;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FuncionariosDAO {
    
    public static FuncionariosDAO instance = new FuncionariosDAO();
    private List<Funcionario> bancoDados;
    
    private FuncionariosDAO() {
        bancoDados = new ArrayList<Funcionario>();
        bancoDados.add( new Funcionario("1", "Joao", "Silva"));
        bancoDados.add( new Funcionario("2", "Jose", "Santos"));
        bancoDados.add( new Funcionario("3", "Joaquim", "Pereira"));
        bancoDados.add( new Funcionario("4", "Maria", "Silva"));
        bancoDados.add( new Funcionario("5", "Marcia", "Santos"));
        bancoDados.add( new Funcionario("6", "Luiza", "Pereira"));
        bancoDados.add( new Funcionario("7", "Luzia", "Pace"));
        bancoDados.add( new Funcionario("8", "Antonio", "Pablo"));
        bancoDados.add( new Funcionario("9", "Armando", "Prioli"));
        bancoDados.add( new Funcionario("10", "Jose", "Pablo"));
        bancoDados.add( new Funcionario("11", "Joao", "Pace"));
        bancoDados.add( new Funcionario("12", "Luiza", "Silva"));
    }
    
    public static FuncionariosDAO getInstance() {
        return instance;
    }
    
    public List<Funcionario> getAllFuncionarios() {
        return bancoDados;
    }
}

