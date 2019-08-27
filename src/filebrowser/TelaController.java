/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filebrowser;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Gabriel Marioto
 */
public class TelaController implements Initializable
{
    @FXML
    private Button btn_Atualizar;
    @FXML
    private Button btn_NovaPasta;
    @FXML
    private TableView<Arquivo> tbv_Tabela;
    @FXML
    private TableColumn<Arquivo, String> col_nome;
    @FXML
    private TableColumn<Arquivo, Long> col_tamanho;
    @FXML
    private TableColumn<Arquivo, ImageView> col_pasta;
    @FXML
    private Button btn_Fechar;
    
    private String pastaInicial = "C:\\ALO";
    private File pasta;
    private ImageView imagem = new ImageView();
    private ImageView naoimagem = new ImageView();
            
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
        // Vincula o atributo "NOME","Tamanho","Pasta" da classe Arquivo com a coluna "col_nome","col_tamanho","col_pasta".
        
        col_nome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
        col_tamanho.setCellValueFactory(new PropertyValueFactory<>("Tamanho"));
        col_pasta.setCellValueFactory(new PropertyValueFactory<>("icone"));
        
        
        preencherTabela();
        
    }    
    private void preencherTabela()
    {
        pasta = new File(pastaInicial);
        Arquivo arq;
        
        List <Arquivo> arquivos = new ArrayList();
        for (int i = 0; i < pasta.listFiles().length; i++)
        {
            if(pasta.listFiles()[i].isDirectory() == true)
            {
                arq = new Arquivo(pasta.listFiles()[i].getName(),pasta.listFiles()[i].length(),
                pasta.listFiles()[i].isDirectory(),new ImageView (new Image ("icons/pasta.png")));                 
                tbv_Tabela.setRowFactory(tv ->
                {
                    return new TableRow<Arquivo>()
                    {                        
                        public void updateItem(Arquivo item, boolean empty)
                        {
                            super.updateItem(item, empty);    
                            setStyle("-fx-fill: red");
                        }
                    };
                });

            }
            else
            {
                arq = new Arquivo(pasta.listFiles()[i].getName(),pasta.listFiles()[i].length(),
                    pasta.listFiles()[i].isDirectory(),new ImageView (new Image ("icons/txt.png")));   
            }                                     
            arquivos.add(arq);                      
        }
        
        //INSERIR O  ARRAYLIST NA TABELA, CONVERTENDO-O EM OBSERVABLELIST
        tbv_Tabela.setItems(FXCollections.observableArrayList(arquivos));
    }

    @FXML
    private void evt_Atualizar(ActionEvent event)
    {
        tbv_Tabela.refresh();
        preencherTabela();
    }

    @FXML
    private void evt_NovaPasta(ActionEvent event)
    {
        String nova;
        
        TextInputDialog dialog = new TextInputDialog();
        
        dialog.setContentText("Informe o nome da pasta");
        
        Optional <String> resultado = dialog.showAndWait();
        
        if(resultado != null )
        {
            File npasta = new File(pastaInicial+"//"+resultado.get());            
            npasta.mkdir();
            tbv_Tabela.getItems().add(new Arquivo(npasta.getName(),0,true,imagem));
          preencherTabela();
        }
    }

    @FXML
    private void evt_Fechar(ActionEvent event)
    {
        
    }
}
