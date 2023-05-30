package Model;
import Model.produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProdutoDAO {

    private Connection con;
    
    public ProdutoDAO() {
        con = new Conexao().conectar();
    }

    public ArrayList<produto> listarpdt() {
        String sql = "SELECT * FROM jogo";
        ArrayList<produto> produtos = new ArrayList<produto>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                produto p = new produto();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setValor(rs.getString("Valor"));
                produtos.add(p);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return produtos;
    }

    public void addpdt(produto p) {
        String sql = "INSERT INTO loja (nome,valor) Values(?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, p.getNome());
            ps.setString(2, p.getValor());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void atualizarpdt(produto p) {
        String sql = "UPDATE loja SET nome=? , valor=? WHERE id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, p.getNome());
            ps.setString(2, p.getValor());
            ps.setInt(3, p.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void comprarpdt(produto p) {
        String sql = "DELETE FROM loja WHERE id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, p.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

