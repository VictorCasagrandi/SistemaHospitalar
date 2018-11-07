
package sistemahospitalar.repositories;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import sistemahospitalar.Paciente;

public class PacienteDAO {
    private String sql;
    
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
            System.out.println("Paciente inserido com Sucesso!");
        }catch (SQLException e){
            throw new RuntimeException("Erro ao inserir paciente: " + e);
        }
        
    }
    
    public void buscar(Paciente buscar){
        Connection con = new ConnectionFactory().getConnection();
        
        sql = "select * "
              + "from t_paciente c"
             + "where c.paciente_cpf = ?";
        
        try{
            PreparedStatement stmt2 = con.prepareStatement(sql);
            stmt2.setString(1, buscar.getCpf());
            stmt2.executeQuery();
            stmt2.close();
            
        }catch (SQLException e){
            throw new RuntimeException("Erro ao consultar paciente: " + e);
        }
    }
    
    
    public void criandoTabelas(){
        
        /* CREATE TABLE `jvadm`.`t_paciente` (
            `PACIENTE_NOME` VARCHAR(50) NOT NULL,
            `PACIENTE_RG` VARCHAR(45) NOT NULL,
            `PACIENTE_CPF` VARCHAR(45) NOT NULL,
            `PACIENTE_NSUS` VARCHAR(45) NOT NULL,
            `PACIENTE_SEXO` VARCHAR(45) NOT NULL,
            `PACIENTE_ETINIA` VARCHAR(45) NOT NULL,
            `PACIENTE_PESO` VARCHAR(45) NOT NULL,
            `PACIENTE_ALTURA` VARCHAR(45) NOT NULL,
            `PACIENTE_IDADE` VARCHAR(45) NOT NULL,
            PRIMARY KEY (`PACIENTE_RG`));
 */
    }
}
