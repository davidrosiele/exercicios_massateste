package dao;

import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class TestDAO {
    static Connection connection;
    static Statement stmt;
    @BeforeClass
    public static void setup() throws SQLException {

        System.out.println("Iniciando conexçao com banco");
        connection = connectionFactory.getConnection();
        System.out.println("Conexao Feita com sucesso!!!");
        stmt = connection.createStatement();
        connection.setAutoCommit(false);
    }
    @Test
    public void testeRetornoSelectDadosTeste() throws SQLException {
        String comandosql = "SELECT dt.MASSA_TESTE FROM DADOS_TESTE dt WHERE ID_CASO_TESTE = 1";
        ResultSet resultSet = stmt.executeQuery(comandosql);
        resultSet.next();
        String jsonMassaTeste = resultSet.getString(1);
        Assert.assertTrue(jsonMassaTeste.contains("\"url\":\"https://amazon.com.br\""));

    }
    @After
    public void after() throws SQLException {
        stmt.close();
        connection.close();
        System.out.println("Conexçao Fechadas com sucesso!!!");

    }
}
