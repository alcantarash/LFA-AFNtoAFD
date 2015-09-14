package transformafn;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Arquivo {

    private FileReader arquivo;
    private BufferedReader dados;
    private String linha;
    private StringTokenizer palavra;
    private static String delimitador = ";";

    public Arquivo(String nomeArquivo) {
        try {
            arquivo = new FileReader(nomeArquivo);
            dados = new BufferedReader(arquivo);
            linha = dados.readLine();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (linha == null) {
            palavra = null;
        } else {
            palavra = new StringTokenizer(linha, delimitador, true);
        }
    }

    public String proximaPalavra() {
        if (palavra.hasMoreTokens()) {
            return palavra.nextToken();
        } else {
            try {
                linha = dados.readLine();
            } catch (IOException ex) {
                Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (linha == null) {
                return "EOF";
            } else {
                palavra = new StringTokenizer(linha, delimitador, true);
                return proximaPalavra();
            }
        }
    }
}
