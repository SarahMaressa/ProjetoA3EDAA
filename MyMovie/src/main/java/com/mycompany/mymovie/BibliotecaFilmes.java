/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.mymovie;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author pedro
 */
public class BibliotecaFilmes {
    private Connection connection;

    /**
     * 
     */
    public BibliotecaFilmes() {
        try {
            // Registrar o driver JDBC do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Conectar ao banco de dados
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tbl_filmes", "root", "teste123");
            criarTabelaSeNaoExistir(); // Cria a tabela se não existir
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    /**
     *
     * @param nome
     * @param genero
     * @param diretor
     * @param ano
     * @param assistido
     * @param favorito
     */
    public void adicionarFilme(String nome, String genero, String diretor, int ano, boolean assistido, boolean favorito) {
        // Insere um novo filme na tabela
        String sql = "INSERT INTO tbl_filmes (nome_filme, genero_filme, diretor_filme, ano_lancamento, filme_assistido, filme_favorito) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, genero);
            stmt.setString(3, diretor);
            stmt.setInt(4, ano);
            stmt.setBoolean(5, assistido);
            stmt.setBoolean(6, favorito);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return
     */
    public List<Filme> listarFilmes() {
        // Lista todos os filmes na tabela
        List<Filme> filmes = new ArrayList<>();
        String sql = "SELECT * FROM tbl_filmes";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Filme filme = new Filme(
                        rs.getString("nome_filme"),
                        rs.getString("genero_filme"),
                        rs.getString("diretor_filme"),
                        rs.getInt("ano_lancamento"),
                        rs.getBoolean("filme_assistido"),
                        rs.getBoolean("filme_favorito")
                );
                filme.setAvaliacao(rs.getInt("avaliacao"));
                filmes.add(filme);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filmes;
    }

    /**
     *
     * @param nome
     */
    public void marcarComoAssistido(String nome) {
        // Marca um filme como assistido
        String sql = "UPDATE tbl_filmes SET filme_assistido = TRUE WHERE nome_filme = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param nome
     */
    public void desmarcarComoAssistido(String nome) {
        // Desmarca um filme como assistido
        String sql = "UPDATE tbl_filmes SET filme_assistido = FALSE WHERE nome_filme = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return
     */
    public List<Filme> listarAssistidos() {
         // Lista todos os filmes marcados como assistidos
        return listarFilmesPorCondicao("filme_assistido = TRUE");
    }

    /**
     *
     * @param nome
     */
    public void adicionarAosFavoritos(String nome) {
        // Adiciona um filme aos favoritos
        String sql = "UPDATE tbl_filmes SET filme_favorito = TRUE WHERE nome_filme = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param nome
     */
    public void removerDosFavoritos(String nome) {
        // Remove um filme dos favoritos
        String sql = "UPDATE tbl_filmes SET filme_favorito = FALSE WHERE nome_filme = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return
     */
    public List<Filme> listarFavoritos() {
        // Lista todos os filmes marcados como favoritos
        return listarFilmesPorCondicao("filme_favorito = TRUE");
    }

    /**
     *
     * @param nome
     */
    public void removerFilme(String nome) {
        // Remove um filme da tabela
        String sql = "DELETE FROM tbl_filmes WHERE nome_filme = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param nome
     * @return
     */
    public List<Filme> buscarFilme(String nome) {
        // Busca filmes pelo nome
        List<Filme> filmes = new ArrayList<>();
        String sql = "SELECT * FROM tbl_filmes WHERE nome_filme LIKE ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, "%" + nome + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Filme filme = new Filme(
                        rs.getString("nome_filme"),
                        rs.getString("genero_filme"),
                        rs.getString("diretor_filme"),
                        rs.getInt("ano_lancamento"),
                        rs.getBoolean("filme_assistido"),
                        rs.getBoolean("filme_favorito")
                );
                filme.setAvaliacao(rs.getInt("avaliacao"));
                filmes.add(filme);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filmes;
    }
    /**
     * 
     * @param condicao
     * @return 
     */
    private List<Filme> listarFilmesPorCondicao(String condicao) {
        // Lista filmes com base em uma condição SQL
        List<Filme> filmes = new ArrayList<>();
        String sql = "SELECT * FROM tbl_filmes WHERE " + condicao;
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Filme filme = new Filme(
                        rs.getString("nome_filme"),
                        rs.getString("genero_filme"),
                        rs.getString("diretor_filme"),
                        rs.getInt("ano_lancamento"),
                        rs.getBoolean("filme_assistido"),
                        rs.getBoolean("filme_favorito")
                );
                filme.setAvaliacao(rs.getInt("avaliacao"));
                filmes.add(filme);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filmes;
    }
    
    /**
     *
     * @param nome
     * @param avaliacao
     */
    public void atualizarAvaliacao(String nome, int avaliacao) {
        // Atualiza a avaliação de um filme
        String sql = "UPDATE tbl_filmes SET avaliacao = ? WHERE nome_filme = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, avaliacao);
            stmt.setString(2, nome);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    /**
     * 
     */
    private void criarTabelaSeNaoExistir() {
        // Cria a tabela de filmes se não existir
        String sql = "CREATE TABLE IF NOT EXISTS filmes (" +
                "id_filme INT AUTO_INCREMENT PRIMARY KEY, " +
                "nome_filme VARCHAR(255), " +
                "genero_filme VARCHAR(255), " +
                "diretor_filme VARCHAR(255), " +
                "ano_lancamento INT, " +
                "filme_assistido BOOLEAN, " +
                "filme_favorito BOOLEAN, " +
                "avaliacao INT)";
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}





