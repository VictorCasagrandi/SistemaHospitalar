
package sistemahospitalar.repositories;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sistemahospitalar.Paciente;
import java.util.List;
import java.util.ArrayList;

public class PacienteDAO {
    private String sql;
    
    //Construtor para cadastro do paciente
    public void adiciona(Paciente paciente){
        
        Connection con = new ConnectionFactory().getConnection();
        
        sql = "INSERT INTO T_PACIENTE "
                + "(PACIENTE_NOME,PACIENTE_RG,PACIENTE_CPF,PACIENTE_NSUS,PACIENTE_SEXO,PACIENTE_ETINIA,PACIENTE_PESO,PACIENTE_ALTURA,PACIENTE_IDADE)"
                + "VALUES (?,?,?,?,?,?,?,?,?)";
        
        try{
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, paciente.getNome());
            stmt.setString(2, paciente.getRg());
            stmt.setString(3, paciente.getCpf());
            stmt.setString(4, paciente.getnSus());
            stmt.setString(5, paciente.getSexo());
            stmt.setString(6, paciente.getEtinia());
            stmt.setString(7, paciente.getPeso());
            stmt.setString(8, paciente.getAltura());
            stmt.setString(9, paciente.getIdade());
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Dados inseridos com Sucesso!");
        }catch (SQLException e){
            throw new RuntimeException("Erro ao inserir dados: " + e);
        }  
    }
    
    //Contrutor para inserir dados da solicitação de exame. 
    public void adicionaSolicitacao (Paciente paciente){
        
        Connection con = new ConnectionFactory().getConnection();
        
        sql = "INSERT INTO T_SOL_EXAME "
                + "(PACIENTE_NSUS, EXAME_TIPO, EXAME_NUMERO, EXAME_DATA, EXAME_CID)"
                + "VALUES (?,?,?,?,?)";
        
        try{
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, paciente.getnSus());
            stmt.setString(3, paciente.getTipoExame());
            stmt.setString(2, paciente.getNunExame());
            stmt.setString(4, paciente.getDataExame());
            stmt.setString(5, paciente.getCidExame());
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Dados inseridos com Sucesso!");
        }catch (SQLException e){
            throw new RuntimeException("Erro ao inserir dados: " + e);
        }  
    }
    
    //Contrutor para adicionar informações do laudo do exame
    public void adicionaLaudo (Paciente laudo){
        
        Connection con = new ConnectionFactory().getConnection();
        
        sql = "INSERT INTO T_REG_LAUDO "
                + "(PACIENTE_NSUS, LAUDO_PROVISORIO, LAUDO_DATA, LAUDO_HORA)"
                + "VALUES (?,?,?,?)";
        
        try{
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, laudo.getnSus());
            stmt.setString(2, laudo.getLadProvisorio());
            stmt.setString(3, laudo.getLaudoData());
            stmt.setString(4, laudo.getLaudoHora());
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Dados inseridos com Sucesso!");
        }catch (SQLException e){
            throw new RuntimeException("Erro ao inserir dados: " + e);
        }  
    }
    
    
    //Busca os dados no banco. 
    public List<Paciente> read() {
        List<Paciente> listaDados = new ArrayList<>();
        
        Connection con = new ConnectionFactory().getConnection();
        PreparedStatement stmt2 = null;
        ResultSet rs = null;
        
        sql = "select * "
              + "from t_reg_exame c"
             + "where c.paciente_nsus = ?";
        
        
        try{
            //stmt2 = con.prepareStatement("select * from t_paciente");
            stmt2 = con.prepareStatement(sql);
            rs = stmt2.executeQuery();
            
            while (rs.next()){
               Paciente paciente = new Paciente();
               paciente.setnSus(rs.getString("PACIENTE_NSUS"));
               paciente.setnSus(rs.getString("EXAME_NUMERO"));
               paciente.setnSus(rs.getString("EXAME_LAUDOPROVISORIO"));
               
               listaDados.add(paciente);
            }
            stmt2.close();
            
            /*stmt2 = con.prepareStatement(sql);
            stmt2.setString(1, Listar.getCpf());
            stmt2.executeQuery();
            stmt2.close();*/
            
        }catch (SQLException e){
            throw new RuntimeException("Erro ao consultar paciente: " + e);
        }
        
        return listaDados;
    }
    
    
}
