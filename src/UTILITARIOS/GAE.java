package UTILITARIOS;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class GAE { //Gravação, Alteração e Exclusão
    Conexao CONEXAO_BANCO = new Conexao();
    String COLUNA ="",VIRGULA = "";
  
    public void GRAVA(String[] coluna, String[] valor, String tabela, String Mensagem){
        CONEXAO_BANCO.conecta();
        String COLUNA = "", VALUE = "", VIRGULA = "";
        for(String Col : coluna){
            COLUNA = COLUNA + VIRGULA + Col;
            if(VIRGULA.equals("")){
                VIRGULA = ",";
            }
        }
        
        VIRGULA = "";
        for(String Val : valor){
            VALUE = VALUE + VIRGULA + "'" + Val + "'";
            if(VIRGULA.equals("")){
                VIRGULA = ",";
            }
        }
        
        try{
            CONEXAO_BANCO.executaSQL("select * from " + tabela + " ");
            String SQL = "insert into " + tabela + " "
                    + "(" + COLUNA + ") values"
                    + "(" + VALUE + ")";
            CONEXAO_BANCO.statement.executeUpdate(SQL);
            
            JOptionPane.showMessageDialog(null, "Concluido");
            
        } catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro na gravacao" + erro);
        } catch (Exception e){
            
        }
        
        CONEXAO_BANCO.desconecta();
    }
        
}
