/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filebrowser;

import javafx.scene.image.ImageView;

/**
 *
 * @author Gabriel Marioto
 */
public class Arquivo
{
    private String nome;
    private long tamanho;
    private boolean pasta;
    private ImageView icone;

    public Arquivo(String nome, long tamanho, boolean pasta, ImageView icone)
    {
        this.nome = nome;
        this.tamanho = tamanho;
        this.pasta = pasta;
        this.icone = icone;
    }

    public Arquivo()
    {
        this("",0,false,null);
    }

    public ImageView getIcone()
    {
        return icone;
    }

    public void setIcone(ImageView icone)
    {
        this.icone = icone;
    }

    

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public long getTamanho()
    {
        return tamanho;
    }

    public void setTamanho(long tamanho)
    {
        this.tamanho = tamanho;
    }

    public boolean isPasta()
    {
        return pasta;
    }

    public void setPasta(boolean pasta)
    {
        this.pasta = pasta;
    }
    
    
    
}
