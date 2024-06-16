/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mymovie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 *
 * @author pedro
 */
public class MyMovieList {
    private BibliotecaFilmes biblioteca;
    private List<Filme> listaAtual;

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MyMovieList::new); // Inicia a aplicação GUI no thread de eventos Swing
    }

    /**
     *
     */
    public MyMovieList() {
        biblioteca = new BibliotecaFilmes(); // Inicializa a biblioteca de filmes
        criarInterfaceGrafica(); // Cria a interface gráfica do usuário
    }
    /**
     * 
     */
    private void criarInterfaceGrafica() {
        JFrame frame = new JFrame("Mymovielist "); // Cria a janela principal
        frame.setSize(750, 550); // Define o tamanho da janela
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define a operação de fechamento da janela
        frame.setLayout(new BorderLayout()); // Define o layout da janela

        // Cores
        Color corFundo = new Color(34, 1, 1); // Define a cor de fundo
        Color corLetras = Color.WHITE; // Define a cor das letras
        Color corCaixaPesquisa = new Color(102, 51, 51); // Define a cor da caixa de pesquisa

        // Configuração de cores do frame
        frame.getContentPane().setBackground(corFundo);

        JPanel panelAdicionar = new JPanel(new GridBagLayout());  // Cria o painel para adicionar filmes com GridBagLayout
        configurarPainel(panelAdicionar, corFundo);  // Configura o painel com a cor de fundo
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;  // Configura o layout para preencher horizontalmente
        gbc.insets = new Insets(5, 5, 5, 5);  // Define as margens dos componentes

        JTextField campoNome = criarCampoTexto(20, corCaixaPesquisa, corLetras);  // Cria campo de texto para o nome do filme
        JTextField campoGenero = criarCampoTexto(20, corCaixaPesquisa, corLetras);  // Cria campo de texto para o gênero do filme
        JTextField campoDiretor = criarCampoTexto(20, corCaixaPesquisa, corLetras);  // Cria campo de texto para o diretor do filme
        JTextField campoAno = criarCampoTexto(20, corCaixaPesquisa, corLetras);  // Cria campo de texto para o ano de lançamento
        JCheckBox checkBoxAssistido = criarCheckBox("Assistido", corFundo, corLetras);  // Cria checkbox para marcar filme como assistido
        JCheckBox checkBoxFavorito = criarCheckBox("Favorito", corFundo, corLetras);  // Cria checkbox para marcar filme como favorito
        JButton botaoAdicionar = criarBotao("Adicionar Filme", corCaixaPesquisa, corLetras);  // Cria botão para adicionar filme

        // Adicionando campos ao painel
        adicionarComponente(panelAdicionar, criarLabel("Nome :", corLetras), gbc, 0, 0);  // Adiciona o rótulo e o campo de texto para o nome
        adicionarComponente(panelAdicionar, campoNome, gbc, 1, 0);
        adicionarComponente(panelAdicionar, criarLabel("Gênero :", corLetras), gbc, 0, 1);  // Adiciona o rótulo e o campo de texto para o gênero
        adicionarComponente(panelAdicionar, campoGenero, gbc, 1, 1);
        adicionarComponente(panelAdicionar, criarLabel("Diretor :", corLetras), gbc, 0, 2);  // Adiciona o rótulo e o campo de texto para o diretor
        adicionarComponente(panelAdicionar, campoDiretor, gbc, 1, 2);
        adicionarComponente(panelAdicionar, criarLabel("Ano :", corLetras), gbc, 0, 3);  // Adiciona o rótulo e o campo de texto para o ano de lançamento
        adicionarComponente(panelAdicionar, campoAno, gbc, 1, 3);
        adicionarComponente(panelAdicionar, botaoAdicionar, gbc, 1, 5, 2);  // Adiciona o botão de adicionar filme

        frame.add(panelAdicionar, BorderLayout.NORTH); // Adiciona o painel de adicionar filme ao frame

        JPanel panelFilmes = new JPanel();  // Cria o painel para listar filmes
        configurarPainel(panelFilmes, corFundo);  // Configura o painel com a cor de fundo
        panelFilmes.setLayout(new GridLayout(0, 1));  // Define o layout do painel para GridLayout

        JScrollPane scrollPane = new JScrollPane(panelFilmes);  // Cria um JScrollPane para o painel de filmes
        frame.add(scrollPane, BorderLayout.CENTER);  // Adiciona o JScrollPane ao frame

        JPanel panelBusca = new JPanel();  // Cria o painel de busca de filmes
        configurarPainel(panelBusca, corFundo);  // Configura o painel com a cor de fundo
        panelBusca.setLayout(new FlowLayout());  // Define o layout do painel para FlowLayout
        JTextField campoBusca = criarCampoTexto(20, corCaixaPesquisa, corLetras);  // Cria campo de texto para busca de filmes
        JButton botaoBuscar = criarBotao("Buscar", corCaixaPesquisa, corLetras);  // Cria botão de buscar filmes
        botaoBuscar.setPreferredSize(new Dimension(75, 20));  // Define o tamanho preferido do botão de busca
        panelBusca.add(criarLabel("Buscar Filme:", corLetras));  // Adiciona o rótulo de busca
        panelBusca.add(campoBusca);  // Adiciona o campo de texto de busca
        panelBusca.add(botaoBuscar);  // Adiciona o botão de busca
        frame.add(panelBusca, BorderLayout.SOUTH);  // Adiciona o painel de busca ao frame

        // Ações dos botões
        botaoAdicionar.addActionListener(e -> {
            try {
                String nome = campoNome.getText();
                String genero = campoGenero.getText();
                String diretor = campoDiretor.getText();
                int ano = Integer.parseInt(campoAno.getText());
                boolean assistido = checkBoxAssistido.isSelected();
                boolean favorito = checkBoxFavorito.isSelected();
                
                // Adiciona o filme na biblioteca e atualiza a lista de filmes na GUI
                biblioteca.adicionarFilme(nome, genero, diretor, ano, assistido, favorito);
                atualizarListaFilmes(panelFilmes, biblioteca.listarFilmes(), "Todos os Filmes", corFundo, corLetras, corCaixaPesquisa);
            } catch (NumberFormatException ex) {
                // Exibe uma mensagem de erro se o ano não for um número inteiro válido
                JOptionPane.showMessageDialog(frame, "Ano deve ser um número inteiro.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
            }
        });

        botaoBuscar.addActionListener(e -> {
            // Busca filmes pelo termo informado e atualiza a lista de filmes na GUI
            String termoBusca = campoBusca.getText();
            List<Filme> resultadosBusca = biblioteca.buscarFilme(termoBusca);
            atualizarListaFilmes(panelFilmes, resultadosBusca, "Resultado da Busca", corFundo, corLetras, corCaixaPesquisa);
        });

        // Inicialmente, exibe todos os filmes
        listaAtual = biblioteca.listarFilmes();
        atualizarListaFilmes(panelFilmes, listaAtual, "Todos os Filmes", corFundo, corLetras, corCaixaPesquisa);

        frame.setVisible(true); // Torna a janela visível
    }
    /**
     * 
     * @param colunas
     * @param corFundo
     * @param corLetras
     * @return 
     */
    // Cria e configura um campo de texto com as cores especificadas
    private JTextField criarCampoTexto(int colunas, Color corFundo, Color corLetras) {
        JTextField campo = new JTextField(colunas);
        campo.setBackground(corFundo);
        campo.setCaretColor(corLetras);
        campo.setForeground(corLetras);
        return campo;
    }
    /**
     * 
     * @param texto
     * @param corFundo
     * @param corLetras
     * @return 
     */
    // Cria e configura um checkbox com as cores especificadas
    private JCheckBox criarCheckBox(String texto, Color corFundo, Color corLetras) {
        JCheckBox checkBox = new JCheckBox(texto);
        checkBox.setBackground(corFundo);
        checkBox.setForeground(corLetras);
        return checkBox;
    }
    /**
     * 
     * @param texto
     * @param corFundo
     * @param corLetras
     * @return 
     */
    // Cria e configura um botão com as cores especificadas
    private JButton criarBotao(String texto, Color corFundo, Color corLetras) {
        JButton botao = new JButton(texto);
        botao.setBackground(corFundo);
        botao.setForeground(corLetras);
        return botao;
    }
    /**
     * 
     * @param texto
     * @param corLetras
     * @return 
     */
    // Cria e configura um rótulo com a cor especificada
    private JLabel criarLabel(String texto, Color corLetras) {
        JLabel label = new JLabel(texto);
        label.setForeground(corLetras);
        return label;
    }
    /**
     * 
     * @param painel
     * @param corFundo 
     */
    // Configura o painel com a cor de fundo especificada
    private void configurarPainel(JPanel painel, Color corFundo) {
        painel.setBackground(corFundo);
    }
    /**
     * 
     * @param painel
     * @param componente
     * @param gbc
     * @param x
     * @param y 
     */
    // Adiciona um componente ao painel com as configurações de GridBagConstraints especificadas
    private void adicionarComponente(JPanel painel, Component componente, GridBagConstraints gbc, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        painel.add(componente, gbc);
    }
    /**
     * 
     * @param painel
     * @param componente
     * @param gbc
     * @param x
     * @param y
     * @param largura 
     */
    // Adiciona um componente ao painel com as configurações de GridBagConstraints especificadas, incluindo a largura
    private void adicionarComponente(JPanel painel, Component componente, GridBagConstraints gbc, int x, int y, int largura) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = largura;
        painel.add(componente, gbc);
    }
    /**
     * 
     */
    // Atualiza a lista de filmes exibida no painel
    private void atualizarListaFilmes(JPanel panelFilmes, List<Filme> filmes, String titulo, Color corFundo, Color corLetras, Color corCaixaPesquisa) {
        panelFilmes.removeAll(); // Remove todos os componentes atuais do painel

        JLabel labelTitulo = new JLabel(titulo, JLabel.CENTER); // Cria um rótulo para o título da lista de filmes
        labelTitulo.setForeground(Color.WHITE);
        panelFilmes.add(labelTitulo);

        JPanel panelBotoesSuperiores = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // Cria um painel para os botões superiores
        panelBotoesSuperiores.setBackground(corFundo);
        JButton botaoFavoritos = criarBotao("Favoritos", corCaixaPesquisa, corLetras);
        botaoFavoritos.setPreferredSize(new Dimension(88, 19));
        JButton botaoAssistidos = criarBotao("Assistidos", corCaixaPesquisa, corLetras);
        botaoAssistidos.setPreferredSize(new Dimension(95, 19));
        JButton botaoTodos = criarBotao("Todos os Filmes", corCaixaPesquisa, corLetras);
        botaoTodos.setPreferredSize(new Dimension(130, 19));

        panelBotoesSuperiores.add(botaoFavoritos);
        panelBotoesSuperiores.add(botaoAssistidos);
        panelBotoesSuperiores.add(botaoTodos);

        // JComboBox para ordenação
        JComboBox<String> comboBoxOrdenacao = new JComboBox<>(new String[]{"Ordenação", "Por Adição", "Por Nome", "Por Avaliação"});
        comboBoxOrdenacao.setPreferredSize(new Dimension(88, 19));
        comboBoxOrdenacao.setBackground(corCaixaPesquisa);
        comboBoxOrdenacao.setForeground(corLetras);
        comboBoxOrdenacao.addActionListener(e -> {
            String criterio = (String) comboBoxOrdenacao.getSelectedItem();
            switch (criterio) {
                case "Por Adição":
                    OrdenadorFilmes.ordenarPorAdicao(listaAtual);
                    break;
                case "Por Nome":
                    OrdenadorFilmes.ordenarPorNome(listaAtual);
                    break;
                case "Por Avaliação":
                    OrdenadorFilmes.ordenarPorAvaliacao(listaAtual);
                    break;
            }
            atualizarListaFilmes(panelFilmes, listaAtual, "Filmes Ordenados", corFundo, corLetras, corCaixaPesquisa);
        });
        panelBotoesSuperiores.add(comboBoxOrdenacao);

        botaoFavoritos.addActionListener(e -> {
            // Atualiza a lista para exibir apenas os filmes favoritos
            listaAtual = biblioteca.listarFavoritos();
            atualizarListaFilmes(panelFilmes, listaAtual, "Filmes Favoritos", corFundo, corLetras, corCaixaPesquisa);
        });

        botaoAssistidos.addActionListener(e -> {
            // Atualiza a lista para exibir apenas os filmes assistidos
            listaAtual = biblioteca.listarAssistidos();
            atualizarListaFilmes(panelFilmes, listaAtual, "Filmes Assistidos", corFundo, corLetras, corCaixaPesquisa);
        });

        botaoTodos.addActionListener(e -> {
            // Atualiza a lista para exibir todos os filmes
            listaAtual = biblioteca.listarFilmes();
            atualizarListaFilmes(panelFilmes, listaAtual, "Todos os Filmes", corFundo, corLetras, corCaixaPesquisa);
        });
        panelFilmes.add(panelBotoesSuperiores);

        for (Filme filme : filmes) {
            JPanel panelFilme = new JPanel(new BorderLayout()); // Cria um painel para cada filme com BorderLayout
            configurarPainel(panelFilme, corFundo);

            JLabel labelFilme = new JLabel(filme.toString()); // Cria um rótulo com as informações do filme
            labelFilme.setForeground(corLetras);
            panelFilme.add(labelFilme, BorderLayout.WEST); // Adiciona o rótulo ao lado esquerdo do painel

            JPanel panelControles = new JPanel(); // Cria um painel para os controles
            panelControles.setBackground(corFundo);
            panelControles.setLayout(new FlowLayout(FlowLayout.RIGHT)); // Layout ajustado para alinhar os controles à direita

            // Adicionando estrelas para avaliação
            JPanel panelAvaliacao = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // Painel para as avaliações
            panelAvaliacao.setBackground(corFundo);

            int avaliacao = filme.getAvaliacao();
            for (int i = 1; i <= 5; i++) {
                JLabel labelEstrela = new JLabel(i <= avaliacao ? "\u2605" : "\u2606"); // Estrela preenchida se i <= avaliacao
                labelEstrela.setFont(new Font("SansSerif", Font.PLAIN, 15));
                labelEstrela.setForeground(new Color(255, 255, 0)); // Define a cor das estrelas
                int pontuacao = i;
                labelEstrela.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        // Atualiza a avaliação do filme ao clicar na estrela
                        filme.setAvaliacao(pontuacao);
                        biblioteca.atualizarAvaliacao(filme.getNome(), pontuacao);
                        atualizarListaFilmes(panelFilmes, filmes, titulo, corFundo, corLetras, corCaixaPesquisa);
                    }
                });
                panelAvaliacao.add(labelEstrela);
            }

            panelControles.add(panelAvaliacao); // Adicionado ao painel de controles

            JCheckBox checkBoxAssistido = criarCheckBox("Assistidos", corFundo, corLetras);
            checkBoxAssistido.setSelected(filme.isAssistido());
            checkBoxAssistido.addActionListener(e -> {
                // Marca ou desmarca o filme como assistido
                if (checkBoxAssistido.isSelected()) {
                    biblioteca.marcarComoAssistido(filme.getNome());
                } else {
                    biblioteca.desmarcarComoAssistido(filme.getNome());
                }
                atualizarListaFilmes(panelFilmes, filmes, titulo, corFundo, corLetras, corCaixaPesquisa);
            });
            panelControles.add(checkBoxAssistido); // Adicionado ao painel de controles

            JCheckBox checkBoxFavorito = criarCheckBox("Favoritos", corFundo, corLetras);
            checkBoxFavorito.setSelected(filme.isFavorito());
            checkBoxFavorito.addActionListener(e -> {
                // Adiciona ou remove o filme dos favoritos
                if (checkBoxFavorito.isSelected()) {
                    biblioteca.adicionarAosFavoritos(filme.getNome());
                } else {
                    biblioteca.removerDosFavoritos(filme.getNome());
                }
                atualizarListaFilmes(panelFilmes, filmes, titulo, corFundo, corLetras, corCaixaPesquisa);
            });
            panelControles.add(checkBoxFavorito); // Adicionado ao painel de controles

            JButton botaoRemover = criarBotao("Remover", corCaixaPesquisa, new Color(255, 255, 125));
            botaoRemover.setPreferredSize(new Dimension(90, 18));
            botaoRemover.addActionListener(e -> {
                // Remove o filme da biblioteca, com confirmação se for favorito
                if (filme.isFavorito()) {
                    int resposta = JOptionPane.showConfirmDialog(null, "Este filme está marcado como favorito. Deseja realmente removê-lo?", "Confirmação", JOptionPane.YES_NO_OPTION);
                    if (resposta == JOptionPane.YES_OPTION) {
                        biblioteca.removerFilme(filme.getNome());
                        atualizarListaFilmes(panelFilmes, filmes, titulo, corFundo, corLetras, corCaixaPesquisa);
                    }
                } else {
                    biblioteca.removerFilme(filme.getNome());
                    atualizarListaFilmes(panelFilmes, filmes, titulo, corFundo, corLetras, corCaixaPesquisa);
                }
            });
            panelControles.add(botaoRemover); // Adicionado ao painel de controles

            panelFilme.add(panelControles, BorderLayout.EAST); // Adicionado ao lado direito
            panelFilmes.add(panelFilme);
        }
        panelFilmes.revalidate();
        panelFilmes.repaint();
    }
}
